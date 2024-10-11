/*This implementation of a stack uses an ArrayList as the underlying structure, allowing dynamic resizing and efficient index-based operations.
The generic type T makes the stack flexible, enabling it to handle different data types.
The class provides standard stack operations: push(), pop(), peek(), size(), and isEmpty(). */
import java.util.*;
public class Generic_class_Stack_Implementation <T>{
    ArrayList<T> st;
    public Generic_class_Stack_Implementation(){
        st=new ArrayList<>();
    }
    public void push(T data){
        st.add(data);
    }
    public T pop(){
        T data=st.get(st.size()-1);
        st.remove(st.size()-1);
        return data;
    }
    public T peek(){
        return st.get(st.size()-1);
    }
    public int size(){
        return st.size();
    }
    public boolean isEmpty(){
        if(st.size()==0){
            return true;
        }
        return false;
    }
    public static void  Main(String args[]) {
            Generic_class_Stack_Implementation<Integer> obj=new Generic_class_Stack_Implementation<>();
            obj.push(1);
            obj.push(2);
            obj.push(3);
            obj.push(4);
            obj.push(5);
            System.out.println(obj.pop());
            System.out.println(obj.peek());
            System.out.println(obj.size());
            System.out.println(obj.isEmpty());

    }
}
