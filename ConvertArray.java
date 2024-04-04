import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertArray {
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();

        HashMap<Integer, Integer> temp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(temp.containsKey(nums[i])){
                temp.put(nums[i], temp.get(nums[i])+1);
            }else{
                temp.put(nums[i],1);
            }
        }
        int max = 0;
        for(int a : temp.keySet()){
            if(temp.get(a) > max){
                max = temp.get(a);
            }
        }

        for(int i=0; i<max; i++){
            List<Integer> inp = new ArrayList<>();
            for(int a : temp.keySet()){
                if(temp.get(a) > 0) {
                    inp.add(a);
                }
                if(temp.get(a)>0){
                    temp.put(a, temp.get(a)-1);
                }
            }
            out.add(inp);
        }

        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,1,2,3,1};
        System.out.println(findMatrix(nums));
    }
}
