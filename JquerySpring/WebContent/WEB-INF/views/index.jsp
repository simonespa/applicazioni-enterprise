<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css" media="screen">
	a {
		font-family: cursive;
		font-style: italic;
	}
	
	a visited {
		font-size: xx-large;
	}
</style>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
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
		$("#doGet").click(doGet);
	}

	$(document).ready(attachListener);
</script>
<title>Index</title>
</head>
<body>
	<a id="doGet">Get</a>
	<div id="result"></div>
</body>
</html>