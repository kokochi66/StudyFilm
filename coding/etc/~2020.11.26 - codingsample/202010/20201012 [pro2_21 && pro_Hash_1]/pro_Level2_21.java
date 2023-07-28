import java.util.Arrays;

public class pro_Level2_21 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int i = 0, j = citations.length-1;
        while(j>=0 && citations[j-i] >= i+1){
            i++;
        }
        return i;
    }
}
