package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import da.DuplicateException;
import da.NotFoundException;

import pd.User;

public class SignUp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName;
		String password;
		String identity;
		
		userName = req.getParameter("userName");
		password = req.getParameter("password");
		identity = req.getParameter("identity");
		
		if("teacher".equals(identity)) {
			identity = req.getParameter("type");
		}
		
		PrintWriter output = resp.getWriter();
		
		if("".equals(userName) || "".equals(password)) {
			output.println("<script type='text/javascript'>" +
					"alert('Username or password cannot be empty!');" +
					"window.location.href='" +
					"http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/signup.jsp" +
					"';</script>");
		} else try {
				User.initialize();
				User.find(userName);
					System.out.println("cunzai");
					//�����Ի�����ʾ�û����Ѿ�����
					output.println("<script type='text/javascript'>" +
							"alert('Sorry,but the name had been already registered Please change a name');" +
							"window.location.href='" +
							"http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/signup.jsp" +
							"';</script>");
				
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				//�������û�
				e.printStackTrace();
				System.out.println("eeee");
				System.out.println("bucunzai");
							User user = new User(userName, password, identity);
							try {
								user.add();
							} catch (DuplicateException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();	
							}
							output.println("<script type='text/javascript'>" +
									"alert('Congratulation! Register Successfully!');" +
									"window.location.href='" +
									"http://desktop-6m41rij:8080/Attendnece%20Management%20System/jsp/signup.jsp" +
									"';</script>");
			}
				
}
}
