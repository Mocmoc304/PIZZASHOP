<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<!--font awesome cdn link-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
    <!--Link css-->
    <link rel="stylesheet" href="./css/admin.css">
</head>
<body>
 <div class="form-addproduct">
    <!-- Form add stars -->
    <section>
    
    <form action="edit" method="post" enctype="multipart/form-data" id="add-product">
    <c:forEach var = "g" items ="${sp}">
        <h3>Edit Product</h3>
        <input type="text" name="masp" placeholder="Mã sản phẩm" class="box" value="${g.masanpham}" readonly="readonly">
        <input type="text" name="tensp" placeholder="Tên sản phẩm" class="box" value="${g.tensanpham}" required="required">
        <input type="text" name="gia" placeholder="Giá" class="box" value="${g.gia}" required="required" id= "format_price">
        <input type="file" name="anh" placeholder="Ảnh" class="box" id="upload-file" onchange="getImagePreview(event)">
        <input type="text" name="linkanh" placeholder="Link ảnh" class="box" value="${g.anh}">
        <div id="preview">
        <img src="${g.anh}">
        </div>
        <textarea rows="4" cols="50" name="noidung" placeholder="Nội dung"  class="box">${g.noidung}</textarea>
       
<!-- value cua ma loai chua lay ra duoc -->
			<select name="danhmuc">
				<c:forEach var="DanhMuc" items="${dsdanhmuc}">
				<option value="${DanhMuc.madanhmuc}" class="box">${DanhMuc.tendanhmuc}</option>
			    </c:forEach>
				
			</select> <br>
	    <input type="submit" value="Edit" name="submit" class="btn"> 
	    </c:forEach>
    </form>
    </section>
    <!-- Form add ends -->
    </div>
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