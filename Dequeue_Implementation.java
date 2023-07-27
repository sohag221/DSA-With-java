public class Dequeue_Implementation {
  public static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

  public static class Deque {
        Node front;
        Node rear;

         Deque() {
            this.front = null;
            this.rear = null;
        }

        public void addFront(int data) {

            Node newNode = new Node(data);

            if (this.front == null) {
                this.front = newNode;
                this.rear = newNode;
            } else {
                newNode.next = this.front;
                this.front.prev = newNode;
                this.front = newNode;
            }
        }

        public void addRear(int data) {
            Node newNode = new Node(data);

            if (this.rear == null) {
                this.front = newNode;
                this.rear = newNode;
            } else {
                newNode.prev = this.rear;
                this.rear.next = newNode;
                this.rear = newNode;
            }
        }

        public int removeFront() {
            if ( this.front==null) {
                return -1;
            } else {
                int data = this.front.data;
                this.front = this.front.next;

                if (this.front == null) {
                    this.rear = null;
                } else {
                    this.front.prev = null;
                }

                return data;
            }
        }

        public int removeRear() {
            if (this.rear == null) {
                return -1;
            } else {
                int data = this.rear.data;
                this.rear = this.rear.prev;

                if (this.rear == null) {
                    this.front = null;
                } else {
                    this.rear.next = null;
                }

                return data;
            }
        }
      public int size() {
          int size = 0;
          Node current = this.front;

          while (current != null) {
              size++;
              current = current.next;
          }

          return size;
      }
    }

    public static void main(String[] args) {
        Deque deque = new Deque();

        int value = deque.removeFront();
        System.out.println(value);
        System.out.println(deque.size());
    }
}
