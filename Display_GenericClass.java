public class Display_GenericClass {
    
    public class Test<T> {
        T obj;

        Test(T obj) {
            this.obj = obj;
        }

        public T getObject() { 
            return this.obj; 
        }
    }

    public <T> void display(T[] arr) {
        for(T element : arr) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Display_GenericClass displayInstance = new Display_GenericClass();
        Test<Integer> iObj = displayInstance.new Test<>(15);

        Integer[] arr = {1, 2, 3, 4, 5};
        displayInstance.display(arr);

        Test<String> iobj2=displayInstance.new Test<>("anuj");
        String[] name={"Anuj","Kush"};
        displayInstance.display(name);
    }
}
