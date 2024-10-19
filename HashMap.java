import java.util.*;
public class HashMap<K,V>{
    public class Node{
        K key;
        V value;
        Node next;
        public Node(K key,V val){
            this.key=key;
            this.value=val;
        }
    }
        ArrayList<Node> table;
        int size=0;
        public HashMap(int size){
            this.table=new ArrayList<>(10);
            for(int i=0;i<size;i++){
                table.add(null);
            }
        }
        public HashMap(){
            this(4);
        }
        public void put(K key,V val){
            int idx=generateIndex(key);
            Node temp=table.get(idx);
            Node prev=temp;
            if(temp!=null){
                if(temp.key.equals(key)){
                    temp.value=val;
                    return ;
                }
                temp=temp.next;
            }
            Node nn=new Node(key, val);
            table.set(idx,nn);
            nn.next=prev;
            size++;
            int lf=size/table.size();
            int thf=2;
            if(lf>thf){
                rehashing();
            }
        }
        public void rehashing(){
            ArrayList<Node> li=new ArrayList<>();
            for(int i=0;i<2*table.size();i++){
                li.add(null);
            }
            ArrayList<Node> list=this.table;
            this.table=li;
            for(Node node:list){
                while(node!=null){
                    table.add(node);
                    node=node.next;
                }
            }
        }
        public V get(K key){
            int idx=generateIndex(key);
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
            for(Node temp:table){
                while(temp!=null){
                    System.out.println(temp.key+" "+temp.value);
                    temp=temp.next;
                }
            }
        }
        public void remove(K key){
            int idx=generateIndex(key);
            Node temp=table.get(idx);
            if(temp==null){
                return ;
            }
            if(temp.key.equals(key)){
                table.set(idx,temp.next);  
                size--;
                return;
            }
            Node prev=null;
            while(temp!=null){
                if(temp.key.equals(key)){
                    prev.next=temp.next;
                    size--;
                    return;
                }
                prev=temp;
                temp=temp.next;
            }
        }
        public boolean containsKey(K key){
            int idx=generateIndex(key);
            Node temp=table.get(idx);
            while (temp!=null) {
                if(temp.key.equals(key)){
                    return true;
                }
                temp=temp.next;
            }
            return false;
        }
        public int generateIndex(K key){
            return key.hashCode()%table.size();
        }
        public static void main(String args[]){
            HashMap<Integer,Integer> map=new HashMap<>(20);
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
            System.out.println();
            map.display();
            System.out.println("size "+map.size);
        }
}
