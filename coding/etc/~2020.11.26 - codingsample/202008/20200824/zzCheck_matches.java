package N6_Rains_of_Reason;

public class zzCheck_matches {

	public static void main(String[] args) {
		String str = "abcd";
		System.out.println(str.matches("(a|b|c)*"));
		//(| |)* 은 해당 안에 있는 값들로만 스트링이 이루어져있는가를 확인
		str = "abcgccc";
		System.out.println(str.matches("[a|b]+"));
		//[||]+ 도 사실상 같은듯
		System.out.println(str.matches("[a|b|c|abcg]*"));
		// 아니 사실 뭐가 다른지 잘 모르겠다
		str = "0_abcAZgccc";
		System.out.println(str.matches("[a-z0-9][a-zA-Z_]*"));
		// [][]* 대괄호 두개를 붙인경우 첫번째 대괄호는 첫번째값만, 두번째값은 나머지에 해당
	}

}
