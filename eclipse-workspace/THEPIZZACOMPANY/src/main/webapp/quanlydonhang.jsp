<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quan ly don hang</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <h3 style="text-align: center;font-size: 24px;">DANH SÁCH ĐƠN HÀNG</h3>
    <table>
<tr>
    
    <th>Name</th>
    <th>Name Product</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Total</th>
    <th>Status</th>
</tr>
<c:forEach var="ds" items="${ds}">
  <tr>
    
    <td>${ds.hoten}</td>
    <td>${ds.tensanpham}</td>
    <td id= "format_price">${ds.gia}</td>
    <td>${ds.soluongmua }</td>
    <td id= "format_price">${ds.thanhtien}</td>
    <td><a href="adminxacnhancontroller?mct=${ds.machitiethd}"><span class="status delivered">Confirm</span></a></td>
  </tr>
 
</c:forEach>
 </table>
   
    <!-- Add products ends -->
  
    
      <!--Scripts-->
     <script src="./js/admin.js"></script>
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