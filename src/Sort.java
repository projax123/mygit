import java.util.*;
import java.util.concurrent.*;

/**
 * java基础排序算法
 * @author wwx
 */
public class Sort {

    public static void main(String[] args) {
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("eee"));
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abcddtte"));
        HashSet
    }

    private static int deCode(String nums){
        if(nums.length()==1){
            return 1;
        }else if(nums.length() ==2){
            int tag = Integer.valueOf(nums);
            if(tag>26){
                return 1;
            }else {
                return 2;
            }
        }
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        int tag = Integer.valueOf(nums.substring(0, 2));
        if(tag>26){
            dp[1] = 1;
        }else{
            dp[1] = 2;
        }
        for(int i = 2;i<nums.length();i++){
            tag = Integer.valueOf(nums.substring(i - 1, i + 1));
            if(tag>26){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[nums.length()-1];
    }

    public static int maxPower(String s){
        int res =1;
        char tag = s.charAt(0);
        int count = 1;
        for(int i = 1;i<s.length();i++){
            if(tag == s.charAt(i)){
                count++;
            }else{
                if(res<count){
                    res = count;
                }
                count = 1;
                tag = s.charAt(i);
            }
        }
        if(res<count){
            res = count;
        }
        return res;
    }

}
