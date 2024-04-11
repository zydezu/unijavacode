package tools;

public class ArrayStack<T> implements IStack<T>{

    T[] data;
    int top; // index of the top of the stack, 0 if empty

    public ArrayStack(int size){
        data = (T[]) new Object[size];
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean push(T value) {
        if(top < data.length - 1){
            data[top] = value;
            top++;
            return true;
        }
        return false;
    }

    @Override
    public T peek() {
        if(top == 0){
            return null;
        }
        return data[top - 1];
    }

    @Override
    public T pop() {
        T value = peek();
        top = Math.max(0, top - 1);
        return value;
    }

    public static void main(String[] args) {
        IStack<String> stackS = new ArrayStack<>(5);
        System.out.println(stackS.isEmpty());
        System.out.println(stackS.pop());
        System.out.println(stackS.push("seven"));
        System.out.println(stackS.peek());

        IStack<Integer> stackI = new ArrayStack<>(5);
        System.out.println(stackI.isEmpty());
        System.out.println(stackI.pop());
        System.out.println(stackI.push(7));
        //Comment/uncomment to show compilation error
        // System.out.println(stackI.push("seven")); 
        System.out.println(stackI.peek());
    }

    
}