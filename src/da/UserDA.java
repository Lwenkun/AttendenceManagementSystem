package da;

import java.sql.*;

import pd.User;

public class UserDA {
	private static User aUser;
	
	private static String url = "jdbc:mysql://localhost:3306/mydatabase";
	private static Connection aConnection;
	private static Statement aStatement;

	private static String identity;
	private static String userName;
	private static String password;

	public static void initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			aConnection = DriverManager.getConnection(url, "root", "19960326");
			aStatement = aConnection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
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
	 * 查找该用户
	 * @param name
	 * @return
	 * @throws NotFoundException
	 */
	public static User find(String name) throws NotFoundException {
		
		aUser = null;

		String sql = "SELECT username,password,identity FROM user " + "WHERE username = '" + name + "'";

		try {
			
			ResultSet rs = aStatement.executeQuery(sql);
			boolean gotIt = rs.next();
			
			System.out.println("" + gotIt);
			if (gotIt) {
				userName = rs.getString("username");
				password = rs.getString("password");
				identity = rs.getString("identity");
				aUser = new User(userName, password, identity);
			} else
				throw (new NotFoundException("没有找到此用户！"));
			 rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return aUser;
	}
	
	/**
	 * 添加该用户
	 * @param User
	 * @throws DuplicateException
	 */
	public static void add(User User) throws DuplicateException {
		
		identity = User.getIdentity();
		userName = User.getUserName();
		password = User.getPassword();
		
		String sql = "INSERT INTO user (username,password,identity) VALUES('" 
		+ userName + "','" + password + "','" + identity + "')";
		
		System.out.println(sql);
		
		try{
			
			User c = find(userName);
			throw (new DuplicateException("该用户已存在！"));
			
		} catch (NotFoundException e) {
			
			try{
				
				int result = aStatement.executeUpdate(sql);
				
			} catch (SQLException ee) {
				System.out.println(ee);
			}
		}
	}

}






