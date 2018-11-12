<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<title></title>
</head>

<body onload="init()">
	<canvas id="canvas" width="300" height="300"
		style="background-color: aliceblue"></canvas>
	<script type="text/javascript">
		var cvs;
		var context;

		function init() {
			cvs = document.getElementById("canvas");
			context = cvs.getContext("2d");

			context.lineWidth = 2;
			context.strokeStyle = "blue";

			cvs.addEventListener("mousemove", function(e) {
				move(e)
			}, false);
			cvs.addEventListener("mousedown", function(e) {
				down(e)
			}, false);
			cvs.addEventListener("mouseup", function(e) {
				up(e)
			}, false);
			cvs.addEventListener("mouseout", function(e) {
				out(e)
			}, false);
		}

		var startX = 0, startY = 0;
		var dragging = false;

		function draw(curX, curY) {
			context.beginPath();
			context.moveTo(startX, startY);
			context.lineTo(curX, curY);
			context.stroke();
		}

		function down(e) {
			startX = e.offsetX;
			startY = e.offsetY;
			dragging = true;
		}

		function up(e) {
			dragging = false;
		}

		function move(e) {
			if (!dragging) {
				return;
			}
			var curX = e.offsetX, curY = e.offsetY;
			draw(curX, curY);
			startX = curX;
			startY = curY;
		}

		function out(e) {
			dragging = false;
		}
	</script>
</body>

</html>
