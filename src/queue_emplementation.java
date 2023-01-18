import java.util.*;

public class queue_emplementation {

    static class  Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    static class Queue_BY_Linkelist{
        static Node head=null;
        static Node tail=null;

    public static boolean isEmpty(){
        return tail==null && head ==null;
        }

     public void enqueu(int data){
        Node newNode =new Node(data);
           if (isEmpty()){
               tail=head=newNode;
           }
           tail.next=newNode;
           tail=newNode;
        }
         public  int  dequeeu(){
        if (isEmpty()){
            return  -1;
        }
        int front=head.data;
        head=head.next;
        return  front;
         }
         public  int peek (){
        if (isEmpty()){
            return  -1;
        }
        return  head.data;
         }


    /*     public class Queue_BY_Stack{

       static Stack<Integer> s1=new Stack<>();
       static Stack<Integer> s2=new Stack<>();

        public static boolean isEmpty(){
                return s1.isEmpty();
            }

            public static void add(int data){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()){
                s2.push(s1.pop());
            }

        }
        public static int remove(){
            if (!s1.isEmpty()){
                return -1;
            }
          return   s1.pop();
        }
        public static int peek(){
            if (!s1.isEmpty()){
                return -1;
            }
            return s1.peek();
        }

         }*/


    }
    public static void main(String[] args) {

        Queue_BY_Linkelist q=new Queue_BY_Linkelist();
        q.enqueu(6);
        q.enqueu(8);
        System.out.println(q.dequeeu());
        System.out.println(q.peek());


    }
}
