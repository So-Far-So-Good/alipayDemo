<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>֧����-�����ⲿ����ҳ��</title>
</head>
<body>
   
     �ⲿ���󶨱���ҳ��
     
     <form action="commitAuth.do" enctype="application/x-www-form-urlencoded" method="post">
         <p>����: <label><c:out value="${userName}"/></label></p>
 		 <p>֧�����˺�: <label><c:out value="${loginId}"/></label></p>
   		 <p>����: <input type="text" name="cardno" /></p>
 		 <p>����: <input type="text" name="password" /></p>
 		 <p><input type="hidden" name="userId"  value="${userId}" /></p>
 		 <input type="submit" value="Submit" />
     </form>

</body>
</html>