<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>主页</title>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/commons/jquery.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		/** 验证码点击切换 */
		$('#code').click(function() {
			$(this).hide().attr('src', ctx + '/checkimage.jpg?r=' + Math.random()).fadeIn();
		});
	});
</script>
</head>
<body>
	<h1>Hello world</h1>

	<P>The time on the server is ${serverTime}.</P>
	<img style="margin-left: 15px;" align="middle" src="${ctx}/checkimage.jpg" id="code" />
</body>
</html>