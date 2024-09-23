
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        // Move all elements from queue2 to queue1
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        // Add the new element to queue2 (which acts as the top of the stack)
        queue2.add(x);
        // Move everything back from queue1 to queue2 to maintain stack order
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
    }
    
    public int pop() {
        return queue2.poll();
    }
    
    public int top() {
        return queue2.peek();
    }
    
    public boolean empty() {
        return queue2.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */