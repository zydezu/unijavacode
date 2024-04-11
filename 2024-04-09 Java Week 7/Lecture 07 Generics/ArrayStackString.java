package tools;

public class ArrayStackString implements IStackString{

    String[] data;
    int top; // index of the top of the stack, 0 if empty

    public ArrayStackString(int size){
        data = new String[size];
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean push(String value) {
        if(top < data.length - 1){
            data[top] = value;
            top++;
            return true;
        }
        return false;
    }

    @Override
    public String peek() {
        if(top == 0){
            return null;
        }
        return data[top - 1];
    }

    @Override
    public String pop() {
        String value = peek();
        top = Math.max(0, top - 1);
        return value;
    }

    
}