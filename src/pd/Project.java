package pd;

import java.util.ArrayList;

import da.DuplicateException;
import da.NotFoundException;
import da.ProjectDA;

public class Project {
    
	private String name;
	
	//���ſγ���ĳһ�ܵ�����
	private float attendenceRate;
	
	//�ܴ�
	private int week;
	
	//��ǰ�ܸÿ�Ŀ�Ľ���
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
	
	//������̬����
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
	
	//��ó�����
	public float getAttendenceRate() {
		return attendenceRate;
	}
	
	//��ȡ�ܴ�
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
	
	//���������
	public static void calAttendneceRate() {
		
	}

	//���һ����¼
	public void add() throws DuplicateException {
		ProjectDA.add(this);
	}

}
 