//Leeland Zhang
//Its such a easy problem, and somehow I get it wrong. I thought
//running straight floodfill would be timeout, but I exceeded memory limit
//with my method.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class fenceplan_silver 
{
	private static long[][] positions;
	static class network
	{
		private long x0;
		private long x1;
		private long y0;
		private long y1;
		private boolean[] numbers=new boolean[10001];
		public network(int pos1, int pos2)
		{
			x0=positions[pos1][0];
			x1=positions[pos1][0];
			y0=positions[pos1][1];
			y1=positions[pos1][1];
			update(pos2);
			numbers[pos1]=true;
			numbers[pos2]=true;
		}
		public void update(int pos)
		{
			if(positions[pos][0]<x0)
				x0=positions[pos][0];
			else if(positions[pos][0]>x1)
				x1=positions[pos][0];
			if(positions[pos][1]<y0)
				y0=positions[pos][1];
			else if(positions[pos][1]>y1)
				y1=positions[pos][1];
		}
		public long calc()
		{
			return 2*(y1-y0)+(2*(x1-x0));
		}
		public boolean ifhas(int a, int b)
		{
			if(numbers[a])
			{
				update(b);
				numbers[b]=true;
				return true;
			}
			else if(numbers[b])
			{
				update(a);
				numbers[a]=true;
				return true;
			}
			return false;
		}
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("fenceplan.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("fenceplan.out"));
		int N=sc.nextInt();
		int M=sc.nextInt();
		positions=new long[N+1][2];
		for(int i=1; i<=N; i++)
		{
			positions[i][0]=sc.nextLong();
			positions[i][1]=sc.nextLong();
		}
		ArrayList<network> socials=new ArrayList<network>();
		boolean has=false;
		for(int i=0; i<M; i++)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			for(int j=0; j<socials.size(); j++)
			{
				boolean x=socials.get(j).ifhas(a,b);
				if(x)
				{
					has=true;
					break;
				}
			}
			if(!has)
				socials.add(new network(a,b));
			has=false;
		}
		long min=socials.get(0).calc();
		for(int i=1; i<socials.size(); i++)
		{
			if(socials.get(i).calc()<min)
				min=socials.get(i).calc();
		}
		pr.println(min);
		pr.close();
	}
}
