public class pro2_TestHash {
    public static boolean solution(String[] phone_book) {
        // char tempI, tempJ;
        // int lengI, lengJ;
        // for(int i=0;i<phone_book.length-1;i++){
        //     lengI = phone_book[i].length()-1;
        //     tempI = phone_book[i].charAt(lengI);
        //     for(int j=i+1;j<phone_book.length;j++){
        //         lengJ = phone_book[j].length()-1;
        //         tempJ = phone_book[j].charAt(lengJ);
        //         if(lengJ > lengI && tempI == phone_book[j].charAt(lengI) && phone_book[j].substring(0,lengI+1).equals(phone_book[i])) return false;
        //         else if(lengJ == lengI && phone_book[i].equals(phone_book[j])) return false;
        //         else if(lengJ < lengI && tempJ == phone_book[i].charAt(lengJ) && phone_book[i].substring(0,lengJ+1).equals(phone_book[j])) return false;
        //         else if(lengJ == lengI && phone_book[j].equals(phone_book[i])) return false;
        //     }
        // }
        // return true;
        for(int i=0;i<phone_book.length-1;i++){
            for(int j=i;j<phone_book.length;j++){
                if(phone_book[i].startsWith(phone_book[j])) return false;
                else if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[] input = {
            "1195478976",
            "119",
        };
        System.out.println(solution(input));
    }
}