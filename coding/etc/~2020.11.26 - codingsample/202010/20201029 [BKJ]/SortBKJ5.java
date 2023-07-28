import java.util.*;

import java.io.*;
public class SortBKJ5 {
    public static void main(String[] args) throws Exception  {
        // Solution();
    }

    public static void SortBKJ5_1() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[] arr = new int[n];
        int[][] freq = new int[2][2];
        boolean Second = false;

        int sum = 0;
        for(int i = 0; i<n;i++){
            input = Read.readLine();
            arr[i] = Integer.parseInt(input);
            sum += arr[i];
        }
        Write.write(Math.round((double)sum/(double)n)+"");
        Write.newLine();

        int temp;
        for(int i=1;i<arr.length;i++){
            int c=i, root;
            do{
                root = (c-1)/2;
                if(arr[root] > arr[c]){
                    temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                }
                c = root;
            } while(c!=0);
        }
        freq[0][0] = arr[0];
        freq[0][1] = 1;
        freq[1][0] = 40001;
        int min = arr[0];
        int max = 0;

        for(int i=arr.length-1;i>=0;i--){
            if(i == n/2) {
                Write.write(arr[0]+"");
                Write.newLine();
            }
            // 중앙값 출력

            // System.out.println(Arrays.toString(freq[0]) +"   현재 최빈값  "+arr[0]);
            // System.out.println(Arrays.toString(freq[1]) +"   비교중인 최빈값  ");
            if(i != arr.length-1 && arr[0] == freq[0][0]){
                freq[0][1]++;
                if(Second) Second = false;
                // 최빈값1) 현재  최빈값과 같은 값이 들어오면 빈도 1 추가
            } else if(arr[0] != freq[0][0]) {
                // 최빈값2) 현재 최빈값과 다른 값이 들어오면
                if(freq[1][0] == arr[0]) freq[1][1]++;
                // 2-1) 비교계산중인 값과 같은 값이 들어오면 빈도 1 추가
                else if(freq[1][0] != arr[i]) {
                    freq[1][0] = arr[0];
                    freq[1][1] = 1;
                    // 2-1-2) 비교계산중인 값과 다르면, 비교계산중인값 변경
                }
                if(freq[1][1] > freq[0][1]) {
                    freq[0][0] = freq[1][0];
                    freq[0][1] = freq[1][1];
                    freq[1][0] = 40001;
                    if(Second) Second = false;
                    // 2-2) 비교계산중인 값의 빈도가 현재 최빈값보다 높아지면 현재 최빈값 업데이트
                    // 여기서 이전의 최빈값으로 지정된 값이 Second로 지정되었던 값이면 Second 업데이트
                } else if(freq[1][1] == freq[0][1] && !Second){
                    freq[0][0] = freq[1][0];
                    freq[0][1] = freq[1][1];
                    freq[1][0] = 4001;
                    Second = true;
                    // 2-3) 비교계산중인 값의 빈도가 현재 최빈값과 같으며, 두번째 값이라면 SECOND=true,후 업데이트
                }
            }

            if(i == 0) max = arr[0];
            //최댓값 저장

            arr[0] = arr[i];
            int c = 0, next;
            do {
                next = (c*2)+1;
                if(next+1<i && arr[next] > arr[next+1]){
                    next++;
                }

                if(next<i && arr[next] < arr[c]){
                    temp = arr[next];
                    arr[next] = arr[c];
                    arr[c] = temp;
                }
                c = next;
            } while(c<i);
        }

        Write.write(freq[0][0]+"");
        Write.newLine();
        Write.write((max-min)+"");
        Write.newLine();
        Write.flush();
        Write.close();
        Read.close();
    }
    public static void SortBKJ5_2() throws Exception {
        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        String[] tok = input.split(" ");

        HashMap<String,Integer> bCount = new HashMap<String,Integer>();
        ArrayList<StringBuilder> bdList = new ArrayList<StringBuilder>();

        int d = Integer.parseInt(tok[0]);
        int b = Integer.parseInt(tok[1]);
        for(int i=0;i<d;i++){
            input = Read.readLine();
            if(bCount.containsKey(input)){
                bCount.put(input, bCount.get(input)+1);
            } else bCount.put(input, 1);
        }

        for(int j=0;j<b;j++){
            input = Read.readLine();
            if(bCount.containsKey(input) && bCount.get(input)>0) {
                bCount.put(input, bCount.get(input)-1);
                StringBuilder temp = new StringBuilder(input);
                bdList.add(temp);
                int c = bdList.size()-1;
                int root;
                do {
                    root = (c-1)/2;
                    if(bdList.get(root).compareTo(bdList.get(c))>0){
                        bdList.set(c,bdList.get(root));
                        bdList.set(root,temp);
                    }
                    c = root;
                } while(c!=0);
            }
        }
        
        Write.write(bdList.size()+"");
        Write.newLine();
        while(!bdList.isEmpty()){
            bdList.get(0);
            Write.write(bdList.get(0).toString());
            Write.newLine();

            bdList.set(0, bdList.get(bdList.size()-1));
            bdList.remove(bdList.size()-1);
            int c = 0, next;
            if(!bdList.isEmpty()){
                StringBuilder temp = new StringBuilder(bdList.get(0));
            do {
                next = (c*2)+1;
                if(next+1<bdList.size() && bdList.get(next).compareTo(bdList.get(next+1))>0) next++;
                if(next<bdList.size() && bdList.get(c).compareTo(bdList.get(next))>0) {
                    bdList.set(c,bdList.get(next));
                    bdList.set(next,temp);
                }
                c = next;
            } while(c<bdList.size());
            }
        }

        Write.flush();
        Write.close();
        Read.close();
    }

}
