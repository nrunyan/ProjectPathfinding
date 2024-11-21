public class DLinkedList {
    Node root;
    public DLinkedList(){
        this.root = new Node();
    }
    public void add(Object value){
        Node curr = this.root;
        Node addedNode;
        while(curr.getNext() != null){
            curr = curr.getNext();
        }
        addedNode = new Node(value,curr);
        curr.setNext(addedNode);
    }
    public Object get(int index){
        Node curr = this.root;
        while(curr.getNext() != null){
            if(curr.getIndex() == index){
                return curr.getValue();
            }
            Node nextNode = curr.getNext();
            curr = nextNode;
        }
        return null;
    }
}
