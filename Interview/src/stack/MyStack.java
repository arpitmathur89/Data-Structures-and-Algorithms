package stack;

/**
 * Created by arpit on 7/4/2017.
 */
public class MyStack<E> {
    private E[] arr = null;
    private int cap;
    private int top = -1;
    private int size = 0;

    public MyStack(int cap){
        this.cap = cap;
        this.arr = (E[])new Object[cap];
    }

    public E pop(){
        if(this.size == 0)
            return null;
        this.size --;
        E result = this.arr[top];
        this.arr[top] = null;
        this.top--;
        return result;
    }

    public void push(E e){
        if(this.size == cap)
            return;
        this.size++;
        this.arr[++top] = e;
        return;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public static void main(String[] args) {
        MyStack<Integer> st = new MyStack<Integer>(5);
        st.push(6);
        st.push(8);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());
        st.push(9);
        System.out.println(st.isEmpty());

    }
}
