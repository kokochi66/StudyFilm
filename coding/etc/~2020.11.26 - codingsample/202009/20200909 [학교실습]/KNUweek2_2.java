
import java.util.Arrays;
import java.util.Scanner;

public class KNUweek2_2 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int river = sc.nextInt();
        int keke = sc.nextInt();
        int[] jump = new int[keke];
        boolean[] output = new boolean[river];
        Arrays.fill(output,false);
        for(int i=0;i<keke;i++) jump[i] = sc.nextInt();
        for(int i=2;i<=river;i++){
            for(int j=0;j<keke;j++){
                if(i % jump[j] == 0 && i%10 != 1) {
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }
    
}
