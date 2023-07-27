public class LinkedList_EM {
    private Node head;
    private Node tail;
    private int size;
    public LinkedList_EM(){
        this.size=0;
    }

    public class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }

    //Insertion First;
    public void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        head=node;
        if (tail==null){
            tail=head;
        }
        size +=1;
    }


    // InsertLast
    public void insertLast(int value){
        Node node = new Node(value);
        if (tail==null){
            insertFirst(value);
            return;
        }
        tail.next=node;
        node=tail;
        size +=1;
    }


    // insert particular position
    public void insert(int value,int index){
        if (index==0){
            insertFirst(value);
            return;
        }
        if (index==size){
            insertLast(value);
            return;
        }
        Node temp=head;
        for (int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(value,temp.next);
        temp.next=node;
        size++;
    }

    // Delete first
    public int deleteFirst(){
        int val=head.value;
        head=head.next;
        if (head==null){
            tail=null;
        }
        size--;
        return val;
    }

    // Delete  last
    public int deleteLast(){
        if (size<=0){
            return deleteFirst();
        }
        Node secondLast= get(size-2);
        int val=tail.value;
        tail=secondLast;
        tail.next=null;
        return val;
    }

    public Node get(int index){
        Node node=head;
        for (int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }

    //  Delete particular index
    public int delete(int index){
        if (index==0){
            return deleteFirst();
        }
        if (index==size-1){
            return deleteLast();
        }
        Node prev=get(index-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        return val;
    }

    // Display the Linked list
    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

   //Main Function

    public static void main(String[] args) {

        LinkedList_EM linkedListEm=new LinkedList_EM();
        linkedListEm.insertFirst(2);
        linkedListEm.insertFirst(3);
        linkedListEm.insertFirst(5);
        linkedListEm.insertFirst(6);
        linkedListEm.display();
        linkedListEm.insertLast(1);
        linkedListEm.insertFirst(9);
        linkedListEm.display();
        linkedListEm.insert(12,3);
        linkedListEm.display();
        System.out.println(linkedListEm.deleteFirst());
        linkedListEm.display();
        linkedListEm.deleteLast();
        linkedListEm.display();
        System.out.println(linkedListEm.delete(2));
        linkedListEm.display();


    }
}
