package stackANDqueue;
class MinStack {
    private Node head;
    
    class Node{
        private int value;
        private int min;
        private Node next;
    }
    
    //the head node always has the "current" minimum value in it
    public void push(int x) {
    	
    Node node =new Node();
    node.value=x;
    
    if(head==null){
        node.min=x;
        head=node;
    }else{
        if(x<head.min){
            node.min=x;
        }else{
            node.min=head.min;
        }
        node.next=head;
        head=node;
    }
    }

    public void pop() {
        if(head.next==null){
            head=null;
        }
        else{
        head=head.next;
        }
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }
}
