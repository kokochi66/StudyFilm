import java.util.Arrays;

public class QuickSort_Pr {
    public static int[] Sortion(int[] numbers, int low, int high){
        int pivotPoint;
        if(high>low){
            pivotPoint = Partion(numbers, low, high);
            Sortion(numbers,low,pivotPoint-1);
            Sortion(numbers,pivotPoint+1,high);
        }
        return numbers;
    }
    public static int Partion(int[] numbers, int low, int high){
        int pivot = numbers[low];
        int j = low;
        for(int i=low+1;i<=high;i++){
            if(numbers[i]<pivot) {
                j++;
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
        int pivotPoint = j;
        int temp = numbers[low];
        numbers[low] = numbers[pivotPoint];
        numbers[pivotPoint] = temp;
        return pivotPoint;
    }
    public static void main(String[] args){
        int[] a = {15,22,13,27,12,10,20,25};
        int[] b = {6,2,3,4};
        System.out.println(Arrays.toString(Sortion(b, 0, b.length-1)));
    }
    
}
