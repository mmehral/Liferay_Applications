package com.action.organizationannouncement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.organizationAnnouncement.model.organization;
import com.organizationAnnouncement.service.organizationLocalServiceUtil;

public class OrganizationAnnouncement extends MVCPortlet
{
	private static Log logger = LogFactoryUtil.getLog(OrganizationAnnouncement.class);
	
	public void addComment(ActionRequest actionRequest, ActionResponse actionResponse) {
		logger.info("Comment=======");

		try {
			invokeTaglibDiscussion(actionRequest, actionResponse);
			logger.info("Comment added Successfully..............");
		} catch (Exception e) {
			logger.error("Error",e);
		}
	}
public void submitOrganizationDetails(ActionRequest request,ActionResponse response) throws IOException
{
	request.getAttribute(WebKeys.THEME_DISPLAY);

	String title = request.getParameter("title");
	logger.info("title : " + title);

	String description = request.getParameter("description");
	logger.info("description : " + description);
	
	long organizationId=ParamUtil.getLong(request, "organizationId");
	logger.info("compliance Id..................."+organizationId);
	
	
	
	 UploadPortletRequest uploadRequest =
	 PortalUtil.getUploadPortletRequest(request);
	 
			SimpleDateFormat df2 = new SimpleDateFormat("ddMMyyyyHHmmss");
			Date date = new Date();
			df2.format(date);
			File sourceFile = uploadRequest.getFile("fileName");
			String sourceFileName = uploadRequest.getFileName("fileName");
			logger.info("file name" + sourceFileName);
			
			String fileName = null;
		if (!sourceFileName.isEmpty())
		{
					logger.info("File selected by user");
					fileName = fileUpload(request, response, uploadRequest, sourceFileName, sourceFile);
		}
		else
		{
					logger.info("File not selected by user");
		}
		logger.info("File name...."+fileName);
		
		
		if(organizationId>=01)
		{
			logger.info("organization id in if loop.."+organizationId);
			modifiedorganizationdetails(request, response,organizationId,title,description,sourceFileName,fileName);
			response.setRenderParameter("jspPage","/jsp/editOrganizationdetails.jsp");
		}
		else
		{
		organization org=organizationLocalServiceUtil.createorganization(CounterLocalServiceUtil.increment());
		org.setOrganization_tite(title);
		org.setOrganization_description(description);
		org.setOrganization_image_name(sourceFileName);
		org.setOrganization_image_path(fileName);
		org.setCreateDate(new Date());
		organizationLocalServiceUtil.addorganization(org);
		
		logger.info("Organization announcement saved successfully............");
		}
		
		
}

private void modifiedorganizationdetails(ActionRequest request, ActionResponse response, long organizationId,String title,String description,String sourceFileName,String fileName)
{
	
     logger.info("edit the forms======");
     logger.info("complianceId.."+organizationId);
	
	organization org = null;
	try
	{
		org=organizationLocalServiceUtil.fetchorganization(organizationId);
		
		logger.info(org);
	} 
	catch (SystemException e)
	{
		logger.error("Error",e);
	}
	if (Validator.isNotNull(org)) 
	{
		org.setOrganization_tite(title);
		org.setOrganization_description(description);
		org.setOrganization_image_name(sourceFileName);
		org.setOrganization_image_path(fileName);
		
		try 
		{
			organizationLocalServiceUtil.updateorganization(org);
		
			
			logger.info("Updated Successfully");
		}
		catch (SystemException e) 
		{
			logger.error("Error",e);
		}
	}
}	

public void deletecompliancedetailsreference(ActionRequest actionRequest,
		ActionResponse actionResponse) throws Exception
{
	logger.info("Delete Vendor======");
	long organizationId = ParamUtil.getInteger(actionRequest, "organizationId");
	logger.info("organizationId===" + organizationId);
	if (organizationId >= 01) {
	
 	try {
 		organizationLocalServiceUtil.deleteorganization(organizationId);
 		
			logger.info("deleted successfully");
			actionResponse.setRenderParameter("jspPage","/jsp/editOrganizationdetails.jsp");
		
		} 
 	catch (Exception e) {
		logger.error("Error",e);
	}
			
	}
	
}

public String fileUpload(ActionRequest request, ActionResponse response, UploadPortletRequest uploadRequest,
		String fileName, File sourceFile) throws IOException
{
	request.getAttribute(WebKeys.THEME_DISPLAY);
	

	String str = "OrganizationAnnouncementUpload";

	
	String role="admin";
	java.util.Properties properties = PortalUtil.getPortalProperties();
	logger.info("my properties is...." + properties);
	File contestfolder = new File(properties.getProperty("liferay.home") + "/tomcat-8.0.32/webapps/" + str);
	File destinationFile = new File(
			properties.getProperty("liferay.home") + "/tomcat-8.0.32/webapps/" + str + "/" + role);

	if (!contestfolder.exists()) {
		destinationFile.mkdirs();
		logger.info("type directory exists");
	}
	logger.info("my directory is : " + contestfolder);

	if (!destinationFile.exists()) {
		destinationFile.mkdirs();
		logger.info("type directory exists");
	}
	logger.info("my directory is : " + destinationFile);

	
	if (fileName != null) {
		/**************** SAVE THE DOC ********************************/
		if (destinationFile.exists()) {
			String fileNa = fileName.substring(0, fileName.lastIndexOf("."));
			logger.info("fileName : " + fileNa);
			String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			logger.info("fileExtension : " + fileExtension);
			fileName = fileNa;
			SimpleDateFormat df2 = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
			Date date = new Date();
			String testDateString = df2.format(date);
			fileName = fileName + "_" + testDateString + fileExtension;

			destinationFile = new File(properties.getProperty("liferay.home") + "/tomcat-8.0.32/webapps/" + str
					+ "/" + role + "/" + fileName);

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

}
