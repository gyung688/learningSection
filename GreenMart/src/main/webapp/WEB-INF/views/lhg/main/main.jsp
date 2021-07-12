<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:include page="/WEB-INF/views/template/lhg/header.jsp"/>
<jsp:include page="/WEB-INF/views/template/lhg/container_begin.jsp"/>
<script>

</script>

<form id="frm" name="frm" method="post" action="/main.gr">
<%-- <input type="hidden" id="pageIndex" name="pageIndex" value="${mainVO.pageIndex }"/> --%>
	
	<!-- mainVisual -->
	<div class="mainVisual">
		<div>
			<img src="resources/img/lhg/main/main1.jpg"/>
		</div>
	</div>
	
</form>
		
<jsp:include page="/WEB-INF/views/template/lhg/container_end.jsp"/>
<jsp:include page="/WEB-INF/views/template/lhg/footer.jsp"/>