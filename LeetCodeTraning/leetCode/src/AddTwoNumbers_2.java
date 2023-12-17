import org.junit.Test;

public class AddTwoNumbers_2 {

    @Test
    public void AddTwoNumbersUnitTest() {
        int[] l1 = {2,4,3};
        int[] l2 = {5,6,1};
        var sumNode = addTwoNumbers(GenNodeList(l1), GenNodeList(l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var num1 = ConvertLinkedListToIntValue(l1);
        var num2 = ConvertLinkedListToIntValue(l2);
        var sum = num1+num2;


        // 創建一個假頭節點，以便於操作
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        // 如果 sum 為 0，則直接返回一個值為 0 的節點
        if (sum == 0) {
            return new ListNode(0);
        }

        // 分解整數和並創建鏈表
        while (sum > 0) {
            int digit = sum % 10; // 取得當前的最低位數字
            current.next = new ListNode(digit); // 創建新節點並連接
            current = current.next; // 移動到新節點
            sum /= 10; // 移除已處理的最低位
        }

        return dummyHead.next; // 返回實際的頭節點
    }

    public int ConvertLinkedListToIntValue(ListNode head) {
        // 反轉鏈表
        ListNode reversedHead = reverseLinkedList(head);

        // 轉換為整數
        int number = 0;
        int multiplier = 1;
        ListNode currentNode = reversedHead;
        while (currentNode != null) {
            number += currentNode.val * multiplier;
            multiplier *= 10;
            currentNode = currentNode.next;
        }

        return number;
    }


    public ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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



}
