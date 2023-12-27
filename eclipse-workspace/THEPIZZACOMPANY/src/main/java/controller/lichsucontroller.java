package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.danhmucbo;
import bo.lichsubo;

/**
 * Servlet implementation class lichsucontroller
 */
@WebServlet("/lichsucontroller")
public class lichsucontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsucontroller() {
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
			request.setAttribute("dsdanhmuc", dmbo.getDanhMuc());
			String mkh = request.getParameter("mkh");
			if(mkh!=null) {
				lichsubo lsbo = new lichsubo();
				request.setAttribute("dschuaxacnhan", lsbo.ThongTinDHChuaXacNhan(mkh));
				request.setAttribute("dsdaxacnhan", lsbo.ThongTinDHDaXacNhan(mkh));
			}
			else {
				request.setAttribute("mess", "Danh sách lịch sử trống!");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("lichsumuahang.jsp");
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
