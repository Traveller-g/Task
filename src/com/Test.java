package com;

import java.io.*;
import java.util.Scanner;

public class Test {
	public static void show() {
		

		
	}
	public static void select() {
		File file = new File("E:\\BIPT.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			int len;
			byte[] data = null;
			byte[] buffer = new byte[(int)file.length()];
			
			while((len=fis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}	
			
			data = bos.toByteArray();
			String str = new String (data);
			
			int count = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("输入你要查找的字或词：");
			char o = sc.next().charAt(0);
			char[] ch = str.toCharArray();
			for(int i = 0;i<ch.length;i++) {
				if(o==ch[i]) {
					count++;
				}
			}
			System.out.println("共出现"+count+"次");
			fis.close();
			bos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void txt(){
		
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		//请输入姓名，编号，性别，年龄，班级，专业;
		System.out.print("姓名\n");
		student.name = scanner.next();
		System.out.print("学号\n");
		student.code = scanner.next();
		System.out.print("性别\n");
		student.sexy = scanner.next();
		System.out.print("年龄\n");
		student.age = scanner.next();
		System.out.print("班级\n");
		student.grade = scanner.next();
		System.out.print("专业\n");
		student.major = scanner.next();
		
		
		File file = new File("E:\\BIPT.txt");
		try {
			FileReader fInputStream = new FileReader(file);
			FileWriter fOutputStream  = new FileWriter("E:\\BIPT2.txt");
			char[] b = student.toString().toCharArray();
			fOutputStream.write(b);
			fOutputStream.write("\n\n");
			
			int p=(int)file.length();
			char[] a = new char[p];
			fInputStream.read(a);
			int x=0;
			int y=7;
			for(int j = 7;j<=file.length()-470;j=j+7,x+=7,y+=7) {
				if(j%2==0) {
					for(int i=x;i<j;i++) {
						char c=a[i];
					fOutputStream.write(c);
					}
					fOutputStream.write(".\n");
					
				}else {
					for(int i=x;i<j;i++) {
						char c=a[i];
					fOutputStream.write(c);
					}
					fOutputStream.write(",");
				}
			}
			
			fInputStream.close();
			fOutputStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}