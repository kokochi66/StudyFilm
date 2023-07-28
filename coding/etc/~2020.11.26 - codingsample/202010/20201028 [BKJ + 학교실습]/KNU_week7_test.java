import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class KNU_week7_test {
    // 피보나치 수의 개수
    public static void main(String[] args) throws Exception {

        // BigInteger a = new BigInteger("12");
        // BigInteger b = new BigInteger("13");
        // System.out.println(a.compareTo(b));

        BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tok = new String[2];

        String input = Read.readLine();
        tok = input.split(" ");

        while(!(tok[0].equals("0")&& tok[1].equals("0")) ) {
            int count = 0;
            ArrayList<BigInteger> list = new ArrayList<BigInteger>();
            list.add(new BigInteger("1"));
            list.add(new BigInteger("2"));
            BigInteger pibA = new BigInteger(tok[0]);
            BigInteger pibB = new BigInteger(tok[1]);
            
            int index = 0;
            while(pibB.compareTo(list.get(list.size()-1)) == 1){
                if(pibA.compareTo(list.get(list.size()-1)) <= 0) count++;
                BigInteger temp1 = list.get(index);
                BigInteger temp2 = list.get(index+1);
                list.add(temp1.add(temp2));
                index++;
            }

            Write.write(count+"");
            Write.newLine();

            input = Read.readLine();
            tok = input.split(" ");
        }

        Write.flush();
        Write.close();
        Read.close();
    }
}
