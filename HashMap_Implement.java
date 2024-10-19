/*This code implements a basic HashMap using chaining (linked list) to handle collisions, supporting generic keys and values (<K, V>).
It provides three core functionalities: put, get, and containsKey.
The underlying structure uses an ArrayList of Node objects, where each Node contains:

A key of generic type K
A value of generic type V
A next pointer to handle chaining in case of collisions. */
import java.util.*;
public class HashMap_Implement<K,V> {
    public class Node{
        K key;
        V value;
        Node next;
        public Node(K key, V value){
            this.key=key;
            this.value=value;
        }
    }
    ArrayList<Node> table;
    int size=0;
    public HashMap_Implement(int size){
        this.table=new ArrayList<>(10);
        for(int i=0;i<size;i++){
            table.add(null);
        }
    }
    public HashMap_Implement(){
        this(4);
    } 
    public void put(K key,V value){
        int idx=key.hashCode()%table.size();
        Node temp=table.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                temp.value=value;
                return ;
            }
            temp=temp.next;
        }
        Node nn=new Node(key,value);
        table.set(idx,nn);
        nn.next=temp;
        size++;
        int lf=size/table.size();
        int thf=2;
        if(lf>thf){
            rehashing();
        }
    }
    private void rehashing(){
        ArrayList<Node> nt=new ArrayList<>();
        for(int i=0;i<2*table.size();i++){
            nt.add(null);
        }
        ArrayList<Node> ot=this.table;
        this.table=nt;
        for(Node n: ot){
            while(n!=null){
                put(n.key,n.value);
                n=n.next;
            }
        }

    }
    public void remove(K key) {
        int idx = key.hashCode() % table.size();
        Node temp = table.get(idx);
        
        if (temp == null) {
            return;
        }
        
        if (temp.key.equals(key)) {
            table.set(idx, temp.next);
            size--;
            return;
        }
        
        Node prev = null;
        while (temp != null) {
            if (temp.key.equals(key)) {
                size--;
                prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }
    public int size(){
        return size;
    }
    public V get(K key){
        int idx=key.hashCode()%table.size();
        Node temp=table.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp=temp.next;
        }
        return null;
    }
    public void display(){
        for(Node n:table){
            while(n!=null){
                System.out.println(n.key+" "+n.value);
                n=n.next;
            }
        }

    }
    public boolean containsKey(K key){
        int idx=key.hashCode()%table.size();
        Node temp=table.get(idx);
        while (temp != null) {
            if (temp.key.equals(key)) {
                return true;
            }
            temp = temp.next; 
        }
        return false;
    }
    public static void main(String args[]){
        HashMap_Implement<Integer,Integer> map=new HashMap_Implement<>(20);
            map.put(1,10);
            map.put(2,20);
            map.put(2,20);
            map.put(3,30);
            map.put(4,40);
            map.put(5,50);
            map.put(6,60);
            map.put(7,70);
            map.put(8,80);
            map.put(9,90);
            map.put(10,100);
            map.put(11,110);
            map.put(12,120);
            map.put(13,130);
            map.put(14,140);
            map.put(15,150);
            map.put(16,160);
            map.put(17,170);
            map.put(18,180);
            map.put(19,190);
            map.put(20,200);
            map.display();
            System.out.println();
            System.out.println(map.get(1));
            System.out.println(map.get(2));
            System.out.println(map.get(3));
            System.out.println(map.get(4));
            System.out.println(map.get(5));
            System.out.println(map.get(6));
            System.out.println(map.get(7));
            System.out.println(map.get(8));
            System.out.println(map.get(9));
            System.out.println(map.get(10));
            map.remove(6);
            map.remove(7);
            map.remove(8);
            map.remove(9);
            map.remove(10);
            map.display();
            System.out.println(map.get(1));
            System.out.println(map.get(2));
            System.out.println(map.get(3));
            System.out.println(map.get(4));
            System.out.println(map.get(5));
            System.out.println(map.containsKey(1));
            System.out.println(map.containsKey(2));
            System.out.println(map.containsKey(3));
            System.out.println(map.containsKey(4));
            System.out.println(map.containsKey(5));
            System.out.println(map.containsKey(6));
            System.out.println(map.containsKey(7));
            System.out.println(map.containsKey(8));
            System.out.println(map.containsKey(9));
            System.out.println(map.containsKey(10));
    }
}
