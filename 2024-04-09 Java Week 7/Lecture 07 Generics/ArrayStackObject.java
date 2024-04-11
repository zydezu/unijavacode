package tools;

public class ArrayStackObject implements IStackObject{

    Object[] data;
    int top; // index of the top of the stack, 0 if empty

    public ArrayStackObject(int size){
        data = new Object[size];
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean push(Object value) {
        if(top < data.length - 1){
            data[top] = value;
            top++;
            return true;
        }
        return false;
    }

    @Override
    public Object peek() {
        if(top == 0){
            return null;
        }
        return data[top - 1];
    }

    @Override
    public Object pop() {
        Object value = peek();
        top = Math.max(0, top - 1);
        return value;
    }

    public static void main(String[] args) {
        IStackObject stack = new ArrayStackObject(10);
        stack.push(1);
        stack.push(new String("one"));
        int product = 1;
        while(!stack.isEmpty()){
            Integer element = (Integer) stack.pop();
            product *= element;
        }
        System.out.println("product is: " + product);
    }
    
}