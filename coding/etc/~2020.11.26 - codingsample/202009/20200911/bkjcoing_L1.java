import java.util.Scanner;

public class bkjcoing_L1 {
    // public static void main(String[] args){
    //     System.out.println("Hello World!");
    // }
    // public static void main(String[] args){
    //     System.out.println("강한친구 대한육군");
    //     System.out.println("강한친구 대한육군");
    // }
    // public static void main(String[] args){
    //     System.out.println("\\    /\\");
    //     System.out.println(" )  ( ')");
    //     System.out.println("(  /  )");
    //     System.out.println(" \\(__)|");
    // }
    // public static void main(String[] args){
    //     System.out.println("|\\_/|");
    //     System.out.println("|q p|   /}");
    //     System.out.println("( 0 )\"\"\"\\");
    //     System.out.println("|\"^\"`    |");
    //     System.out.println("||_/=\\\\__|");
    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     System.out.println(a+b);
    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     System.out.println(a-b);
    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     System.out.println(a*b);
    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     System.out.println((double)a/b);
    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     System.out.println(a+b);
    //     System.out.println(a-b);
    //     System.out.println(a*b);
    //     System.out.println((int)a/b);
    //     System.out.println(a%b);
    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     int c = sc.nextInt();
    //     System.out.println((a+b)%c);
    //     System.out.println(((a%c) + (b%c))%c);
    //     System.out.println((a*b)%c);
    //     System.out.println(((a%c) * (b%c))%c);
    // }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a*b;
        while(b != 0){
            System.out.println(a*(b%10));
            b /= 10;
        }
        System.out.println(sum);
    }
}
