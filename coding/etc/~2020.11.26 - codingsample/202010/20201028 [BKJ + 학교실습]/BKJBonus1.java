import java.util.*;

public class BKJBonus1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0) System.out.println(1);
        else {
            int[] arr = new int[n];
            arr[0] = 1;
            for(int i=1;i<n;i++){
                arr[i] = arr[i-1]*(i+1);
            }
            System.out.println(arr[n-1]);
        }
        
    }
}
