//Leeland Zhang
//Took me 45 mins
//10/10
//Used a bronze method but I to make it faster I could use binary search ofc
//I think I could have also used a treemap type thing maybe
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class factory_bronze 
{
	static int N;
	static int count=0;
	static ArrayList<ArrayList<Integer>> stations;
	static void connect(int i)
	{
		for(int j=0; j<stations.get(i).size(); j++)
		{
			count++;
			connect(stations.get(i).get(j));
		}
	}
	static int solve()
	{
		for(int i=1; i<=N; i++)
		{
			connect(i);
			if(count==N-1)
				return i;
			count=0;
		}
		return -1;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("factory.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("factory.out"));
		N=sc.nextInt();
		stations=new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++)
		{
			stations.add(new ArrayList<Integer>());
		}
		for(int i=0; i<N-1; i++)
		{
			int temp=sc.nextInt();
			stations.get(sc.nextInt()).add(temp);
		}
		pr.println(solve());
		pr.close();
	}
}
