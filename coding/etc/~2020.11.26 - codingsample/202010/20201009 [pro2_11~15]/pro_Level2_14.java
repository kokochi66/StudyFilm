import java.util.Arrays;

public class pro_Level2_14 {
    public static boolean compar(StringBuilder a, int b){   // true = (b<a) , false = (b>=a)
        StringBuilder TempB = new StringBuilder(b+"");
        StringBuilder Temp = new StringBuilder(a);
        Temp.append(TempB);
        TempB.append(a);
        System.out.println(Temp +"    "+ TempB);
        return Integer.parseInt(Temp.toString()) > Integer.parseInt(TempB.toString());
    }
    public static int Partion(int[] numbers, int low, int high){
        StringBuilder pivot = new StringBuilder(numbers[low]+"");
        int j = low;
        for(int i=low+1;i<=high;i++){
            if(compar(pivot,numbers[i])){   //pivot과 비교해 numbers[i]가 더 작다면
                j++;
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
        int PivotPoint = j;
        int temp = numbers[PivotPoint];
        numbers[PivotPoint] = numbers[low];
        numbers[low] = temp;
        return PivotPoint;
    }

    public static int[] Sortion(int[] numbers, int x, int y){
        int pivotPoint;
        if(x<y){
            pivotPoint = Partion(numbers,x,y);
            Sortion(numbers,x,pivotPoint-1);
            Sortion(numbers,pivotPoint+1,y);
        }
        return numbers;
    }
    public static String solution(int[] numbers) {
        StringBuilder temp = new StringBuilder();
        Sortion(numbers, 0, numbers.length-1);
        System.out.println(Arrays.toString(numbers));
        for(int i=numbers.length-1;i>=0;i--) {
            if(!(temp.toString().equals("0")&&numbers[i]==0)) temp.append(numbers[i]);
        }
        return temp.toString();
    }

    public static void main(String[] args){
        int[] a = {123,456,789,123};
        System.out.println(solution(a));
    }
}
