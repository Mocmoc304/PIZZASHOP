<%@page import="bean.adminxacnhanbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <!--font awesome cdn link-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
    <!--Link css-->
    <link rel="stylesheet" href="./css/admin.css">
    <style type="text/css">
    a{
    text-decoration: none;}
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

    <!--Cart stars-->
    <div class="cardBox">
                <div class="card">
                    <div>
                        <div class="numbers">1,504</div>
                        <div class="cardName">Daily Views</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="eye-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers">${dh}</div>
                        <div class="cardName">Sales</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="cart-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers">284</div>
                        <div class="cardName">Comments</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="chatbubbles-outline"></ion-icon>
                    </div>
                </div>

                <div class="card">
                    <div>
                        <div class="numbers" id= "format_price">${tk}</div>
                        <div class="cardName">Earning</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="cash-outline"></ion-icon>
                    </div>
                </div>
    </div>
    <!--Cart ends-->

    <!--Order Details List ends-->
       <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Recent Orders</h2>
                        <a href="#" class="btn">View All</a>
                    </div>
                    <table style="margin-top: -50px;">
                        <thead>
                            <tr>
                                <td>Name</td>
                                <td>Name Product</td>
                                <td>Price</td>
                                <td>Quantity</td>
                                <td>Total</td>
                                <td>Status</td>
                            </tr>
                        </thead>

                 <c:forEach var="ds" items="${ds}">
                        <tbody>
                            <tr>
                                <td>${ds.hoten}</td>
                                <td>${ds.tensanpham}</td>
                                <td id= "format_price">${ds.gia}</td>
                                <td>${ds.soluongmua }</td>
                                <td id= "format_price">${ds.thanhtien}</td>
                                <td><a href="quantricontroller?mct=${ds.machitiethd}"><span class="status delivered">Confirm</span></a></td>
                            </tr>
                        </tbody>
                      </c:forEach>
                    </table>
                </div>
              
    <!--New Customer stars-->
    <div class="recentCustomers">
                    <div class="cardHeader">
                        <h2>Recent Customers</h2>
                    </div>

                    <table>
                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="anh/info/2.png" alt=""></div>
                            </td>
                            <td>
                                <h4>David <br> <span>Italy</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="anh/info/3.png" alt=""></div>
                            </td>
                            <td>
                                <h4>Amit <br> <span>India</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="anh/info/4.png" alt=""></div>
                            </td>
                            <td>
                                <h4>David <br> <span>Italy</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="anh/info/5.png" alt=""></div>
                            </td>
                            <td>
                                <h4>Amit <br> <span>India</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="anh/info/6.png" alt=""></div>
                            </td>
                            <td>
                                <h4>David <br> <span>Italy</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="anh/info/7.png" alt=""></div>
                            </td>
                            <td>
                                <h4>Amit <br> <span>India</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="anh/info/8.png" alt=""></div>
                            </td>
                            <td>
                                <h4>David <br> <span>Italy</span></h4>
                            </td>
                        </tr>

                        <tr>
                            <td width="60px">
                                <div class="imgBx"><img src="anh/info/9.png" alt=""></div>
                            </td>
                            <td>
                                <h4>Amit <br> <span>India</span></h4>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!--New customer ends-->
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