public class AL_DoubleLinkedList {
    public static void main(String[] args){
        DoubleLinkedList<Integer> dl  = new DoubleLinkedList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        for(int i=0;i<arr.length;i++) dl.add(arr[i]);
        for(int i=0;i<dl.size;i++){
            System.out.println(dl.get(i));
        }
    }
    static class DoubleLinkedList<object> {
        private class Node {
            private object data;
            private Node Prev;
            private Node Next;
            Node(object d) {
                this.data = d;
                this.Prev = null;
                this.Next = null;
            }
        }
        private Node header;
        private Node tail;
        public int size;
        public DoubleLinkedList(){
            header = new Node(null);
            size = 0;
        }
        public object get(int index){
            return getNode(index).data;
        }
        private Node getNode(int index){
            if(index<0 || index>size) {
                System.out.println("Error");
                return null;
            }
            Node Curr;
            if(index<=size/2){
                Curr = header;
                for(int i=0;i<index;i++) {
                    Curr = Curr.Next;
                }
            } else {
                Curr =tail;
                for(int i=size-1;i>index;i--) {
                    Curr = Curr.Prev;
                }
            }
            return Curr;
        }
        public void addFirst(object input) {
            if(header.data == null){
                header = new Node(input);
                tail = new Node(null);
                header.Next = tail;
            } else {
                Node inputNode = new Node(input);
                inputNode.Next = header;
                header.Prev = inputNode;
                header = inputNode;
                if(tail == null) tail = header.Next;
            }
            size++;
        }
        public void add(object input){
            if(header.data == null) {
                addFirst(input);
                return;
            }
            else if(tail.data == null){
                tail = new Node(input);
                header.Next = tail;
                tail.Prev = header;
            } else {
                Node inNode = new Node(input);
                inNode.Prev = tail;
                tail.Next = inNode;
                tail = inNode;
            }
            this.size++;
        }
        public void add(int index, object input){
            if(index == 0) addFirst(input);
            else if(index<0 || index>size){
                System.out.println("Error");
                return;
            }
            else if(index == size){
                add(input);
                return;
            }
            Node inNode = new Node(input);
            Node Curr;
            if(index<=size/2){
                Curr = header;
                for(int i=0;i<=index;i++) Curr = Curr.Next;
            } else {
                Curr =tail;
                for(int i=size;i>=index;i--) Curr = Curr.Prev;
            }
            inNode.Prev = Curr.Prev;
            Curr.Prev.Next = inNode;
            inNode.Next = Curr;
            Curr.Prev = inNode;
            size++;
        }

    }
}
