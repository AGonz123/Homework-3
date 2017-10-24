

/**
 *Deque using a doubly linked 
 * @author Andrew Gonzales
 */

 
    Public class Deque<T> implements DequeInterface<T> {
        class Node<T>{
     
    private Node<T> prev;
    private Node<T> next;
    private T value;
     
    public Node<T> getPrevious() {
        return prev;
    }
    public void setPrevious(Node<T> previous) {
        this.prev = previous;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
 
    private Node<T> front;
    private Node<T> rear;
     
    public void addToFront(T item){
        //** Adds a new entry to the front of this dequeue.
        
        Node<T> node = new Node<T>();
        node.setValue(item);
        node.setNext(front);
        if(front != null) front.setPrevious(node);
        if(front == null) rear = node;
        front = node;
    }
     
    public void addToBack(T item){
        //** Adds a new entry to the front/back of this dequeue.
        System.out.println("adding at rear: "+item);
        Node<T> node1 = new Node<T>();
        node1.setValue(item);
         node1.setPrevious(rear);
        if(rear != null) rear.setNext( node1);
        if(rear == null) front =  node1;
         
        rear =  node1;
    }
     
    public void removeFront(){
         //** Removes and returns the frontentry of this dequeue.
        if(front == null){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        
        Node<T> node2 = front.getNext();
        if(node2 != null) node2.setPrevious(null);
        if(node2 == null) rear = null;
        System.out.println("removed from front: "+front.getValue());
        front = node2;
    }
     
    public void removeBack(){
        //** Removes and returns the back entry of this dequeue.
        if(rear == null){
            System.out.println("Queue is Empty");
            return;
        }
       
        Node<T> node3 = rear.getPrevious();
        if(node3 == null) front = null;
        if(node3 != null) node3.setNext(null);
        
        System.out.println("removed from rear: "+rear.getValue());
        rear = node3;
    }
     
    }
