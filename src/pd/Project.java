package pd;

import da.ProjectDA;

public class Project {
    //�γ���
	private String name;
	//���ſγ���ĳһ�ܵ�����
	private float attendenceRate;
	//����
	private String week;
	//��ǰ�ܵ�����
	private String num;
	
	/**
	 * 
	 * @param name
	 * @param attendenceRate
	 * @param week
	 * @param num
	 */
	public Project(String name, String week, String num) {
		this.name = name;
		this.week = week;
		this.num = num;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	//��ó�����
	public float getAttendenceRate() {
		return attendenceRate;
	}
	
	public int getWeek() {
		return week;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeek(int week) {
		this.week = week;
	}
	//���������
	public static void calAttendneceRate() {
		
	}
	
	public static void initialize() {
		ProjectDA.initialize();
	}
	
	public void add() {
		ProjectDA.add(this);
	}
	
	public static void terminate() {
		ProjectDA.terminate();
	}
	
	public Project find(String name) {
		return ProjectDA.find(name);
	}

}
 