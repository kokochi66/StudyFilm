public class pro_Level2_17 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0, max = people.length-1, count = 0;
        while(min <= max){
            if(min == max) {
                count++;
                break;
            }
            int sum = people[min] + people[max];
            if(sum > limit) max--;
            else if(sum <= limit) {
                min++;
                while(min < max && people[min] + sum <= limit) min++;
                max--;
            }
            count++;
        }
        return count;
    }
}   
