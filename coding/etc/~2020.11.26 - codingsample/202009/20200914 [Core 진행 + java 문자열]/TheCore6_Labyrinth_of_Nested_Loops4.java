import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TheCore6_Labyrinth_of_Nested_Loops4 {
    private static int P2(String a, String b, String c, int switA, int switB, int switC){
        int count = 0;
        int min = Math.min(a.length()-switA-1,b.length()-switB-1);
        for(int i=2;i<=min;i++){
            for(int j=0;j<=c.length()-switC-1;j++){
                if(c.charAt(j) == a.charAt(switA+i) && c.charAt(j+switC) == b.charAt(switB+i)) {
                    count++;
                }
            }
        }
        return count;
    }
    private static int P1(String[] words, int Top, int Left, int Right, int Bottom) {
        int count = 0;
        int[] Lpound = new int[words[Top].length()];
        ArrayList<Integer> Lswit = new ArrayList<Integer>();
        int[] Rpound = new int[words[Top].length()];
        ArrayList<Integer> Rswit = new ArrayList<Integer>();
        Arrays.fill(Lpound,0);
        Arrays.fill(Rpound,0);
        for(int i=0;i<words[Top].length();i++){
            if(i<words[Top].length()-2) for(int j=0;j<words[Left].length()-2;j++) if(words[Top].charAt(i) == words[Left].charAt(j)) {
                Lpound[i]++;
                Lswit.add(j);
            }
            if(i>1) for(int j=0;j<words[Right].length()-2;j++) if(words[Top].charAt(i) == words[Right].charAt(j)) {
                Rpound[i]++;   
                Rswit.add(j);
            }
        }
        int swit1 = 0, swit2 = 0, swit3 = 0, var;
        for(int i=0;i<Lpound.length-2;i++){
            if(Lpound[i]>0) for(int j=i+2;j<Rpound.length;j++){
                if(Rpound[j]>0) {
                    var = 0;
                    swit1 = IntStream.range(0,i).map(q->Lpound[q]).sum();
                    swit2 = IntStream.range(0,j).map(q->Rpound[q]).sum();
                    swit3 = j-i;
                    for(int q=0;q<Lpound[i];q++){
                        for(int w=0;w<Rpound[j];w++){
                            count += P2(words[Left],words[Right],words[Bottom],Lswit.get(swit1+q),Rswit.get(swit2+w),swit3);
                        }
                    }
                }
            }
        }
        return count;
    }
    private static int crosswordFormation(String[] words) {
        int Top, Bottom, Left, Right;
        int temp, count = 0;
        for(Top=0;Top<4;Top++){       //q에 Top의 문자열을 지정해준다.
            for(int w=1;w<=2;w++) {
                for(int e=w+1;e<=3;e++){
                    Left = (Top+w)%4;
                    Right = (Top+e)%4;
                    Bottom = 6-(Left+Right+Top);
                    count += P1(words,Top,Left,Right,Bottom);
                    count += P1(words,Top,Right,Left,Bottom);
                }
            }
        }
       return count;
    }
    
    public static void main(String[] args){
        String[] input = {"eternal", 
        "texas", 
        "chainsaw", 
        "massacre"};
        System.out.println(crosswordFormation(input));
    }
    
}
