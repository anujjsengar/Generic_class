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
        table=new ArrayList<>(10);
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
    public int size(){
        return size;
    }
    public V get(K key){
        int idx=key.hashCode();
        return table.get(idx%table.size()).value;
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
        HashMap_Implement<Integer,Integer> map=new HashMap_Implement<>(4);
        map.put(1,1);
        map.put(1,2);
        map.put(2,1);
        map.put(3,2);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(3));
        System.out.println(map.containsKey(5));
        System.out.println(map.size());
    }
}
