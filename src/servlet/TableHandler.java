package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.Project;

public class TableHandler extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name;
		String id;
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
			name = req.getParameter("student" + i);
		    id = req.getParameter("studentid" + i);
		    mClass = req.getParameter("class" + i);
		    yuwen = new Project(req.getParameter("yuwen" + i);
		    shuxue = req.getParameter("shuxue" + i);
		    yingyu = req.getParameter("yingyu" + i);
		    wuli = req.getParameter("wuli" + i);
		    shengwu = req.getParameter("shengwu" +i);
		    huaxue = req.getParameter("huaxue" + i);
		    projects.add(yuwen);
			System.out.println(req.getParameter("studnet4"));
		}
		
	}
	

}
