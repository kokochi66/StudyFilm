import java.util.Scanner;

public class bkjcoing_L2 {
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     if(a>b) System.out.println(">");
    //     else if(a<b) System.out.println("<");
    //     else if(a==b) System.out.println("==");
    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     if(a%4==0 && a%100!=0 || a%400==0) System.out.println("1");
    //     else System.out.println("0");
    // }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        b -= 45;
        if(b<0) {
            a--;
            b+=60;
        }
        if(a<0) a += 24;
        System.out.println(a + " " + b);
    }
}
