package N6_Rains_of_Reason;

public class Rains_of_Reason_3_variableName {
	static boolean variableName(String name) {
	    return name.matches("[a-zA-Z_][a-zA-Z0-9_]*");
	}
	public static void main(String[] args) {
		String input = "_3va1Int";
		System.out.println(variableName(input));
	}

}
