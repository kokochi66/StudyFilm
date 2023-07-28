import java.util.*;
import java.io.*;

public class StackBKJ4 {
    public static void main(String[] args) throws Exception {
        Solution();
    }
    
    public static void Solution() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer[]> tower = new Stack<Integer[]>();
        String input = Read.readLine();
        
        while(!input.equals("0")){
            long max = 0;
            String[] tok = input.split(" ");

            for(int i=0;i<tok.length;i++){
                int tId = i;
                int n = Integer.parseInt(tok[i]);


                while(!tower.isEmpty() && n < tower.peek()[0]) {
                    long tempMax = (long)(i-tower.peek()[1]) *(long)tower.peek()[0];
                    max = max > tempMax ? max : tempMax;
                    tId = tower.peek()[1];
                    tower.pop();
                }

                tower.push(new Integer[]{n,tId});

                // if(tower.isEmpty() || (arr[i] > tower.peek()[0])) tower.push(new Integer[]{arr[i],i});
                // // tower 스택에 현재 타워의 높이 [0], 현재 타워의 번호 [1] 가 저장됨. => 현재 스택에 아무것도 없을 때
                // else if(arr[i] < tower.peek()[0]){
                //     // 스택 가장 끝 스택의 타워 높이보다 현재 타워 높이가 낮다면
                //     while(!tower.isEmpty() && arr[i] < tower.peek()[0]){
                //         // 현재 타워보다 높이가 높은 스택에 남아있는 타워들의 높이를 계산하며 반환
                //         int right = i, left = -1;
                //         Integer[] Curr = tower.pop();
                //         if(tower.isEmpty()) left = -1;
                //         else left = tower.peek()[1];
                //         // 현재 스택의 타워 높이보다 낮은 타워를 찾을 때까지 반복함
                //         long tempMax = (long)((long)(right-left-1)*(long)Curr[0]);
                //         // System.out.println("현재 left와 right 값 = "+left+" "+right+"     "+i+"   "+tempMax);
                //         if(max < tempMax) max = tempMax;
                //     }
                //     tower.push(new Integer[]{arr[i],i});
                // } else if(arr[i] == tower.peek()[0]) {
                //     tower.pop();
                //     tower.push(new Integer[]{arr[i],i});
                // }


            }

            while(!tower.isEmpty()){
                long tempMax = (long)(tok.length-tower.peek()[1]) *(long)tower.peek()[0];
                max = max > tempMax ? max : tempMax;
                tower.pop();
                //반복문을 전부 돌고 tower에 스택이 남아있을 때, (아직 최소높이처리 및 끝의 타워값이 측정이 안됨)
                    // int right = arr.length, left = -1;
                    // Integer[] Curr = tower.pop();
                    // if(tower.isEmpty()) left = -1;
                    // else left = tower.peek()[1];
                    // long tempMax = (long)((long)(right-left-1)*(long)Curr[0]);
                    // // System.out.println("현재 left와 right 값 = "+left+" "+right+"     "+Curr[1]+"   "+tempMax);
                    // if(max < tempMax) max = tempMax;
            }

            Write.write(max+"");
            Write.newLine();

            input = Read.readLine();
        }
        Write.flush();
        Write.close();
        Read.close();
    }
}

// 전혀 모르겠어서 내일 다시 풀어보는걸로
