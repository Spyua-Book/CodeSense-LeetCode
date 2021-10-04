import org.junit.Test;

public class RemoveNthFromEnd_19 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Test
    public void RemoveNthFromEndCase1(){
        // Ans:1235
        int[] nums = {1,2,3,4,5};
        var nodeList = GenNodeList(nums);
        PrintListNode(removeNthFromEnd(nodeList, 2));
    }

    //   int[] nums = {1};
    @Test
    public void RemoveNthFromEndCase2(){
        // Ans:
        int[] nums = {1};
        var nodeList = GenNodeList(nums);
        PrintListNode(removeNthFromEnd(nodeList, 1));
    }

    //  int[] nums = {1,2};
    @Test
    public void RemoveNthFromEndCase3(){
        //Ans:1
        int[] nums = {1,2};
        var nodeList = GenNodeList(nums);
        PrintListNode(removeNthFromEnd(nodeList, 1));
    }

    //  int[] nums = {1,2};
    @Test
    public void RemoveNthFromEndCase4(){
        //Ans:2
        int[] nums = {1,2};
        var nodeList = GenNodeList(nums);
        PrintListNode(removeNthFromEnd(nodeList, 2));
    }

    //   int[] nums = {1,2,3};
    @Test
    public void RemoveNthFromEndCase5(){
        //Ans:1,2,3
        int[] nums = {1,2,3};
        var nodeList = GenNodeList(nums);
        PrintListNode(removeNthFromEnd(nodeList, 3));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int point = 0;
        var preNode = new ListNode();
        var sortNode = new ListNode();
      
        int totalNode = 0;
        sortNode = head;
        

        // [Special] 只有一個數 直接return   針對 {1} n =1
        if(head.next==null && n==1)
            return null;

        // Step1: 走訪看有多少Node 並記錄
        var tmp = new ListNode();
        tmp = head;
        while(tmp!=null){         
            tmp = tmp.next;
            totalNode ++;
        }

        // Step2: 針對去頭Case  {1,2} n= 2  {1,2,3} n=3
        if(totalNode==n){
            sortNode = sortNode.next;
            return sortNode;
        }
            

        // Step3: 實際去除中間斷與去尾
        while(sortNode != null){     
                  
            if(point==totalNode-n){                
                preNode.next = sortNode.next;
                sortNode = preNode;
            }
            else{
                preNode = sortNode;
                sortNode = sortNode.next;
            }
            point++;
        }   
        return head;
    }



    public ListNode GenNodeList(int[] nums){

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
