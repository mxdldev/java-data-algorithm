package D栈队列.A005滑动窗口最大值;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: <Solution1><br>
 * Author:      mxdl<br>
 * Date:        2021/3/7<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Solution1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{2, 8, 6, 3, 2, 4}, 3)));
    }

    //leetcode:239
    static int[] maxSlidingWindow(int[] nums, int k) {
        //数组的长度
        int n = nums.length;
        //创建一个优先队列
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        //给优先队列先赋值 前k个元素
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        //结果数组
        int[] ans = new int[n - k + 1];
        //结果数组第一个元素赋值
        ans[0] = pq.peek()[0];
        //往队列里面添加元素
        for (int i = k; i < n; ++i) {
            //把当前元素添加到队列
            pq.offer(new int[]{nums[i], i});
            //把最左侧不在滑动窗口范围类的所有最大的元素干掉
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            //取最大值赋值给结果数组
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
