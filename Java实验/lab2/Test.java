import java.util.*;
public class Test
{
	public static void main(String[] args)
	{
		Student s1=new Student();
		Student s2=new Student();
		Scanner out=new Scanner(System.in);
		s1.stdCode=out.next();
		s1.age=out.nextInt();
		s1.name=out.next();
		s2.stdCode=out.next();
		s2.age=out.nextInt();
		s2.name=out.next();
		if (s1.equals(s2))
		{
      			System.out.println( s1 +" is equal to  " +s2);
		}
		else
		{
			System.out.println( s1 +" is not equal to " +s2);
		}
	}
}
class Student
{
	String stdCode;
	int age;
	String name;
	public boolean equals(Student s2)
	{
		if(this.stdCode.equals(s2.stdCode)&&this.name.equals(s2.name))
			return true;
		else
			return false;
	}
	public String toString()
	{
		return"["+stdCode+"-"+name+"]";
	}
}	