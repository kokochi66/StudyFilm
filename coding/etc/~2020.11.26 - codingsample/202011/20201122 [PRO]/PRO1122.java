import java.util.*;
import java.io.*;

public class PRO1122 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
        System.out.println(2<<1);
    }
    public int solution1(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            if(!set.contains(nums[i]) && set.size()<n/2) {
                set.add(nums[i]);
            }
        }
        return set.size();
    }
    public static int solution2(int[][] land) {
        int n = land.length;
        int[][] darr = new int[n][4];
        for(int i=0;i<4;i++) darr[n-1][i] = land[n-1][i];
        for(int i=n-2;i>=0;i--){
            darr[i][0] = Math.max(darr[i+1][1], Math.max(darr[i+1][2],darr[i+1][3])) + land[i][0];
            darr[i][1] = Math.max(darr[i+1][0], Math.max(darr[i+1][2],darr[i+1][3])) + land[i][1];
            darr[i][2] = Math.max(darr[i+1][1], Math.max(darr[i+1][0],darr[i+1][3])) + land[i][2];
            darr[i][3] = Math.max(darr[i+1][1], Math.max(darr[i+1][2],darr[i+1][0])) + land[i][3];
        }
        return Math.max(Math.max(darr[0][0],darr[0][1]), Math.max(darr[0][2],darr[0][3]));
    }
    public static int solution3(int n) {
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        int sum = 0;
        for(int i=0;i<=n;i++){
            sum += i;
            q.offer(i);
            if(sum > n){
                while(sum > n){
                    sum -= q.poll();
                }
            }
            if(sum == n) {
                res++;
            }
        }
        return res;
    }
    public int[] solution4(String s) {
        int zeroCnt = 0;
        int res = 0;
        int oneCnt = 0;
        while(!s.equals("1")){
            res++;
            oneCnt = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0') zeroCnt++;
                else oneCnt++;
            }
            int index = 1;
            s = "";
            while(oneCnt != 0){
                if((oneCnt&index)!=0){
                    oneCnt -= index;
                    s += "1";
                } else s+= "0";
                index <<= 1;
            }
            System.out.println(s);
        }
        return new int[]{res,zeroCnt};
    }
    public String solution5(String s) {
        StringTokenizer tok = new StringTokenizer(s);
        ArrayList<Integer> list = new ArrayList<>();
        while(tok.hasMoreTokens()) list.add(Integer.parseInt(tok.nextToken()));
        Collections.sort(list);
        return list.get(0)+" "+list.get(list.size()-1);
    }
    public int solution6(int[] A, int[] B)
    {
        int res = 0;
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<n;i++){
            res += (A[i]*B[n-i-1]);
        }
        return res;
    }
    public int solution7(int n) {
        long sum = 0;
        long[] arr = new long[n+5];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            arr[i] = (arr[i-1]+arr[i-2])%1234567;
        }
        return (int)arr[n];
    }
    public long solution(String expression) {
        max = 0;
        StringTokenizer tok = new StringTokenizer(expression,"[+*-]");
        ArrayList<Integer> numl = new ArrayList<>();
        ArrayList<Character> opl = new ArrayList<>();
        while(tok.hasMoreTokens()) numl.add(Integer.parseInt(tok.nextToken()));
        for(int i=0;i<expression.length();i++) {
            if( expression.charAt(i)=='*'||
                expression.charAt(i)=='+'||
                expression.charAt(i)=='-') 
                    opl.add(expression.charAt(i));
        }
        char[] op = {'*','+','-'};
        char[] oper = new char[3];
        boolean[] used = new boolean[3];
        max = 0;
        solution8_btk(0,oper,op,used,numl,opl);
        long answer = 0;
        return answer;
    }
    static long max;
    public static void solution8_btk(int k, char[] oper, char[] op, boolean[] used, ArrayList<Integer> numl, ArrayList<Character> opl){
        if(k==3){
            ArrayList<Integer> cn = new ArrayList<Integer>(numl);
            ArrayList<Character> co = new ArrayList<Character>(opl);
            for(int i=0;i<3;i++) {
                for(int j=0;j<co.size();j++){
                    if(co.get(j)==oper[i]){
                        int res = 0;
                        if(oper[i]=='*') res = cn.get(j)*cn.get(j+1);
                        else if(oper[i]=='+') res = cn.get(j)+cn.get(j+1);
                        else if(oper[i]=='-') res = cn.get(j)-cn.get(j+1);
                        cn.set(j, res);
                        cn.remove(j+1);
                        co.remove(j);
                        j--;
                    }
                }
            }
            int temp = Math.abs(cn.get(0));
            if(max < temp) max = temp;
        } else {
            for(int i=0;i<3;i++){
                if(!used[i]){
                    oper[k] = op[i];
                    used[i] = true;
                    solution8_btk(k+1,oper,op,used,numl,opl);
                    used[i] = false;
                }
            }
        }
    }
}