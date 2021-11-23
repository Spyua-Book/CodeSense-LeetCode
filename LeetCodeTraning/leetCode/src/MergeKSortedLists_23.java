import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class MergeKSortedLists_23 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    
    @Test
    public void MergeTwoSortedListsCase1(){
   
        int[] l1 = {1,4,5};
        int[] l2 = {1,3,4};
        int[] l3 = {2,6}; 
        ListNode[] listNodes = {GenNodeList(l1),  GenNodeList(l2), GenNodeList(l3)};
        var result = MergeKLists(listNodes);      
        PrintListNode(result);
    }


    public ListNode MergeKLists(ListNode[] lists) {
        
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        
        // l > r 非順序集合，不符合條件，回傳一個Null
        if(l>r) return null;        
        
        // l == r List自己，單一List Node
        if(l==r) return lists[l];

        // l+1 == r 兩個List，直接Merge
        if(l+1==r) return MergeTwoLists(lists[l], lists[r]);
        
        // 3個List以上作處理
        int m = l + (r-l)/2;

        // 左 Group  List
        var l1 = merge(lists, l, m);
        
        // 右 Group List
        var l2 = merge(lists, m+1, r);
        
        return MergeTwoLists(l1, l2);
    }

    public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;       
        if (l1.val < l2.val) {
            l1.next = MergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = MergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode GenNodeList(int[] nums){

        if(nums.length==0)
            return new ListNode();

        var head = new ListNode(nums[0]);
        
        var tmpNode = new ListNode();
        tmpNode = head;
       
        for(int i=1; i<nums.length; i++){            
            tmpNode.next = new ListNode(nums[i]);
            tmpNode = tmpNode.next;
        }

        return head;
    }

    public void PrintListNode(ListNode node){
        while(node!=null){         
            System.out.printf("Node No %d\n",node.val);
            node = node.next;
        }
    }

}
