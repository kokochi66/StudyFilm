package src.Y2021.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class main1125 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m;
    public static void main(String[] args) throws Exception {

/*        int[] lot = {44, 1, 0, 0, 31, 25};
        int[] win = {31, 10, 45, 1, 6, 19};
        int[] lot2 = {0, 0, 0, 0, 0, 0};
        int[] win2 = {38, 19, 20, 40, 15, 25};
        int[] lot3 = {44, 1, 0, 0, 31, 25};
        int[] win3 = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lot2, win2)));*/

//        System.out.println(solution("...!@B#*.................adfg.d.fg.sdf.gs....s.dfg.sd.fgsdfg.....sdf...$>@>#$>#>.V>DSFB..c..sd.g..bcv.b.sdfg..3456.."));
//        System.out.println(solution("123"));
//        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
//        System.out.println(solution(new int[]{4,7,12}, new boolean[]{true,false,true}));
//        System.out.println(solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2}));
//        System.out.println(solution(0, 17));
//        System.out.println(solution(1000000000));
//        System.out.println(solution(new int[][]{{60,50},{30,70},{60,30},{80,40}}));
//        System.out.println(solution(12));
        System.out.println(solution(3,20,4));
    }

    public static long solution(int price, int money, int count) {
        long pricefull =0;
        for(int i=1;i<=count;i++) {
            pricefull += (i * price);
        }
        return money >= pricefull ? 0 : pricefull - money;
    }

    public static int solution11(int n) {
        for(int i=1;i<=n;i++) {
            if(n%i == 1) return i;
        }
        return n-1;
    }


    public static int solution10(int[][] sizes) {
        int n = sizes.length;;
        for(int i=0;i<n;i++) {
            Arrays.sort(sizes[i]);
            System.out.println(Arrays.toString(sizes[i]));
        }
        Arrays.sort(sizes, (a,b) -> {return b[0] - a[0];});
        int maxLeft = sizes[0][0];
        System.out.println(maxLeft);
        Arrays.sort(sizes, (a,b) -> {return b[1] - a[1];});
        int maxRight = sizes[0][1];
        System.out.println(maxRight);

        return maxLeft * maxRight;
    }

    public static int solution9(int n) {
        long oper = 1;
        long res = 0;
        while(n > 0) {
//            System.out.println(res +" "+n+" "+ oper);
            res += (n%3) * oper;
            n/=3;
            oper *= 10;
        }
        StringBuilder sb = new StringBuilder(res+"");
//        System.out.println(sb);
        int ans = 0;
        for(int i=0;i<sb.length();i++) {
            ans += (Character.getNumericValue(sb.charAt(i)) * (Math.pow(3,i)));
//            System.out.println((Character.getNumericValue(sb.charAt(i)) * (Math.pow(3,i))));
        }
        return ans;
    }

    public static int solution8(int left, int right) {
        int answer = 0;

        for(int i=left;i<=right;i++) {
            int cnt = 0;
            for(int j=1;j<=Math.sqrt(i);j++) {
                if(i%j == 0) {
                    if(j*j == i) cnt++;
                    else cnt +=2;
                }
            }
            System.out.println(i +" "+ cnt+" "+ answer);
            if(cnt%2 == 0) answer += i;
            else answer -= i;

        }
        return answer;
    }

    public static int solution7(int[] a, int[] b) {
        int sum = 0;
        int n= a.length;
        for(int i=0;i<n;i++) {
            sum += (a[i] * b[i]);
        }
        return sum;
    }

    public static int solution6(int[] absolutes, boolean[] signs) {
        int n =absolutes.length;
        long sum = 0;
        for(int i=0;i<n;i++) {
            if(signs[i]) sum += absolutes[i];
            else sum -= absolutes[i];
        }

        return (int)sum;
    }

    public static int solution5(int[] numbers) {
        Arrays.sort(numbers);
        int sum = 0;
        int left = 0;
        for(int i=1;i<=9;i++) {
            while(left < numbers.length && numbers[left] < i) left++;
            if((left < numbers.length && numbers[left] > i) || left >= numbers.length) {
                sum += i;
            }
        }
        return sum;
    }

    public static int solution4(String s) {
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        s = s.replaceAll("zero", "0");
        System.out.println(s);
        int answer = 0;
        return answer;
    }

    public static String solution3(String new_id) {
        // 아이디 = 3자이상 15자 이하
        // 알파벳 소문자, 숫자, -, _, . 만 사용가능
        // .는 처음과 끝에 사용불가, 연속사용 불가

        //1. 소문자 치환
        String str = new_id.toLowerCase();
        System.out.println("소문자 치환 :: " + str);

        //2. 조건 문자 제외 모두 제거
        str = str.replaceAll("[^a-z0-9\\-_.]", "");
        System.out.println("조건문자제거 :: " + str);

        //3. . 두개이상 연속 -> 1개
        StringBuilder st = new StringBuilder(str);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<st.length();i++) {
            if(st.charAt(i) == '.') {
                if((i+1 < st.length() && st.charAt(i+1) != '.') || i+1 == st.length()) while(!stack.isEmpty()) {
                    int c = stack.pop();
                    st.deleteCharAt(c);
                    i--;
                } else {
                    stack.add(i);
                }
            }
        }
        System.out.println("연속. 제거 :: " + st);

        //4. .가 처음이나 끝이면 제거
        while(st.length() > 0 && st.charAt(0) == '.') st.deleteCharAt(0);
        while(st.length() > 0 && st.charAt(st.length()-1) == '.') st.deleteCharAt(st.length()-1);
        System.out.println("처음끝. 제거 :: " + st);

        //5. 빈문자열이면 a삽입
        if(st.length() == 0) st.append('a');
        System.out.println("빈문자열 처리 :: " + st);

        //6. 16자 이상이면 15자 제외 모두 제거
        if(st.length() >= 16) {
            st.delete(15,st.length());
        }
        System.out.println("16자이상 제거 :: " + st);

        while(st.length() > 0 && st.charAt(0) == '.') st.deleteCharAt(0);
        while(st.length() > 0 && st.charAt(st.length()-1) == '.') st.deleteCharAt(st.length()-1);
        System.out.println("처음끝. 제거 :: " + st);

        //7. 길이 2자 이하라면 마지막문자를 길이가 3이 될때까지 반복해서 붙임
        if(st.length() <= 2) {
            char c = st.charAt(st.length() - 1);
            while (st.length() < 3) st.append(c);
        }

        return st.toString();
    }

    public static int[] solution2(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int left = 0, right = 0;
        int max = 0, min = 0;
        int n = lottos.length;
        while(left < n && right < n) {
            int lot = lottos[left];
            int win = win_nums[right];

            if(lot == win) {
                max++;
                min++;
                left++;
                right++;
            } else if(lot == 0) {
                max++;
                left++;
            } else {
                if(lot < win) {
                    left++;
                } else {
                    right++;
                }
            }
        }

//        System.out.println(Arrays.toString(lottos));
//        System.out.println(Arrays.toString(win_nums));
//        System.out.println("TEST :: " + max +" " + min);
        return new int[]{7-max >= 6 ? 6 : 7-max, 7-min >= 6 ? 6 : 7-min};
    }
}
