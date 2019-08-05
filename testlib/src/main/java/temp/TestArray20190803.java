package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Description: <TestArray20190803><br>
 * Author:      mxdl<br>
 * Date:        2019/8/3<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class TestArray20190803 {
    public static void main(String[] args) {
        int[] nums = {8,2,25,2,3,5,25};
        //1.冒泡排序
        int[] ints = bubbleSort(nums);
        System.out.println(Arrays.toString(ints));
        System.out.println("------------------------");
        //2.选择排序
        int[] ints1 = selectSort(nums);
        System.out.println(Arrays.toString(ints1));
        System.out.println("------------------------");
        //3.桶排序
        int[] ints2 = bukketSort(nums,25);
        for(int i = 0; i < ints2.length; i++){
            if(ints2[i]>0){
                while (ints2[i]-- > 0){
                    System.out.println(i);
                }
            }
        }
        System.out.println("------------------------");
        //4.查找数组中有没有重复元素
        boolean repeat = checkRepeat(nums);
        System.out.println("repeat:"+repeat);
        System.out.println("-------------------------");

        //5.删除数组的重复元素
        int[] nums1 = {8,8,25,8,25,5,25};
        int[] ints3 = deleteRepeat(nums1);
        System.out.println(Arrays.toString(ints3));
        System.out.println("------------------------");

        //6.两数之和求下标
        int[] nums2 = {2,8,5,3,1};
        int[] ints4 = twoSum(nums2, 13);
        System.out.println(Arrays.toString(ints4));
        System.out.println("------------------------");

        //7.求左上到右下的路径数
        int path = getPath(2,3);
        System.out.println("path:"+path);
        System.out.println("-------------------------");

        //8.求左上做右下所有路径的最小值
        int[][] nums8 = new int[][]{{2,4},{3,31},{5,9}};
        int min = getMin(nums8);
        System.out.println("min"+min+";int[0][0]:"+nums8[0][0]+";int[1][0]:"+nums8[1][1]);
        System.out.println("-------------------------");

        //9.删除集合中的偶数
        ArrayList<Integer> list = new ArrayList<Integer>(){
            {add(10);}
            {add(1);}
            {add(2);}
            {add(3);}
        };
        List<Integer> list1 = getList(list);
        Iterator<Integer> iterator = list1.iterator();
        while(iterator.hasNext()){
            System.out.println("value:"+iterator.next());
        }
    }
    //1.冒泡排序
    public static int[] bubbleSort(int[] nums) {
        //循环的轮次
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                //相邻的两个元素两两相比
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    //2.选择排序
    public static int[] selectSort(int[] nums){
        //控制循环的轮次
        for(int i = 0; i < nums.length -1 ; i++){
            //拿出第一个元素和剩余的元素相比
            for(int j = i + 1; j < nums.length; j++){
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    //3.桶排序:已知数组和最大值
    public static int[] bukketSort(int[] nums,int max){
        //创建一个max+1长的数组
        int[] arr = new int[max + 1];
        for(int i = 0; i < nums.length; i++){
            //以源数组的值作为新数组的下标
            arr[nums[i]]++;
        }
        return arr;
    }
    //4.查找数组中有没有重复元素
    public static  boolean checkRepeat(int[] nums){
        //借助hash表可以很轻松的解决该问题，哈希表用来缓存数据和查找数据
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length ; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    //5.删除数组中的重复元素
    public static int[] deleteRepeat(int[] nums){
        //拿出以第一个元素和剩余元素比较
        //拿出第一个元素和剩余元素比较
        loop:for(int i = 0; i < nums.length ; i++){
            for(int j = i + 1; j < nums.length; j++){
              if(nums[i] == nums[j]){
                  //j之后的元素往前挪动一个位置
                  int k  =  j;
                  while(k < nums.length - 1){
                      nums[k] = nums[k+1];
                      k++;
                  }
                  //循环完毕压缩数组
                  nums = Arrays.copyOf(nums,nums.length -1);
                  //System.out.println("value:"+Arrays.toString(nums));
                  //从头再开始循环
                  i  = -1;
                  continue loop;
              }
            }
        }
        return nums;
    }

    //6.两数之和找下标
    public static int[] twoSum(int[] nums,int target){
        //一遍哈希法
        HashMap<Integer,Integer> map = new HashMap<>();
        //遍历集合元素放入哈希表
        for(int i = 0 ; i < nums.length; i++){
            int curr = target - nums[i];
            if(map.containsKey(curr)){
                return new int[]{i,map.get(curr)};
            }
            //放入哈希表，便于下次查找
            map.put(nums[i],i);
        }
        return null;
    }
    //7.给定一个m*n二维数组，求左上到右下的路径数
    public static int getPath(int m,int n){
        //动态规划法
        //给二维数组第一行都赋值为1
        int[][] nums = new int[m][n];
        for(int i = 0 ; i < n; i++){
            nums[0][i] = 1;
        }
        //给二维数组第一列都赋值为1
        for(int i = 0; i < m; i++){
            nums[i][0] = 1;
        }
        //System.out.println("nums :"+Arrays.(nums));
        System.out.println("nums hang:"+nums.length);
        System.out.println("nums lie:"+nums[0].length);
        //给从nums[1][1]开始的元素的赋值
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                System.out.println("nums["+i+"]["+j+"]"+nums[i][j]);
                nums[i][j] = nums[i-i][j] + nums[i][j-1];
            }
        }
        return nums[nums.length-1][nums[0].length -1];
    }
    //8.给定一个数组，求左上到右下路径的最小数字
    public static int getMin(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        int[][] arr = new int[m][n];
        //给新二维数组的第一个元素赋值
        arr[0][0]  = nums[0][0];

        //给第一行01  02，03赋值
        for(int i = 1; i < n;i++){
            //当前元素为当前元素和其后面元素值的和
            arr[0][i] = arr[0][i -1] + nums[0][i];
        }
        //给第一列赋值10,20,30...
        for(int i = 1; i < m; i++){
            arr[i][0] = arr[i-1][0] + nums[i][0];
        }
        //给11之后的元素赋值
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1]) + nums[i][j];
            }
        }
        return arr[m-1][n-1];
    }

    //9.删除集合中的偶数元素
    public static List<Integer> getList(List<Integer> list){
        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()){
            if((iterator.next() % 2) == 0){
                iterator.remove();
            }
        }
        return list;
    }
    public static ListNode ReverseList2(ListNode head) {
        ListNode reverseHead = null;
        // 指针1：当前节点
        ListNode currentNode = head;
        // 指针2：当前节点的前一个节点
        ListNode prevNode = null;
        while (currentNode != null) {
            // 指针3：当前节点的后一个节点
            ListNode nextNode = currentNode.next;
            if (nextNode == null) {
                reverseHead = currentNode;
            }
            // 将当前节点的后一个节点指向前一个节点
            currentNode.next = prevNode;
            // 将前一个节点指向当前节点
            prevNode = currentNode;
            // 将当前节点指向后一个节点
            currentNode = nextNode;
        }
        return reverseHead;
    }
}
