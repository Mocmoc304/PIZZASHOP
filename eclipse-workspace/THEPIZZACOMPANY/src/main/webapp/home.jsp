<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <!--font awesome cdn link-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"
/>
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
    
    <!--Home Section Starts-->
    <section class="home" id="home">
        <div class="swiper mySwiper home-slider">
            <div class="swiper-wrapper wrapper">
                <div class="swiper-slide slide">
                    <div class="content">
                        <span>Our special dish</span>
                        <h3>Hot Pizza</h3>
                        <p>Lần đầu tiên, trái thanh long có trong pizzaaaaaaa
                        </p>
                        <a href="" class="btn">Order Now</a>
                    </div>
                    <div class="image">
                        <img src="anh/11.png" alt="">
                    </div>
                </div>
                <div class="swiper-slide slide">
                    <div class="content">
                        <span>Our special dish</span>
                        <h3>Instant Noodles</h3>
                        <p>Lần đầu tiên, trái thanh long có trong mì tômmmmm
                        </p>
                        <a href="" class="btn">Order Now</a>
                    </div>
                    <div class="image">
                        <img src="anh/12.png" alt="">
                    </div>
                </div>
                <div class="swiper-slide slide">
                    <div class="content">
                        <span>Our special dish</span>
                        <h3>Hot Salad</h3>
                        <p>Lần đầu tiên, trái thanh long có trong saladdddd
                        </p>
                        <a href="" class="btn">Oder Now</a>
                    </div>
                    <div class="image">
                        <img src="anh/13.png" alt="">
                    </div>
                </div>
            </div>
            <div class="swiper-pagination"></div>
        </div>

    </section>
    <!--Home Section Ends-->
    
    <!--Dishes section starts-->
    <section class="dishes" id="dishes">
        <h3 class="sub-heading">
            Our Dishes
        </h3>
        <h1 class="heading">
            Popular Dishes
        </h1>

        <div class="box-container">
        <c:forEach var="Popular" items="${dspopular}">
            <div class="box">
                <a href="#" class="fas fa-heart"></a>
                <a href="chitietcontroller?msp=${Popular.masanpham}" class="fas fa-eye"></a>
                <img src="${Popular.anh}" alt="">
                <h3>${Popular.tensanpham}</h3>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"> </i>
                    <i class="fas fa-star-half-alt"></i>
                </div>
                <span  id= "format_price">${Popular.gia}</span>
                <a href="dathangcontroller?msp=${Popular.masanpham}&tsp=${Popular.tensanpham}&gia=${Popular.gia}&anh=${Popular.anh}" class="btn">Add to cart</a>
            </div>
        </c:forEach>
        </div>
    </section>

    <!--Dishes section ends-->

    <!--About section starts-->
    <section class="about" id="about">
        <h3 class="sub-heading">
            About us
        </h3>
        <h1 class="heading">
            Why choose us?
        </h1>
        <div class="row">
            <div class="image">
                <img src="anh/71.png" alt="">
            </div>
            <div class="content">
                <h3>Best food in the country</h3>
                <p>Chúng tôi là The Pizza Company. Thương hiệu thuộc quyền sở hữu của tập đoàn Minor Food Group, một trong những tập đoàn hàng đầu châu Á về ngành khách sạn và ẩm thực cao cấp.  </p>
                <p>Được thành lập từ 1981, The Pizza Company Chuỗi nhà hàng Pizza phong vị Ý bắt đầu mở rộng, phát triển hệ thống cửa hàng và nhượng quyền thương mại quốc tế. Đến nay, thương hiệu The Pizza Company có hơn 300 cửa hàng tại hơn 12 thị trường trên toàn thế giới. </p>
              
                <div class="icons-container">
                    <div class="icons">
                        <i class="fas fa-shipping-fast"> </i>
                        <span>Free Delivery</span>
                    </div>
                    <div class="icons">
                        <i class="fas fa-dollar-sign"> </i>
                        <span>Easy Payments</span>
                    </div>
                    <div class="icons">
                        <i class="fas fa-headset"> </i>
                        <span>24/7 Service</span>
                    </div>
                </div>
                <a href="#" class="btn">Learn more</a>
            </div>
        </div>
    </section>

    <!--About section ends-->

    <!--Menu section stars-->
    <section class="menu" id="menu">
        <h3 class="sub-heading">
            Our Menu
        </h3>
        <h1 class="heading">
            Today's Speciality
        </h1>

        <div class="box-container">
        <c:forEach var="Today" items="${dstoday}">
            <div class="box">
                <div class="image">
                    <img src="${Today.anh}" alt="">
                    <a href="#" class="fas fa-heart"></a>
                </div>
                <div class="content">
                    <div class="stars">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star-half-alt"></i>
                    </div>
                    <a href="chitietcontroller?msp=${Today.masanpham}"><h3>${Today.tensanpham}</h3></a>
                    <span class="price"  id= "format_price">${Today.gia}</span>
                    <a href="dathangcontroller?msp=${Today.masanpham}&tsp=${Today.tensanpham}&gia=${Today.gia}&anh=${Today.anh}" class="btn">Add to cart</a> 
                </div>
            </div>
            </c:forEach>
            
        </div>
    </section>

    <!--Menu section ends-->

    <!--Review section starts-->
    <section class="review" id="review">
        <h3 class="sub-heading">
            Customer's Review
        </h3>
        <h1 class="heading">
            What thay say?
        </h1>

        <div class="swiper mySwiper review-slider">
            <div class="swiper-wrapper wrapper">
                <div class="swiper-slide slide">
                    <i class="fas fa-quote-right"></i>
                    <div class="user">
                        <img src="anh/info.jpg" alt="">
                        <div class="user-info">
                            <h3>Nguyen Thuy Ha</h3>
                            <div class="stars">
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star-half-alt"></i>
                            </div>
                        </div>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Atque iste amet quasi autem reiciendis omnis voluptate sit possimus, ipsa voluptas minima, fugit nulla corrupti impedit labore suscipit cum ipsam dolores.</p>
                </div>
                <div class="swiper-slide slide">
                    <i class="fas fa-quote-right"></i>
                    <div class="user">
                        <img src="anh/info.jpg" alt="">
                        <div class="user-info">
                            <h3>Nguyen Thuy Ha</h3>
                            <div class="stars">
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star-half-alt"></i>
                            </div>
                        </div>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Atque iste amet quasi autem reiciendis omnis voluptate sit possimus, ipsa voluptas minima, fugit nulla corrupti impedit labore suscipit cum ipsam dolores.</p>
                </div>
                <div class="swiper-slide slide">
                    <i class="fas fa-quote-right"></i>
                    <div class="user">
                        <img src="anh/info.jpg" alt="">
                        <div class="user-info">
                            <h3>Nguyen Thuy Ha</h3>
                            <div class="stars">
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star-half-alt"></i>
                            </div>
                        </div>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Atque iste amet quasi autem reiciendis omnis voluptate sit possimus, ipsa voluptas minima, fugit nulla corrupti impedit labore suscipit cum ipsam dolores.</p>
                </div>
                <div class="swiper-slide slide">
                    <i class="fas fa-quote-right"></i>
                    <div class="user">
                        <img src="anh/info.jpg" alt="">
                        <div class="user-info">
                            <h3>Nguyen Thuy Ha</h3>
                            <div class="stars">
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star-half-alt"></i>
                            </div>
                        </div>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Atque iste amet quasi autem reiciendis omnis voluptate sit possimus, ipsa voluptas minima, fugit nulla corrupti impedit labore suscipit cum ipsam dolores.</p>
                </div>
            </div>
        </div>
    </section>

    <!--Review section ends-->

    <!--Order section starts-->
    <section class="order" id="order">
        <h3 class="sub-heading">
            Order Now
        </h3>
        <h1 class="heading">
            Free anf Fast
        </h1>

        <form action="">
            <div class="inputBox">
                <div class="input">
                    <span>Your Name</span>
                    <input type="text" name="" id="" placeholder="Enter your name">
                </div>
                <div class="input">
                    <span>Your Number</span>
                    <input type="number" name="" id="" placeholder="Enter your number">
                </div>
            </div>
            <div class="inputBox">
                <div class="input">
                    <span>Your Order</span>
                    <input type="text" name="" id="" placeholder="Enter food name">
                </div>
                <div class="input">
                    <span>Addtional food</span>
                    <input type="text" name="" id="" placeholder="Extra with food">
                </div>
            </div>
            <div class="inputBox">
                <div class="input">
                    <span>How much</span>
                    <input type="number" name="" id="" placeholder="How many orders">
                </div>
                <div class="input">
                    <span>Date and time</span>
                    <input type="datetime-local">
                </div>
            </div>
            <div class="inputBox">
                <div class="input">
                    <span>Your Address</span>
                    <textarea  placeholder="Enter your address" cols="30" rows="10"></textarea>
                </div>
                <div class="input">
                    <span>Your Message</span>
                    <textarea  placeholder="Enter your message" cols="30" rows="10"></textarea>
                </div>
            </div>
            <input type="submit" value="Order now" class="btn">
        </form>
    </section>

    <!--Order section ends-->

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
   