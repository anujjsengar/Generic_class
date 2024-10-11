public class Generic_class_LinkedList<T>{
    public class Node{
        T data;
        Node next;
    public Node(T data){
        this.data=data;
    }
}
    Node head;
    public Generic_class_LinkedList(T data){
        this.head=new Node(data);
    }
    public static void main(String args[]){
        Generic_class_LinkedList<Integer> obj=new Generic_class_LinkedList<>(10);
        obj.head.next=obj.new Node(20);
        while(obj.head!=null){
            System.out.print(obj.head.data+" ");
            obj.head=obj.head.next;
        }
        System.out.println();
        Generic_class_LinkedList<String> obj_string=new Generic_class_LinkedList<>("Anuj");
        obj_string.head.next=obj_string.new Node("Lovely");
        while(obj_string.head!=null){
            System.out.print(obj_string.head.data+" ");
            obj_string.head=obj_string.head.next;
        }
    }
}