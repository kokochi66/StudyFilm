import java.util.*;
import java.util.stream.*;

public class pro_Level1_27 {
    public static int[] solution(int[] a) {
        int b = IntStream.range(0, a.length).map(i->a[i]).min().getAsInt();
        ArrayList<Integer> tempAL = new ArrayList<Integer>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        tempAL.remove(tempAL.indexOf(b));
        b = tempAL.size();
        if(b==0) b=1;
        int[] output = new int[b];
        output[0] = -1;
        for(int i=0;i<tempAL.size();i++) output[i] = tempAL.get(i); 
        return output;
    }
}
