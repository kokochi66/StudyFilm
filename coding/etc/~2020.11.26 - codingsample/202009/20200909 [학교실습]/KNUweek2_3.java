import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KNUweek2_3 {

    public static void main(String[] args) throws Exception{
        Queue q = new LinkedList<String>();
        Queue tempQ = new LinkedList<String>();
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] order;
        int cellP = 0, cellH = 0, cellN = 0;
        int Piz = 0, Ham = 0, Any = 0;
        while(!a.equals("E")){
            order = a.split(" ");
            if(order[0].equals("O")) {
                if(order[1].equals("Hamburger") && (Ham+Piz+Any)<2) Ham++;
                else if(order[1].equals("Pizza") && (Ham+Piz+Any)<2) Piz++;
                else if(order[1].equals("Any") && (Ham+Piz+Any)<2) Any++;
                else if(Ham+Piz+Any>=2) cellN++;
            }
            else if(order[0].equals("F")) {
                q.offer(order[1]);
            }
            if(q.peek() != null) {
                if(Any>0){
                    if(q.peek().equals("Hamburger")) cellH++;
                    else if(q.peek().equals("Pizza")) cellP++;
                    q.poll();
                    Any--;
                }
                else if(Ham > 0 || Piz > 0){
                    while(q.peek() != null) {
                        if(q.peek().equals("Hamburger") && Ham > 0) {
                            Ham--;
                            cellH++;
                            q.poll();
                        }
                        else if(q.peek().equals("Pizza") && Piz > 0) {
                            Piz--;
                            cellP++;
                            q.poll();
                        }
                        else tempQ.offer(q.poll());
                    }
                    while(tempQ.peek() != null) q.offer(tempQ.poll());
                }
            }
            a = sc.nextLine();
        }
        while(q.peek() != null) {
            if(Ham > 0 && q.peek().equals("Hamburger")){
                cellH++;
                Ham--;
                q.poll();
            }
            else if(Piz > 0 && q.peek().equals("Pizza")){
                cellP++;
                Piz--;
                q.poll();
            }
            q.poll();
        }
        System.out.println("Pizza: " + cellP);
        System.out.println("Hamburger: " + cellH);
        System.out.println("Nothing: " + (cellN + Ham + Piz + Any));
    }
    
}
