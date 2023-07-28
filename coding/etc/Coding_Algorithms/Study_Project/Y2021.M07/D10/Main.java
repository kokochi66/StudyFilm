package D10;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		System.out.println(solution(5, 12));
	}
    public static int solution(int N, int number) {
    	if(N == number) return 1;
        int answer = 0;
        
        HashSet<Integer>[] setArr = new HashSet[8];
        int cont_num = N, cont_digit = 10;
        for(int i=0;i<8;i++) {
        	setArr[i] = new HashSet<Integer>();
        	setArr[i].add(cont_num);
        	cont_num += cont_digit * N;
        	cont_digit *= 10;
        }
        
        for(int i=1;i<8;i++) {
        	for(int j=0;j<i;j++) {
        		
        		for(Integer op1 : setArr[j]) {
        			for(Integer op2 : setArr[i-j-1]) {
        				if(op1 + op2 > 0) setArr[i].add(op1 + op2);
        				if(op1 - op2 > 0) setArr[i].add(op1 - op2);
        				if(op1 * op2 > 0) setArr[i].add(op1 * op2);
        				if(op1 / op2 > 0) setArr[i].add(op1/op2);
        			}
        		}
        	}
        	if(setArr[i].contains(number)) {
        		answer = i+1;
        		break;
        	}
        	else answer = -1;
        }
        
        for(Integer a : setArr[2]) System.out.println(a);
        return answer;
    }
}