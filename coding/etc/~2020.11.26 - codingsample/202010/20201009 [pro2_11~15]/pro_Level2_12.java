import java.util.Arrays;

public class pro_Level2_12 {

    public static boolean CheckFrom(StringBuilder p){
        int Number = 0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i) == '(') Number++;
            else Number--;
            if(Number<0) return false;
        }
        return true;
    }
    public static String solution(String p) {
        if(p.equals("")) return "";
        int[] num = new int[2];
        Arrays.fill(num, 0);
        StringBuilder u = new StringBuilder();
        int forIndex = 0;
        while((num[0]==0&&num[1]==0) || num[0]!=num[1]){
            if(p.charAt(forIndex) == '(') num[0]++;
            else num[1]++;
            u.append(p.charAt(forIndex++));
        }
        StringBuilder v = new StringBuilder(p.substring(forIndex, p.length()));
        if(CheckFrom(u)) return u.toString() + solution(v.toString());
        else {
            StringBuilder newOut = new StringBuilder();
            newOut.append("(");
            newOut.append(solution(v.toString()));
            newOut.append(")");
            u.delete(0, 1);
            u.delete(u.length()-1, u.length());
            for(int i=0;i<u.length();i++){
                if(u.charAt(i) == '(') u.replace(i, i+1, ")");
                else u.replace(i, i+1, "(");
            }
            newOut.append(u);
            return newOut.toString();
        }
    }
    public static void main(String[] args){
        System.out.println(solution("()))((()"));
    }
}
