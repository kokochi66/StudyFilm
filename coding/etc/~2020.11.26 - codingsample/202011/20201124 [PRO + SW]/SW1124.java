import java.util.*;
import java.io.*;

public class SW1124 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
        Solution();
      
    }
    public static void Solution() throws Exception {
        for(int TT=0;TT<10;TT++){
            int TestCase = Integer.parseInt(Read.readLine());
            StringBuilder str = new StringBuilder(Read.readLine());
            ArrayList<String> res = new ArrayList<>();
            Stack<String> os = new Stack<>();
            tok = new StringTokenizer(str.toString(),"[+-*/()]");
            Queue<Integer> nq = new LinkedList<>();
            Queue<String> oq = new LinkedList<>();
            while(tok.hasMoreTokens()) nq.offer(Integer.parseInt(tok.nextToken()));
            for(int i=0;i<str.length();i++) {
                if(str.charAt(i)>=0 && str.charAt(i)<=9){
                    oq.offer(tok.nextToken());
                    while(str.charAt(i)>=0 && str.charAt(i)<=9) i++;
                    i--;
                } else {
                    oq.offer(Character.toString(str.charAt(i)));
                }
            }
            // 입력부 O
            // while(!oq.isEmpty()) System.out.print(oq.poll()+" ");

            while(!oq.isEmpty()) {
                char c = oq.peek().charAt(0);
                String cu;
                if(!os.isEmpty()) cu = os.peek();
                else cu = "";
                if(c=='+' || c=='-') {
                    if(cu.equals("+") || cu.equals("-")) {
                        while(cu.equals("+") || cu.equals("-")) {
                            res.add(cu);
                            os.pop();
                            if(!os.isEmpty()) cu = os.peek();
                            else cu = "";
                        }
                    } else if(cu.equals("*") || cu.equals("/")) {
                        res.add(cu);
                        os.pop();
                        cu = os.peek();
                        while(cu.equals("+") || cu.equals("-")) {
                            res.add(cu);
                            os.pop();
                            if(!os.isEmpty()) cu = os.peek();
                            else cu = "";
                        }
                    }
                    os.push(Character.toString(c));
                } else if(c=='*' || c=='/') {
                    if(cu.equals("*") || cu.equals("/")) {
                        while(cu.equals("*") || cu.equals("/")) {
                            res.add(cu);
                            os.pop();
                            if(!os.isEmpty()) cu = os.peek();
                            else cu = "";
                        }
                    }
                    os.push(Character.toString(c));
                } else if(c=='(') {
                    os.push(Character.toString(c));
                } else if(c==')') {
                    while(!cu.equals("(")){
                        res.add(cu); 
                        os.pop();
                        if(!os.isEmpty()) cu = os.peek();
                        else cu = "";
                    }
                    os.pop();
                } else {
                    res.add(oq.peek());
                }
                oq.poll();
            }
            while(!os.isEmpty()) res.add(os.pop());

            Stack<Integer> numb = new Stack<>();
            int ans = 0;
            for(int i=0;i<res.size();i++){
                char c = res.get(i).charAt(0);
                if(c=='+'){
                    int a = numb.pop();
                    int b = numb.pop();
                    numb.push(b+a);
                } else if(c=='-'){
                    int a = numb.pop();
                    int b = numb.pop();
                    numb.push(b-a);
                } else if(c=='*'){
                    int a = numb.pop();
                    int b = numb.pop();
                    numb.push(b*a);
                } else if(c=='/'){
                    int a = numb.pop();
                    int b = numb.pop();
                    numb.push(b/a);
                } else numb.push(Integer.parseInt(res.get(i)));
            }
            System.out.println(numb.pop());
            // for(int i=0;i<res.size();i++) System.out.print(res.get(i)+" ");
            // System.out.println("  ::this is res::");
        }
    }
    public static void SW1124_3() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=1;TT<=TestCase;TT++){
            tok = new StringTokenizer(Read.readLine());
            int n = Integer.parseInt(tok.nextToken());
            int m = Integer.parseInt(tok.nextToken());
            int k = Integer.parseInt(tok.nextToken());
            int res = k < n ? n-k : k > m ? -1 : 0;
            System.out.println("#"+TT+" "+res);
        }
    }
    public static void SW1124_2() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        System.out.println(n+m);
        System.out.println(n-m);
        System.out.println(n*m);
        System.out.println(n/m);
    }
    public static void SW1124_1() throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s.toUpperCase());
    }
}