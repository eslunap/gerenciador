<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
		<c:if test="${ not empty nombreEmpresa }">
		Empresa ${nombreEmpresa} registrada!
		</c:if>
		<c:if test="${ empty nombreEmpresa }">
		Ninguna empresa registrada!
		</c:if>
	</body>
</html>