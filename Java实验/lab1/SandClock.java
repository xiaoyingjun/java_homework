import java.util.*;
public class SandClock
{
	public static void main(String[] args)
	{
		Scanner out=new Scanner(System.in);
		int number=out.nextInt();
		char c=out.next().charAt(0);
		int i=1;
		while(2*i*i-1<=number)
		{
			i++;
		}
		i=i-1;
		for(int j=i;j>0;j--)
		{
			int temp1=2*j-1;
			int temp2=i-j;
			int temp3=i-j;
			while(temp2>0)
			{
				System.out.print(" ");
				temp2--;
			}
			while(temp1>0)
			{
				System.out.print(c);
				temp1--;
			}
			while(temp3>0)
			{
				System.out.print(" ");
				temp3--;
			}
			System.out.println();
		}
		for(int j=2;j<=i;j++)
		{
			int temp1=2*j-1;
			int temp2=i-j;
			int temp3=i-j;
			while(temp2>0)
			{
				System.out.print(" ");
				temp2--;
			}
			while(temp1>0)
			{
				System.out.print(c);
				temp1--;
			}
			while(temp3>0)
			{
				System.out.print(" ");
				temp3--;
			}
			System.out.println();
		}
		if(number==0)
			System.out.print(0);
		else
			System.out.print(number-2*i*i+1);
	}
	
}