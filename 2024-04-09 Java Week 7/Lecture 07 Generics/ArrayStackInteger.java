package tools;

public class ArrayStackInteger implements IStackInteger{

    Integer[] data;
    int top; // index of the top of the stack, 0 if empty

    public ArrayStackInteger(int size){
        data = new Integer[size];
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean push(Integer value) {
        if(top < data.length - 1){
            data[top] = value;
            top++;
            return true;
        }
        return false;
    }

    @Override
    public Integer peek() {
        if(top == 0){
            return null;
        }
        return data[top - 1];
    }

    @Override
    public Integer pop() {
        Integer value = peek();
        top = Math.max(0, top - 1);
        return value;
    }

    public static void main(String[] args) {
        IStackInteger stack = new ArrayStackInteger(10);
        stack.push(1);
        //Comment/uncomment to show compilation error
        // stack.push(new String("one"));
        int product = 1;
        while(!stack.isEmpty()){
            Integer element = (Integer) stack.pop();
            product *= element;
        }
        System.out.println("product is: " + product);
    }

    

    
}