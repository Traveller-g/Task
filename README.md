# 模拟学生作业处理 计G201 郭纪伟 2020322076
---
### ___实验目的___  
1.掌握字符串String及其方法的使用  
2.掌握文件的读取/写入方法  
3.掌握异常处理结构  
### ___业务要求___  
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。  
文件A包括两部分内容：  
一是学生的基本信息；  
二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：  
1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”;  
2.允许提供输入参数，统计古诗中某个字或词出现的次数;  
3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A;    
4.考虑操作中可能出现的异常，在程序中设计异常处理程序;    
### ___输入：___  
汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝
选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起
娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早
朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉
楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高
处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽
衣曲九重城阙烟尘生千乘万骑西南行<未完，待续>  
### ___输出：___  
汉皇重色思倾国，御宇多年求不得。  
杨家有女初长成，养在深闺人未识。  
天生丽质难自弃，一朝选在君王侧。  
回眸一笑百媚生，六宫粉黛无颜色。  
春寒赐浴华清池，温泉水滑洗凝脂。  
侍儿扶起娇无力，始是新承恩泽时。  
云鬓花颜金步摇，芙蓉帐暖度春宵。  
春宵苦短日高起，从此君王不早朝。  
### ___要求：___  
1.设计学生类（可利用之前的）;  
2.采用交互式方式实例化某学生;  
3.设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中;  
### ___核心代码___  
```
  //Student学生类并创建无参构造函数和带参构造函数，并且重写toString()方法;
  //创建关于学生的属性
	String name;							//关于学生的姓名
	String code;							//关于学生的编号
	String sexy;							//关于学生的性别
	String age;							//关于学生的年龄
	String grade;							//关于学生的班级
	String major;							//关于学生的专业
	//构造函数
	Student(){							//无参构造函数
		
	}
	Student(String name,String code){				//带参构造函数
		this.name = name;
		this.code = code;
	}
  ……
  public String toString() {						//重写toString()方法
		String information = "姓名："+name+"学号："+code+"年龄："+age+"班级："+grade+"专业："+major;
		return information;
	}
```
```
//在Test.java中创建txt()方法,通过FileReader && FileWriter对BIPT.txt文件进行读写;
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

		File file = new File("E:\\BIPT.txt");                               //通过File获取E盘下的BIPT.txt文档的路径;  
		try {                                                               //try{}catch(){}异常捕获机制,捕获运行过程出现的异常问题并抛出;
		
			FileReader fInputStream = new FileReader(file);			
			FileWriter fOutputStream  = new FileWriter("E:\\BIPT2.txt");
			char[] b = student.toString().toCharArray();			//将toString转换为字符流
			fOutputStream.write(b);						//通过FileWriter输出在文件BIPT2.txt中
			fOutputStream.write("\n\n");
			
			FileReader fInputStream = new FileReader(file);                   //FileReader方法读取File方法中的路径中的文件,方便进行下一步操作;
			FileWriter fOutputStream  = new FileWriter("E:\\BIPT2.txt");      //FileWriter方法将运行后的结果正确的输出在BIPT2.txt文件中,此时文件未创建在对BIPT2进行写的操作的时候,会自动创建;
			int p=(int)file.length();                                         //通过length()方法获取BIPT.txt文件的字节长度并强制转换为int型;
			char[] a = new char[p];                                           //创建char[] a并将字节长度p赋给char[] a
			fInputStream.read(a);
			int x=0;
			for(int j = 7;j<=file.length()-470;j=j+7,x+=7) {                  //通过for循环来进行循环遍历并通过if判断来进行输出的要求
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
			
			fInputStream.close();                                              //当方法使用完毕后,通过close()方法进行关闭
			fOutputStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
```
```
/**
*本段代码是完成查找，字或词出现次数；
*/

public static void select() {
		File file = new File("E:\\BIPT.txt");				//获取要查找的文件路径
		try {
			FileInputStream fis = new FileInputStream(file);	//将路径通过FileInputStream方法进行读取
			ByteArrayOutputStream bos = new ByteArrayOutputStream();//通过ByteArrayOutputStream方法进行字节数组输出流在内存中创建一个字节数组缓冲区
			
			int len;
			byte[] data = null;
			byte[] buffer = new byte[(int)file.length()];		//获取file的长度并给buffer
			
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
			System.out.println("共出现"+count+"次");		//在控制台输出结果
			fis.close();
			bos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
```
### ___实验运行结果___  
![结果图](https://github.com/Traveller-g/Task/blob/main/img/new1606741381.jpg)  
![结果图](https://github.com/Traveller-g/Task/blob/main/img/1606741450.jpg)  
### ___编程感想___  
通过本次实验让我对字符流的抽象基类进行了了解和实践，例如字符输入流和字符输出流有了更深刻的认识  
我认为只要通过实践才能对代码进行更好的掌握。  
