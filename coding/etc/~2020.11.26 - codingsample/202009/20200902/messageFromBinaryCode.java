public class messageFromBinaryCode {

    static int binaryTranslate(String a){
        if(a.length()!=8) return -1;
        int var = 0, temp = 1;
        for(int i=7;i>=0;i--){
            var += ((a.charAt(i)-'0')*temp);
            temp *= 2;
        }
        return var;
    }
    static String messageFromBinaryCode(String code) {
        if(code.length()%8 != 0) return "None";
        String temp = "";
        String output = "";
        for(int i=0;i<code.length();i++){
            temp += code.charAt(i);
            if((i+1)%8 == 0 || i == code.length()-1){
                output += (char)binaryTranslate(temp);
                temp = "";
            }
        }
        return output;
    }
    
    
    public static void main(String[] args){
        String a = "010010000110010101101100011011000110111100100001";
        System.out.println(messageFromBinaryCode(a));
    }


}