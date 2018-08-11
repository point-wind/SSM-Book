<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>register-ok.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<script type="text/javascript">  
            var time = 4;  
            function returnUrlByTime() {    
                window.setTimeout('returnUrlByTime()', 1000);    
                time = time - 1;    
                if(time<=0){  
                    time = 0;  
             window.setTimeout("location.href='index';", 0);   
                }  
                document.getElementById("layer").innerHTML = time;    
            }    
    </script>  
  </head>
  
  <body onload="returnUrlByTime()">
  <div>
  	<a href="javascript:void(0)" onclick="href='index'">
  		<font size="5px">登陆成功<b>
  		<span id="layer">3</span></b>秒后自动跳转,未跳转点击此处··
  		</font>
  	</a>
  </div>
  <!-- <a href="javascript:void(0)" 
  onclick="window.location.href='${pageContext.request.contextPath}/index/index.xhtml' " >
  <font size="5px" >恭喜您注册成功，<b>
  <span id="layer">3</span>
  </b>秒后会自动跳转，如果没有跳转，请点这里......</font>
  </a></div>   -->
  </body>
</html>