package da;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pd.Student;

public class StudentDA {
	private static Student aStudent;
	
	private static String url = "jdbc:mysql://localhost:3306/mydatabase";
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

	public static void terminate() {
		try {
			aStatement.close();
			aConnection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

    /**
     * 
     * @param key 学生ID
     * @param week 周次
     * @return 该周次该学生的一条记录
     * @throws NotFoundException
     */
	public static Student find(String key,int week) throws NotFoundException {
		
		aStudent = null;

		String sql = "SELECT * FROM student" + " WHERE studentid = '" + key + "' AND week ='" + week + "'";
		
		System.out.println(sql);
		
		try {
			
			ResultSet rs = aStatement.executeQuery(sql);

			boolean gotIt = rs.next();
			if (gotIt) {
				
				ArrayList<String> projectNameList = GlobalInfo.getProjectList();
				studentID = rs.getString("studentid");
				name = rs.getString("name");
				week = rs.getInt("week");
				mClass = rs.getString("class");
				int att[] = new int[projectNameList.size()];
				Map<String, Integer> attMap = new HashMap<>();
				for(int i = 0; i < projectNameList.size(); i ++) {
					
					att[i] = rs.getInt(projectNameList.get(i));
					attMap.put(projectNameList.get(i), att[i]);
				}

				aStudent = new Student(studentID, week, name, mClass, attMap);
				
			} else {
				throw (new NotFoundException("没有找到此学生！"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aStudent;
	}

	/**
	 * 添加某个学生的一条记录
	 * @param aStudent
	 * @throws DuplicateException
	 */
	public static void add(Student aStudent) throws DuplicateException {
		
		studentID = aStudent.getId();
		name = aStudent.getName();
		week = aStudent.getWeek();
		mClass = aStudent.getmClass();

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

	/**
	 *更新某个学生某一周的到课情况
	 * @param aStudent
	 * @param week
	 * @throws NotFoundException
	 */
	public static void update(Student aStudent, int week) throws NotFoundException {
		
		studentID = aStudent.getId();
		
		ArrayList<String> projectNameList = GlobalInfo.getProjectList();
		Map<String, Integer> attMap = aStudent.getAttMap();
		int[] att = new int[projectNameList.size()];
		for(int i = 0; i < projectNameList.size(); i ++) {
			att[i] = attMap.get(projectNameList.get(i));
		}
	
		String sql = "UPDATE student SET "
				+ "Assembly = '" + att[0] + "'," + "Oop = '"
				+ att[1] + "'," + "Data_Structure = '" + att[2] + "'," + "Circuit_Theory = '" + att[3] + "',"
				+ "Physics = '" + att[4] + "'," + "Complex_Function = '" + att[5] + "' WHERE studentid = '" + studentID + "' AND week = '" + week + "'";

		System.out.println(sql);
		try {
			int result = aStatement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
   /**
    * 用于计算某门课的到课率
    * @param key 科目类型
    * @param week 周次
    * @return 一个该周所有学生该科目的实到课率数组
    * @throws NotFoundException
    */
	public static ArrayList<Integer> findForCalProjRate(String key, int week) throws NotFoundException {
		
		aStudent = null;
		
		ArrayList<Integer> rates = new ArrayList<>();
		
		String sql = "SELECT " + key + " FROM student WHERE week = '" + week + "'";
		
		System.out.println(sql);
		
		try {
			
			ResultSet rs = aStatement.executeQuery(sql);
			
			while(rs.next()) {
				rates.add(rs.getInt(key));
			}  
			if (rates.size() == 0){
				throw (new NotFoundException("没有该科目该周次的信息"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rates;
	}
	
	/**
	 * 根据学生ID查找该学生所有周次的记录
	 * @param key
	 * @return
	 */
	public static  ArrayList<Student> findStudents(String key) {
		
		studentID = key;
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		System.out.println(studentID + "dad");
		
		String sql = "SELECT * FROM student WHERE studentid = '" + studentID + "'"; 
		
		System.out.println(sql);
		
		try {
			ResultSet rs = aStatement.executeQuery(sql);
			
			while(rs.next()) {
				
				String name = rs.getString("name");
				int week = rs.getInt("week");
				String mClass = rs.getString("class");
				ArrayList<String> projectNameList = GlobalInfo.getProjectList();
				int att[] = new int[projectNameList.size()];
				Map<String, Integer> attMap = new HashMap<>();
				for(int i = 0; i < projectNameList.size(); i ++) {
					
					att[i] = rs.getInt(projectNameList.get(i));
					attMap.put(projectNameList.get(i), att[i]);
				}
				
				students.add(new Student(null, week, name, mClass, attMap));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}


}
