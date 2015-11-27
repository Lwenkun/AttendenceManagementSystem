package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.NotFoundException;

import pd.User;

public class Login extends HttpServlet {
	
	public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
	
	String userName;
	String password;
	
	String address = null;
	//��ȡ�û���������
	userName = req.getParameter("userName");
	password = req.getParameter("password");
	//��������û���ƥ����û�
	
	//����������ݿ����ҵ��û������û��������ǹ���Ա
	if("".equals(userName) || "".equals(password)) {
		address = "/jsp/error.jsp";
	} else {
		
		User user = null;
		try {
			User.initialize();
			user = User.find(userName);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}
		
		if(user != null) {
			
			if(password.equals(user.getPassword())) {
				
				switch (user.getIdentity()) {
				
				case User.ADMINISTRATOR :
					address = "/jsp/administratorchoice.jsp";
					break;
				case User.COUNSELOR :
					address = "/jsp/counselor.jsp";
					break;
				default :
					address = "/jsp/teacher.jsp";
					break;
				}
				
			} else {
				address = "/jsp/error.jsp";
				}
			
		} else {
			address = "/jsp/error.jsp";
		}
	}
	
	RequestDispatcher dispatcher = req.getRequestDispatcher(address);
	
	dispatcher.forward(req, res);
	}
}
