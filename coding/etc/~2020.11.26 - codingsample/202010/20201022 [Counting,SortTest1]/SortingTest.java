import java.util.Arrays;

public class SortingTest {
    //선택정렬, 버블정렬, 삽입정렬, 퀵정렬, 힙정렬, 합병정렬, 계수정렬
    // 5:48 시작, 종료시간 6:31
    // 힙정렬 재정리 필요할듯
    public static void main(String[] args){
        int[] a = {1,3,2,4,3,2,5,3,1,2,3,4,4,3,5,1,2,3,5,2,3,1,4,3,5,1,2,1,1,1};
        int[] b = {5,3,1,2,4};
        CountingS(a,5);
        System.out.println(Arrays.toString(a));
    }
    public static void SelectionS(int[] arr){
        int min, minS, temp;
        for(int i=0;i<arr.length-1;i++){
            min = arr[i];
            minS = i;
            for(int j=i;j<arr.length;j++){
                if(min>arr[j]) {
                    min = arr[j];
                    minS = j;
                }
            }
            temp = arr[i];
            arr[i] = min;
            arr[minS] = temp;
        }
    }
    public static void BubbleS(int[] arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void InsertionS(int[] arr){
        int temp;
        for(int i=1;i<arr.length;i++){
            int j = i;
            while(j>0 && arr[j]<arr[j-1]){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    public static void QuickS(int[] arr, int start, int end){
        if(start>=end) return;
        int pivot = arr[start];
        int i = start+1;
        int j = end, temp;
        while(i<=j){
            while(i<=end && arr[i]<=pivot) i++;
            while(j>start && arr[j]>pivot) j--;
            if(i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        QuickS(arr, start, j-1);
        QuickS(arr, j+1, end);
    }
    public static void HeapS(int[] arr){
        int temp;
        for(int i=1;i<arr.length;i++){
            int c = i;
            do {
                int root = (c-1)/2;
                if(arr[root]<arr[c]){
                    temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                }
                c = root;
            } while(c!=0);
        }
        for(int i=arr.length-1;i>=0;i--){
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            int c, root = 0;
            do {
                c = (root*2)+1;
                if(c+1<i && arr[c+1] > arr[c]) c++;
                if(c<i && arr[c] > arr[root]){
                    temp = arr[c];
                    arr[c] = arr[root]; 
                    arr[root] = temp;
                }
                root = c;
            } while(c<i);
        }
    }
    public static void Merge(int[] arr, int start, int middle, int end){
        int[] sorted = new int[end-start+1];
        int i = start, k = 0, j = middle+1;
        while(i<=middle && j<=end){
            if(arr[i]<arr[j]) sorted[k] = arr[i++];
            else sorted[k] = arr[j++];
            k++;
        }
        if(i>middle){
            for(int var1=j;var1<=end;var1++) sorted[k++] = arr[var1];
        } else {
            for(int var1=i;var1<=middle;var1++) sorted[k++] = arr[var1];
        }
        k = start;
        for(int var1=0;var1<sorted.length;var1++) arr[k++] = sorted[var1];
    }
    public static void MergeS(int[] arr, int start, int end){
        if(start<end){
            int middle = (start+end)/2;
            MergeS(arr,start,middle);
            MergeS(arr,middle+1,end);
            Merge(arr,start,middle,end);
        }
    }
    public static void CountingS(int[] arr, int max){
        int[] sorted = new int[max];
        for(int i=0;i<max;i++) sorted[i] = 0; 
        for(int i=0;i<arr.length;i++) {
            sorted[arr[i]-1]++;
        }
        int k = 0;
        for(int i=0;i<max;i++){
            for(int j=0;j<sorted[i];j++) {
                arr[k++] = i+1;
            }
        }
    }
}
