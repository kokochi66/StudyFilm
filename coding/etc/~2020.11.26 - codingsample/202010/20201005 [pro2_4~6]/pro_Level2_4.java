import java.util.Arrays;

public class pro_Level2_4 {
    public static int solution(String skill, String[] skill_trees) {
        boolean[] clear = new boolean[skill.length()];
        String temp;
        boolean ALLCLEAR;
        int count = 0;
        for(int i=0;i<skill_trees.length;i++){
            Arrays.fill(clear, false);
            for(int j=0;j<skill_trees[i].length();j++){
                temp = Character.toString(skill_trees[i].charAt(j));
                if(skill.contains(temp)) {
                    ALLCLEAR = true;
                    for(int k=0;k<skill.indexOf(temp);k++) ALLCLEAR = ALLCLEAR && clear[k];
                    if(ALLCLEAR) clear[skill.indexOf(temp)] = true;
                    else break;
                }
                if(j == skill_trees[i].length()-1) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        String skill = "ABCD";
        String[] skill_trees1 = {"ABCD", "AFBCD", "ACD", "AD", "ABD", "AB","ABC","AQWERT","AR","B","CDE","BCD","CD"};
        System.out.println(solution(skill,skill_trees1));
        // 6
    }
    
}
