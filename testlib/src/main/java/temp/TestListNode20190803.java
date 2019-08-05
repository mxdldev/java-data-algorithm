package temp;

import java.util.List;

/**
 * Description: <TestListNode20190803><br>
 * Author:      mxdl<br>
 * Date:        2019/8/3<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class TestListNode20190803 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        //node3.next = head;
        //1.判断有没有环
        boolean cricle = isListNodeRing(head);
        System.out.println("iscricle:" + cricle);
        System.out.println("--------------------------");
        //2.找到环的入口节点
        //ListNode enterNode = getEnterNode(head);
        //System.out.println("val:"+enterNode.val);
        System.out.println("--------------------------");

        //3.翻转一个链表
//        ListNode node = reversListNote(head);
//        StringBuilder builder = new StringBuilder();
//        while (node != null) {
//            builder.append(node.val).append(",");
//            node = node.next;
//        }
//        System.out.println("new ListNode:" + builder.toString());
        System.out.println("--------------------------");
        //4.删除链表当中的倒数第n个节点
        ListNode node = delteNode(head, 4);
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append(",");
            node = node.next;
        }
        System.out.println("delteNode ListNode:" + builder.toString());
        //System.out.println("value:"+node.val);
        System.out.println("--------------------------");

        ListNode head1 = new ListNode(0);
        ListNode node11 = new ListNode(5);
        ListNode node21 = new ListNode(7);
        ListNode node31 = new ListNode(10);
        head1.next = node11;
        node11.next = node21;
        node21.next = node31;


        ListNode head11 = new ListNode(2);
        ListNode node111 = new ListNode(4);
        ListNode node211 = new ListNode(6);
        ListNode node311 = new ListNode(8);
        head11.next = node111;
        node111.next = node211;
        node211.next = node311;

        ListNode merge = merge(head1, head11);

        StringBuilder builder1 = new StringBuilder();
        while (merge != null) {
            builder1.append(merge.val).append(",");
            merge = merge.next;
        }
        System.out.println("new ListNode:" + builder1.toString());

    }

    //1.判断一个链表有没有环
    public static boolean isListNodeRing(ListNode listNode) {
        ListNode slowNode = listNode;
        ListNode fastNode = listNode;
        while (slowNode != null && fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    //2.如果链表有环找到链表的入口节点
    public static ListNode getEnterNode(ListNode listNode) {
        ListNode slowNode = listNode;
        ListNode fastNode = listNode;
        while (slowNode != null && fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                break;
            }
        }
        //快节点移动到头结点
        fastNode = listNode;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return fastNode;
    }

    //3.翻转一个链表
    //　定义3个指针，分别指向当前遍历到的结点、它的前一个结点及后一个结点。在遍历过程中，首先记录当前节点的后一个节点，然后将当前节点的后一个节点指向前一个节点，其次前一个节点再指向当前节点，最后再将当前节点指向最初记录的后一个节点，如此反复，直到当前节点的后一个节点为NULL时，则代表当前节点时反转后的头结点了。
    public static ListNode reversListNote(ListNode listNode) {
        ListNode headNode = null;
        ListNode currNode = listNode;
        ListNode preNdoe = null;
        while (currNode != null) {
            //记录当前节点的下一个节点
            ListNode nextNode = currNode.next;
            if (nextNode == null) {
                headNode = currNode;
            }
            //当前节点的下一个节点指向前一个节点
            currNode.next = preNdoe;
            //前一个节点指向当前节点
            preNdoe = currNode;
            //当前节点指向下一个节点
            currNode = nextNode;
        }
        return headNode;
    }

    //4.删除链表当中的倒数第n个节点
    public static ListNode delteNode(ListNode listNode, int n) {
        //首先找到正数第n个节点
        ListNode pa = listNode;
        ListNode pb = listNode;
        int i = 1;
        while (i <= n) {
            pa = pa.next;
            i++;
        }
        if(pa == null){
            return listNode.next;
        }
         while ( pa.next != null) {
            pa = pa.next;
            pb = pb.next;
        }
        pb.next = pb.next.next;
        return listNode;
    }

    //5.合并两个有序链表
    public static ListNode merge(ListNode pa, ListNode pb) {
        ListNode headNode = new ListNode(0);
        ListNode currNode = headNode;
        while (pa != null && pb != null) {
            if (pa.val < pb.val) {
                currNode.next = pa;
                pa = pa.next;
            } else {
                currNode.next = pb;
                pb = pb.next;
            }
            currNode = currNode.next;
        }
        currNode.next = pa != null ? pa : pb;
        return headNode.next;
    }
}
