package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.GlobalInfo;
import da.NotFoundException;

import pd.Project;
import pd.Student;

public class CounselorChoiceHandler extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		     PrintWriter out = res.getWriter();
		     String studentID = req.getParameter("studentID");
		     System.out.println(studentID);
		     printIndividual(out, studentID);
		     Student.terminate();
		     Project.terminate();
		
	}
	
	/**
	 * ���ĳ��ѧ�������е������
	 * @param out
	 * @param studentID
	 */
	public void printIndividual(PrintWriter out, String studentID) {
		
	     Student.initialize();
	     System.out.println(studentID);
	     ArrayList<Student> students = Student.findStudents(studentID);	     
	     out.println("<html>" +
	     		"<head" +
	     		"<meta content='text/html; charset=utf-8' http-equiv='content-type'>" +
	     		"</head>" +
	     		"<center>" +
	     		"<body>" +
	     		"<p>The Result You Are Searching:</p>" +
	     		"<p>studentID:" + studentID + " Name:" + students.get(0).getName() + " Class:" + students.get(0).getmClass() + "</p>" +
	     		"<table border='1'>");
	     
	     out.println("<tr>" +
	    	 		"<th>week</th>");
	     
	     Project.initialize();
	    	 ArrayList<String> projectNameList = GlobalInfo.getProjectList();
	    	 
	    	 //�����ͷ
	    	 for(int j = 0; j < projectNameList.size(); j ++ ) {
	    		 out.println("<th>" + projectNameList.get(j) + "</th>");
	    	 }
	    	 out.println("</tr>");
	    	 
	     Student student;
	     Map<String, Integer> attMap = null;
	     float rates[] = new float[projectNameList.size()];
//	    ѭ�� ���ѧ�����ܵĿ������
	     for(int i = 0; i< students.size(); i ++) {
	    	 student = students.get(i);
	    	 attMap = student.getAttMap();
	    	 
	    	 //����ܴ�
	    	 out.println("<tr>" +
	    	 		"<td>" + student.getWeek() + "</td>");
	    	 
	    	 //��ȡ���ܴεĸ��Ƶĵ������
	    	 for(int j = 0 ; j < projectNameList.size(); j ++) {
	    		 
	    		 int should = 1;
	    		 
				try {
					should = Project.find(projectNameList.get(j), student.getWeek()).getNum();
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		 rates[j] = (float)attMap.get(projectNameList.get(j)) / (float)should;
	    	 }
	    	 
	    	//ѭ�����ѧ��ÿ�ܵĵ������
	    	 for(int j = 0; j < projectNameList.size(); j++ ) {
	    		 out.println("<td>" + rates[j] + "</td>");
	    	 }
	    	 out.println("</tr>");
	    	 
	     }
	     
	     out.println("</table>" +
	     		"</center>" +
	     		"</body>" +
	     		"</html>");
	}
	
}
