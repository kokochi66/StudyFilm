import java.util.*;

public class pro_Level1_40 {
    public static int[] solution(int N, int[] stages) {
        Hashtable<Integer, Double> table = new Hashtable<Integer, Double>();
        for(int i=1;i<=N;i++){
            final int index = i;
            table.put(i, (double)((double)Arrays.stream(stages).filter(index1 -> index1==index).count()/(double)Arrays.stream(stages).filter(index2 -> index2>=index).count()));
        }
        ArrayList<Integer> outList = new ArrayList<Integer>();
        int swit = 0;
        for(int i=1;i<=N;i++){
            swit = 0;
            for(int j=0;j<outList.size();j++) {
                if(table.get(i) > table.get(outList.get(j))) {
                    swit = j;
                    break;
                }
                else swit = j+1;
            }
            outList.add(swit,i);
        }
        int[] output = new int[N];
        for(int i=0;i<N;i++) output[i] = outList.get(i);
        return output;
    }
}
