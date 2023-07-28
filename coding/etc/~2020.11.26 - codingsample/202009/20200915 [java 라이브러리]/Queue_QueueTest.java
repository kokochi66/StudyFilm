import java.util.LinkedList;
import java.util.Queue;

public class Queue_QueueTest {
    public static void main(String[] args){
        Queue<Integer> myque = new LinkedList<Integer>();

        int t1 = 1;
        int t2 = 2;
        int t3 = 3;
        int t4 = 4;

        myque.offer(t1);
        myque.offer(t2);
        myque.offer(t3);
        myque.offer(t4);
        while(myque.peek() != null) {
            String val = myque.poll()+"";
            System.out.println("값은 " + val);
        }
    }
    
}
