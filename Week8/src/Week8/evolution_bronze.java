//Leeland Zhang
//I realized that it any two sets 'cross' then there cannot be a tree
//before I even finished reading the problem, which the solutions
//says it the easiest solution to solve, yet I spent 2 hours and still have no
//clue how to do it, even after reading the solution, like i dunno.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class evolution_bronze 
{
	static String solve()
	{
		
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("evolution.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("evolution.out"));
		int N=sc.nextInt();
		Map<String, Integer> key=new HashMap<String, Integer>();
		ArrayList<Integer> positions=new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> features=new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N;i++)
		{
			features.add(new ArrayList<Integer>());
		}
		int count=0;
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<sc.nextInt();j++)
			{
				String tp=sc.next();
				if(!key.containsKey(tp))
				{
					key.put(tp,count);
					count++;
				}
				positions.add(key.get(tp),i);
				features.get(i).add(key.get(tp));
			}
		}
	}
}
