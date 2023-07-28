import java.util.*;

public class sol3_pro11 {

    public static String solution(String encrypted_text, String key, int rotation) {
        StringBuilder TP = new StringBuilder(encrypted_text);
        int[] keyNum = new int[key.length()];
        for(int i=0;i<keyNum.length;i++){
            keyNum[i] = key.charAt(i) - 'a' +1;
        }
        if(rotation>0){
            for(int i=0;i<rotation;i++){
                TP.append(TP.charAt(0));
                TP.deleteCharAt(0);
            }
        }
        else {
            rotation *= -1;
            for(int i=0;i<rotation;i++){
                TP.insert(0, TP.charAt(TP.length()-1));
                TP.deleteCharAt(TP.length()-1);
            }
        }

        for(int i=0;i<TP.length();i++){
            char Curr = (char)(TP.charAt(i)-keyNum[i]);
            if(Curr < 'a'){
                int temp = 'a' - Curr;
                Curr = (char)('z' - temp+1);
            }
            TP.replace(i, i+1, Curr+"");
        }
        // System.out.println(TP);
        
        return TP.toString();
    }
    public static void main(String[] args) throws Exception {
        System.out.println(solution("aaaaaaaaaaaaaaaaaaaaaaaaaa","abcdefghijklmnopqrstuvwxyz",3));
    }
}
