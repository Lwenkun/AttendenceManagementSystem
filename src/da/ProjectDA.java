package da;

import java.sql.*;

import pd.Project;

public class ProjectDA {
	private static Project aProject;
	//
	private static String url = "jdbc:mysql://localhost:3306/attendenceSystem";
	private static Connection aConnection;
	private static Statement aStatement;
	
	private static int week;
	private static int num;
	private static String name;
	
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
	
	public static Project find(String key) throws NotFoundException {
		//
		aProject = null;
		// define the SQl query statement using the phone number key

		String sql = "SELECT * FROM project" + " WHERE name = " + key;
		//
		try {
			ResultSet rs = aStatement.executeQuery(sql);

			//
			boolean gotIt = rs.next();
			if (gotIt) {
				//
				name = rs.getString("name");
				week = rs.getInt("week");
				num = rs.getInt("num");
				
				//
				aProject = new Project(name, week, num);
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
		
		week = project.getWeek();
		num = project.getNum();
		name = project.getName();
		
		String sql = "INSERT INTO project (week,num,name) VALUES ("
		+ week + "','" + num + "','" + name + "')";
		
		System.out.println(sql);
		
		try{
			
			aProject = find(name);
			
		}catch(NotFoundException e){ 
			
			try{
				
				int result = aStatement.executeUpdate(sql);
				
			}catch(SQLException ee){
				
				System.out.println(ee);
				
			}
		}
	}

	public static void update(Project project) throws NotFoundException {
		
		name = project.getName();
		week = project.getWeek();
		num = project.getNum();

		String sql = "UPDATE Subject SET name = '" + name + "'," 
		+ "week = " + week + "," 
				+ "num = '" + num + "'" +
		"WHERE name = '" + name + "'";

		try {
			int result = aStatement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}








