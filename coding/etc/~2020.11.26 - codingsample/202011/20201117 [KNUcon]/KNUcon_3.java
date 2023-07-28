import java.util.*;
import java.io.*;
import java.security.DrbgParameters.Reseed;

public class KNUcon_3 {
    public static void main(String[] args) throws Exception {
        int[] a1 = {9, 4, 4,10, 7};
        int[] b1 = {2, 7, 6,4, 3};

        int[] a2 = {6, 3, 4, 9, 2, 7, 5};
        int[] b2 = {4, 2, 8, 2, 1, 10, 3};

        int[] a3 = {1,5,9,9};
        int[] b3 = {2,8,10,2};
        System.out.println(Arrays.toString(solution(10,a3,b3)));
    }
    public static int[] solution(int n, int[] t1, int[] t2) {
        HashSet<Integer> RS = new HashSet<>();
        int tc = 1, m = t1.length;
        int cc = 0;
        for(int i=1;i<=n;i++) RS.add(i);
        // 10만

        int[] oper = new int[n+1];
        ArrayList<ArrayList<Integer>> opl = new ArrayList<ArrayList<Integer>>();
        opl.add(new ArrayList<Integer>());
        for(int i=0;i<m;i++){
            RS.remove(t1[i]);
            RS.remove(t2[i]);
            if(oper[t1[i]] != 0 || oper[t2[i]] != 0){
                if(oper[t1[i]]==0 && oper[t2[i]]!=0) {
                    oper[t1[i]] = oper[t2[i]];
                    opl.get(oper[t2[i]]).add(t1[i]);
                }
                else if(oper[t2[i]]==0 && oper[t1[i]]!=0) {
                    oper[t2[i]] = oper[t1[i]];
                    opl.get(oper[t1[i]]).add(t2[i]);
                } else if(oper[t2[i]]!=0 && oper[t1[i]]!=0) {
                    
                }
            } else {
                oper[t1[i]] = tc;
                oper[t2[i]] = tc;
                opl.add(new ArrayList<Integer>());
                opl.get(tc).add(t1[i]);
                opl.get(tc).add(t2[i]);
                tc++;
            }
        }
        // 1000만

        for(int i=0;i<opl.size();i++){
            System.out.println(i+" :::  ");
            for(int j=0;j<opl.get(i).size();j++){
                System.out.print(opl.get(i).get(j)+" ");
            }
            System.out.println();
        }

        int temp;
        int[] arr = new int[RS.size()+(tc-1)-cc];
        int arn = 0;
        for(int i=1;i<opl.size();i++){
            if(opl.get(i).size()!=0){
                int half = (opl.get(i).size())/2;
                if(opl.get(i).size()%2==1) half++;
                Collections.sort(opl.get(i));
                arr[arn++] = opl.get(i).get(half-1);
            }
        }
        // System.out.println(Arrays.toString(arr));
        Iterator<Integer> it = RS.iterator();
        while(it.hasNext()) {
            int c = it.next();
            arr[arn++] = c;
        }
        Arrays.sort(arr);

        return arr;
    }
}
