package da;

import java.sql.*;

import pd.Project;

public class ProjectDA {
	private static Project aProject;
	//
	private static String url = "jdbc:mysql://localhost:3306/attendenceSystem";
	private static Connection aConnection;
	private static Statement aStatement;
	
	private static int subjectID;
	private static int week;
	private static int expectNumber;
	private static String subjectName;
	
	public static Connection initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			aConnection = DriverManager.getConnection(url, "root", "");
			aStatement = aConnection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return (aConnection);
	}

	public static void terminate() {
		try {
			aConnection.close();
			aStatement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static Project find(int key) throws NotFoundException {
		//
		aProject = null;
		// define the SQl query statement using the phone number key

		String sql = "SELECT * FROM subject" + " WHERE subjectID = " + key;
		//
		try {
			ResultSet rs = aStatement.executeQuery(sql);

			//
			boolean gotIt = rs.next();
			if (gotIt) {
				//
				subjectID = rs.getInt("subjectID");
				week = rs.getInt("week");
				expectNumber = rs.getInt("expectNumber");
				subjectName = rs.getString("subjectName");

				//
			} else {
				throw (new NotFoundException("没有找到此课程！"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return aProject;
	}
	
	public static void add(Project project) throws DuplicateException{
		subjectID = project.getId();
		week = project.getWeek();
		expectNumber = project.getExpectNumber();
		subjectName = project.getName();
		
		String sql = "INSERT INTO subject (week,expectNumber,subjectName)VALUES (" 
		+ week + "," + expectNumber + ",'" + subjectName +"')";
		
		System.out.println(sql);
		
		try{
			aProject = find(subjectID);
		}catch(NotFoundException e){
			try{
				int result = aStatement.executeUpdate(sql);
			}catch(SQLException ee){
				System.out.println(ee);
			}
		}
	}

	public static void update(Project project) throws NotFoundException {
		subjectID = project.getID();
		subjectName = project.getName();
		week = project.getName();
		expectNumber = project.getExpectNumber();

		String sql = "UPDATE Subject SET subjectName = '" + subjectName + "'," 
		+ "week = " + week + "," + "expectNumber = " + expectNumber 
		+ "WHERE subjectID = " + subjectID;

		try {
			int result = aStatement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}








