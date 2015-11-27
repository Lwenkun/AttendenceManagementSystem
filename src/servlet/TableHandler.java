package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.DuplicateException;
import da.GlobalInfo;
import da.GlobalInfo.StudentInfo;

import pd.Project;
import pd.Student;

public class TableHandler extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GlobalInfo.StudentInfo> infoList = GlobalInfo.getStudentInfoList();
		ArrayList<String> projectNameList = GlobalInfo.getProjectList();
		
//		int projectNum = projectNameList.size();
//		String[] projectNames = new String[projectNum];
//		
//		for(int i = 0; i < projectNameList.size(); i++) {
//			projectNames[i] = projectNameList.get(i);
//		}
		
		//与记录学生情况有关的变量
		StudentInfo info;
		Student student;
		String name;
		String studentID;
		String mClass;
		
		//记录当前周次
		int week = Integer.parseInt(req.getParameter("week"));
		for(int i = 0; i < infoList.size(); i ++) {
			
			//获取一条学生信息
			info = infoList.get(i);
			
			//获取信息详情
			name = info.getName();
		    studentID = info.getStudentID();
		    mClass = info.getClassName();
		    
		    //记录每个学生的每门功课的到课情况
		    HashMap<String, Integer> attMap = new HashMap<>();
		    for(int j = 0; j < projectNameList.size(); j++) {
		    	attMap.put(projectNameList.get(j), Integer.parseInt(req.getParameter(projectNameList.get(j) + i)));
		    	System.out.println(projectNameList.get(j));
		    	System.out.println(req.getParameter(projectNameList.get(j) + i));
		    }
		    
		    //将结果保存到数据库
		    try {
				student = new Student(studentID, week, name, mClass, attMap);
				student.add();
			} catch (DuplicateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println(studentID);
				System.out.println("" + week);
				System.out.println(name);
				System.out.println(mClass);
			}
			
		}
		
		//记录每门功课当周的实际节数
	    for(int j = 0; j < projectNameList.size(); j++ ) {
	    	
				Project project  = new Project(projectNameList.get(j), week, Integer.parseInt(req.getParameter(projectNameList.get(j))));
				try {
					project.add();
				} catch (DuplicateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	    }
		
	}
	
}
