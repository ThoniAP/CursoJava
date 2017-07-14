<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="id" required="true" %>
<%@ attribute name="dt" required="false" type="java.lang.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<input type="text" id="${id}" name="${id}" value='<fmt:formatDate  value="${dt}"
                    pattern="dd/MM/yyyy" />' />
<script>
    $("#${id}").datepicker({dateFormat: 'dd/mm/yy', changeYear: true,  changeMonth: true});
</script>