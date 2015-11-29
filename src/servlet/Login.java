package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.GlobalInfo;
import da.NotFoundException;

import pd.Project;
import pd.Student;
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
					address = "/jsp/individual.jsp";
					break;
				default :
					
					PrintWriter out = res.getWriter();
					printTable(out, user.getIdentity());

					break;
				}
				
			} else {
				address = "/jsp/error.jsp";
				}
			
		} else {
			address = "/jsp/error.jsp";
		}
	}
	if(address != null) {
		RequestDispatcher dispatcher = req.getRequestDispatcher(address);
		
		dispatcher.forward(req, res);
	}
}
	
	public void printTable(PrintWriter out, String type) {
		
		ArrayList<String> projectNameList = GlobalInfo.getProjectList();
		out.println("<html>" +
				"<head>" +
				"</head>" +
				"<body><center>" +
				 "<p><b>" +
				 "The AttendenceRates of the project you teach:" +
				 "</b></p>" +
				"<table border='1'>");
		
		ArrayList<Integer> weeks = null;
		
		try {
			Project.initialize();
			weeks = Project.findForWeek(type);
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int weekNum = weeks.size();
		 
		 //���ڼ�¼���ܸ�ѧ�Ƶĵ�����
		 float rate[] = new float[weekNum];
		
		try {
			Student.initialize();
			
			int should[] = new int[weekNum];
			
			//��ȡѧ��������
			int studentNum  = GlobalInfo.getStudentInfoList().size();
			
			//������ſθ�������ѧ��Ӧ�õ����ܽ���
			for(int i = 0; i < weekNum; i++) {
				should[i] = Project.find(type, weeks.get(i)).getNum() * studentNum;
			}
			
			//������ſθ�������ѧ��ʵ�ʵ����ܽ�������������ܸ�ѧ�Ƶĵ�����
		    for(int i = 0; i < weekNum; i++) {
		    	ArrayList<Integer> rates = Student.findForCalProjRate(type, weeks.get(i));
		    	int sum = 0;
		        for(int j = 0; j < rates.size(); j ++) {
		        	sum += rates.get(i);
		        }
		        rate[i] = (float) sum / (float) should[i];
		    }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < weekNum; i++) {
			out.println("<tr>" +
					"<th>" +
					"week" + weeks.get(i) + ":" +
					"</th>"  + 
					"<td>" +
					rate[i] +
					"</td>" +
					"</tr>");
		}
		
		out.println("</table>" +
				"</center></body>" +
				"</html>");
	}
}
