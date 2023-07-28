package javaSpeedCoding20200901;

import java.util.Scanner;

public class OtoX {

	public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String s = input.nextLine();
            if (s.charAt(0) == '0') {
                int hex = Integer.parseInt(s.substring(2), 16); // Skip two characters "0x"
                System.out.println(hex);
            }
            else {
                int dec = Integer.parseInt(s);
                String hs = Integer.toHexString(dec);
                System.out.println("0x" + hs.toUpperCase());
            }
        }		
	}

}
