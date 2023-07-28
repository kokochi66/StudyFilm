import java.util.*;
import java.io.*;

public class KNU_week7_1 {
    static List<Integer> num; // 집합의 원소들을 저장하기 위한 리스트
	static List<Integer> subset; // 부분 집합을 저장하기 위한 배열
	

	public static void solve(int num_idx, int subset_idx, int subset_size) {
        if(subset_size == subset_idx) {
            System.out.print("{ ");
            for(int i=0;i<subset.size();i++) System.out.print(subset.get(i)+" ");
            System.out.println("}");
            return;
        }
        for(int i=num_idx;i<num.size();i++){
            subset.add(num.get(i));
            subset_idx++;
            solve(i+1, subset_idx, subset_size);
            subset.remove(subset.size()-1);
            subset_idx--;
        }
	}

	public static void main(String[] args)throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));

        num = new LinkedList<>();
        subset = new LinkedList<>();
        
        /* 필요한 코드를 추가하시오 */
        String input = Read.readLine();
        String[] tok = input.split(" ");
        for(int i=0;i<tok.length;i++) num.add(Integer.parseInt(tok[i]));
		for (int i = 0; i <= num.size(); i++) {
			solve(0, 0, i);
		}

        /* 필요한 코드를 추가하시오 */
        Write.flush();
        Write.close();
        Read.close();
	}
}
