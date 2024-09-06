import java.util.Scanner;
 
  class Kruskal
  {
         
         static int INF=999;
         static int v;
         static int parent[];
         static int find(int i)
         {
          
             while(parent[i]!=i)
                     i=parent[i];
              return i;
         }
         
         static void union(int i,int j)
         {
             int a=find(i);
             int b=find(j);
              parent[a]=b;
         }
         
         
         static void MST(int cost[][])
         {
              int min_cost=0;
              for(int i=0;i<v;i++)
                    parent[i]=i;
               int edge_count=1;
               while(edge_count<v)
               {
                   int min=INF,x=0,y=0;
                   for(int i=0;i<v;i++)
                   {
                      for(int j=0;j<v;j++)
                      {
                           if(find(i)!=find(j)  && min>cost[i][j])
                             {
                                 min=cost[i][j];
                                 x=i;
                                 y=j;
                             }
                      }    
                   }
                   union(x,y);
                   System.out.printf("Edge %d (%d ,%d) cost %d \n",edge_count++,x,y,min);
                       min_cost=min_cost+cost[x][y];
             }      
             System.out.println("Minimum Cost is : "+min_cost);
         }
         
         
         public static void main(String[]args)
         {
              Scanner sc=new Scanner(System.in);
             
              System.out.print("Enter the number of vertices : ");
              v=sc.nextInt();
              parent=new int[v];
              int cost[][]=new int[v][v];
             
              System.out.print("Enter the weight of the vertices inside the matrix :");
              for(int i=0;i<v;i++)
                {
                    for(int j=0;j<v;j++)
                     {
                          cost[i][j]=sc.nextInt();
                     }
                }
                MST(cost);
         }
  }
