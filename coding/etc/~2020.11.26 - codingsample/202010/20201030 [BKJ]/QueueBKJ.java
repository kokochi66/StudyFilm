import java.io.*;
import java.util.*;

public class QueueBKJ {
    public static void main(String[] args) throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        // 테스트 케이스 개수 입력

        for(int Tcase=0;Tcase<n;Tcase++){
            Queue<Integer[]> que = new LinkedList<Integer[]>();
            StringTokenizer tok;
            tok = new StringTokenizer(Read.readLine());
            int AP = Integer.parseInt(tok.nextToken());
            int Point = Integer.parseInt(tok.nextToken());
            // 문서의 총 개수 AP와 목표값 Point 입력

            int[] arr = new int[AP];
            tok = new StringTokenizer(Read.readLine());
            for(int i=0;i<AP;i++){
                arr[i] = Integer.parseInt(tok.nextToken());
                que.add(new Integer[]{arr[i], i});
            }
            // 각 문서의 우선순위를 문서의 번호와 함께 Queue에 입력
            // 그리고 정렬이 필요한 우선순위값을 배열에 저장

            int temp;
            for(int i=1;i<arr.length;i++){
                int j=i;
                while(j>0 && arr[j] > arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
                }
            }
            // 선택정렬로 정렬

            int CSarr = 0;
            // 정렬한 배열의 현재 위치값을 설정

            while(!que.isEmpty()){
                Integer[] Curr = que.poll();
                if(Curr[0] == arr[CSarr]) {
                    CSarr++;
                    if(Curr[1] == Point) {
                        Write.write(CSarr+"");
                        Write.newLine();
                        break;
                    }
                    // 큐 맨앞 값이 우선순위가 가장 높은 값이라면 해당 값 반환
                    // 반환된 값이 Point라면 출력 후 break;
                }
                else {
                    // 우선순위가 가장 높은 값이 아니면 큐 맨뒤로 이동
                    que.add(Curr);
                }
            }
            

        }
        Write.flush();
        Write.close();
        Read.close();
    }

}
