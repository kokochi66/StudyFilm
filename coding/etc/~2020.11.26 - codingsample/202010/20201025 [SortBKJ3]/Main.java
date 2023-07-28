import java.util.*;
import java.io.*;

public class Main {
    // 1. https://www.acmicpc.net/problem/10814 나이순 정렬
    // 2. https://www.acmicpc.net/problem/11651 좌표정렬하기 2
    // 3. https://www.acmicpc.net/problem/2583 영역 구하기
    
    public static void main(String[] args) throws Exception {
        // Solution();
    }

    public static void SorkBKJ3_1()  throws Exception{
        //최대 길이 N이 100,000이기 때문에, N*Log N 연산인 힙 정렬을 이용합니다.

        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        
        String[] name = new String[n];
        int[][] arr = new int[n][2];
        // 0값에는 나이, 1값에는 가입한 순서

        for(int i=0;i<n;i++){
            input = Read.readLine();
            String[] Token = input.split(" ");
            arr[i][0] = Integer.parseInt(Token[0]);
            name[i] = Token[1];
            arr[i][1] = i;
        }
        //입력 완료.

        // System.out.println(Arrays.toString(name));
        // for(int i=0;i<n;i++) System.out.println(Arrays.toString(arr[i]));

        int[] temp = new int[2];

        for(int i=1;i<arr.length;i++) {
            int c = i, root;
            do {
                root = (c-1)/2;
                if(arr[root][0] > arr[c][0] ||
                 ( arr[root][0] == arr[c][0] && arr[root][1] > arr[c][1])){
                    temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                 }
                 c = root;
            } while(c!=0);
        }

        for(int i=arr.length-1;i>=0;i--){
            Write.write(arr[0][0]+" "+name[arr[0][1]]);
            Write.newLine();
            arr[0] = arr[i];
            int c = 0, next;
            do {
                next = (c*2)+1;
                if(next+1 < i && (
                    arr[next][0] > arr[next+1][0] || (
                        arr[next][0] == arr[next+1][0] &&
                        arr[next][1] > arr[next+1][1]
                    ))) {
                        next++;
                }
                if(next < i && (
                    arr[c][0] > arr[next][0] || (
                        arr[c][0] == arr[next][0] &&
                        arr[c][1] > arr[next][1]
                    ))) {
                        temp = arr[c];
                        arr[c] = arr[next];
                        arr[next] = temp;
                }
                c = next;
            } while(c<i);
        }

        Write.flush();
        Write.close();
        Read.close();

    }
    public static void SorkBKJ3_2()  throws Exception{
        //최대 길이 N이 100,000이기 때문에, N*Log N 연산인 힙 정렬을 이용합니다.

        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        int n = Integer.parseInt(input);
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            input = Read.readLine();
            String[] Token = input.split(" ");
            arr[i][0] = Integer.parseInt(Token[0]);
            arr[i][1] = Integer.parseInt(Token[1]);
        }

        int[] temp = new int[2];
        for(int i=1;i<arr.length;i++){
            int c = i, root;
            do {
                root = (c-1)/2;
                if(arr[c][1] < arr[root][1] || (
                    arr[c][1] == arr[root][1] && arr[c][0] < arr[root][0]
                )){
                    temp = arr[c];
                    arr[c] = arr[root];
                    arr[root] = temp;
                }
                c = root;
            } while(c!=0);
        }
        for(int i=arr.length-1;i>=0;i--){
            Write.write(arr[0][0]+" "+arr[0][1]);
            Write.newLine();
            arr[0] = arr[i];
            int c =0, next;
            do {
                next = (c*2)+1;
                if(next+1<i && (
                    arr[next][1] > arr[next+1][1] || (
                        arr[next][1] == arr[next+1][1] && arr[next][0] > arr[next+1][0]
                    )
                )) {
                    next++;
                }

                if(next<i && (
                    arr[c][1] > arr[next][1] || (
                        arr[c][1] == arr[next][1] && arr[c][0] > arr[next][0]
                    )
                )) {
                    temp = arr[c];
                    arr[c] = arr[next];
                    arr[next] = temp;
                }
                c = next;
            } while(c<i);
        }
        // for(int i=0;i<n;i++) System.out.println(Arrays.toString(arr[i]));
        Write.flush();
        Write.close();
        Read.close();

    }
    public static void SorkBKJ3_3()  throws Exception{
        //최대 길이 N이 100,000이기 때문에, N*Log N 연산인 힙 정렬을 이용합니다.

        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = Read.readLine();
        String[] Token = input.split(" ");
        int w = Integer.parseInt(Token[1]), h = Integer.parseInt(Token[0]);
        int n = Integer.parseInt(Token[2]);
        int[][] Sqaure = new int[h][w];
        for(int i=0;i<n;i++){
            input = Read.readLine();
            Token = input.split(" ");
            int[] miniWorld = new int[4];
            for(int j=0;j<4;j++) miniWorld[j] = Integer.parseInt(Token[j]);
            int SwitX=miniWorld[0], SwitY=miniWorld[1];
            while(SwitX<miniWorld[2] && SwitY<miniWorld[3]){
                Sqaure[SwitY][SwitX] = -1;
                SwitX++;
                if(SwitX>=miniWorld[2]) {
                    SwitX=miniWorld[0];
                    SwitY++;
                }

            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<Sqaure.length;i++){
            for(int j=0;j<Sqaure[0].length;j++){
                if(Sqaure[i][j] != -1) {
                    list.add(SortBKJ3_3_Solution(Sqaure,j,i));
                }
            }
        }
        int temp;
        for(int i=1;i<list.size();i++){
            int j=i;
            while(j>0 && list.get(j) < list.get(j-1)){
                temp = list.get(j);
                list.set(j, list.get(j-1));
                list.set(j-1, temp);
                j--;
            }
        }

        Write.write(list.size()+"");
        Write.newLine();
        for(int i=0;i<list.size();i++){
            Write.write(list.get(i)+" ");
        }
        Write.flush();
        Write.close();
        Read.close();

    }
    public static int SortBKJ3_3_Solution(int[][] arr, int x, int y) throws Exception {
        if(x<0 || y<0 || y>=arr.length || x>=arr[0].length || arr[y][x] == -1) return 0;
        int sum = 1;
        arr[y][x] = -1;
        sum += SortBKJ3_3_Solution(arr,x+1,y);
        sum += SortBKJ3_3_Solution(arr,x,y+1);
        sum += SortBKJ3_3_Solution(arr,x-1,y);
        sum += SortBKJ3_3_Solution(arr,x,y-1);
        return sum;
    }


}

