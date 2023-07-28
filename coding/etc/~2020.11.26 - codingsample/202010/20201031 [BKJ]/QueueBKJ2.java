import java.io.*;
import java.util.*;

public class QueueBKJ2 {
    //  https://www.acmicpc.net/problem/2164 카드 2
    public static void main(String[] args) throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> card = new LinkedList<Integer>();
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        for(int i=1;i<=n;i++){
            card.add(i);
        }
        boolean count = false;
        while(card.size() > 1){
            if(count) {
                card.add(card.poll());
                count = false;
            } else {
                card.poll();
                count = true;
            }
        }
        System.out.println(card.peek());
    }
}
