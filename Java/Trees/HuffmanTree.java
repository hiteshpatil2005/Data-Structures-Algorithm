import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    int data;
    char a;
    Node left;
    Node right;
}

class MyComp implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.data - y.data;
    }
}

class Huffman {

    // Method to print Huffman Codes
    public static void printCode(Node root, String h) {
        if (root.left == null && root.right == null && Character.isLetter(root.a)) {
            System.out.println(root.a + " : " + h);
            return;
        }

        if (root.left != null) {
            printCode(root.left, h + "0");
        }

        if (root.right != null) {
            printCode(root.right, h + "1");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 9;
        char[] arrdata = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        int[] arrfreq = {12, 3, 45, 23, 1, 6, 8, 2, 9};
        String h = "";

        PriorityQueue<Node> q = new PriorityQueue<Node>(n, new MyComp());

        for (int i = 0; i < n; i++) {
            Node w = new Node();
            w.a = arrdata[i];
            w.data = arrfreq[i];
            w.left = null;
            w.right = null;
            q.add(w);
        }

        Node root = null;

        while (q.size() > 1) {
            Node x = q.poll();
            Node y = q.poll();

            Node p = new Node();
            p.data = x.data + y.data;
            p.a = '-';

            p.left = x;
            p.right = y;

            root = p;

            q.add(p);
        }
      
        if (q.size() == 1) {
            root = q.poll();
        }

        printCode(root, h);

        sc.close();
    }
}
