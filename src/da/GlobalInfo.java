package da;

import java.sql.*;
import java.util.*;

/**
 * 全局信息
 * @author 15119
 *
 */
public class GlobalInfo {
	
	private static final int STUDENTID = 1;
	private static final int NAME = 2;
	private static final int CLASS = 3;
	private static final int PROJECT = 1;
	
	private static Connection aConnection;
	private static Statement aStatement;
	public static final String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
	
	public static ArrayList<StudentInfo> getStudentInfoList() {
		ArrayList<StudentInfo> infoList = new ArrayList<>();
		initialize();
		String sqlx = "SELECT studentid,name,class FROM globalinfo";
		
		try {
			ResultSet rs = aStatement.executeQuery(sqlx);
			while(rs.next()) {
				infoList.add(new StudentInfo(rs.getString(STUDENTID), rs.getString(NAME), rs.getString(CLASS)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		terminate();
		
		return infoList;
	}
	
	//获取课程名数组
	public static ArrayList<String> getProjectList() {
		ArrayList<String> projectList = new ArrayList<>();
		initialize();
		String sqlx = "SELECT project FROM globalinfo WHERE project != 'null'";
		
		try {
			ResultSet rs = aStatement.executeQuery(sqlx);
			while(rs.next()) {
				projectList.add(rs.getString(PROJECT));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		terminate();
		
		return projectList;
	}
	
	
	private static void initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			aConnection = DriverManager.getConnection(url, "root", "19960326");
			aStatement = aConnection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void terminate() {
		try {
			aStatement.close();
			aConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//获取学生信息但不包括到课情况
	public static class StudentInfo{
		String studentID;
		
		String name;
		
		String className;
		
		public StudentInfo(String studentID, String name, String className) {
			this.studentID = studentID;
			this.name = name;
			this.className = className;
		}
		
		public String getStudentID() {
			return studentID;
		}
		
		public String getName() {
			return name;
		}
		
		public String getClassName() {
			return className;
		}
		
	}
	
}
