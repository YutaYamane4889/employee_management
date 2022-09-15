package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDAO;
import model.entity.EmployeeBean;

/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/employee-list-servlet")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("servlethanter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
		HttpSession session = request.getSession();
		String order = null;
		String section = null;
		order=request.getParameter("order");
		section = request.getParameter("section");
		if(section==null) {
			section = (String)session.getAttribute("section");
		}
		session.setAttribute("section", section);


		if(order==null) {
			order="employee_code";
		}
		EmployeeDAO dao = new EmployeeDAO();
		if (section==null||section.equals("all")) {
			try {
				// DAOの利用
			employeeList = dao.allEmployee(order);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			try {
				employeeList = dao.sectionAllEmployee(order,section);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		request.setAttribute("employeeList", employeeList);
		RequestDispatcher rd = request.getRequestDispatcher("employee-list.jsp");
		rd.forward(request, response);
	}

}
