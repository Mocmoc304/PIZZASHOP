package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.sanphambean;
import bo.danhmucbo;
import bo.sanphambo;



/**
 * Servlet implementation class quanlysanphamcontroller
 */
@WebServlet("/quanlysanphamcontroller")
public class quanlysanphamcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanlysanphamcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "anh/sanpham/";
		response.getWriter().println(dirUrl1);
		try {
			String mdm= request.getParameter("mdm");
			sanphambo spbo = new sanphambo();
			danhmucbo dmbo = new danhmucbo();
			String indexPage = request.getParameter("index");
			if(indexPage==null) {
				indexPage = "1";
			}
			
			int index = Integer.parseInt(indexPage);
			ArrayList<sanphambean> list = spbo.Pagination(index);
			int count = spbo.getSLSanPham();
			request.setAttribute("dsdanhmuc", dmbo.getDanhMuc());
			if(mdm!=null){
		    	count = spbo.getSLSanPhamcuaDM(mdm);
		    	
		    	list = spbo.TimDanhMuc(mdm, index);
		    }
			int endPage = count/9;
			if(count% 9 !=0) {
				endPage++;
			}
			
			request.setAttribute("endPage", endPage);
			request.setAttribute("list", list);
			request.setAttribute("tag", index);
			if (request.getContentLength() <= 0) {// Chay lan dau
				RequestDispatcher rd = request.getRequestDispatcher("quanlysp.jsp");
				rd.forward(request, response);
				return;
			}
			String masanpham = "", tensanpham = "", anh = "", noidung = "", madanhmuc = "";
			long gia = 0;
			
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					
					String nameimg = fileItem.getName();
					anh= "anh/sanpham/"+nameimg;
					if (!nameimg.equals("")) {
						
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "anh/sanpham/";
						File dir = new File(dirUrl);
						if (!dir.exists()) {
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);
						try {
							fileItem.write(file);
							System.out.println("UPLOAD THÀNH CÔNG...!");
							
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();

					if (tentk.equals("masp")) {
						response.getWriter().println(fileItem.getString());
						masanpham = fileItem.getString("UTF-8");
					}
					if (tentk.equals("tensp")) {
						response.getWriter().println(fileItem.getString());
						tensanpham = fileItem.getString("UTF-8");
					}
					if (tentk.equals("gia")) {
						response.getWriter().println(fileItem.getString());
						gia = Long.parseLong(fileItem.getString());
					}
					if (tentk.equals("noidung")) {
						response.getWriter().println(fileItem.getString());
						noidung = fileItem.getString("UTF-8");
					}
					if (tentk.equals("danhmuc")) {
						response.getWriter().println(fileItem.getString());
						madanhmuc = fileItem.getString("UTF-8");
						
					}
				}
			}
			
			spbo.Them(masanpham, tensanpham, gia, anh, noidung, madanhmuc);
			response.sendRedirect("quanlysanphamcontroller");
		}
		 catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
