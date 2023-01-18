
import java.util.*;

public class Tree_emplementation {
   static class BST_class {

       static class Node {
           int data;
           Node left;
           Node right;

           Node(int data) {
               this.data = data;
               left = right = null;
           }

       }
        static    Node root;
           BST_class() {
               root = null;
           }

           // insert a node in BST
           void insert(int key) {
               root = insert_Recursive(root, key);
           }

           Node insert_Recursive(Node root, int key) {
               if (root == null) {
                   root = new Node(key);
                   return root;
               }
               if (key < root.data) {
                   root.left = insert_Recursive(root.left, key);
               } else if (key > root.data) {
                   root.right = insert_Recursive(root.right, key);
               }
               return root;
           }
           // searching operation;

           boolean search(int key) {
               return search_Recursive(root,key);
           }

           boolean search_Recursive(Node root, int key) {
               if (root == null ) {
                   return false;
               }
               if (root.data  > key) {
                   return search_Recursive(root.left, key);
               }
             else if (root.data==key){
                 return true;
               }
             else {
                   return search_Recursive(root.right, key);
               }
           }

             Node delete(int key){
               return  deleteOperation( root , key);
           }
           static Node deleteOperation(Node root,int key){
               if (root.data>key){
                   root.left=deleteOperation(root.left,key);
               }
               else if (root.data<key){
                   root.right=deleteOperation(root.right,key);
               }
               else {  // this else work when kye==root.datat;

                   // case 1;
                    if (root.left==null && root.right==null){
                        return null;
                    }
                    // case 2;
                    if (root.left==null){
                        return root.right;
                    } else if (root.right==null) {
                        return root.left;
                    }
                    // case 3;
                   Node IS=inorderSuccessor(root.right);
                    root.data=IS.data;
                  root.right=  deleteOperation(root.right,IS.data);
               }
               return root;
           }
public static Node inorderSuccessor(Node root){
         while (root.left!=null){

             root=root.left;
         }
    return root;
}
           // preOder operation;
           void preOrder() {
               preOrder_Recursive(root);
           }

           void preOrder_Recursive(Node root) {
               if (root != null) {
                   System.out.print(root.data + " ");
                   preOrder_Recursive(root.left);
                   preOrder_Recursive(root.right);
               }
           }


           //InOrder traverse;
           void inorder() {
               inorder_Recursive(root);
           }

           void inorder_Recursive(Node root) {
               if (root != null) {
                   inorder_Recursive(root.left);
                   System.out.print(root.data + " ");
                   inorder_Recursive(root.right);
               }
           }

           // PostOrder traverse ;

           void postOrder() {
               postOrder_Recursive(root);
           }

           void postOrder_Recursive(Node root) {
               if (root != null) {
                   postOrder_Recursive(root.left);
                   postOrder_Recursive(root.right);
                   System.out.print(root.data + " ");
               }
           }

           // print level order (BFS)
           void level(){
               levelOperation(root);
           }

     void levelOperation(Node root){
               if (root==null){
                   return ;
               }
               Queue<Node> q=new LinkedList<>();
               q.add(root);
               q.add(null);
               while (!q.isEmpty()){
                   Node current=q.remove();
                   if (current==null){
                       System.out.println();
                       if (q.isEmpty()){
                           break;
                       }else {
                           q.add(null);
                       }
                   }else {
                       System.out.println(current.data);
                       if (current.left!=null){
                           q.add(current.left);
                       }
                       if (current.right!=null){
                           q.add(current.right);
                       }

                   }
               }


   }

       // count operation;
  void countNode(){
    System.out.println(MethoadOFcount(root));
}

static int MethoadOFcount(Node root){
    if (root==null){
        return 0;
    }
    int leftcont=MethoadOFcount(root.left);
    int rightcount=MethoadOFcount(root.right);
    return leftcont+rightcount+1;
}


// sum of all node;

 void sumOfNode(){
     System.out.println(methoadofSum(root));
  }

    static int methoadofSum(Node root){

    if (root==null){
        return  0;
    }
    int leftsum= methoadofSum(root.left);
    int rightsum=methoadofSum(root.right);
    return leftsum+rightsum+root.data;

    }
    //Height operation;


    void height(){
        System.out.println(heightOperation(root));
    }
    static int heightOperation(Node root){
      if (root==null){
          return 0;
      }
      int leftHight=heightOperation(root.left);
      int rightHight=heightOperation(root.right);

      int myhight=Math.max(leftHight,rightHight)+1;
      return myhight;
    }

     void   diameter(){
        System.out.println(diameterMethoad(root));
    }
    // get Diameter with O(n2) time complexity;

     static int diameterMethoad(Node root){

      if (root==null){
          return  0;
      }

      int diam1=diameterMethoad(root.left);
      int diam2=diameterMethoad(root.right);
      int diam3= heightOperation(root.left)+heightOperation(root.right) + 1;

      return Math.max(diam3,Math.max(diam1,diam2));
    }

       // print all data in path ;
     void printRootToleaf(){
        ArrayList<Integer> list=new ArrayList<>();
        operationprintRootToleaf(root,list);
    }

      static   void operationprintRootToleaf(Node root, ArrayList<Integer> path) {

               if (root==null){
                   return;
               }
               path.add(root.data);
               if (root.left==null && root.right==null){
                  printPath(path);
               }
               operationprintRootToleaf(root.left,path);
               operationprintRootToleaf(root.right,path);
               path.remove(path.size()-1);

       }

       public static void printPath(ArrayList<Integer> path){
               for (int i=0;i<path.size();i++){
                   System.out.print(path.get(i)+" ");
               }
           System.out.println();
       }

       // Print the data in range;

       void printINrange(int x,int y){
               operationPrintINNrange(root, x,y);
       }

       static void operationPrintINNrange(Node root,int  x,int y){

           if(root==null){
               return;
           }
           if (x<=root.data && y>=root.data){
               operationPrintINNrange(root.left,x,y);
               System.out.println(root.data);
               operationPrintINNrange(root.right,x,y);

           }else if (root.data>=y) {
               operationPrintINNrange(root.left,x,y);
           }
           else {
               operationPrintINNrange(root.right,x,y);
           }


       }


   }

    public static void main(String[] args) {
            BST_class bst = new BST_class();
        Scanner input=new Scanner(System.in);
        System.out.println("How much number do you need !");
        int n=input.nextInt();
        for (int i=0;i<n;i++){
            bst.insert(input.nextInt());
        }
     /*  System.out.println("inOrder Traverse ");
            bst.inorder();
        System.out.println();
        System.out.println("PreOrder traverse ");
            bst.preOrder();
        System.out.println();
        System.out.println("PostOrder traverse ");
            bst.postOrder();
        System.out.println();
        System.out.println(bst.search(4));
        bst.countNode();
        bst.sumOfNode();
        bst.height();
        bst.diameter();
        bst.delete(5);
        bst.inorder();*/
       // bst.level();
      //  bst.printRootToleaf();
        bst.printINrange(6,12);
        }
}
