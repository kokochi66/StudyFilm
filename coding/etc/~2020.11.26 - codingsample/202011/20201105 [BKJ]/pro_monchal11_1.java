import java.util.*;

public class pro_monchal11_1 {
    

    public static void main(String[] args){
        
    }

    public int solution(int[] a, int[] b) {
        int n = a.length;
        int result = 0;
        for(int i=0;i<n;i++){
            result += a[i]*b[i];
        }
        return result;
    }
}
