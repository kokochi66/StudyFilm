package N7_Through_the_Fog;

public class Through_the_Fog_1_circleOfNumbers {
	static int circleOfNumbers(int n, int firstNumber) {
	    return (firstNumber+(n/2))%n;
	}
	public static void main(String[] args) {
		System.out.println(circleOfNumbers(10,2));
	}

}
