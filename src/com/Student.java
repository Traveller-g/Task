package com;

class Student {
	//创建关于学生的属性
	String name;							//关于学生的姓名
	String code;							//关于学生的编号
	String sexy;							//关于学生的性别
	String age;								//关于学生的年龄
	String grade;							//关于学生的班级
	String major;							//关于学生的专业
	//构造函数
	Student(){								//无参构造函数
		
	}
	Student(String name,String code){		//带参构造函数
		this.name = name;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSexy() {
		return sexy;
	}
	public void setSexy(String sexy) {
		this.sexy = sexy;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String toString() {				//重写toString()方法
		String information = "姓名："+name+"学号："+code+"年龄："+age+"班级："+grade+"专业："+major;
		return information;
	}
	
	
}
