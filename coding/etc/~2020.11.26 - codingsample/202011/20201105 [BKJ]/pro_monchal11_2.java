import java.util.*;

public class pro_monchal11_2 {


    public static void main(String[] args){
        System.out.println(Arrays.toString(solution("110010101001")));
    }

    public static int[] solution(String s) {
        StringBuilder temp = new StringBuilder(s);
        int count = 0, delzero = 0;;
        while(!temp.toString().equals("1")){
            for(int i=0;i<temp.length();i++){
                if(temp.charAt(i) == '0'){
                    temp.deleteCharAt(i);
                    i--;
                    delzero++;
                }
            }
            int curr = temp.length();
            StringBuilder here = new StringBuilder("");
            while(curr !=0 ){
                if(curr%2==0){
                    here.insert(0, "0");
                } else here.insert(0, "1");
                curr /= 2;
            }
            count++;
            temp = here;
        }
    
        System.out.println(temp);

        int[] output = new int[2];
        return new int[]{count,delzero};
    }
}
