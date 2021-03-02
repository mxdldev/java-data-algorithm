package D栈队列.A006前k个高频元素;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Soluction {
    //leetcode:347
    static int[] getTopKRequent(int[] nums,int k){
        //1.通过哈希表计数
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        //2.通过优先队列来过滤k以下的
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(pq.size() == k){
                if(pq.peek()[1] < count){
                    pq.poll();
                    pq.offer(new int[]{num,count});
                }
            }else{
                pq.offer(new int[]{num,count});
            }
        }
        //3.把队列数据存入数组
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll()[0];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTopKRequent(new int[]{1,1,2,2,2,3,3,3,5,56,6,7,8,8,8,8},4)));
        //System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,2,2,2,3,3,3,5,56,6,7,8,8,8,8},4)));
    }
}
