package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
		if("老师".equals(identity)) {
			identity = req.getParameter("type") + "老师";
		}
		
		PrintWriter output = resp.getWriter();
		
		if(User.find(userName) != null) {
			//弹出对话框，提示用户名已经存在
			output.println("<script type='text/javascript'>" +
					"alert('用户名已经存在<br>请换用其他用户名');" +
					"window.location.href='" +
					"http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/signup.jsp" +
					"';</script>");
			
		} else {
			//创建新用户
			User user = new User(userName, password, identity);
			user.add();
			output.println("<script type='text/javascript'>" +
					"alert('注册成功!');" +
					"window.location.href='" +
					"http://desktop-6m41rij:8080/Attendnece%20Management%20System/jsp/signup.jsp" +
					"';</script>");
		}
	}
	
}
