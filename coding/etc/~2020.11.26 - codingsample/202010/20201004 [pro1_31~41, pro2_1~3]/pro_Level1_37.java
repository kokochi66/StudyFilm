import java.util.*;

public class pro_Level1_37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[] tempS = new char[a];
        Arrays.fill(tempS,'*');
        for(int i=0;i<b;i++){
            System.out.println(new String(tempS));
        }
    }
}
