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
		if("��ʦ".equals(identity)) {
			identity = req.getParameter("type") + "��ʦ";
		}
		
		PrintWriter output = resp.getWriter();
		
		if(User.find(userName) != null) {
			//�����Ի�����ʾ�û����Ѿ�����
			output.println("<script type='text/javascript'>" +
					"alert('�û����Ѿ�����<br>�뻻�������û���');" +
					"window.location.href='" +
					"http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/signup.jsp" +
					"';</script>");
			
		} else {
			//�������û�
			User user = new User(userName, password, identity);
			user.add();
			output.println("<script type='text/javascript'>" +
					"alert('ע��ɹ�!');" +
					"window.location.href='" +
					"http://desktop-6m41rij:8080/Attendnece%20Management%20System/jsp/signup.jsp" +
					"';</script>");
		}
	}
	
}
