<%@page import="java.util.ArrayList"%>
<%@page import="bean.danhmucbean"%>
<%@page import="bo.danhmucbo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quan ly danh muc</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quan ly danh muc</title>
    <!--font awesome cdn link-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
    <!--Link css-->
    <link rel="stylesheet" href="./css/admin.css">
    <style type="text/css">
    html{
    font-size: 62.5%;
    }
 table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  font-family: 'Nunito', sans-serif;
  text-align: left;
  padding: 8px;
  font-size: 24px;
  color: #666;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #006a31;
  color: white;
}

a{
text-decoration: none;
color: #666;
font-family: 'Nunito', sans-serif;
}
    </style>
</head>
<body>
<!--Header stars-->
    <div class="container">
        <div class="navigation">
            <ul>
                <li>
                    <a href="#">
                        <span class="icon">
                            <i class="fas fa-utensils ion-icon"></i>
                        </span>
                        <span class="title">The Pizza Company</span>
                    </a>
                </li>

                <li>
                    <a href="quantricontroller">
                        <span class="icon">
                            <ion-icon name="home-outline"></ion-icon>
                        </span>
                        <span class="title">Dashboard</span>
                    </a>
                </li>

                <li>
                    <a href="quanlydanhmuccontroller">
                        <span class="icon">
                            <ion-icon name="people-outline"></ion-icon>
                        </span>
                        <span class="title">Quản lý danh mục</span>
                    </a>
                </li>

                <li>
                    <a href="quanlysanphamcontroller">
                        <span class="icon">
                            <ion-icon name="chatbubble-outline"></ion-icon>
                        </span>
                        <span class="title">Quản lý sản phẩm</span>
                    </a>
                </li>

                <li>
                    <a href="adminxacnhancontroller">
                        <span class="icon">
                            <ion-icon name="help-outline"></ion-icon>
                        </span>
                        <span class="title">Quản lý đơn hàng</span>
                    </a>
                </li>
                <li>
                    <a href="logoutcontroller">
                        <span class="icon">
                            <ion-icon name="log-out-outline"></ion-icon>
                        </span>
                        <span class="title">Sign Out</span>
                    </a>
                </li>
            </ul>
        </div>

    <!--Header ends-->
    
    <!--Main stars-->
    <div class="main">
            <div class="topbar">
                <div class="toggle">
                   <i class="fa fa-bars ion-icon"></i>
                </div>

                <div class="search">
                    <label>
                        <input type="text" placeholder="Search here">
                        <i class="fas fa-search ion-icon"></i>
                    </label>
                </div>

                <div class="user">
                 <c:forEach var="user" items="${dnhap}">
                    <img src="${user.anh}" alt="">
                 </c:forEach>
                </div>
            </div>

    <!--Main ends-->
    <div class="form-addproduct">
    <!-- Form add stars -->
    <section>
    <form action="quanlydanhmuccontroller" method="post"id="add-product">
        <h3>Add New Catalogue</h3>
        <input type="text" name="madm" placeholder="Mã danh mục" class="box" required="required">
        <input type="text" name="tendm" placeholder="Tên danh mục" class="box" required="required">
       
	    <input type="submit" value="Add" name="submit" class="btn"> 
    </form>
    </section>
    <!-- Form add ends -->
    </div>
    <!-- Add products stars -->
    <table>
<tr>
    
    <th>Mã danh mục</th>
    <th>Tên danh mục</th>
    <th>Sửa</th>
    <th>Xóa</th>
</tr>
<c:forEach var="danhmuc" items="${dsdanhmuc}">
  <tr>
    
    <td>${danhmuc.madanhmuc}</td>
    <td><a href="loadproduct?mdm=${danhmuc.madanhmuc}">${danhmuc.tendanhmuc}</a></td>
    <td>
    <a href="loadproduct?mdm=${danhmuc.madanhmuc}"><i class="fas fa-pen"></i></a></td>
    <td><a href="delete?mdm=${danhmuc.madanhmuc}"><i class="fas fa-trash-alt"></i></a>
    </td>
    
  </tr>
 
</c:forEach>
 </table>
   
    <!-- Add products ends -->
  
    
      <!--Scripts-->
     <script src="./js/admin.js"></script>
      <c:forEach var="mess" items="${mess}">
     <script>
        function showNotification(mess) {
            alert(mess);
        }
    </script>
    </c:forEach>
</body>
</html>