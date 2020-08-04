//Leeland Zhang
//Took me half an hour to account for all the special cases
//10/10
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class buckets_bronze 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("buckets.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("buckets.out"));
		int xb=0;
		int xl=0; 
		int yb=0; 
		int yl=0;
		int xr=0;
		int yr=0;
		for(int i=0; i<10; i++)
		{
			String temp=sc.next();
			for(int j=0; j<10; j++)
			{
				if(temp.substring(j,j+1).equals("B"))
				{
					xb=j;
					yb=i;
				}
				else if(temp.substring(j, j+1).equals("L"))
				{
					xl=j;
					yl=i;
				}else if(temp.substring(j, j+1).equals("R"))
				{
					xr=j;
					yr=i;
				}
			}
		}
		sc.close();
		if((xr==xl&&xl==xb&&!(yr>yb&&yr>yl))||(yr==yl&&yl==yb&&!(xr>xb&&xr>xl)))
		{
			pr.println(Math.abs(xb-xl)+Math.abs(yb-yl)+1);
		}
		else
		{
			pr.println(Math.abs(xb-xl)+Math.abs(yb-yl)-1);
		}
		pr.close();
	}
}
