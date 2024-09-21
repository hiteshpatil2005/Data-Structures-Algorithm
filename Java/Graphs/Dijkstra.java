import java.util.*;

public class Dijkstra
{
       static int v;
       
       int minimumDistance(int distance[],boolean visited[])
       {   
            int max=Integer.MAX_VALUE ;
            int min =-1;
            
            for(int vx=0;vx<v;vx++)
            {
                if(visited[vx]==false && distance[vx]<=max)
                {
                     max=distance[vx];
                     min=vx;  
                }
            }
             return min;
       }
       
       static void printSoln(int distance[],int v)
       {
            System.out.println("The distance of the vertex from the source is:");
            for(int j=0;j<v;j++)
            {
                 System.out.print("Vertex "+j+"The shortest distance is :"+distance[j]);
            }
       }
       
       
       public void dijkstra(int graph[][],int src)
       {
             int distance[]=new int[v];
             boolean visited[]=new boolean[v];
       
             
             for(int i=0;i<v;i++)
             {
                  distance[i]=Integer.MAX_VALUE;
                  visited[i]=false;        
             }
             distance[src]=0;
             
             
             for(int count=0;count<v-1;count++)
             {
                  int ux=minimumDistance(distance,visited);
                  visited[ux]=true;
                  
                  for(int j=0;j<v;j++)
                  {
                       if(!visited[j] && graph[ux][j]!=-1 && distance[ux]!=Integer.MAX_VALUE && distance[ux]+graph[ux][j]<distance[j])
                        {
                             distance[j]=distance[ux]+graph[ux][j];
                        }
                  }
                  
                  printSoln(distance,v);
             }
       }
       
       
       
       public static void main(String[]args)
       {
             Scanner sc=new Scanner(System.in);
             
             System.out.print("Enter the number of vertices :");
             v=sc.nextInt();
             
             int graph[][]=new int[v][v];
             
             System.out.println("Enter the Adjacency matrix (take inf index as -1) : ");
             
             for(int i=0;i<v;i++)
             {
                  for(int j=0;j<v;j++)
                  {
                      System.out.print("["+i+"]["+j+"] :");
                       graph[i][j]=sc.nextInt();
                  }
             }
             
             System.out.print("Enter the source :");
             int src=sc.nextInt();
             
             Dijkstra d=new Dijkstra();
             d.dijkstra(graph,src);
       }
}
