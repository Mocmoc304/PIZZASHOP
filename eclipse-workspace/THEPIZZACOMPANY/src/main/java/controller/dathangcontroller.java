package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.danhmucbo;
import bo.giohangbo;

/**
 * Servlet implementation class dathangcontroller
 */
@WebServlet("/dathangcontroller")
public class dathangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dathangcontroller() {
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
			String tsp = request.getParameter("tsp");
			String gia = request.getParameter("gia");
			String msp = request.getParameter("msp");
            String anh = request.getParameter("anh");
			HttpSession session = request.getSession();
			
			
			if (tsp != null && msp != null && gia != null && anh!= null) {
				giohangbo g = null;
				// nếu ở đây giohangbo g = new giohangbo() thì cứ mỗi lần thêm sách là cấp phát
				
				// một vùng nhớ thêm một lần nữa
				// neu mua hang lan dau
				if (session.getAttribute("gh") == null) {// mua lần đầu
					g = new giohangbo();
					session.setAttribute("gh", g);// tao gio hang
				}
				// Gian session: gh vao bien: g
				g = (giohangbo) session.getAttribute("gh");
				// Them hang vao bien: g
				g.Them(msp, tsp, Long.parseLong(gia), anh, (long) 1);
				// Luu bien vao session
				session.setAttribute("gh", g);
				response.sendRedirect("dathangcontroller");
				return;
			}
			// Hien thi do trong session: gh
			if (session.getAttribute("gh") != null) {
				giohangbo g = new giohangbo();
				g = (giohangbo) session.getAttribute("gh");
			}
           
			RequestDispatcher rd = request.getRequestDispatcher("dathang.jsp");
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
	
	}

}
