<%@page import="com.chola.shutterspeed.service.shutterspeedgalleryLocalServiceUtil"%>
<%@page import="com.chola.shutterspeed.model.shutterspeedgallery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects/>
<html>
<head>

</head>
<body>
 <portlet:renderURL var="back">
   <portlet:param name="jspPage" value="/view.jsp" />
</portlet:renderURL>
<liferay-ui:header title="Home"
	backLabel="Back" backURL="<%=back%>" /> 

<%
ClassLoader cl = shutterspeedgallery.class.getClassLoader();
DynamicQuery dynamicQuery= DynamicQueryFactoryUtil.forClass(
		shutterspeedgallery.class,cl).add(RestrictionsFactoryUtil.eq("flag","1"));
	List<shutterspeedgallery> list=shutterspeedgalleryLocalServiceUtil.dynamicQuery(dynamicQuery);
						
		System.out.println("List : " + list);
		PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("jspPage", "/jsp/updateAlbum.jsp");
	%>
		
	<liferay-ui:search-container delta="5"
	   total="<%=shutterspeedgalleryLocalServiceUtil.getshutterspeedgalleriesCount()%>"
		emptyResultsMessage="Sorry ,There is no Record to display"
		iteratorURL="<%=iteratorURL %>">
		<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(list, searchContainer.getStart(),searchContainer.getEnd())%>" />
		<liferay-ui:search-container-row className="com.chola.shutterspeed.model.shutterspeedgallery" keyProperty="shutterId" modelVar="shutter">
		<liferay-ui:search-container-column-text name="Album Name" value="${shutter.albumName}"  />
		<liferay-ui:search-container-column-text name="Album Description" value="${shutter.albumDesc}"  />
		<liferay-ui:search-container-column-jsp name="Actions" path="/jsp/editMenu.jsp"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>	
</body>
</html>
