<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>正在跳转</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
    <script>
    	window.location.href='<s:property value="location"/>';
    </script>
  </body>
</html>
