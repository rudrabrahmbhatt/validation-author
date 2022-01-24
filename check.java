package task1;
  
import java.io.IOException;
import java.io.PrintWriter;
//
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/auth_user")//web annotation: @webServlet(form action name)
public class check extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
//
		String userid = req.getParameter("uname");
		String upass = req.getParameter("passwd");

		ServletConfig config = getServletConfig();

		String passwd1 = config.getInitParameter("rudra1");

		ServletContext context = getServletContext();

		String passwd2 = context.getInitParameter("rudra2");

		System.out.println(passwd1);
		if (userid.equals("rudra1") && upass.equals(passwd1)) {
			out.println("<h1>Welcome Dear: " + userid+ "</h1>");
		}

		else if (userid.equals("rudra2") && upass.equals(passwd2)) {
			out.println("<h1>Welcome Dear: " + userid + "</h1>");
		}

		else {
			RequestDispatcher RD = req.getRequestDispatcher("not_allowed.html");
			RD.include(req, res);

		}
	}

	public void destroy() {
	}
}
