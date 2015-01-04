<%@page import="com.ibm.beans.impl.DB2FactoryService"%>
<%@page import="com.ibm.beans.SpringUtils"%>
<%@ page import="com.ibm.nosql.json.api.*" %>
<%@ page import="com.ibm.nosql.json.util.*" %>
<%@ page import="org.springframework.context.ApplicationContext" %>



<html>
<body>
<h2>Hello World IBM BlueMix DB2</h2>
<%
	ApplicationContext appContext = SpringUtils.getApplicationContext(application);
DB2FactoryService db2 = appContext.getBean(DB2FactoryService.class);
%>
Username: <%=db2.getUserName() %>
</br>
Password: <%=db2.getPassWord() %>
</br>
URI: <%=db2.getUri() %>

</body>
</html>
