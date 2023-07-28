
import java.util.*;
import java.util.stream.*;

public class pro_Level1_5{
    public static int ListToJ(List<Integer> lostP, List<Integer> reserveP, int n, int to){
        lostP.remove(lostP.indexOf(n));
        reserveP.remove(reserveP.indexOf(to));
        return 1;
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        if(reserve.length == 0) return n-lost.length;
        List<Integer> lostP = new ArrayList<>();
        List<Integer> reserveP = new ArrayList<>();
        for(int i=0;i<Math.max(lost.length,reserve.length);i++){
            if(i<lost.length) lostP.add(lost[i]);
            if(i<reserve.length) reserveP.add(reserve[i]);
        }
        for(int i=1;i<=n;i++){
            if(lostP.contains(i) && reserveP.contains(i)) {
                lostP.remove(lostP.indexOf(i));
                reserveP.remove(reserveP.indexOf(i));
            }
        }
        int count = 0;
        for(int i=1;i<=n;i++){
            if(lostP.contains(i)){
                if(reserveP.contains(i-1)){
                    lostP.remove(lostP.indexOf(i));
                    reserveP.remove(reserveP.indexOf(i-1));
                    count++;
                }
                else if(reserveP.contains(i+1)){
                    lostP.remove(lostP.indexOf(i));
                    reserveP.remove(reserveP.indexOf(i+1));
                    count++;
                }
            }
            else count++;
        }
        return count;
    }
    public static void main(String[] args){
        int n1 = 10;
        int[] a1 = new int[] {4,5,8,9};
        int[] b1 = new int[] {2,6,10};
        int n2 = 10;
        int[] a2 = new int[] {3,5,7};
        int[] b2 = new int[] {4,6,8};
        int n3 = 10;
        int[] a3 = new int[] {3,6,7};
        int[] b3 = new int[] {4,5,8};
        int n4 = 10;
        int[] a4 = new int[] {4,5,6,7};
        int[] b4 = new int[] {2,3,8,9};
        int n5 = 9;
        int[] a5 = new int[] {1,3,5,7,9};
        int[] b5 = new int[] {2,4,6,8};
        System.out.println(solution(n1,a1,b1));
    }
}