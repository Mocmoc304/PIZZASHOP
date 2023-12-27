package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.sanphambean;
import bo.danhmucbo;
import bo.sanphambo;

/**
 * Servlet implementation class maincontroller
 */
@WebServlet("/maincontroller")
public class maincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public maincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			danhmucbo dmbo = new danhmucbo();
			sanphambo spbo = new sanphambo();
			String indexPage = request.getParameter("index");
			if(indexPage==null) {
				indexPage = "1";
			}
			int index = Integer.parseInt(indexPage);
			
			request.setAttribute("dsdanhmuc", dmbo.getDanhMuc());
			String mdm= request.getParameter("mdm");
			String key = request.getParameter("txttk");
			ArrayList<sanphambean> list = spbo.Pagination(index);
			int count = spbo.getSLSanPham();
			
			if(mdm!=null){
		    	count = spbo.getSLSanPhamcuaDM(mdm);
		    	
		    	list = spbo.TimDanhMuc(mdm, index);
		    }
			else if(key!=null)
			{
                count = spbo.getSLSanPhamcuaSearch(key);
		    	
		    	list = spbo.Tim(key, index);
				
			}
			
			int endPage = count/9;
			if(count% 9 !=0) {
				endPage++;
			}
			
            
			request.setAttribute("tag", index);
			request.setAttribute("list", list);
			request.setAttribute("endPage", endPage);
			RequestDispatcher rd= request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
