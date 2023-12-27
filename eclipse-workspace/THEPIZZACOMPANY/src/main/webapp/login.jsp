<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--font awesome cdn link-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
   
    <!--custom css file link-->
    
    <link rel="stylesheet" href="./css/dangnhap.css">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div style="width: 600px">
            <form action="logincontroller" method="post">
                <h1>Sign in</h1>
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <span>or use your account</span>
                <input type="text" name="txtun" placeholder="Username" required/>
                <input type="password" name="txtpass" placeholder="Password" required/>
                <p style="color: red; font-size: 1.5rem; height: 1.7rem; font-weight: bold;">${mess}</p>
                <a href="#">Forgot your password?</a>
                <button>Sign In</button>
            </form>
</div>
</body>
</html>