public class pro_Level1_20 {
    public static String solution(String s, int n) {
        String output = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ' '){
                if(s.charAt(i)<='Z') output += (char)((s.charAt(i) - 'A' + n)%26 + 'A');
                else output += (char)((s.charAt(i) - 'a' + n)%26 + 'a');
            }
            else output += " ";
        }
        return output;
    }
}
