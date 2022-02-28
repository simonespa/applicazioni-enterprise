<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
	function link1() {
		alert("Link 1");
	}

	function link2() {
		alert("Link 2");
	}

	function callback(data) {
		$("#result").html(data);
	}

	function doGet() {
		$.get("home", function(data) {callback(data)});
	}

	function attachListener() {
		$("#link1").click(link1);
		$("#link2").click(link2);
		$("#doGet").click(doGet);
	}

	$(document).ready(attachListener);
</script>
<title>Index</title>
</head>
<body>
	<a id="link1" href="#">Uno</a>
	<a id="link2" href="#">Due</a>
	<a id="doGet" href="#">Get</a>
	<div id="result"></div>
</body>
</html>
