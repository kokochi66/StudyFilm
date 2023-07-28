import java.util.stream.IntStream;

public class TheCore3_Corner_of_0s_and_1s {
    private static int killKthBit(int n, int k) {
        return ((n&(int)Math.pow(2,k-1)) == (int)Math.pow(2,k-1)) ? n-(int)Math.pow(2,k-1) : n;
      }
    private static int arrayPacking(int[] a) {
        return IntStream.range(0,a.length).map(i->a[i]<<8*i).sum();
    }
    
    private static int numBit(int a){
        int count = 0;
        while(a!=0){
            if((a&1)==1) {
                a--;
                count++;
            }
            a = a>>1;
        }
        return count;
    }
    private static int rangeBitCount(int a, int b) {
        return IntStream.range(a,b+1).map(i->numBit(i)).sum();
    }
    
    private static int mirrorBits(int a){
        int b = 0;
        while(a != 0){
            b <<= 1;
            b |= (a&1);
            a >>= 1;
        }
        return b;
    }

    private static int secondRightmostZeroBit(int n) {
        return (int)Math.pow(2,IntStream.range(0,(int)(Math.log(n)/Math.log(2))).filter(i->(n&(int)Math.pow(2,i))==0).toArray()[1]);
      }
    private static int swapAdjacentBits(int n) {
        return ((n<<1)&715827882)+((n>>1)&357913941);
      }
      
    private static int differentRightmostBit(int n, int m) {
        return (int)Math.pow(2,IntStream.range(0,30).filter(i->((int)Math.pow(2,i)&n)!=((int)Math.pow(2,i)&m)).min().getAsInt());
      }
    private static int equalPairOfBits(int n, int m) {
        return (int)Math.pow(2,IntStream.range(0, 30).filter(i->((int)Math.pow(2,i)&n)==((int)Math.pow(2,i)&m)).min().getAsInt());
      }

    public static void main(String[] args){
        int[] a = {24,85,0};
        System.out.println(killKthBit(37,3));
        System.out.println(arrayPacking(a));
        System.out.println(rangeBitCount(2,7));
        System.out.println(mirrorBits(8));
        System.out.println(secondRightmostZeroBit(37));
        System.out.println(swapAdjacentBits(13));
        System.out.println(differentRightmostBit(11,13));
        System.out.println(equalPairOfBits(10,11));
    }
}
