package pd;

import da.DuplicateException;
import da.NotFoundException;
import da.UserDA;

public class User {
	public static final String TEACHER = "teacher";
	public static final String ADMINISTRATOR = "administrator";
	public static final String COUNSELOR = "counselor";
	
	private String userName;
	private String password;
	//用户身份，有管理员，老师，辅导员
	private String identity;
	
	public User(String userName, String password, String identity) {
		this.userName = userName;
		this.password = password;
		this.identity = identity;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getIdentity() {
		return identity;
	}
	
	public static void initialize() {
		UserDA.initialize();
	}
	
	public static void terminate() {
		UserDA.terminate();
	}
	
	public void add() throws DuplicateException {
		UserDA.add(this);
	}

	public static User find(String userName) throws NotFoundException {
		return UserDA.find(userName);
	}
}
