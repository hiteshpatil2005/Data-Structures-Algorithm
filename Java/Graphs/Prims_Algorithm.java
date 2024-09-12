
import java.util.Arrays;
import java.util.Scanner;

class Prims_Algorithm
{
    static void prims(int cost[][],int v)
    {
        int mincost=0;
        int edgecount=1;

        boolean visited[]=new boolean[v];
        Arrays.fill(visited,false);
        visited[0]=true;

        while(edgecount<v)
        {
            int INF=999;
            int min=INF;
            int x=0,y=0;

            for(int i=0;i<v;i++)
            {
                if(visited[i]==true)
                {
                    for(int j=0;j<v;j++)
                    {
                        if(visited[j]!=true && min>cost[i][j])
                        {
                            min=cost[i][j];
                            x=i;
                            y=j;
                        }
                    }
                }
            }
            visited[y]=true;

            System.out.printf("Edge %d(%d,%d),cost %d\n",edgecount++,x,y,cost[x][y]);
            mincost+=cost[x][y];
        }
        System.out.println("Minimum cost is : "+mincost);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter the number of vertices : ");
        int v=sc.nextInt();

        int cost[][]=new int[v][v];
        System.out.println("Enter the adjacency matrix :");
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                cost[i][j]=sc.nextInt();
            }
        }
        prims(cost,v);
    }
}
