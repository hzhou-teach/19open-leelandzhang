
//Leeland Zhang
//I overcomplicated the problem once again
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class leftout_silver 
{
	static String row1;
	static String row2;
	static int find(String[] rows)
	{
		int pos=0;
		row1=rows[0];
		int repeat=0;
		while(row2!=null)
		{
			pos++;
			if(row1.equals(rows[pos]))
			{
				repeat++;
				continue;
			}
			if(pos==3&&repeat!=2)
				row1=rows[pos];
			int count=0;
			for(int i=0; i<row1.length(); i++)
			{
				if(rows[pos].substring(i).equals(row1))
					count++;
			}
			if(count==0)
				row2=rows[pos];
		}
		return -1;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("leftout.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("leftout.out"));
		int N=sc.nextInt();
		String[] rows=new String[N];
		String[] columns=new String[N];
		for(int i=0; i<N; i++)
		{
			String tp=sc.next();
			rows[i]=tp;
			for(int j=0; j<N; j++)
			{
				columns[j]+=tp.substring(j);
			}
		}
		
	}
}
