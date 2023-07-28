import java.util.Arrays;

public class SortingTest2 {
    //선택정렬, 버블정렬, 삽입정렬, 퀵정렬, 힙정렬, 합병정렬, 계수정렬
    // 3:45 시작 ~ 4:10
    // 25분컷 완료

    public static void main(String[] args){
        int[] a = {1,3,2,4,3,2,5,3,1,2,3,4,4,3,5,1,2,3,5,2,3,1,4,3,5,1,2,1,1,1};
        CountingS(a,5);
        System.out.println(Arrays.toString(a));
    }

    public static void SelectionS(int[] arr){
        int min, minS;
        for(int i=0;i<arr.length-1;i++){
            min = arr[i];
            minS = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<min) {
                    minS = j;
                    min = arr[minS];
                }
            }
            arr[minS] = arr[i];
            arr[i] = min;
        }
    }
    public static void BubbleS(int[] arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
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
        int pivot = arr[start], i = start+1, j = end, temp;

        while(i<=j){
            while(i<=end && arr[i]<=pivot) i++;
            while(j>start && arr[j]>=pivot) j--;
            if(i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[j];
        arr[j] = pivot;
        arr[start] = temp;
        QuickS(arr,start,j-1);
        QuickS(arr,j+1,end);
    }
    public static void HeapS(int[] arr){
        int temp;
        for(int i=1;i<arr.length;i++){
            int c = i;
            do {
                int root = (c-1)/2;
                if(arr[c]>arr[root]){
                    temp = arr[c];
                    arr[c] = arr[root];
                    arr[root] = temp;
                }
                c= root;
            } while(c!=0);
        }
        for(int i=arr.length-1;i>=0;i--){
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            int c = 0, next;
            do {
                next = (c*2)+1;
                if(next+1<i && arr[next+1]>arr[next]) next++;
                if(next<i && arr[next]>arr[c]){
                    temp = arr[next];
                    arr[next] = arr[c];
                    arr[c] = temp;
                }
                c = next;
            } while(c<i);
        }
    }
    public static void Merge(int[] arr, int start, int middle, int end){
        int[] sorted = new int[end-start+1];
        int i = start, j = middle+1, k = 0;
        while( i<= middle && j <= end){
            if(arr[i]<arr[j]) sorted[k++] = arr[i++];
            else sorted[k++] = arr[j++];
        }
        while(i<=middle) sorted[k++] = arr[i++];
        while(j<=end) sorted[k++] = arr[j++];
        k = start;
        for(int temp=0;temp<sorted.length;temp++) arr[k++] = sorted[temp];
    }
    public static void MergeS(int[] arr, int start, int end){
        if(start<end){
            int middle= (start+end)/2;
            MergeS(arr,start,middle);
            MergeS(arr,middle+1,end);
            Merge(arr,start,middle,end);
        }
    }
    public static void CountingS(int[] arr, int max){
        int[] maxTemp = new int[max];
        for(int i=0;i<max;i++) maxTemp[i] = 0;
        for(int i=0;i<arr.length;i++) maxTemp[arr[i]-1]++;
        int k = 0;
        for(int i=0;i<max;i++) {
            for(int j=0;j<maxTemp[i];j++) arr[k++] = i+1;
        }
    }
}
