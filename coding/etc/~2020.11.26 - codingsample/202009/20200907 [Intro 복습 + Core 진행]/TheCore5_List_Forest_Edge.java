import java.util.Arrays;
import java.util.stream.IntStream;

public class TheCore5_List_Forest_Edge {
    private static int[] createArray(int size) {
        int[] output = new int[size];
        Arrays.fill(output, 1);
        return output;
    }
    //입력 size만큼의 int배열을 모두 1로 채워서 출력
    private static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for(int i=0;i<inputArray.length;i++) if(inputArray[i]==elemToReplace) inputArray[i] = substitutionElem;
        return inputArray;
    }
    //inputArray배열의 elemToReplace를 모두 substitutionElem으로 바꿔 출력
    private static int[] firstReverseTry(int[] arr) {
        if(arr.length==0) return arr;
            int temp = 0;
            temp = arr[0];
            arr[0] = arr[arr.length-1];
            arr[arr.length-1] = temp;
        return arr;
    }
    //배열의 첫번째값과 마지막값을 스왑하여 출력    
    private static int[] concatenateArrays(int[] a, int[] b) {
        // int[] output = new int[a.length+b.length];
        // for(int i=0;i<a.length;i++) output[i] = a[i];
        // for(int i=0;i<b.length;i++) output[a.length+i] = b[i];
        // return output;
        // 내 정답은 좀 구리다.
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
    }
    //두 배열을 합친 배열을 출력
    private static int[] removeArrayPart(int[] inputArray, int l, int r){
        return IntStream.range(0, inputArray.length).map(i->inputArray[i]).filter(i->!(i>=l&&i<=r)).toArray();
    }
    //입력 배열의 l부터 r까지의 값을 뺀 배열을 출력
    private static boolean isSmooth(int[] arr) {
        if(arr.length<=2) {
            if(arr.length==2){
                return arr[0]==arr[1] ? arr[0]==0 : false;
            }
            return arr.length<=1;
        }
        int mid;
        if(arr.length%2==0) mid = arr[arr.length/2] + arr[(arr.length/2)-1];
        else mid = arr[arr.length/2];
        return arr[0] == arr[arr.length-1] ? arr[0] == mid : false;
    }
    // 첫번째요소와 마지막요소와 중간요소가 모두 같은값이면 true출력
    private static int[] replaceMiddle(int[] arr) {
        if(arr.length<=1 || arr.length%2==1) return arr;
        int[] output = new int[arr.length-1];
        int outNum = 0;
        for(int i=0;i<arr.length;i++){
            if(!(i>=(arr.length/2)-1 && i<=(arr.length/2))) output[outNum++] = arr[i];
            else {
                output[outNum++] = arr[(arr.length/2)-1] + arr[arr.length/2];
                i++;
            }
        }
        return output;
    }
    // 배열이 짝수라면 중간요소를 합쳐서 홀수 배열로 만들어 출력
    private static int makeArrayConsecutive2(int[] statues) {
        return IntStream.range(0,statues.length).map(i->statues[i]).max().getAsInt() - IntStream.range(0,statues.length).map(i->statues[i]).min().getAsInt() - statues.length + 1;
    }
    //배열에 존재하는 수가 정확하게 1씩 증가하는 수들로 모이는데 필요한 수를 출력    
    public static void main(String[] args){
        int[] a = {1,2,1};
        int[] b = {1,2,3,4,5};
        int[] c = {3,5,3,3};
        System.out.println(Arrays.toString(createArray(4)));
        System.out.println(Arrays.toString(arrayReplace(a,1,3)));
        System.out.println(Arrays.toString(firstReverseTry(b)));
        System.out.println(Arrays.toString(concatenateArrays(a,b)));
        System.out.println(Arrays.toString(removeArrayPart(b,2,3)));
        System.out.println(isSmooth(c));
        System.out.println(Arrays.toString(replaceMiddle(c)));
        System.out.println(makeArrayConsecutive2(b));
    }
}
