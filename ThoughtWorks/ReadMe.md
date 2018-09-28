# 第一步：建立一个静态工厂类

静态工厂类中含有一个生成迷宫对象的静态方法

```java
public class MazeFactory {
	public static Maze create(String command) {
		return new Maze(command);
	}
}
```



# 第二步：建立一个Maze迷宫类

```java
package com.wkk.maze;
public class Maze {
	private String str;
	public Maze(String str) {
		this.str = str;
	}
	public String render(){
	}
	
	private String render(int m, int n, String[] inputMaze) {}
	private String decorate(int[][] matrix) {};
}

```

## 1.构造函数

构建Maze对象，将输入的字符串传入`str`属性；

## 2.render() 

```java
public String render(){
	String[] strs = this.str.split("\n");
	//解析出维度m和n
	if (strs.length != 2) {
		return "Incorrect command format.";
	}
	String[] mn = strs[0].split(" ");
    if (mn.length != 2) return "Incorrect command format.";
	int m = 0;
	int n = 0;
	try {
		m = Integer.parseInt(mn[0]);
		n = Integer.parseInt(mn[1]);
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		return "Invalid number format.";
	}
		
	//解析出迷宫的连通性
	String[] inputMaze = strs[1].split(";");
	return render(m, n, inputMaze);
}
```



解析`str`字符串，当行数不等于2时，返回格式错误信息`Incorrect command format.`

第一行得到维度m、n, 如果第一行数个数不等于2，返回并且捕捉异常，有无效的字符时，返回无效字符错误信息`Invalid number format.`

得到含有连通信息的字符串inputMaze；

调用重载函数 render(int，int，String)返回mazeText；

## 3.render(int,int,String)

