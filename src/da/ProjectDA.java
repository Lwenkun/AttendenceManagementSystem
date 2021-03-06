package da;

import java.sql.*;
import java.util.ArrayList;

import pd.Project;

public class ProjectDA {
	private static Project aProject;
	
	private static String url = "jdbc:mysql://localhost:3306/mydatabase";
	private static Connection aConnection;
	private static Statement aStatement;
	
	private static int week;
	private static int num;
	private static String name;
	
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
	
	/**
	 * 根据课程名和周次查找某个课程的记录
	 * @param projectName
	 * @param week
	 * @return
	 * @throws NotFoundException
	 */
	public static Project find(String projectName, int week) throws NotFoundException {
	
		aProject = null;

		String sql = "SELECT * FROM projects WHERE name = '" + projectName + "' AND week = '" + week + "'"  ;
		
		try {
			ResultSet rs = aStatement.executeQuery(sql);

			boolean gotIt = rs.next();
			if (gotIt) {
				
				name = rs.getString("name");
				week = rs.getInt("week");
				num = rs.getInt("num");
				
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
	
	/**
	 * 获取有该课程的所有周次
	 * @param projectName
	 * @return
	 * @throws NotFoundException
	 */
	public static ArrayList<Integer> findForWeek(String projectName) throws NotFoundException {

	      String sql = "SELECT week FROM projects WHERE name = '" + projectName + "'" ;
	      
	      ArrayList<Integer> weeks = new ArrayList<Integer>();
		
		try {
			ResultSet rs = aStatement.executeQuery(sql);
			
			while(rs.next()) {
			
				week = rs.getInt("week");
			
				weeks.add(week);
			} 
			if(weeks.size() == 0) {
				throw (new NotFoundException("没有该课程的信息！"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return weeks;
	}
	
	public static void add(Project project) throws DuplicateException{
		aProject = null;
		
		name = project.getName();
		week = project.getWeek();
		num = project.getNum();
		
		String sql = "INSERT INTO projects (name,week,num) VALUES ('"
		+ name + "','" + week + "','" +  num + "')";
		
		System.out.println(sql);
		
		try{
			
			aProject = find(name, week);
			System.out.println("本课程该周次的数据已经录入，请不要重复录入");
			
		}catch(NotFoundException e){ 
			
			try{
				
				int result = aStatement.executeUpdate(sql);
				
			}catch(SQLException ee){
				
				System.out.println(ee);
				
			}
		}
	}

	/**
	 * 更新课程记录
	 * @param project 
	 * @throws NotFoundException
	 */
	public static void update(Project project) throws NotFoundException {
		
		name = project.getName();
		week = project.getWeek();
		num = project.getNum();

		String sql = "UPDATE projects SET name = '" + name + "'," 
		+ "week = '" + week + "'," 
				+ "num = '" + num + "'" +
		"WHERE name = '" + name + "'";

		try {
			int result = aStatement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}








