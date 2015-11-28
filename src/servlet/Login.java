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
import pd.TeacherType;
import pd.User;

public class Login extends HttpServlet {
	
	public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
	
	String userName;
	String password;
	
	String address = null;
	//获取用户名和密码
	userName = req.getParameter("userName");
	password = req.getParameter("password");
	//查找与该用户名匹配的用户
	
	//如果能在数据库中找到用户并且用户的类型是管理员
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
					//address = "/jsp/teacher.jsp";
					PrintWriter out = res.getWriter();
					printTable(out, user.getIdentity());
//					req.setAttribute("type", new TeacherType(user.getIdentity()));
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
	
//	public String findTeacherType(User user) {
//		String identity = user.getIdentity();
//		ArrayList<String> projectNameList = GlobalInfo.getProjectList();
//		String type;
//		for(int i = 0;i < projectNameList.size(); i++) {
//			if("identity".equals(projectNameList.get(i)))
//				
//		}
//	}
	
	public void printTable(PrintWriter out, String type) {
		
		ArrayList<String> projectNameList = GlobalInfo.getProjectList();
		out.println("<html>" +
				"<head>" +
				"</head>" +
				"<body>" +
				 "<p>" +
				 "您所教的科目各周到课率的情况为" +
				 "</p>" +
				"<table>");
		
		ArrayList<Integer> weeks = null;
		
		try {
			weeks = Project.findForWeek(type);
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int weekNum = weeks.size();
		 
		 //用于记录各周该学科的到课率
		 float rate[] = new float[weekNum];
		
		try {
			Project.initialize();
			
			int should[] = new int[weekNum];
			
			//获取学生总人数
			int studentNum  = GlobalInfo.getStudentInfoList().size();
			
			//计算该门课各周所有学生应该到的总节数
			for(int i = 0; i < weekNum; i++) {
				should[i] = Project.find(type, weeks.get(i)).getNum() * studentNum;
			}
			
			//计算该门课各周所有学生实际到的总节数，并算出各周该学科的到课率
		    for(int i = 0; i < weekNum; i++) {
		    	ArrayList<Integer> rates = Student.findForCalProjRate(type, weeks.get(i));
		    	int sum = 0;
		        for(int j = 0; j < rates.size(); j ++) {
		        	sum += rates.get(i);
		        }
		        rate[i] = sum / (float) should[i];
		    }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < weekNum; i++) {
			out.println("<tr>" +
					"<td>" +
					"第" + weeks.get(i) + "周：" +
					"</td>"  + 
					"<td>" +
					rate[i] +
					"</td>" +
					"</tr>");
		}
		
		out.println("</table>" +
				"</body>" +
				"</html>");
	}
}
