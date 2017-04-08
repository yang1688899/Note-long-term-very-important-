package test;

public class Integer赋值 {
	public static void main(String[] args)
	{
		Integer i1=5;
		Integer i2=5;//i1与i2 id一致，指向同一个对象
		Integer i3=135;
		Integer i4=135;//i3与i4 id不一致，指向两个不同对象,当Integer赋值超出-128至127范围，出现该现象
		
	}

}
