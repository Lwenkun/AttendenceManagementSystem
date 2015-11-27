package da;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pd.Student;

public class StudentDA {
	private static Student aStudent;
	
	private static String url = "jdbc:mysql://localhost:3306/mydatabase";// !
	private static Connection aConnection;
	private static Statement aStatement;
	
	private static String studentID; 
	private static String name;
	private static String mClass;
	private static int week;

	public static Connection initialize() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			aConnection = DriverManager.getConnection(url, "root", "19960326");
			
			aStatement = aConnection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return aConnection;
	}

	// 释放所用系统资源
	public static void terminate() {
		try {
			aStatement.close();
			aConnection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// 从数据库中检索特定用户的属性值
	public static Student find(String key, int week) throws NotFoundException {
		//
		aStudent = null;
		// define the SQl query statement using the phone number key

		String sql = "SELECT * FROM student" + " WHERE studentid = '" + key + "' AND week ='" + week + "'";
		
		System.out.println(sql);
		//
		try {
			
			ResultSet rs = aStatement.executeQuery(sql);

			boolean gotIt = rs.next();
			if (gotIt) {
				//
				ArrayList<String> projectNameList = GlobalInfo.getProjectList();
				studentID = rs.getString("studentid");
				name = rs.getString("name");
				week = rs.getInt("week");
				mClass = rs.getString("class");
				int att[] = new int[projectNameList.size()];
				Map<String, Integer> attMap = new HashMap<>();
				for(int i = 0; i < projectNameList.size(); i ++) {
					System.out.println("wwwwww");
					System.out.println(projectNameList.get(i));
					att[i] = rs.getInt(projectNameList.get(i));
					attMap.put(projectNameList.get(i), att[i]);
				}
				//reaAttendence = rs.getInt("reaAttendence");

				// ！数据库中的命名我用的是大写，这个地方可以调

				aStudent = new Student(studentID, week, name, mClass, attMap);
				//
			} else {
				throw (new NotFoundException("没有找到此学生！"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aStudent;
	}

	public static void add(Student aStudent) throws DuplicateException {
		
		studentID = aStudent.getId();
		name = aStudent.getName();
		week = aStudent.getWeek();
		mClass = aStudent.getmClass();
	//	reaAttendence = aStudent.getReaAttendence();

		ArrayList<String> projectNameList = GlobalInfo.getProjectList();
		Map<String, Integer> attMap = aStudent.getAttMap();
		int[] att = new int[projectNameList.size()];
		for(int i = 0; i < projectNameList.size(); i ++) {
			att[i] = attMap.get(projectNameList.get(i));
		}
		
		String sql = "INSERT INTO student (studentid,name,week,class,Assembly,Oop,Data_Structure,Circuit_Theory,Physics,Complex_Function"
				+ ") VALUES ('" + studentID + "','" + name + "','"
				+ week + "','" + mClass + "','" + att[0] + "','" + att[1] + "','" + att[2] + "','"
				+ att[3] + "','" + att[4] + "','" + att[5] + "')";

		System.out.println(sql);

		try {
			Student t = find(studentID, week);
			throw (new DuplicateException("该学生本周次的出勤率已经录入，请不要重复录入！"));
		} catch (NotFoundException e) {
			try {
				int result = aStatement.executeUpdate(sql);
			} catch (SQLException ee) {
				System.out.println(ee);
			}
		}
	}

	// ！！Update参照书上代码所写，这里面的get方法有直接获取课程的，和你的动态数组会有出入
	// ！！这个地方不知道怎么 处理，暂且先这样写吧
	public static void update(Student aStudent) throws NotFoundException {
		
		studentID = aStudent.getId();
		
		ArrayList<String> projectNameList = GlobalInfo.getProjectList();
		Map<String, Integer> attMap = new HashMap<>();
		int[] att = new int[projectNameList.size()];
		for(int i = 0; i < projectNameList.size(); i ++) {
			att[i] = attMap.get(projectNameList.get(i));
		}
	//	Assembly,Oop,Data_Structure,Circuit _Theory,Physics,Complex_Function
		String sql = "UPDATE student SET "
				+ "Assembly = '" + att[0] + "'," + "Oop = '"
				+ att[1] + "'," + "Data_Structure = '" + att[2] + "'," + "Circuit_Theory = '" + att[3] + "',"
				+ "Physics = '" + att[4] + "'," + "Complex_Function = '" + att[5] + "' WHERE id = '" + studentID + "'";

		try {
			int result = aStatement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
