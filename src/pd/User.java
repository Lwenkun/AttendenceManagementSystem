package pd;

public class User {
	public static final String TEACHER = "��ʦ";
	public static final String ADMINISTRATOR = "����Ա";
	public static final String COUNSELOR = "����Ա";
	
	private String userName;
	private String password;
	//��ݣ���ʦ������Ա������Ա��
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
	
	public void initialize() {
		UserDA.initialize();
	}
	
	public void terminate() {
		UserDA.terminate();
	}
	
	public void add() {
		UserDA.add(this);
	}

	public static User find(String userName) {
		return UserDA.find(userName);
	}
}
