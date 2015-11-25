package da;

import java.sql.*;

import pd.User;

public class UserDA {
	private static User aUser;
	//
	private static String url = "jdbc:mysql://localhost:3306/mydatabase";
	private static Connection aConnection;
	private static Statement aStatement;
	//

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

	public static User find(String name) throws NotFoundException {

		String sql = "SELECT * FROM user" + "WHERE userName =" + name;

		try {
			ResultSet rs = aStatement.executeQuery(sql);

			boolean gotIt = rs.next();
			if (gotIt) {
				userName = rs.getString("userName");
				password = rs.getString("password");
				identity = rs.getString("identity");
				aUser = new User(userName, password, identity);
			} else
				throw (new NotFoundException("û���ҵ����û���"));
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return aUser;
	}
	
	public static void add(User User) throws DuplicateException {
		
		identity = User.getIdentity();
		userName = User.getUserName();
		password = User.getPassword();
		
		String sql = "INSERT INTO user (userName, password, identity) VALUES('" 
		+ userName + "','" + password + "','" + identity + "')";
		
		System.out.println(sql);
		
		try{
			aUser = find(userName);
			throw (new DuplicateException("���û��Ѵ��ڣ�"));
		} catch (NotFoundException e) {
			try{
				int result = aStatement.executeUpdate(sql);
			} catch (SQLException ee) {
				System.out.println(ee);
			}
		}
	}

}





