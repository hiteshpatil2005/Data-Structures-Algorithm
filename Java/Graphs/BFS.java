import java.util.*;

public class BFS
  {
    int v;
    LinkedList<Integer>[] adj;

    BFS(int v)
    {
      this.v=v;
      adj = new LinkedList[v];
      for (int i = 0; i < v; i++)
        {
           adj[i] = new LinkedList<>();
        }
    }
    
    void addEdge(int s,int d)
    {
      adj[s].add(d);
    }

    void BFS(int start) {
        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    
    public static void main(String[]args)
    {
      Scanner sc=new Scanner(System.in);

      System.out.print("Enter the number of Vertices :");
      int v=sc.nextInt();

      System.out.print("Enter the number of Edges : ");
      int e=sc.nextInt();

      BFS g=new BFS(v);

      for(int i=0;i<e;i++)
        {
          System.out.print("Enter the Source : ");
          int src=sc.nextInt();

          System.out.print("Enter the Destination : ");
          int dest=sc.nextInt();

          g.addEdge(src,dest);
        }
      System.out.print("Enter the starting vertex : ");
      int x=sc.nextInt();

      System.out.print("BFS starting from vertex "+x+" : ");
      g.BFS(x);
    }
  }
