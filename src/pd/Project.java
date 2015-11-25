package pd;

import da.ProjectDA;

public class Project {
    //课程名
	private String name;
	//本门课程在某一周到课率
	private float attendenceRate;
	//周数
	private String week;
	//当前周的数量
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
	//获得出勤率
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
	//计算出勤率
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
 