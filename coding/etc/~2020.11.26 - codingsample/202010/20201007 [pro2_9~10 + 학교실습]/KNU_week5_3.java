import java.util.*;
import java.util.stream.*;
public class KNU_week5_3 {

    public static boolean CheckingList(List<String> A, List<String> B, char[] chartemp) {
        List<String> tempA = new ArrayList<String>(A);
        List<String> tempB = new ArrayList<String>(B);
        int j=0;
        while(!tempA.isEmpty()){
            while(!tempB.isEmpty()){
                if(tempA.get(0).length() == tempB.get(j).length()) {
                    for(int index=0;index<tempA.get(0).length();index++){
                        if(chartemp[tempA.get(0).charAt(index) -'a'] != tempB.get(j).charAt(index) && chartemp[tempA.get(0).charAt(index)-'a'] !='0') {
                            if(j == tempB.size()-1) return false;
                            break;
                        }
                        else if(index == tempA.get(0).length()-1){
                            tempA.remove(0);
                            tempB.remove(j);
                            j--;
                            break;
                        }
                    }
                }
                j++;
            }
        }
        return true;
    }
    public static char[] TakingFox(List<String> A, List<String> B, char[] charTemp){
        List<String> tempA = new ArrayList<String>(A);
        List<String> tempB = new ArrayList<String>(B);

        return charTemp;
    }

    public static boolean CheckingPatch(String a, String b){
        if(a.length() != b.length()) return false;
        HashSet<Character> aSet = new HashSet<Character>();
        int var = 0;
        String outputA = "";
        String outputB = "";
        for(int i=0;i<a.length();i++){
            if(!aSet.contains(a.charAt(i))){
                var+=1;
                outputA += var+"";
                aSet.add(a.charAt(i));
            }
            else outputA += var+"";
        }
        aSet.clear();
        var = 0;
        for(int i=0;i<b.length();i++){
            if(!aSet.contains(b.charAt(i))){
                var+=1;
                outputB += var+"";
                aSet.add(b.charAt(i));
            }
            else outputB += var+"";
        }
        return outputA.equals(outputB);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        final String fox = "the quick brown fox jumps over the lazy dog";
        boolean TakingFox = false;
        boolean faultFor = false;
        char[] AlphaArr = new char[26];
        String[] aToken = a.split(" ");
        String[] bToken = b.split(" ");
        List<String> TargetA = new ArrayList<String>();
        List<String> TargetB = new ArrayList<String>();
        int ProblemSwit = 0;
        for(int i=0;i<aToken.length;i++){
            TargetA.add(aToken[i]);
            TargetB.add(bToken[i]);
        }
        TargetA.sort(Comparator.comparing(String::length));
        TargetB.sort(Comparator.comparing(String::length));

    
        Arrays.fill(AlphaArr, '0');
        int i =0;
        while(i<TargetA.size()){
            final int CurrIndex = i;
            if(TargetA.stream().filter(q-> q.length() == TargetA.get(CurrIndex).length()).count() == 1){
                for(int j=0;j<TargetA.get(i).length();j++){
                    if(AlphaArr[TargetA.get(i).charAt(j)-'a'] == '0') {
                        AlphaArr[TargetA.get(i).charAt(j)-'a'] = TargetB.get(i).charAt(j);
                    }
                }
                TargetA.remove(i);
                TargetB.remove(i);
                i--;
            }
            i++;
        }
        i = 0;

        while(!TargetA.isEmpty()){
            for(int index=0;index<TargetA.get(0).length();index++){
                AlphaArr[TargetA.get(0).charAt(index)-'a'] = TargetB.get(0).charAt(index);
            }
            TargetA.remove(0);
            TargetB.remove(0);
        }

        // int TypeB = 0;
        // while(i<TargetB.size()){
        //     if(CheckingPatch(TargetA.get(0),TargetB.get(i))){
        //         System.out.println(TargetA.get(0)+" "+TargetB.get(i));
        //         for(int index=0;index<TargetA.get(0).length();index++){
        //             if(AlphaArr[TargetA.get(0).charAt(index)-'a'] == '0') {
        //                 AlphaArr[TargetA.get(0).charAt(index)-'a'] = TargetB.get(i).charAt(index);
        //             }
        //         }
        //         TargetA.remove(0);
        //         TargetB.remove(i);
        //         i=0;
        //     }
        //     else i++;
        // }
 




        // int TargetPoint = 0;
        // boolean fault = false;
        // while(!TakingFox){
        //     char[] charTemp = new char[26];
        //     List<String> tempTA = new ArrayList<String>(TargetA);
        //     List<String> tempTB = new ArrayList<String>(TargetB);
        //     charTemp = AlphaArr;
        //     fault = false;
        //     while(!fault){
        //         int EqualLengthCount = (int) tempTA.stream().filter(induct -> induct.length() == tempTA.get(0).length()).count();
        //         for(int koko=0;koko<tempTB.get(TargetPoint).length();koko++){
        //             if(AlphaArr[tempTA.get(0).charAt(koko)-'a'] != '0' && AlphaArr[tempTA.get(0).charAt(koko)-'a'] != tempTB.get(0).charAt(koko)) {
        //                 fault = true;
        //                 TargetPoint++;
        //                 break;
        //             }
        //             else charTemp[tempTA.get(0).charAt(koko)-'a'] = tempTB.get(0).charAt(koko);
        //             if(koko==tempTB.get(TargetPoint).length()-1) {
        //                 tempTA.remove(0);
        //                 tempTB.remove(TargetPoint);
        //             }
        //         }
        //         if(!fault && CheckingList(tempTA,tempTB,charTemp)){

        //         }
        //     }
        // }



        String[] aToken2 = new String[TargetA.size()];
        String[] bToken2 = new String[TargetA.size()];

        for(int r=0;r<TargetA.size();r++){
            aToken2[r] = TargetA.get(r);
            bToken2[r] = TargetB.get(r);
        }
        System.out.println(Arrays.toString(aToken2));
        System.out.println(Arrays.toString(bToken2));


        String output = "";
        for(int r=0;r<fox.length();r++) {
            if(fox.charAt(r) == ' ') output += " ";
            else output += Character.toString(AlphaArr[fox.charAt(r)-'a']);
        }
        System.out.println(output);
        for(int r=0;r<26;r++) System.out.println((char)('a'+r)+" "+AlphaArr[r]);

    }
}
//문제에 오류가 있는 듯