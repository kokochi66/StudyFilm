import java.util.Arrays;
import java.util.stream.IntStream;

public class Intro4_Exploring_the_Waters {
    private static int[] alternatingSums(int[] a) {
        return new int[] {IntStream.range(0, a.length).filter(i->i%2==1).map(i->a[i]).sum(),IntStream.range(0, a.length).filter(i->i%2==0).map(i->a[i]).sum()};
    }
    // 배열의 홀수값을 첫번째값, 짝스값을 두번째값으로 하는 배열을 출력
    private static String[] addBorder(String[] picture){
        String[] output = new String[picture.length+2];
        for(int i=0;i<picture.length;i++) output[i+1] = '*' + picture[i] + '*';
        output[0] = output[output.length-1] = output[1].replaceAll(".", "*");
        return output;
    }
    // 입력된 문자열 배열에 *테두리를 만들어서 출력
    private static boolean areSimilar(int[] a, int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {if (a[i] != b[i]) {sum++;}}
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b) && sum < 3;
    }
    // 배열 a와 b가 요소 1개를 제외하고 모두 같은지를 출력
    public static void main(String[] args){
        int[] a = {50,60,60,45,70};
        String[] b ={"abc", 
                    "ded"};
        int[] c = {1,2,3,4};
        int[] d = {2,3,4,5};
        System.out.println(Arrays.toString(alternatingSums(a)));
        System.out.println(Arrays.toString(addBorder(b)));
        System.out.println(areSimilar(c,d));
    }
}
