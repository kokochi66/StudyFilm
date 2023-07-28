import java.math.BigInteger;
import java.util.Arrays;

public class ALG_MT2 {
    
    // 알고리즘 2장 분할정복
    public static void main(String[] args){
        // int[] a = {1,6,8,5,3,6,3,2,3,4,7,8};
        // Num2_QuickSort(a,0,a.length-1);
        // System.out.println(Arrays.toString(a));
        // int[] Ba = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        // int[] Bb = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        // int[] Bc = Num3_Big_Integer_add(Ba,Bb);
        // System.out.println(Arrays.toString(Bc));
        System.out.println(Num4_Big_Integer_prod(100000000,500));
    }   

    public static int[][] Num5_Strasen_Matrix(int[][] a, int[][] b){
        int[][] c = new int[a.length][a[0].length];

        return c;
    }
    public static long Num4_Big_Integer_prod(long a, long b){
        String aa = a+"";
        String bb = b+"";
        int n = (int) Math.max(aa.length(),bb.length());
        if(a==0 || b==0) return 0;
        else if((long)(a*b) == (int)(a*b)) return a*b;
        else {
            int m = n/2;
            int x = (int)a/((int)Math.pow(10, m));
            int y = (int)a%((int)Math.pow(10, m));
            int w = (int)b/((int)Math.pow(10, m));
            int z = (int)b%((int)Math.pow(10, m));
            System.out.println(x);
            System.out.println(y);
            System.out.println(w);
            System.out.println(z);
            return (long)((Num4_Big_Integer_prod(x,w)*(long)Math.pow(10, 2*m)) + 
            ((Num4_Big_Integer_prod(x,z)+Num4_Big_Integer_prod(w,y))*(long)Math.pow(10,m)) +
            Num4_Big_Integer_prod(y,z));
        }
        // W(n) = S(n^2);
    }
    public static int[] Num3_Big_Integer_add(int[] inA, int[] inB){
        int carry = 0;
        int[] result = new int[Math.max(inA.length,inB.length)+1];
        for(int i=result.length-1;i>=0;i--){
            int CurrA=0, CurrB=0;
            if(i<inA.length) CurrA = inA[i];
            if(i<inB.length) CurrB = inB[i];
            int sum = CurrA+CurrB+carry;
            if(sum>9) {
                sum -= 10;
                carry = 1;
            }
            else carry = 0;
            result[i] = sum;
        }
        return result;
    }
    public static void Num2_QuickSort(int[] arr, int low, int high){
        if(low>=high) return;
        int pivot = arr[low];
        int i=low+1, j = high, temp;
        while(i<=j){
            while(i<=high && pivot >= arr[i]) i++;
            while(j>low && pivot < arr[j]) j--;
            if(i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        Num2_QuickSort(arr,low,j-1);
        Num2_QuickSort(arr,j+1,high);
        // W(n) = O(n^2) , A(n) = S(N*Log n), B(n) n-1, T(n) = O(n^2)
    }
    public static void Num1_Merge(int[] arr, int low, int mid, int high){
        int i=low, j= mid+1, k=0;
        int[] sorted = new int[high-low+1];
        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                sorted[k++] = arr[i++];
            } else sorted[k++] = arr[j++];
        }
        while(i<=mid) sorted[k++] = arr[i++];
        while(j<=high) sorted[k++] = arr[j++];
        k = low;
        for(int q=0;q<sorted.length;q++) arr[k++] = sorted[q];
        // - 병합정렬의 병합단계
        // W(n) = S(N), B(n) = S(n) , T(n)= S(n)
    }
    public static void Num1_MergeSort(int[] arr, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            Num1_MergeSort(arr, low, mid);
            Num1_MergeSort(arr, mid+1, high);
            Num1_Merge(arr, low, mid, high);
        }
        // 1. 병합정렬의 분할단계
        // W(n) = S(Log N), B(n) = S(Log N), T(n) = S(Log N)
        // 병합단계와 합치면 T(N) = S(N*Log N)
        // 메모리의 경우 새로운 배열을 계속 생성하면 2n, 있는거에서 쓰면 n
    }
}
