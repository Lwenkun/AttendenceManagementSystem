package pd;

import java.util.ArrayList;
import java.util.Map;

import da.DuplicateException;
import da.NotFoundException;
import da.StudentDA;



public class Student {
	
private String id;//学号
private int week;//周次
private String name;//姓名
private String mClass;//班级
private Map<String, Integer> attMap;//课程

public Student(String id, int week, String name, String mClass, Map<String, Integer> attMap) {
	this.id = id;
	this.week = week;
	this.name = name;
	this.mClass = mClass;
	this.attMap = attMap;
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

public Map<String, Integer> getAttMap() {
	return attMap;
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


public void add() throws DuplicateException {
	StudentDA.add(this);
}

public static Student find(String name, int week) throws NotFoundException {
	return StudentDA.find(name, week);
}

public void update() throws NotFoundException {
	StudentDA.update(this, week);
}

public static void initialize() {
	StudentDA.initialize();
}

public static void terminate() {
	StudentDA.terminate();
}

//根据课程名和周次获取本周该课程所有学生的到课情况
public static ArrayList<Integer> findForCalProjRate(String projectName, int week) throws NotFoundException {
	return StudentDA.findForCalProjRate(projectName, week);
}

//获取某位学生的所有周次的记录
public static ArrayList<Student> findStudents(String studentID) {
	
	return StudentDA.findStudents(studentID);
}
}
