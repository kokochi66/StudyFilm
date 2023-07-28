import java.util.PriorityQueue;
import java.util.Random;

public class Queue_PriorityQueueTest {
    public static void main(String[] args){
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        Random random = new Random(System.nanoTime());  //우선순위 확인을 위해 난수 발생
        System.out.print("난수발생 = ");
        for(int i=0;i<10;i++){
            int r = random.nextInt(50);
            System.out.print(r+" ");
            q.add(r);
        }
        System.out.println();

        int size = q.size();
        for(int i=0;i<size;i++){
            System.out.println("우선순위 큐에 정렬된 난수 " + i + " = " + q.poll()+" ");
        }
        System.out.println();
        //난수로 입력된 값들이 정렬이 되어서 출력됨
    }
}
