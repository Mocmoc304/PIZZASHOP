<%@page import="java.util.ArrayList"%>
<%@page import="bean.danhmucbean"%>
<%@page import="bo.danhmucbo"%>
<%@page import="bean.sanphambean"%>
<%@page import="bo.sanphambo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quan ly san pham</title>
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
  font-size: 16px;
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
.image{
 width: 20rem;
 height: 20rem;
}
/*Pagination stars*/
.pagination-container{
	width: 100%;
	height: 50px;
	background: linear-gradient(45deg, #410358, var(--green));
	display: flex;
	align-items: center;
	justify-content: center;
}
.pagination{
	display: flex;
	align-items: center;
	background: #fff;
	color: #383838;
	padding: 0px 8px;
	border-radius: 6px;
	}
	
.pagination >ul{
	margin: 5px 8px;
}

.pagination >ul >li{
	display: inline-block;
	margin: 0 5px;
	background: #ccc;
	width: 26px;
	height: 22px;
	text-align: center;
	font-size: 14px;
	font-weight: 500;
	line-height: 16px;
	cursor: pointer;
	border-radius: 50%; 
}

.pagination btn1, btn2{
	display: inline-block;
	align-items: center;
	font-size: 22px;
	font-weight: 500;
	color: #383838;
	background: transparent;
	outline: none;
	border: none;
	cursor: pointer;
	}
	
.pagination >ul >li.active{
	color: #fff;
	background-image: linear-gradient(#ff4568, #ff4568);
	background-repeat: no-repeat;

}

/*Pagination ends*/
.dropbtn {
	background-color: #006a31;;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 200px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
    font-family: 'Nunito', sans-serif;
	color: black;
	font-size: 16px;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
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
    <form action="quanlysanphamcontroller" method="post" enctype="multipart/form-data" id="add-product">
        <h3>Add New Product</h3>
        <input type="text" name="masp" placeholder="Mã sản phẩm" class="box" required="required">
        <input type="text" name="tensp" placeholder="Tên sản phẩm" class="box" required="required">
        <input type="text" name="gia" placeholder="Giá" class="box" required="required" id= "format_price">
        <input type="file" name="anh" placeholder="Ảnh" class="box" id="upload-file" onchange="getImagePreview(event)" required="required">
         <div id="preview" style="width:300px; height: 300px"></div>
        <textarea rows="4" cols="50" name="noidung" placeholder="Nội dung" class="box"> </textarea>
       
<!-- value cua ma loai chua lay ra duoc -->
			<select name="danhmuc">
				<c:forEach var="DanhMuc" items="${dsdanhmuc}">
				<option value="${DanhMuc.madanhmuc}" class="box">${DanhMuc.tendanhmuc}</option>
			    </c:forEach>
				
			</select> <br>
	    <input type="submit" value="Add" name="submit" class="btn"> 
    </form>
    </section>
    <!-- Form add ends -->
    </div>
    <!-- Add products stars -->
    <div class="dropdown">
		<button class="dropbtn">Tất cả sản phẩm <i class="fas fa-angle-down"></i></button>
		<div class="dropdown-content">
		<a href="quanlysanphamcontroller">
			Tất cả
			</a>
			<c:forEach var="dm" items="${dsdanhmuc}">

				<a href="quanlysanphamcontroller?mdm=${dm.madanhmuc}">${dm.tendanhmuc}</a>

			</c:forEach>
		</div>
	</div>
    <table style="margin-top: 5px;">
<tr>
    <th>Mã sản phẩm</th>
    <th>Tên sản phẩm</th>
    <th>Ảnh</th>
    <th>Giá</th>
    <th>Nội dung</th>
    <th>Sửa</th>
    <th>Xóa</th>
</tr>
<c:forEach var="sanpham" items="${list}">
  <tr>
    <td>${sanpham.masanpham}</td>
    <td>${sanpham.tensanpham}</td>
    <td><img class="image" src="${sanpham.anh}"></td>
    <td id= "format_price">${sanpham.gia}</td> 
    <td>${sanpham.noidung }</td>
    <td>
    <a href="loadproduct?msp=${sanpham.masanpham}"><i class="fas fa-pen"></i></a></td>
    <td><a href="delete?msp=${sanpham.masanpham}"><i class="fas fa-trash-alt"></i></a>
    </td>
  </tr>
</c:forEach>
 </table>
    
    <!-- Add products ends -->
<!-- Pagination stars -->
    <div class="pagination-container">
    <div class="pagination">
    <ul>
    <c:if test="${tag>1 }">
    <li ><a href="quanlysanphamcontroller?index=${tag-1}"><i class="fa fa-arrow-left" aria-hidden="true"></i></a></li>
    </c:if>
    <c:forEach begin="1" end="${endPage}" var="i">
    <li class="link" onclick="activeLink()"><a href="quanlysanphamcontroller?index=${i}">${i}</a></li>
    </c:forEach>
    <c:if test="${tag<endPage}">
    <li ><a href="quanlysanphamcontroller?index=${tag+1}"><i class="fa fa-arrow-right" aria-hidden="true"></i></a></li>
    </c:if>
    </ul>
    </div>
    </div>
    <!-- Pagination ends -->    
    
      <!--Scripts-->
     <script src="./js/admin.js"></script>
     <script type="text/javascript">
    function getImagePreview(event) {
		var image = URL.createObjectURL(event.target.files[0]);
		var imagediv = document.getElementById('preview');
		var newimg = document.createElement('img');
		imagediv.innerHTML = '';
		newimg.src = image;
		newimg.width="300";
		imagediv.appendChild(newimg); 
	}
    </script>
    <script type="text/javascript" src="js/pagination.js"></script>
    <script>
    // Lấy tất cả các phần tử có class="format_price"
    const priceElements = document.querySelectorAll('#format_price');

    // Duyệt qua từng phần tử và định dạng số tiền
    priceElements.forEach(element => {
      const number = parseInt(element.textContent); // Lấy số từ nội dung của mỗi thẻ

      const formattedNumber = new Intl.NumberFormat('vi-VN').format(number); // Định dạng số

      element.textContent = formattedNumber + " VND"; // Thay đổi nội dung của từng thẻ thành số được định dạng
    });
  </script>
</body>
</html>
