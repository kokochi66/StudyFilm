import java.util.*;
import java.io.*;

public class PRO1123 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
    }
    public int[][] solution1(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int l = arr1[0].length;
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int res = 0;
                for(int k=0;k<l;k++){
                    res += arr1[i][k]*arr2[k][j];
                }
                answer[i][j] = res;
            }
        }
        for(int i=0;i<n;i++) System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static String solution2(String s) {
        StringBuilder str = new StringBuilder("");
        StringTokenizer tok = new StringTokenizer(s);
        int index = 0;
        while(tok.hasMoreTokens()){
            String c = tok.nextToken();
            str.append(c.toUpperCase().charAt(0));
            str.append(c.toLowerCase().substring(1, c.length()));
            index += c.length();
            while(index < s.length() && s.charAt(index) == ' ') {
                str.append(' ');
                index++;
            }
        }
        return str.toString();
    }
    public int solution3(int[] arr) {
        long lcm = 1;
        int n = arr.length;
        for(int i=0;i<n;i++){
            long res = 0;
            int max = Math.max(arr[i], (int)lcm);
            int min = Math.min(arr[i], (int)lcm);
            while(min>0){
                int ds = max/min;
                int ms = max%min;
                if(ms==0){
                    res = min;
                    break;
                }
                max = min;
                min = ms;
            }
            System.out.println(res);
            lcm = res;
        }
        return (int)lcm;
    }
    public int solution4(String s)
    {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i)==st.peek()) {
                st.pop();
                count++;
            }
            else st.push(s.charAt(i));
        }
        return count;
    }
    public int solution5(int[] nums) {
        res = 0;
        boolean[] used = new boolean[nums.length];
        solution5_btk(0,0,0,nums,used);
        return res;
    }
    static int res;
    public static void solution5_btk(int k, int ci, int sum, int[] arr, boolean[] used){
        if(k==3){
            System.out.println(sum);
            for(int i=2;i<=Math.sqrt(sum);i++){
                if(sum%i==0) return;
            }
            res++;
        } else {
            for(int i=ci;i<arr.length;i++){
                if(!used[i]){
                    used[i] = true;
                    solution5_btk(k+1,i+1,sum+arr[i],arr,used);
                    used[i] = false;
                }
            }
        }
    }
    public int solution6(int n) {
        int count = 0;
        while(n>1) {
            if(n%2==0) n/=2;
            else {
                count ++;
                n--;
            }
        }
        return n+1;
    }
}