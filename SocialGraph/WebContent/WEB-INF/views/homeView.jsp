<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relinking Social Users</title>
</head>
<body>
 <h3>De-annonymization : Relinking Social Users</h3>
       <form method="POST" target="_blank" action="${pageContext.request.contextPath}/home">
       <label>Number of Seeds  </label>
       <input type="text" name="seeds" value="${home.seeds}"/>
       <label>Keep Previous Seeds</label>
       <input class="keepSeeds" type="checkbox" name="keepSeeds" value="Y"/><br><br>
       <input class="prfile" type="checkbox" name="profile" value="Y"/>
       <label>Profile  Attributes     :Gender , Year of Birth</label><br>
       <input class="centrality" type="checkbox" name="centrality" value="Y"/>
       
       <label>Structural Attributes : Degree , Centrality</label><br><br>
       
       
       <input type="submit" value="SUBMIT"/>
      </form>
</body>
</html>