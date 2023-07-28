import java.util.*;

public class pro_Level2_16 {
    public static int deletion(int[] s, int size){
        int saveAs = s[0];

        s[0] = s[size-1];
        size--;
        int CurrS = 1;
        int CurrV = s[CurrS-1];
        while(CurrS*2 <= size){
            int posS = CurrS*2;
            int posV = s[posS-1];
            if(posS < size && s[posS] < posV) {
                posS++;
                posV = s[posS-1];
            }
            if(posV > CurrV) return saveAs;
            s[CurrS-1] = posV;
            s[posS-1] = CurrV;
            CurrS = posS;
        }
        return saveAs;
    }
    
    public static boolean Addition(int[] s, long n, int size){
        if(size==0) {
            s[0] = (int)n;
            return true;
        }
        s[size] = (int)n;
        size++;
        int CurrS = size;
        int CurrV = s[CurrS-1];
        while(CurrS > 1 && s[(CurrS/2)-1] > CurrV){
            s[CurrS-1] = s[(CurrS/2)-1];
            s[(CurrS/2)-1] = CurrV;
            CurrS /= 2;
        }
        return true;
    } 

    public static int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
        int size = scoville.length;
        boolean over = false;
        int count = 0;
        while(size>0 && scoville[0] < K){
            if(size == 1) return -1;
            count++;
            long a = (long) deletion(scoville, size--);
            a += (long) (deletion(scoville, size--)*(long)2);
            System.out.println(Arrays.toString(scoville) + "  size22 = "+size+" "+a);
            if(a >= K && ! over) {
                Addition(scoville,a,size++);
                over = true;
            }
            else if(a < K) Addition(scoville,a,size++);
            System.out.println(Arrays.toString(scoville) + "  size33 = "+size);
        }
        return count;
    }
    public static void main(String[] args){
        int[] scoville = {1,1,0,1,0,0,1};
        System.out.println(Addition(scoville,0,1));
        
        int K = 8;
        System.out.println(solution(scoville,K));

    }
    
}
