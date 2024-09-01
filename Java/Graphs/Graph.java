import java.util.Scanner;

class Graph
{
   class link
   {
     int src;
     int dest;
   }

   int edge,vertices;
   link[]arr;

   Graph(int edge,int vertices)
   {
      this.edge=edge;
      this.vertices=vertices;

      arr=new link[edge];

      for(int i=0;i<edge;i++)
      {
         arr[i]=new link();
      }
   }

   public static void main(String[]args)
   {
      Scanner sc=new Scanner(System.in);

      System.out.print("Enter the number of edges : ");
      int noEdge=sc.nextInt();

      System.out.print("Enter the number of Vertices : ");
      int noVertices=sc.nextInt();

      Graph g=new Graph(noEdge,noVertices);   
   
      for(int i=0;i<noEdge;i++)
      {
         System.out.print("Enter the source : ");
         g.arr[i].src=sc.nextInt();

         System.out.print("Enter the destination :");
         g.arr[i].dest=sc.nextInt();
      }        

      for(int i=0;i<noEdge;i++)
      {
         System.out.println(g.arr[i].src+" - "+g.arr[i].dest);
      }
   }
}
