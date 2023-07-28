public class Intro1_Journey_Begins {
    private static int centuryFromYear(int year) {
        return (int) Math.ceil(year/100.0);
    }
    //년도의 세기를 출력함
    //Math.ceil(올림) 함수를 이용하여 간단하게 구현가능.

    private static boolean checkPalindrome(String inputString) {
        return new StringBuilder(inputString).reverse().toString().equals(inputString);
    }
    //입력된 문자열이 회문인지를 출력함.
    //StringBuilder를 이용하여 구현가능.
    public static void main(String[] args){
        System.out.println(centuryFromYear(2001));
        System.out.println(checkPalindrome("aabaa"));
    }
}
