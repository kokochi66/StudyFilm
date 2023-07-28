import java.util.*;

public class pro_monchal11_3 {


    public static void main(String[] args){
        int[] a = {5,2,3,3,5,3};
        int[] b = {0,3,3,0,7,2,0,2,2,0};
        int[] c = {0,2,1,0,2,0,0};
        System.out.println(solution(c));
        // ArrayList<HashSet> setList = new ArrayList<>();
        // HashSet<Integer> set = new HashSet<>();
        // HashSet<Integer> set2 = new HashSet<>();
        // set.add(1);
        // set2.add(1);
        // set2.add(2);
        // setList.add(set);
        // setList.add(set2);
        // System.out.println(setList.get(0).equals(setList.get(1)));
    }

    public static int solution(int[] a) {
        return func2(a);
    }

    public static int func2(int[] arr){
        if(arr.length<=3) return 0;
        int[] counting = new int[arr.length+2];
        int[] used = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            System.out.println(i+"  "+arr[i]);
            if(i==0 && arr[i] != arr[i+1]) {
                counting[arr[i]]++;
                counting[arr[i+1]]++;
                used[i+1] = arr[i];
                i++;
            }
            else if(i==0 && arr[i] == arr[i+1]) {
                while(i<arr.length-1 && arr[i] == arr[i+1]) i++;
                if(i==arr.length-1) return 0;
                counting[arr[i]]++;
                counting[arr[i+1]]++;
                used[i+1] = arr[i];
                i++;
            } 
            else if(i==arr.length-1) {
                if(used[i-1] != arr[i]) counting[arr[i]]++;
            }
            else if(used[i-1] == arr[i] && arr[i] != arr[i+1]){
                counting[arr[i]]++;
                counting[arr[i+1]]++;
                used[i+1] = arr[i];
                i++;
            }
            else if(used[i-1] == arr[i] && arr[i] == arr[i+1]){
                while(i<arr.length-1 && arr[i] == arr[i+1]) i++;
                if(i<arr.length-1){
                    counting[arr[i]]++;
                    counting[arr[i+1]]++;
                    used[i+1] = arr[i];
                    i++;
                } else if(i==arr.length-1){
                    counting[arr[i]]++;
                    i++;
                }
            }
            else if(used[i-1] != arr[i] && arr[i] != arr[i-1]){
                counting[arr[i]]++;
                used[i] = arr[i-1];
                if(arr[i] != arr[i+1]){
                    counting[arr[i+1]]++;
                    used[i+1] = arr[i];
                    i++;
                }
                else if(arr[i] == arr[i+1]){
                    while(i<arr.length-1 && arr[i] == arr[i+1]) i++;
                    if(i<arr.length-1){
                        counting[arr[i+1]]++;
                        used[i+1] = arr[i];
                        i++;
                    } else if(i==arr.length-1){
                        counting[arr[i]]++;
                        i++;
                    }
                }
            }
            else if(used[i-1] != arr[i] && arr[i] == arr[i-1]){
                if(arr[i] != arr[i+1]){
                    counting[arr[i]]++;
                    counting[arr[i+1]]++;
                    used[i+1] = arr[i];
                    i++;
                }
                else if(arr[i] == arr[i+1]){
                    while(i<arr.length-1 && arr[i] == arr[i+1]) i++;
                    if(i<arr.length-1){
                        counting[arr[i]]++;
                        counting[arr[i+1]]++;
                        used[i+1] = arr[i];
                        i++;
                    } else if(i==arr.length-1){
                        counting[arr[i]]++;
                        i++;
                    }
                }
            }
        }

        int max = 0;
        for(int i=0;i<counting.length;i++) {
            if(counting[i] > max && counting[i]>1) {
                max = counting[i];
                System.out.println(i+" "+max);
            }
        }
        return max*2;
    }

}
