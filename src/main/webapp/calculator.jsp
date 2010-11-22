<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Calculator</title>
		
		<style>
			h1 {
				font-family: Arial;
				font-size: 14pt;
				font-weight: normal;
			}
			td input {
				font-family: Arial;
				font-size: 10pt;
				width: 30px;
			}
			
			input.double {
				width: 60px;
			}
			
			input.doubleheight {
				height: 48px;
			}
			
			input.display {
				border: 1px solid black;
				readonly: true;
				width: 120px;
				padding: 2px;
			}
		</style>
	</head>
	
	<body>
		<h1>Calculator</h1>
		
		<form method="GET" action="calculate.html">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="4">
				<input class="display" type="text" id="display" value="<c:out value="${displayAmount}"/>" readonly/>
			</td>
		</tr>
		<tr>
			<td><input type="submit" name="button" id="btn-7" value="7"/></td>
			<td><input type="submit" name="button" id="btn-8" value="8"/></td>
			<td><input type="submit" name="button" id="btn-9" value="9"/></td>
			<td><input type="submit" name="button" id="btn-/" value="/"/></td>
			<td><input type="submit" name="button" id="btn-C" value="C"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="button" id="btn-4" value="4"/></td>
			<td><input type="submit" name="button" id="btn-5" value="5"/></td>
			<td><input type="submit" name="button" id="btn-6" value="6"/></td>
			<td><input type="submit" name="button" id="btn-*" value="*"/></td>
			<td></td>
		</tr>
		<tr>
			<td><input type="submit" name="button" id="btn-1" value="1"/></td>
			<td><input type="submit" name="button" id="btn-2" value="2"/></td>
			<td><input type="submit" name="button" id="btn-3" value="3"/></td>
			<td><input type="submit" name="button" id="btn--" value="-"/></td>
			<td rowspan="2"><input class="doubleheight" type="submit" name="button" id="btn-=" value="="/></td>
		</tr>
		<tr>
			<td colspan="2"><input class="double" type="submit" name="button" id="btn-0" value="0"/></td>
			<td><input type="button" name="button" id="btn-." value="."/></td>
			<td><input type="submit" name="button" id="btn-+" value="+"/></td>
		</tr>
		</table>
		</form>
	</body>
</html>

		