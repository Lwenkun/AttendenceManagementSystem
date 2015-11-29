package pd;

import java.util.ArrayList;

import da.DuplicateException;
import da.NotFoundException;
import da.ProjectDA;

public class Project {
    
	private String name;
	
	//本门课程在某一周到课率
	private float attendenceRate;
	
	//周次
	private int week;
	
	//当前周该科目的节数
	private int num;
	
	/**
	 * 
	 * @param name
	 * @param attendenceRate
	 * @param week
	 * @param num
	 */
	public Project(String name, int week, int num) {
		this.name = name;
		this.week = week;
		this.num = num;
	}
	
	//三个静态方法
	public static void initialize() {
		ProjectDA.initialize();
	}
	
	public static void terminate() {
		ProjectDA.terminate();
	}
	
	public static Project find(String name, int week) throws NotFoundException{
		return ProjectDA.find(name, week);
	}
	
	public static ArrayList<Integer> findForWeek(String name) throws NotFoundException {
		return ProjectDA.findForWeek(name);
	}
	
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return num;
	}
	
	//获得出勤率
	public float getAttendenceRate() {
		return attendenceRate;
	}
	
	//获取周次
	public int getWeek() {
		return week;
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public void setWeek(int week) {
//		this.week = week;
//	}
	
	//计算出勤率
	public static void calAttendneceRate() {
		
	}

	//添加一条记录
	public void add() throws DuplicateException {
		ProjectDA.add(this);
	}

}
 