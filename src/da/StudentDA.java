package da;

import java.net.PasswordAuthentication;
import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import pd.Student;

public class StudentDA {
	private static Student aStudent;
	//
	private static String url = "jdbc:mysql://localhost:3306/attendenceSystem";// !
	private static Connection aConnection;
	private static Statement aStatement;
	//
	private static String studentID; // ��ѧ��ID�����Σ���Ҫע��
	private static String name;
	private static String mClass;
	private static int week;

	private static int oop;
	private static int complexFunction;
	private static int assemblyLanguage;
	private static int chinese; // ��������Ϊ�¼���γ�
	private static int physics;
	private static int marx;

	// ��ע��������ط��ı�������ʵ�ʵ������������ǵ�����
	// ��������ע���Ǳ���
	private static int reaAttendence;

	// private static double attendenceRate;
	// private static ArrayList<String> subjectName = new ArrayList<String>();

	public static Connection initialize() {// ���ڽ�����洢���ݵ��ļ�������
		try {
			// loading jdbc - odbc bridge driver
			Class.forName("com.mysql.jdbc.Driver");

			// ����һ�����������ݿ�URL�����Ӻ�Statement��ʵ��
			aConnection = DriverManager.getConnection(url, "root", "");
			// ����Statementʵ��
			aStatement = aConnection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return aConnection;
	}

	// �ͷ�����ϵͳ��Դ
	public static void terminate() {
		try {
			aStatement.close();
			aConnection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// �����ݿ��м����ض��û�������ֵ
	public static Student find(String key) throws NotFoundException {
		//
		aStudent = null;
		// define the SQl query statement using the phone number key

		String sql = "SELECT * FROM student" + " WHERE studentid = " + key;
		//
		try {
			ResultSet rs = aStatement.executeQuery(sql);

			ArrayList<String> projectNameList = GlobalInfo.getProjectList();
			//
			boolean gotIt = rs.next();
			if (gotIt) {
				//
				studentID = rs.getString("studentid");
				name = rs.getString("name");
				week = rs.getInt("week");
				mClass = rs.getString("mClass");
				int att[] = new int[projectNameList.size()];
				for(int i = 0; i < projectNameList.size(); i ++) {
					att[i] = rs.getInt(projectNameList.size());
				}
				//reaAttendence = rs.getInt("reaAttendence");

				// �����ݿ��е��������õ��Ǵ�д������ط����Ե�
				oop = rs.getInt("OOP");
				complexFunction = rs.getInt("Complex_Function");
				assemblyLanguage = rs.getInt("Assembly_Language");
				chinese = rs.getInt("Chinese");
				physics = rs.getInt("Physics");
				marx = rs.getInt("Marx");

				aStudent = new Student(studentID, week, name, mClass, attMap);
				//
			} else {
				throw (new NotFoundException("û���ҵ���ѧ����"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
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
		
//		attMap.get()
//		oop = aStudent.getOOP();
//		complexFunction = aStudent.getComplexFunction();
//		assemblyLanguage = aStudent.getAssemblyLanguage();
//		chinese = aStudent.getChinese();
//		physics = aStudent.getPhysics();
//		marx = aStudent.getMarx();
		

		String sql = "INSERT INTO student (studentid,name,week,mClass,���,�������,���ݽṹ,��·����,��ѧ����,���亯��"
				+ ") VALUES ('" + studentID + "','" + name + "','"
				+ week + "','" + mClass + "','" + att[0] + "','" + att[1] + "','" + att[2] + "','"
				+ att[3] + "','" + att[4] + "','" + att[5] + "')";

		System.out.println(sql);

		try {
			Student t = find(studentID);
			throw (new DuplicateException("��ѧ���Ѵ��ڣ�"));
		} catch (NotFoundException e) {
			try {
				int result = aStatement.executeUpdate(sql);
			} catch (SQLException ee) {
				System.out.println(ee);
			}
		}
	}

	// ����Update�������ϴ�����д���������get������ֱ�ӻ�ȡ�γ̵ģ�����Ķ�̬������г���
	// ��������ط���֪����ô ��������������д��
	public static void update(Student aStudent) throws NotFoundException {
		id = aStudent.getId();
		name = aStudent.getName();
		week = aStudent.getWeek();
		mClass = aStudent.getmClass();
		//reaAttendence = aStudent.getReaAttendence();

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
