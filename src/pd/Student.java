package pd;

import java.util.ArrayList;

import da.StudentDA;



public class Student {
private String id;//ѧ��
private int week;//�ܴ�
private String name;//����
private String mClass;//�༶
private ArrayList<Project> projects;//�γ�
private float attendenceRate;//������

public Student(String id, int week, String name, String mClass, ArrayList<Project> projects) {
	this.id = id;
	this.week = week;
	this.name = name;
	this.mClass = mClass;
	this.projects = projects;
}
public int getWeek() {
	return week;
}
public void setWeek(int week) {
	this.week = week;
}
public String getId() {
	return id;
}

public String getName() {
	return name;
}

public String getmClass() {
	return mClass;
}

public float getAttendenceRate() {
	return attendenceRate;
}

public void setId(String id) {
	this.id = id;
}

public void setName(String name) {
	this.name = name;
}

public void setmClass(String mClass) {
	this.mClass = mClass;
}

public static void calAttendenceRate() {
	
}

public void add() {
	StudentDA.add(this);
}

public static Student find(String name) {
	return StudentDA.find(name);
}

public  void update() {
	StudentDA.update(this);
}

public static void initialize() {
	StudentDA.initialize();
}

public static void terminate() {
	StudentDA.terminate();
}

}
