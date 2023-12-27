<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Danh Muc</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
    <!--Link css-->
    <link rel="stylesheet" href="./css/admin.css">
</head>
<body>
  <div class="form-addproduct">
    <!-- Form add stars -->
    <section>
    <form action="editdm" method="post"id="add-product">
        <h3>Edit Catalogue</h3>
         <c:forEach var = "g" items ="${dm}">
        <input type="text" name="madm" placeholder="Mã danh mục" class="box" value="${g.madanhmuc}" readonly="readonly">
        <input type="text" name="tendm" placeholder="Tên danh mục" class="box" value="${g.tendanhmuc}" required="required">
       
	    <input type="submit" value="Edit" name="submit" class="btn"> 
	    </c:forEach>
    </form>
    </section>
    <!-- Form add ends -->
    </div>
    <!-- Add products stars -->
</body>
</html>