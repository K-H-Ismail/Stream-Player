package pack;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	Facade facade = new Facade();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		ServletContext context = getServletContext( );
		context.log("This is a log item");
		
		if (op.equals("ajoutCompte")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			facade.ajoutCompte(login,password,email);
			response.getWriter().println("<meta http-equiv='refresh' content='0; index.html\' />");
		}

		if (op.equals("connection")) {
			String login = request.getParameter("un");
			String password = request.getParameter("pw");
			Compte compte = facade.chercherCompte(login, password);
			if (compte != null) {
				request.setAttribute("login", login);
				request.getRequestDispatcher("signup/loginSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("signup/loginInvalid.jsp").forward(request, response);
			}

		}

		if (op.equals("logout")) {

		}
	}

}
