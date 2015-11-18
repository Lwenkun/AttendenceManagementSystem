package pd;

import java.util.ArrayList;

public class Student {
private String id;//学号
private String week;//周次
private String name;//姓名
private String mClass;//班级
private ArrayList<Project> projects;//课程
private float attendenceRate;//出勤率

public Student(String id, String week, String name, String mClass, ArrayList<Project> projects) {
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
public int getId() {
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

public void setId(int id) {
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
