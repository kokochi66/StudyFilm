import java.util.Arrays;

public class union1109 {
    static int getp(int[] p, int x){
        System.out.println(x+"  "+p[x]);
        System.out.println(Arrays.toString(p));
        if(p[x] == x) {
            System.out.println("output");
            return x;
        }
        return p[x] = getp(p, p[x]);
    }

    static void unip(int[] p, int a, int b){
        a = getp(p, a);
        System.out.println("here::::::::::::::::");
        b = getp(p, b);
        if(a<b) p[b] = a;
        else p[a] = b;
    }
    static boolean finp(int[] p, int a, int b){
        a = getp(p, a);
        b = getp(p, b);
        return a==b;
    }
    public static void main(String[] args){
        int[] p = new int[10];
        for(int i=0;i<10;i++) p[i] = i;
        unip(p,1,2);
        unip(p,2,3);
        unip(p,3,4);
        unip(p,5,6);
        unip(p,6,7);
        unip(p,7,8);
        System.out.println(finp(p,1,5));
        System.out.println("Searching here ------");
        unip(p,1,7);
        System.out.println("Searching End -------");
        System.out.println(finp(p,1,7));

    }
}
