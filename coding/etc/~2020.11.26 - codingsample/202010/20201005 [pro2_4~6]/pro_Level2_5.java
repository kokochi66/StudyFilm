import java.util.*;
import java.util.stream.IntStream;

public class pro_Level2_5 {
    public static int solution(int[] priorities, int location) {
        LinkedList<Integer[]> list = new LinkedList<Integer[]>();
        for(int i=0;i<priorities.length;i++) list.add(new Integer[]{priorities[i],0});
        list.set(location, new Integer[]{priorities[location],1});
        int answer = 1;
        int max = IntStream.range(0,list.size()).map(index->list.get(index)[0]).max().getAsInt();
        while(!(list.get(0)[1] == 1 && list.get(0)[0] >= max)){
            int first = list.get(0)[0];
            System.out.println(first +" "+max+" "+answer);
            if(first<max) {
                list.add(list.get(0));
                list.remove(0);
            }
            else {
                list.remove(0);
                answer++;
            }
            max = IntStream.range(0,list.size()).map(index->list.get(index)[0]).max().getAsInt();
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] input = {1, 1, 9, 1, 1, 1};
        System.out.println(solution(input,5));
    }
    
}
