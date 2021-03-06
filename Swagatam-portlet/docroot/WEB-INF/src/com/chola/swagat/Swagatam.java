package com.chola.swagat;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.chola.swagatam.model.swagatam;
import com.chola.swagatam.model.swagatamdata;
import com.chola.swagatam.model.swagatampath;
import com.chola.swagatam.service.swagatamLocalServiceUtil;
import com.chola.swagatam.service.swagatamdataLocalServiceUtil;
import com.chola.swagatam.service.swagatampathLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

public class Swagatam extends MVCPortlet{
	private static Log logger = LogFactoryUtil.getLog(Swagatam.class);
	
	public void updateDetails(ActionRequest request,ActionResponse response) throws Exception
	{
		logger.info("Inside Update Method");
		
		String id = request.getParameter("id");
		logger.info("ID : "+id);
		
		String title = request.getParameter("title");
		logger.info("Title : "+title);
		
		String desc = request.getParameter("desc");
		logger.info("desc : "+desc);
		
		swagatam img = swagatamLocalServiceUtil.fetchswagatam(Long.parseLong(id));
		img.setTitle(title);
		img.setDesc(desc);
		img = swagatamLocalServiceUtil.updateswagatam(img);
		
		logger.info("Updated ID : "+img.getId());
		
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try 
		{
			
			if ("swagatamack".equalsIgnoreCase(resourceRequest.getResourceID())) {
				logger.info("Inside AJAX ACK");
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
				swagatamdata data = swagatamdataLocalServiceUtil.createswagatamdata(CounterLocalServiceUtil.increment());
				data.setWatched("true");
				data.setEmpId(String.valueOf(themeDisplay.getUserId()));
				data.setAcknowledged("true");
				data = swagatamdataLocalServiceUtil.addswagatamdata(data);
				logger.info("ACK Successfully Emp ID : "+data.getEmpId());
				
			}
		}
		catch (Exception e) {
			logger.error("Error",e);
		}
	}
	public void uploadData(ActionRequest request, ActionResponse response) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String title = request.getParameter("title");
		logger.info("title : "+title);
		
		String desc = request.getParameter("desc");
		logger.info("desc : "+desc);
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		String[] sourceFileName = uploadPortletRequest.getFileNames("uploadedFile");
		File[] sourceFile = uploadPortletRequest.getFiles("uploadedFile");
		SimpleDateFormat df2 = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		String albumId = df2.format(date);
		
		swagatampath path = null;
		for(int i=0;i<sourceFileName.length;i++)
		{
		logger.info("File Name : "+sourceFileName[i]);
		
		String fileName=null;
		if(!"".equalsIgnoreCase(sourceFileName[i]))
		{
			logger.info("File selected by user");
			fileName = fileUpload(request,response,uploadPortletRequest,sourceFileName[i],sourceFile[i]);
		}
		else
		{
			logger.info("File not selected by user");
		}
		
		path = swagatampathLocalServiceUtil.createswagatampath(CounterLocalServiceUtil.increment());
		path.setVideoPath(fileName);
		path.setCreatedBy(String.valueOf(themeDisplay.getUserId()));
		path.setCreatedDate(date);
		path.setFlag("1");
		path.setInductionid(albumId);
		path = swagatampathLocalServiceUtil.addswagatampath(path);
		
		}
		if(path!=null)
		{
		swagatam swag = swagatamLocalServiceUtil.createswagatam(CounterLocalServiceUtil.increment());
		swag.setTitle(title);
		swag.setDesc(desc);
		swag.setInductionid(path.getInductionid());
		swag.setCreatedBy(String.valueOf(themeDisplay.getUserId()));
		swag.setCreatedDate(date);
		swag.setFlag("1");
		
		swag = swagatamLocalServiceUtil.addswagatam(swag);
		
		logger.info("Swagatam Created with ID : "+swag.getInductionid());
		}
}
	
	public String fileUpload(ActionRequest request, ActionResponse response,UploadPortletRequest uploadRequest,String fileName,File sourceFile) throws IOException
	{

	    String str = "SwagatamUpload";

		java.util.Properties properties = PortalUtil.getPortalProperties();
		logger.info("my properties is...." + properties);
		File contestfolder = new File(properties.getProperty("liferay.home") + "/tomcat-8.0.32/webapps/" + str);
		File destinationFile = new File(
				properties.getProperty("liferay.home") + "/tomcat-8.0.32/webapps/" + str + "/" + "admin");

		if (!contestfolder.exists()) {
			destinationFile.mkdirs();
		}
		logger.info("my directory is : " + contestfolder);

		if (!destinationFile.exists()) {
			destinationFile.mkdirs();
		}
		logger.info("my directory is : " + destinationFile);
	
		if(fileName!=null){
				/**************** SAVE THE DOC ********************************/
			if (destinationFile.exists()) {
				String fileNa = fileName.substring(0,fileName.lastIndexOf("."));
				logger.info("fileName : " + fileNa);
				String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				logger.info("fileExtension : "+ fileExtension);
				fileName = fileNa;
				SimpleDateFormat df2 = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
				Date date = new Date();
				String testDateString = df2.format(date);
				fileName = fileName +"_"+testDateString +fileExtension;

				destinationFile = new File(
						properties.getProperty("liferay.home") + "/tomcat-8.0.32/webapps/" + str + "/" + "admin" + "/" + fileName);

				logger.info("destinationFile : " + destinationFile);

			}
			logger.info("File : " + fileName);
			FileUtil.copyFile(sourceFile, destinationFile);
			
			
			String FilePath = destinationFile.toString();
			logger.info("Successfully Saved the Document");
			/*************** ENDED THE SAVING ******************/
			logger.info(FilePath);
	}
		return fileName;
	}
	
	public void removeAlbum(ActionRequest request,ActionResponse response)
	{
		logger.info("Inside Remove Method");
		
		String title = request.getParameter("title");
		logger.info("title : "+title);
		
		swagatam swag = swagatamLocalServiceUtil.fetchswagatam(Long.parseLong(title));
		swag.setFlag("2");
		swag = swagatamLocalServiceUtil.updateswagatam(swag);
		
		logger.info("Removed Successfully : "+swag.getId());
	}

}
