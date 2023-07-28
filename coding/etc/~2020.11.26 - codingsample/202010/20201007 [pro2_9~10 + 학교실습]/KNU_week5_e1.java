import java.util.*;

public class KNU_week5_e1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
        String inputStringCurr = sc.nextLine();
        LinkedList<String> tempStringCase = new LinkedList<String>();
        char[] alphaPASS = new char[26];
        String CheckTemp = "";
        final String CheckingFoxs = "the quick brown fox jumps over the lazy dog";
        boolean CatchFox = false;
        inputStringCurr = sc.nextLine();
        for(int CurrCase = 1; CurrCase <= TestCase; CurrCase++) {
            // System.out.println(CurrCase+"번째 케이스가 시작됩니다 ::");
            inputStringCurr = sc.nextLine();
            CatchFox = false;
            while(inputStringCurr != null && !inputStringCurr.equals("")){
                // System.out.println("스트링이 입력되었습니다 => "+inputStringCurr);
                tempStringCase.add(inputStringCurr);
                CheckTemp = "";
                if(!CatchFox){      //아직 해당문장을 찾지 못했다면
                    Arrays.fill(alphaPASS, '0');
                    for(int alphaIndex = 0; alphaIndex<inputStringCurr.length(); alphaIndex++){
                        if(inputStringCurr.charAt(alphaIndex)>='a' && inputStringCurr.charAt(alphaIndex)<='z' &&
                        CheckingFoxs.charAt(alphaIndex)>='a' && CheckingFoxs.charAt(alphaIndex)<='z'){
                            if(alphaPASS[inputStringCurr.charAt(alphaIndex)-'a'] == '0' || alphaPASS[inputStringCurr.charAt(alphaIndex)-'a'] == CheckingFoxs.charAt(alphaIndex)) {
                                // System.out.println(":: 여우를 잡는 중입니다 ::"+CheckingFoxs.charAt(alphaIndex)+" == "+inputStringCurr.charAt(alphaIndex));
                                alphaPASS[inputStringCurr.charAt(alphaIndex)-'a'] = CheckingFoxs.charAt(alphaIndex);
                                if(alphaIndex == inputStringCurr.length()-1) {
                                    // System.out.println("여우를 잡았습니다 => "+inputStringCurr);
                                    CatchFox=true;
                                }
                            }
                            else break;
                        }
                        else if(inputStringCurr.charAt(alphaIndex)==' ' && CheckingFoxs.charAt(alphaIndex)==' ') TestCase = TestCase;
                        else break;
                    }
                }
                else {
                    while(!tempStringCase.isEmpty()) {
                        CheckTemp = "";
                        inputStringCurr = tempStringCase.get(0);
                        for(int i=0;i<inputStringCurr.length();i++){
                            if(inputStringCurr.charAt(i)>='a' && inputStringCurr.charAt(i)<='z'){
                                CheckTemp += Character.toString(alphaPASS[inputStringCurr.charAt(i)-'a']);
                            }
                            else CheckTemp += " ";
                        }
                        System.out.println(CheckTemp);
                        tempStringCase.remove(0);
                    }
                }
                inputStringCurr = sc.nextLine();
            }
            // System.out.println("케이스에서 빠져나옵니다.");
        }
    }
}
// the quick brown fox jumps over the lazy dog