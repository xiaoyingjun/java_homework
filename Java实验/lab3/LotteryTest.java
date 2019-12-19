import java.util.*;
public class LotteryTest {
    public static void main(String[] arg)
    {
	Scanner out=new Scanner(System.in);
	int array[]=new int[7];
	int lottype=out.nextInt();
	for(int i=0;i<7;i++)
	{
		array[i]=out.nextInt();
	}
	if(lottype==1)
	{
		Lottery t=new DoubleLotery();
		if(!t.checkFormat(array))
		{
			System.out.print("ERROR");
		}
		else
			System.out.print(t.getLever(array));
	}
	else if(lottype==2)
	{
		Lottery t=new BigLotery();
		if(!t.checkFormat(array))
		{
			System.out.print("ERROR");
		}
		else
			System.out.print(t.getLever(array));
	}
	else
		System.out.print("ERROR");
	
        
    }
    
}
abstract class Lottery{
    int[] befornumber;
    int[] afternumber;
    int[] winbnumber;
    int[] winanumber;
    abstract boolean checkFormat(int[] arg1);
    abstract int getLever(int[] arg1);
    public int[] makewinnumber(int a,int b)
    {
        arg1=new int[a];
        for(int i=0;i<a;i++)
        {
            arg1[i]=1+(int)(Math.random()*b);
        }
        return arg1;
    }
    }
class DoubleLotery extends Lottery{
    @SuppressWarnings("empty-statement")
    DoubleLotery()
    {
        winbnumber=makewinnumber(6,33);
        winanumber=makewinnumber(1,16);
    }
 
 
    @Override
    boolean checkFormat(int[] arg1) {
       for(int i=0;i<6;i++)
	{
		if(arg1[i]>33||arg1[i]<1)
		{
			return false;
		}
	} 
	if(arg1[6]>16||arg1[6]<1)
		return false;
	else return true;
    }
 
    @Override
    int getLever(int[] arg1) {
        int count=0;
	for(int i=0;i<6;i++)
	{
		for(int j=0;j<6;j++)
		{
			if(arg1[i]==winbnumber[j])
				count++;
		}
	}
		if(arg1[6]==winanumber[0])
		{
			if(count==6)
				return 1;
			else if(count>2)
				return 8-count;
			else
				return 6;
		}
		else
		{
			if(count==6)
				return 2;
			else if(count==4||count==5)
				return 9-count;
			else
				return 7;
		}
	}
}
class BigLotery extends Lottery{
 
    BigLotery()
    {
        winbnumber=makewinnumber(5,35);
        winanumber=makewinnumber(2,12);
        
    }
 
    @Override
    boolean checkFormat(int[] arg1) {
        for(int i=0;i<5;i++)
	{
		if(arg1[i]>35||arg1[i]<1)
		{
			return false;
		}
	}
	for(int i=5;i<7;i++)
	{
		if(arg1[i]>12||arg1[i]<1)
			return false;
	}
	return true;
    }
 
    @Override
    int getLever(int[] arg1) {
	int count2=0;
	int count=0;
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
        		if(arg1[i]==winbnumber[j])
				count++;
		}
	 }
	for(int i=5;i<7;i++)
	{
		for(int j=0;j<2;j++)
		{
			if(arg1[i]==winanumber[j])
				count2++;
		}
	}
	if(count2==2)
	{
		if(count==5)
			return 1;
		else if(count>1)
			return 7-count;
		else
			return 6;
	}
	else if(count2==1)
	{
		if(count==5)
			return 2;
		else if(count>1)
			return 8-count;
		else
			return 7;
	}
	else
	{
		if(count==5)
			return 3;
		else if(count>2)
			return 9-count;
		else
			return 7;
	}
	}
}
