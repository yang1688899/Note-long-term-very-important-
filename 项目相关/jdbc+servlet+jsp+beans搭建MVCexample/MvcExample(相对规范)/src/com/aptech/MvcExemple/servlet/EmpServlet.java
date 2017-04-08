package com.aptech.MvcExemple.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aptech.MvcExemple.model.Emp;
import com.aptech.MvcExemple.service.EmpService;
import com.aptech.MvcExemple.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empno = request.getParameter("empno");
		
		Emp emp = new Emp();
		emp.setEmpno(empno);
		
		EmpService service = new EmpServiceImpl();
		ResultSet rs = service.select(emp);
		
		HttpSession session = request.getSession();
		session.setAttribute("rs", rs);
		
		response.sendRedirect("result.jsp");
	}

}
