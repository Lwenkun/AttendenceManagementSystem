package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.GlobalInfo;
import da.NotFoundException;

import pd.Student;

public class UpdateHandler extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> projectNameList = GlobalInfo.getProjectList();
		Map<String, Integer> attMap = new HashMap<>();
		String studentID = req.getParameter("studentID");
		for(int i = 0; i < projectNameList.size(); i ++) {
			
			attMap.put(projectNameList.get(i), Integer.parseInt(req.getParameter(projectNameList.get(i))));
		}
		int week = Integer.parseInt(req.getParameter("week"));
		PrintWriter output = res.getWriter();
		System.out.println(studentID + week);
		try {
			
			Student student = new Student(studentID, week, null, null, attMap);
			
			student.update();
			
			output.println("<script type='text/javascript'>" +
					"alert('Updata successfully!');" +
					"window.location.href='" +
					"http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/adminupdate.jsp" +
					"';</script>");
			
		} catch(NotFoundException e) {
			
			output.println("<script type='text/javascript'>" +
					"alert('Updata failed!');" +
					"window.location.href='" +
					"http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/adminupdate.jsp" +
					"';</script>");
			e.printStackTrace();
		}
	}

	
}
