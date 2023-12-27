<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi Tiet San Pham</title>
<!--font awesome cdn link-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<!--custom css file link-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
            <c:forEach var="Kh" items="${sessionScope.dn.getAll()}">
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
                <c:forEach var="Khachhang" items="${sessionScope.dn.getAll()}">
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
    
    <!-- Details stars -->
    <section class="product-details">
    <div class="container">
    <c:forEach var = "g" items ="${sp}">
     <div class="row">
      <div class="col-lg-6 col-md-6">
       <div class="product__details__pic">
        <img class="product__details__pic__item--large" style="width: 300px;"
              src="${g.anh}" alt="">
       </div>
      </div>
       <div class="col-lg-6 col-md-6">
       <div class="product__details__text">
       <h3>${g.tensanpham}</h3>
       <div class="product__details__rating">
       <i class="fa fa-star"></i>
       <i class="fa fa-star"></i>
       <i class="fa fa-star"></i>
       <i class="fa fa-star"></i>
       <i class="fa fa-star-half"></i>
       <span>(18 reviews)</span>
       </div>
       <div class="product__details__price" id= "format_price"> ${g.gia}</div>
       <div class="product__details__content"> ${g.noidung}</div>
       <div class="product__details__quantity">
           <div >
               <div style="font-size: 2rem;">
                    <input type="number" value="1">
               </div>
               </div>
       </div>
       <a href="dathangcontroller?msp=${g.masanpham}&tsp=${g.tensanpham}&gia=${g.gia}&anh=${g.anh}" class="btn" style="margin-right: 10px;">ADD TO CARD</a>
       <a href="#" class="fas fa-heart heart-icon"></a>
       </div>
       </div>
     </div>
     </c:forEach>
    </div>
    </section>
    <!-- Details ends -->
    <!--Footer section stars-->
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