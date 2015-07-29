package com.sample.rest.message;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.simple.JSONObject;


//@Provider annotation is not needed in the Service Class
@Path(value = "/message")
public class SendMessageResource {
	
	private static String message;

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "getText")
	public String sendATextMessage (@QueryParam("name") String name) {
		System.out.println("Inside getText service");
		message = "This is a sample text message " + name;
		return message;
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "postText")
	public String sendAPostMessage (String name) {
		System.out.println("Inside postText service");
		message = "This is a post text message" + name;
		return message;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "getJSON")
	public String sendAJSONMessage (@QueryParam("name") String name) {
		System.out.println("Inside getJSON service");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "This is a sample JSON Message");
		jsonObject.put("name",name);
		return jsonObject.toJSONString();
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	@Path(value = "getHtml")
	public String sendAHTMLMessage (@QueryParam("name") String name) {
		System.out.println("Inside getHtml service");
		message = "<html><body>This is a sample HTML Document " + name + "</body></html>";
		return message;
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "company/{companyID}/employee/{employeeID}")
	public String getEmployee (@NotNull @PathParam("companyID") String companyID,
							   @NotNull @PathParam("employeeID") String employeeID) {
		System.out.println("Inside getEmployee service");
		return "companyID " + companyID + " employeeID " + employeeID;
	}
	
	
	
	
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "postFormData")
	public String sendAFormDataMessage (@FormDataParam("id") String id,
										@FormDataParam("uploadFile") InputStream fileInputStream, 
										@FormDataParam("uploadFile") FormDataContentDisposition  contentDispositionHeader) {
		System.out.println("Inside sendAFormDataMessage service");
		String path = "C:\\Users\\prasannakumarr\\Desktop\\progressbar";
		/*String path = "C:\\Users\\prasannakumarr\\Desktop\\progressbar";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-SSS");
		String dirName = sdf.format(Calendar.getInstance().getTime());*/
/*		ExecutorService executor = Executors.newFixedThreadPool(5);
		Runnable worker = new FileWriterThread(fileInputStream, path+"\\"+ dirName, contentDispositionHeader.getFileName());
		executor.execute(worker);*/
		//executor.shutdown();
		saveFile(fileInputStream, path+"\\"+ id, contentDispositionHeader.getFileName());
		System.out.println("File being written to " + path+"\\"+ id + "\\" + contentDispositionHeader.getFileName());
		return "FileUploaded";
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "fileUploadID")
	public String getFileUploadID () {
		System.out.println("Inside getFileUploadID");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-SSS");
		String dirName = sdf.format(Calendar.getInstance().getTime());
		return dirName;
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "progress/{id}")
	public String getProgress (@PathParam("id") String id) {
		System.out.println("Inside getProgress");
		String path = "C:\\Users\\prasannakumarr\\Desktop\\progressbar";
		File dir = new File(path+"\\"+id);
		String size = String.valueOf(getFileFolderSize(dir));
		System.out.println("size " + size);
		return size;
	}
	
	private static long getFileFolderSize (File dir) {
		long size = 0;
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.isFile()) {
					size += file.length();
				} else
					size += getFileFolderSize(file);
			}
		} else if (dir.isFile()) {
			size += dir.length();
		}
		return size/1000000;
	}
	
	private void saveFile(InputStream uploadedInputStream, String serverLocation, String fileName) {
		OutputStream outpuStream = null;
		File file = null;
		try {
			file = new File(serverLocation);
			if(!file.exists()) {
				file.mkdirs();
			}
			int read = 0;
			byte[] bytes = new byte[1024];
			System.out.println(serverLocation + "\\" + fileName);
			outpuStream = new FileOutputStream(new File(serverLocation + "\\" + fileName));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			System.out.println("End of write process");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(outpuStream != null) {
					outpuStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}