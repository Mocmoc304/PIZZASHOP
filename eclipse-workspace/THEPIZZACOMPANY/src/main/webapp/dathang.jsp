<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gio Hang</title>
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
    
    
    <!-- Cart stars -->
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
                                    <th>Delete</th>
                                    <th>Update</th>
                                </tr>
                            </thead>
                            <tbody >
                             <c:forEach var = "g" items ="${sessionScope.gh.getAll()}">
                                <tr>
                                    <td  class="shoping_cart_item">
                                        <a href="chitietcontroller?msp=${g.masanpham}"><img style="height: 200px;" src="${g.anh}" alt=""></a>
                                        <h5 style="color: #1c1c1c;display: inline-block;font-size: 2rem;color: var(--black);font-weight: 600;">${g.tensanpham}</h5>
                                    </td>
                                    <td class="shoping_cart_price" style="font-size: 2rem;color: #1c1c1c;font-weight: 700;width: 150px;" id= "format_price">
                                       ${g.gia}
                                    </td>
                                    <td style="width: 100px;font-size: 2rem; text-align: center;color: #1c1c1c;font-weight: 700;">
                                               <input type="text" name="txtcapnhat" value="${g.soluongmua}">
                                         
                                    </td>
                                    <td style="font-size: 18px;color: #1c1c1c;font-weight: 700;width: 150px;" id= "format_price">
                                        ${g.thanhtien}
                                    </td>
                                    <td style="font-size: 18px; text-align: center;color: #1c1c1c;font-weight: 700; width: 80px;">
                                        <a href="xoaspgiohang?msp=${g.masanpham}"><i class="fa fa-times" aria-hidden="true" ></i></a>
                                    </td >
                                    <td style="font-size: 18px; text-align: center;color: #1c1c1c;font-weight: 700;">
                                        <a href="suaspgiohang?msp=${g.masanpham}"><i class="fas fa-pen"></i></a></td>

                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div >
                        <a href="maincontroller" class="btn">CONTINUE SHOPPING</a>
                        <a href="xoatoanbogh" class="primary-btn cart-btn cart-btn-right"><span class="fa fa-spinner"></span>
                            Delete All Cart</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    
                </div>
                <div class="col-lg-6">
                    <div class="shoping_checkout">
                        <h5>Cart Total</h5>
                        <ul>
                           
                            <li>Total: 
                            <c:choose>
                            <c:when test="${sessionScope.gh!=null}">
                            <span style="font-size: 18px;color: #dd2222;float: right;" id= "format_price"> ${sessionScope.gh.TongTien()}
                            </span></c:when>
                            <c:otherwise><span style="font-size: 18px;color: #dd2222;float: right;" id= "format_price"> 0</span></c:otherwise></c:choose>
                            </li>
                        </ul>
                        <a href="xacnhancontroller" class="btn" style="display: block;text-align: center;">PROCEED TO CHECKOUT</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Cart ends -->
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