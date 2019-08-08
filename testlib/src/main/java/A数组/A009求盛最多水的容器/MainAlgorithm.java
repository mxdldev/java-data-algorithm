package A数组.A009求盛最多水的容器;

/**
 * Description: <MainAlgorithm><br>
 * Author:      mxdl<br>
 * Date:        2019/8/8<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAlgorithm {
    //给定一个数组，求面积
    public static int getMaxArea(int[] args){
        int maxArea = 0;
        for(int i = 0; i < args.length; i++){
            for(int j = i + 1; j < args.length; j++){
                maxArea = Math.max(maxArea,Math.min(args[i],args[j]) * (j - i));
            }
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[] arr = new int[]{4,3,5,6,1};
        System.out.println(arr);
    }
}
