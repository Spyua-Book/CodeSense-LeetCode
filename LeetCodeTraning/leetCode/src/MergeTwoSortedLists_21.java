import org.junit.Test;

public class MergeTwoSortedLists_21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    @Test
    public void MergeTwoSortedListsCase1(){
        //Ans:1,2,3
        int[] l1 = {1,2,4};
        int[] l2 = {1,3,4};        
        var result = MergeTwoLists(GenNodeList(l1), GenNodeList(l2));      
        PrintListNode(result);
    }

    @Test
    public void MergeTwoSortedListsCase2(){
        //Ans:1,2,3
        int[] l1 = {};
        int[] l2 = {};        
        var result = MergeTwoLists(GenNodeList(l1), GenNodeList(l2));      
        PrintListNode(result);
    }

    @Test
    public void MergeTwoSortedListsCase3(){
        //Ans:1,2,3
        int[] l1 = {};
        int[] l2 = {0};        
        var result = MergeTwoLists(GenNodeList(l1), GenNodeList(l2));      
        PrintListNode(result);
    }


    @Test
    public void MergeTwoSortedListsCase4(){
        int[] l1 = {2};
        int[] l2 = {1};        
        var result = MergeTwoLists(GenNodeList(l1), GenNodeList(l2));      
        PrintListNode(result);
    }

    @Test
    public void MergeTwoSortedListsCase5(){
        int[] l1 = {5};
        int[] l2 = {1,2,4};        
        var result = MergeTwoLists(GenNodeList(l1), GenNodeList(l2));      
        PrintListNode(result);
    }

    @Test
    public void MergeTwoSortedListsCase6(){
        int[] l1 = {-9,3};
        int[] l2 = {5,7};        
        var result = mergeTwoListsIteration(GenNodeList(l1), GenNodeList(l2));      
        PrintListNode(result);
    }

    // 一般寫法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
    
        ListNode result = new ListNode(0);
        ListNode cur = result;

        // Result Node : cur
        // 比較兩個List. 誰小先拿誰然後往下走.

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        // 剩餘Append
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
    
        // 第一個是0
        return result.next;
    }   

    // 迭代寫法
    public ListNode mergeTwoListsIteration(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;       
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsIteration(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsIteration(l1, l2.next);
            return l2;
        }
    }

    // Wrong Answer (原先想法)
    public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        
        var outerList = new ListNode();
        var innerList = new ListNode();
        int l1NodeCount = 0;
        int l2NodeCount = 0;
  
        // Step1: Count Total Node
        var tmp = new ListNode();
        tmp = l1;
        while(tmp!=null){         
            tmp = tmp.next;
            l1NodeCount ++;
        }

        tmp = l2;
        while(tmp!=null){         
            tmp = tmp.next;
            l2NodeCount ++;
        }

        // Step2 Special Case
        if(l1NodeCount ==0 && l2NodeCount ==0)
            return null; 

        if(l1NodeCount !=0 && l2NodeCount ==0)
            return l1;

        if(l1NodeCount ==0 && l2NodeCount !=0)
            return l2;    

        if(l1NodeCount ==1  && l2NodeCount==1){

            if(l1.val>=l2.val){
                l2.next = l1;
                return l2;
            }else{
                l1.next = l2;
                return l1;
            }

        }
        
        // Outer is the smallest list
        if(l1NodeCount>l2NodeCount){
            outerList = l2;
            innerList = l1;
        }else{
            outerList = l1;
            innerList = l2;
        }
        
        var innerHead = new ListNode();
        // Reset Point Use
        innerHead = innerList;

        // Step4: Merge
        while(outerList != null){     
            
            int checkIndex = 0;
            int innerLoopCnt = 1;
            
            innerList = innerHead;

            // Check Index
            while(innerList!=null){

                // Equal
                if(outerList.val == innerList.val){
                 
                    var node = new ListNode();
                    node.val = outerList.val;

                    node.next = innerList.next;
                    innerList.next = node;

                    innerLoopCnt = -1;
                    break;
                }

                if(outerList.val >= innerList.val){
                    checkIndex = innerLoopCnt;
                }
          
                innerList = innerList.next;                   
                innerLoopCnt ++; 
            }

            innerList = innerHead;

            if(checkIndex==0){                
                var node = new ListNode();
                node.val = outerList.val;
                node.next = innerList;
                innerLoopCnt = -1;
                innerHead = node;
            }

            innerLoopCnt = innerLoopCnt==-1? -1:1;
            // Insert
            if(innerLoopCnt!=-1) 
            while(innerList!=null){            
                
                if(innerLoopCnt+1 == checkIndex){

                    var node = new ListNode();
                    node.val = outerList.val;

                    if(outerList.val >= innerList.next.val){
                        node.next = innerList.next.next;
                        innerList.next.next = node;
                    }else{
                        node.next = innerList.next;
                        innerList.next = node;
                    }

                }
                innerList = innerList.next;                       
                innerLoopCnt ++; 
            }
          

            outerList = outerList.next;
        }   

        return innerHead;
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



