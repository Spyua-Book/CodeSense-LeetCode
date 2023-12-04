import org.junit.Assert;
import org.junit.Test;

public class AddTwoNumbers_2 {

    @Test
    public void PalindromeNumberUnitTest() {
        int[] l1 = {2,4,3};
        int[] l2 = {5,6,1};
        var sumNode = addTwoNumbers(GenNodeList(l1), GenNodeList(l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return new ListNode();
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
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
