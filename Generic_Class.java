import java.util.*;
public class Generic_Class <K,V>{
    public class Node{
        K key;
        V val;
        Node next;
        public Node(K key,V value){
            this.key=key;
            this.val=value;
            this.next=null;
        }
    }
    ArrayList<Node> table;
    public Generic_Class(int size){
        this.table=new ArrayList<>(size);
        for(int i=0;i<size;i++){
            table.add(null);
        }
    }
    public Generic_Class(){
        this(4);
    }
    public void put(K key,V value){
        int idx=getIndex(key);
        Node temp=table.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                temp.val=value;
                return ;
            }
            temp=temp.next;
        }
        Node nn=new Node(key,value);
        table.set(idx,nn);
        nn.next=temp;

    }
    public int getIndex(K key){
        int idx=key.hashCode();
        return idx%table.size();
    }
    public V get(K key){
        int idx=key.hashCode();
        return table.get(idx%table.size()).val;
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
        Generic_Class<Integer,Integer> map=new Generic_Class<>(4);
        map.put(1,1);
        map.put(1,2);
        map.put(2,1);
        map.put(3,2);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(3));
        System.out.println(map.containsKey(5));
    }
}
