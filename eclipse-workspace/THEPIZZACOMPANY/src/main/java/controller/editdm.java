package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.danhmucbo;

/**
 * Servlet implementation class editdm
 */
@WebServlet("/editdm")
public class editdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editdm() {
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
    		String mdm = request.getParameter("madm");
    		String tendm = request.getParameter("tendm");
    		danhmucbo dmbo = new danhmucbo();
    		if(mdm!= null) {
    			dmbo.Sua(tendm, mdm);
    			response.sendRedirect("quanlydanhmuccontroller");
    		}
			
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
