import java.util.*;

class Node
{
    int data;
    Node left,right;

    public Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}


class BT
{
    Node root;
    public void insert(int data)
    {
        Node newNode = new Node(data);

        if(root==null)
        {
            root=newNode;
        }

        else
        {
            insertOption(root,newNode);
        }
    }


    public void insertOption(Node current, Node newNode)  //Insert Operation of node in the tree
    {
        int position;
        Scanner sc=new Scanner(System.in);

        do
        {
            System.out.print("1.Left side\n2.Right side\nEnter your choice to insert the element:");
            position = sc.nextInt();

            if(position==1)
            {
                if(current.left==null)
                {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            }

            else if(position==2)
            {
                if(current.right==null)
                {
                    current.right= newNode;
                    break;
                }
                current = current.right;
            }

            else
            {
                System.out.print("Invalid choice \n Please enter 1 for left or 2 for right");
            }

        }while(true);
    }


    public void display()   //Display of Nodes of tree
    {
        int choice;
        Scanner sc = new Scanner(System.in);

            System.out.print("1.In order traversal\n2.Pre order traversal\n3.Post order traversal\nEnter Your choice of traversing :");
            choice=sc.nextInt();

            if(choice==1)
            {
                System.out.print("In-order traversal is : ");
                inorder_traversal(root);
            }

            else if(choice==2)
            {
                System.out.print("Pre-order traversal is : ");
                preorder_traversal(root);
            }

            else if(choice==3)
            {
                System.out.print("Post - order traversal is : ");
                postorder_traversal(root);
            }
    }

    private void inorder_traversal(Node current_node)  //Inorder traversal
    {
        if(current_node!=null)
        {
            inorder_traversal(current_node.left);
            System.out.print(current_node.data+" ");
            inorder_traversal(current_node.right);
        }
    }

    private void preorder_traversal(Node current_node)      //Preorder traversal
    {
        if(current_node!=null)
        {
            System.out.print(current_node.data+" ");
            preorder_traversal(current_node.left);
            preorder_traversal(current_node.right);
        }
    }

    private void postorder_traversal(Node current_node)          //Postorder traversal
    {
        if(current_node!=null)
        {
            postorder_traversal(current_node.left);
            postorder_traversal(current_node.right);
            System.out.print(current_node.data+" ");
        }
    }

    public int countNode()          //Count Number of Nodes in the tree
    {
        return countNode(root);
    }

    public int countNode(Node root)
    {

        if(root==null)
        {
            return 0;
        }

        else
        {
            int count=1;
            count+=countNode(root.left);
            count+=countNode(root.right);
            return count;
        }
    }

    public void printLeaves(Node root)     //Printing Leaves
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            System.out.print(root.data);
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public int countLeaves(Node root)   //Counting Leaves
    {
        if(root==null)
        {
            return 0;
        }
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        else
        {
            return countLeaves(root.left)+countLeaves(root.right);
        }
    }

    public int treeHeight(Node root)  //Height of the tree
    {
        if(root==null)
        {
            return 0;
        }
        int max=Math.max(treeHeight(root.left),treeHeight(root.right));
        return max+1;
    }
}



public class BinaryTree   //Main class
{
    public static void main(String args[])
    {
        int repeat,a;
        BT b = new BT();
        Scanner sc=new Scanner(System.in);
        int choice,data;

        do
        {

            System.out.print("Enter your choice\n1.Insert\n2.Display\n3.Count of Node \n4.Print the Leaves\n5.Count of Leaves\n6.Height of Tree\n");
            choice=sc.nextInt();

            switch(choice)
            {
                case 1:System.out.print("Enter the data:");
                    data=sc.nextInt();
                    b.insert(data);
                    break;

                case 2: b.display();
                    break;

                case 3: a=b.countNode();
                    System.out.print("Count of node is : "+a);
                    break;

                case 4: System.out.print("Leaves are : ");
                        b.printLeaves(b.root);
                    System.out.print(" ");
                        break;

                case 5 : System.out.print("Count of Leaves is : "+b.countLeaves(b.root));
                         break;

                case 6 : System.out.print("Height of the Leaves is :"+b.treeHeight(b.root));
                         break;
                default: System.out.print("Please enter the valid choice");
                    break;

            }

            System.out.println("\nIf you want to continue enter 1 or else enter 0 :");
            repeat=sc.nextInt();

        }while(repeat!=0);


    }
}
