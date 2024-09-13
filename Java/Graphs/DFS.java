import java.util.*;

public class DFS
  {
    int v;
    LinkedList<Integer>[] adj;

    DFS(int v)
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

    void DFS(int start) {
        boolean visited[] = new boolean[v];
        LinkedList<Integer> stack = new LinkedList<>();

        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node + " ");

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
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

      DFS g=new DFS(v);

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
      g.DFS(x);
    }
  }
