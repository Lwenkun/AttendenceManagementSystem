package da;

import java.net.PasswordAuthentication;
import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;

import pd.Student;

public class StudentDA {
	private static Student aStudent;
	//
	private static String url = "jdbc:mysql://localhost:3306/attendenceSystem";// !
	private static Connection aConnection;
	private static Statement aStatement;
	//
	private static int id; // ！学生ID是整形！需要注意
	private static String name;
	private static int mClass;
	private static int week;

	private static int oop;
	private static int complexFunction;
	private static int assemblyLanguage;
	private static int chinese; // ！后三门为新加入课程
	private static int physics;
	private static int marx;

	// ！注意我这个地方的变量，是实际到课人数，不是到课率
	// 后面两行注释是备用
	private static int reaAttendence;

	// private static double attendenceRate;
	// private static ArrayList<String> subjectName = new ArrayList<String>();

	public static Connection initialize() {// 用于建立与存储数据的文件的连接
		try {
			// loading jdbc - odbc bridge driver
			Class.forName("com.mysql.jdbc.Driver");

			// 创建一个到给定数据库URL的连接和Statement的实例
			aConnection = DriverManager.getConnection(url, "root", "");
			// 创建Statement实例
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
	public static Student find(int key) throws NotFoundException {
		//
		aStudent = null;
		// define the SQl query statement using the phone number key

		String sql = "SELECT * FROM student" + " WHERE id = " + key;
		//
		try {
			ResultSet rs = aStatement.executeQuery(sql);

			//
			boolean gotIt = rs.next();
			if (gotIt) {
				//
				id = rs.getInt("id");
				name = rs.getString("name");
				week = rs.getInt("week");
				mClass = rs.getInt("mClass");
				reaAttendence = rs.getInt("reaAttendence");

				// ！数据库中的命名我用的是大写，这个地方可以调
				oop = rs.getInt("OOP");
				complexFunction = rs.getInt("Complex_Function");
				assemblyLanguage = rs.getInt("Assembly_Language");
				chinese = rs.getInt("Chinese");
				physics = rs.getInt("Physics");
				marx = rs.getInt("Marx");

				//
			} else {
				throw (new NotFoundException("没有找到此学生！"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return aStudent;
	}

	public static void add(Student aStudent) throws DuplicateException {
		id = aStudent.getId();
		name = aStudent.getName();
		week = aStudent.getWeek();
		mClass = aStudent.getmClass();
		reaAttendence = aStudent.getReaAttendence();

		oop = aStudent.getOOP();
		complexFunction = aStudent.getComplexFunction();
		assemblyLanguage = aStudent.getAssemblyLanguage();
		chinese = aStudent.getChinese();
		physics = aStudent.getPhysics();
		marx = aStudent.getMarx();

		String sql = "INSERT INTO student(id,name,week,mClass,reaAttendence,oop,"
				+ "Complex_Function,Assembly_Language,Chinese,Physics,Marx) VALUES ('" + id + "','" + name + "','"
				+ week + "','" + mClass + "','" + +oop + "','" + "complexFunction" + "','" + assemblyLanguage + "','"
				+ chinese + "','" + physics + "','" + marx + "')";

		System.out.println(sql);

		try {
			Student t = find(id);
			throw (new DuplicateException("该学生已存在！"));
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
		id = aStudent.getId();
		name = aStudent.getName();
		week = aStudent.getWeek();
		mClass = aStudent.getmClass();
		reaAttendence = aStudent.getReaAttendence();

		oop = aStudent.getOOP();
		complexFunction = aStudent.getComplexFunction();
		assemblyLanguage = aStudent.getAssemblyLanguage();
		chinese = aStudent.getChinese();
		physics = aStudent.getPhysics();
		marx = aStudent.getMarx();

		String sql = "UPDATE student SET name = '" + name + "'," + "mClass = " + mClass + "," + "week = " + week + ","
				+ "reaAttendence = " + reaAttendence + "," + "OOP = " + oop + "," + "Complex_Function = "
				+ complexFunction + "," + "Assembly_Language = " + assemblyLanguage + "," + "Chinese = " + chinese + ","
				+ "Physics = " + physics + "," + "Marx = " + marx + "WHERE id = " + id;

		try {
			int result = aStatement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
