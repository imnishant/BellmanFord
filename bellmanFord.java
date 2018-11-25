import java.util.Scanner;

public class BelmanFord {
	
	static void BFAlgo(int adj[][], int n, int dest)
	{
		int dist[] = new int[n];
		int pred[] = new int[n];
		for (int i = 0; i < n; i++)
		{
			dist[i] = adj[dest][i];
			pred[i] = dest;
		}
		pred[dest] = -1;
		dist[dest] = 0;
		
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if((adj[i][j] != 999) && (dist[j] > dist[i] + adj[i][j]))
				{
					dist[j] = dist[i] + adj[i][j];
					pred[j] = i;
				}
			}
			
			/*for (int k = 0; k < n; k++)
				System.out.print(dist[k] + " ");
			System.out.println();*/
		}
		for (int i = 0; i < n; i++) {
			System.out.println("Cost from node-" + i + " to node-" + dest + " is " + dist[i] + " through node- " + pred[i]);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of vertices");
		int n = sc.nextInt();
		int adj[][] = new int[n][n];
		
		System.out.println("Enter adjacency matrix");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) 
				adj[i][j] = sc.nextInt();
		
		System.out.println("Enter destination vertex");
		int dest = sc.nextInt();
		
		BFAlgo(adj, n, dest);
	}

}

/*
0 3 2 5 999 999
3 0 999 1 4 999
2 999 0 2 999 1
5 1 2 0 3 999
999 4 999 3 0 2
999 999 1 999 2 0
*/ 

/*
0 3 2 5 999 999
3 0 999 1 4 999
2 999 0 2 999 999
5 1 2 0 3 999
999 999 999 3 0 2
999 999 999 999 2 0
*/
