//Leeland Zhang
//I literally thought that my method would time out but the solutions
//had pretty much the same idea...I really need to learn how to 
//calculate time complexity: not finished

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class cowjump_silver 
{
	static long[][] x;
	static long[][] y;
	static int partition(long arr[][], int m, int l) 
	{ 
		long pivot = arr[l][0];  
		int i = (m-1);
		for (int j=m; j<l; j++) 
		{ 
			if (arr[j][0] < pivot) 
			{ 
				i++; 
				long temp = arr[i][1]; 
            	arr[i][1] = arr[j][1]; 
            	arr[j][1] = temp;
            	temp = arr[i][0]; 
            	arr[i][0] = arr[j][0]; 
            	arr[j][0] = temp;
            	temp = arr[i][2]; 
            	arr[i][2] = arr[j][2]; 
            	arr[j][2] = temp;
			} 
		} 
		long temp = arr[i+1][0]; 
		arr[i+1][0] = arr[l][0]; 
		arr[l][0] = temp; 
		temp = arr[i+1][1]; 
		arr[i+1][1] = arr[l][1]; 
		arr[l][1] = temp; 
		temp = arr[i+1][2]; 
		arr[i+1][2] = arr[l][2]; 
		arr[l][2] = temp; 
		return i+1; 
	} 
	static void sort(long arr[][], int m, int l) 
	{ 
		if (m < l) 
		{ 
			int pi = partition(arr, m, l); 
			sort(arr, m, pi-1); 
			sort(arr, pi+1, l); 
		} 
	} 
	static int algorithm()
	{
		int sol=-1;
		for(int i=0; i<x.length;i++)
		{
			sol++;
		}
		return sol;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("cowjump.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("cowjump.out"));
		int N=sc.nextInt();
		x=new long[N][3];
		y=new long[N][3];
		for(int i=0; i<N; i++)
		{
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			x[i][0]=Math.min(x1, x2);
			y[i][0]=Math.min(y1, y2);
			x[i][1]=Math.max(x1, x2);
			y[i][1]=Math.max(y1, y2);
			x[i][2]=i;
			y[i][2]=i;
		}
		sc.close();
		sort(x,0,N-1);
		sort(y,0,N-1);
		int[] pos=new int[N];
		for(int i=0; i<N; i++)
		{
			pos[(int) y[i][2]]=i;
		}
		for(int i=0; i<N; i++)
		{
			System.out.println(x[i][0]+" "+x[i][1]+" "+x[i][2]);
		}		
		for(int i=0; i<N; i++)
		{
			System.out.println(y[i][0]+" "+y[i][1]+" "+y[i][2]);
		}
		//pr.println(algorithm()+1);
		//pr.close();
	}
}
