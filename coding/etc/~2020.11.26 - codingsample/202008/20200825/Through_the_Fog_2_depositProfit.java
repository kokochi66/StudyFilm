package N7_Through_the_Fog;

public class Through_the_Fog_2_depositProfit {
	static int depositProfit(int deposit, int rate, int threshold) {
		return (int) Math.ceil(Math.log((double)threshold/deposit)/Math.log((double)1+(rate*0.01)));
	}

	public static void main(String[] args) {
		System.out.println(depositProfit(100,20,170));

	}

}
