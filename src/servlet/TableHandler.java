package servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		int projectNum = projectNameList.size();
		String[] projectNames = new String[projectNum];
		
		for(int i = 0; i < projectNameList.size(); i++) {
			projectNames[i] = projectNameList.get(i);
		}
		
		
		StudentInfo info;
		Student student;
		String name;
		String studentID;
		String mClass;
		String yuwen;
		
		String shuxue;
		String yingyu;
		String wuli;
		String huaxue;
		String shengwu;
		String week;
		ArrayList<Project> projects;
		week = req.getParameter("week");
		for(int i = 0; i < 10; i ++) {
			info = infoList.get(i);
			name = info.getName();
		    studentID = info.getStudentID();
		    mClass = info.getClassName();
		    
		    yuwen = new Project(req.getParameter("yuwen" + i);
		    shuxue = req.getParameter("shuxue" + i);
		    yingyu = req.getParameter("yingyu" + i);
		    wuli = req.getParameter("wuli" + i);
		    shengwu = req.getParameter("shengwu" +i);
		    huaxue = req.getParameter("huaxue" + i);
		    projects.add(new Project(req.getParameter("yuwen" + i)), week, get);
			System.out.println(req.getParameter("studnet4"));
		}
		
	}
	

}
