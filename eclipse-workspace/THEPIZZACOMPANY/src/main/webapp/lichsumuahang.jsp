<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lich Su Mua Hang</title>
<!--font awesome cdn link-->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<!--custom css file link-->
   
    <link rel="stylesheet" href="./css/style.css">
    
</head>
<body>
<!--header section starts-->
    <header>
        <a href="#" class="logo"><i class="fas fa-utensils"></i>The Pizza Company.</a>
        <nav class="navbar">
         <ul>
            <li><a class="active" href="homecontroller">Home</a></li>
            <li><a href="#dishes">Dishes</a></li>
            <li><a href="#about">About</a></li>
            <li class="dropdown">
                <a href="maincontroller" class="dropbtn">Menu</a>
                <div class="dropdown-content">
                <c:forEach var="DanhMuc" items="${dsdanhmuc}">
						
							<a href="maincontroller?mdm=${DanhMuc.madanhmuc}">${DanhMuc.tendanhmuc}</a>
						
					</c:forEach>
                </div>
                </li>
            <li><a href="#review">Review</a></li>
            <c:forEach var="Kh" items="${dn}">
            <li><a href="lichsucontroller?mkh=${kh.makh}">History</a></li>
            </c:forEach>
         </ul>
        </nav>
        <div class="icons">
        <ul>
            <li><i class="fas fa-bars" id="menu-bars"></i></li>
            <li><i class="fas fa-search" id="search-icon"></i></li>
            <li><a href="#" class="fas fa-heart"></a></li>
            <li><a href="dathangcontroller" class="fas fa-shopping-cart">
            </a></li>
            <li class="dropdown">
            <a href="#" class="fas fa-user" class="dropbtn"></a>
            <div class="dropdown-content">
                <c:forEach var="Khachhang" items="${dn}">
					<c:choose>
						<c:when test="${sessionScope.dn != null}">
							    <a href="#"> Xin chào ${Khachhang.hoten}</a>
								<a href="dangxuatcontroller" class="drop-item">Đăng xuất</a>
						</c:when >
					</c:choose>
				</c:forEach>
				
				<c:if test="${sessionScope.dn == null}">
					<a href="dangnhapcontroller" class="drop-item">Đăng nhập
					</a>
			
				</c:if>
					<a href="dangkycontroller" class="drop-item">Đăng ký
					</a>					
                </div>
            </li>
         </ul>
        </div>
    </header>
    <!--header section ends-->

    <!--search form-->
    <form action="maincontroller" method="post" id="search-form">
        <input type="search" placeholder="Search here..." name="txttk" id="search-box">
        <label for="search-box" class="fas fa-search"></label>
        <i class="fas fa-times" id="close"></i>
    </form>
    <!--End search form-->
    <h1 style="text-align: center;padding-top: 80px;">Lịch sử hàng đã mua</h1>
    <section class="shoping-cart">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping_cart_table">
                        <table >
                            <thead>
                                <tr>
                                    <th class="shoping_product">Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Date</th>
                                    <th>Confirm</th>
                                </tr>
                            </thead>
                            <tbody >
                             <c:forEach var = "g" items ="${dschuaxacnhan}">
                                <tr>
                                    <td  class="shoping_cart_item">
                                       <img style="height: 200px;" src="${g.anh}" alt="">
                                        <h5 style="color: #1c1c1c;display: inline-block;font-size: 2rem;color: var(--black);font-weight: 600;">${g.tensanpham}</h5>
                                    </td>
                                    <td class="shoping_cart_price" style="font-size: 2rem;color: #1c1c1c;font-weight: 700;width: 150px;" id= "format_price">
                                       ${g.gia}
                                    </td>
                                    <td style="width: 100px;font-size: 2rem; text-align: center;color: #1c1c1c;font-weight: 700;">
                                               <input type="text" name="" value="${g.soluongmua}" readonly="readonly">
                                         
                                    </td>
                                    <td style="font-size: 18px;color: #1c1c1c;font-weight: 700;width: 150px;" id= "format_price">
                                        ${g.thanhtien}
                                    </td>
                                    <td style="font-size: 18px; text-align: center;color: #1c1c1c;font-weight: 700;width: 120px;">
                                        ${g.ngaymua}
                                    </td >
                                    <td style="font-size: 18px; text-align: center;color: #1c1c1c;font-weight: 700;">
                                       ${g.damua}</td>

                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                </div>
                </div>
    </section>
    <h1 style="text-align: center;">Lịch sử hàng đã xác nhận</h1>
    <section class="shoping-cart">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping_cart_table">
                        <table >
                            <thead>
                                <tr>
                                    <th class="shoping_product">Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Date</th>
                                    <th>Confirm</th>
                                </tr>
                            </thead>
                            <tbody >
                             <c:forEach var = "g" items ="${dsdaxacnhan}">
                                <tr>
                                    <td  class="shoping_cart_item">
                                       <img style="height: 200px;" src="${g.anh}" alt="">
                                        <h5 style="color: #1c1c1c;display: inline-block;font-size: 2rem;color: var(--black);font-weight: 600;">${g.tensanpham}</h5>
                                    </td>
                                    <td class="shoping_cart_price" style="font-size: 2rem;color: #1c1c1c;font-weight: 700;width: 150px;" id= "format_price">
                                       ${g.gia}
                                    </td>
                                    <td style="width: 100px;font-size: 2rem; text-align: center;color: #1c1c1c;font-weight: 700;">
                                               <input type="text" name="" value="${g.soluongmua}" readonly="readonly">
                                         
                                    </td>
                                    <td style="font-size: 18px;color: #1c1c1c;font-weight: 700;width: 150px;" id= "format_price">
                                        ${g.thanhtien}
                                    </td>
                                    <td style="font-size: 18px; text-align: center;color: #1c1c1c;font-weight: 700;width: 120px;">
                                        ${g.ngaymua}
                                    </td >
                                    <td style="font-size: 18px; text-align: center;color: #1c1c1c;font-weight: 700;">
                                       ${g.damua}</td>

                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                </div>
                </div>
    </section>
      <!--Footer section starts-->
    <section class="footer">
        <div class="box-container">
            <div class="box">
                <h3>Locations</h3>
                <a href="#">India</a>
                <a href="#">Janpan</a>
                <a href="#">USA</a>
                <a href="#">Viet Nam</a>
                <a href="#">Korea</a>
                <a href="#">Canada</a>
            </div>
            <div class="box">
                <h3>Quick Links</h3>
                <a href="#">Home</a>
                <a href="#">Dishes</a>
                <a href="#">About</a>
                <a href="#">Menu</a>
                <a href="#">Review</a>
                <a href="#">Order</a>
            </div>
            <div class="box">
                <h3>Contact Info</h3>
                <a href="#">+123-456-7890</a>
                <a href="#">+123-456-7890</a>
                <a href="#">+123-456-7890</a>
                <a href="#">iamhane@gmail.com</a>
                <a href="#">thuyha123@gmail.com</a>
                <a href="#">20t1020660@husc.edu.vn</a>
            </div>
            <div class="box">
                <h3>Follow us</h3>
                <a href="#">Facebook</a>
                <a href="#">Instagram</a>
                <a href="#">Telegram</a>
                <a href="#">Zalo</a>
                <a href="#">Website</a>
                <a href="#">Youtube</a>
            </div>
        </div>
        <div class="credit">Copyright @ 2023 by <span>.mocmoc</span></div>
    </section>

    <!--Footer section ends-->

    <!--custom js file link-->
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="script.js"></script>
    <script src="https://unpkg.com/currency.js@~2.0.0/dist/currency.min.js"></script>
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