import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ValidParentheses_20 {
    
   @Test
   public void ValidParenthesesTest() {
     //  var s = "{[]}";    // true
     //  var s = "()[]{}";   //true
     //   var s = "([)]";     //false
     //   var s = "()";      // true
     //   var s = "([}}])";  // false
     var s = "))";
     var isVaild = ValidParentheses(s);
     Assert.assertTrue(isVaild);    
   }

   @Test
   public void ValidParenthesesIniCase() {
     // ([)] XXX
     var s = "[{[]}]";
     var isVaild = ValidParentheses_Intuition(s);
     Assert.assertTrue(isVaild);    
   } 
   
   @Test
   public void ValidParenthesesIniCase1() {
     var s = "()[]{}";
     var isVaild = ValidParentheses_Intuition(s);
     Assert.assertTrue(isVaild);    
   }
   
   @Test
   public void ValidParenthesesIniCase2() {
     var s = "([  )]";
     var isVaild = ValidParentheses_Intuition(s);
     Assert.assertFalse(isVaild);    
   }
   

   public boolean ValidParentheses(String s){

      HashMap<Character, Character> dic = new HashMap<>();
      dic.put('[', ']');
      dic.put('{', '}');
      dic.put('(', ')');

      var firstChar = s.charAt(0);

      //  非成對直接回false ||  非左括開始直接回false
      if (s.length() % 2 == 1 || !dic.containsKey(firstChar))
         return false;

      var stack = new Stack<Character>();
      stack.push(firstChar);

      int cmpFail = 0;

      for(int i=1; i<s.length(); i++){
         var charTemp = s.charAt(i);
         
         if(dic.containsKey(charTemp)){
            // 左括號 放入Stack
            stack.push(charTemp);         
         }
         else{
            // 右括號 Stack拿出比較 符合的話pop stack
            if(stack.size()==0 || cmpFail>1)
               return false;

            var ch = stack.peek();
            var cmpCh = dic.get(ch);

            if(cmpCh == charTemp){
               stack.pop();
               cmpFail = 0;
            }else{
               // 防 ([ }} ])
               cmpFail++;
            }
             
         }

      }

      return stack.size() == 0;   

   }

   // [{[]}]
   public boolean ValidParentheses_Intuition(String s) {
   
      HashMap<Character, Integer> leftBrackets = new HashMap<>();
      leftBrackets.put('{', 0);
      leftBrackets.put('[', 1);
      leftBrackets.put('(', 2);

      HashMap<Character, Integer> rightBrackets = new HashMap<>();
      rightBrackets.put('}', 0);
      rightBrackets.put(']', 1);
      rightBrackets.put(')', 2);

      var leftCharList = new ArrayList<Character>();
      var rightCharList = new ArrayList<Character>();

      // Step1:將String放入List 分左右兩邊
      for(int i=0; i<s.length();i++){
         var ch = s.charAt(i);

         if(leftBrackets.containsKey(ch)){
            leftCharList.add(ch);
            continue;
         }
         rightCharList.add(ch);
      }

      // Step2: 左右兩邊不相等直接回null
      if(leftCharList.size()!=rightCharList.size())
         return false;
 
      // Step3: 左從頭取值 {[   右從尾取值去比較 ]} 相比兩個編號是否相同
      for(int i=0; i<leftCharList.size(); i++){
         
         var lIndex = leftBrackets.get(leftCharList.get(i));
         var rIndex = rightBrackets.get(rightCharList.get(rightCharList.size()-1-i));
                  
         if(lIndex!=rIndex){

            lIndex = leftBrackets.get(leftCharList.get(i));
            rIndex = rightBrackets.get(rightCharList.get(i));

            if(lIndex!=rIndex)
               return false;           
         }
            
      }

      return true;
   }

}
