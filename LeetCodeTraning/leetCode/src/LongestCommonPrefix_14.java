import org.junit.Test;

public class LongestCommonPrefix_14 {

    @Test
    public void Test(){


    }
    public String longestCommonPrefixGood(String[] strs){
        if (strs == null || strs.length == 0) return "";

        // 尋找最短的字符串
        // 可用 String minStr = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).orElse("");
        // 取代((但效率很差...
        String minStr = strs[0];
        for (String str : strs) {
            if (str.length() < minStr.length()) {
                minStr = str;
            }
        }

        int length = minStr.length();
        for (int i = 0; i < length; i++) {
            char currentChar = minStr.charAt(i);

            // 比較所有字符串在 i 位置的字符
            for (String str : strs) {
                if (str.charAt(i) != currentChar) {
                    return minStr.substring(0, i);
                }
            }
        }

        return minStr;
    }

    public String longestCommonPrefix(String[] strs) {

        if(strs ==null || strs.length ==0)
            return  "";

        // 以第一個字串為基準
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // 當前字串
            String currentString = strs[i];

            // 檢查當前字串是否包含目前的前綴
            while (currentString.indexOf(prefix) != 0) {
                // 如果不包含，則縮短前綴
                prefix = prefix.substring(0, prefix.length() - 1);

                // 如果前綴縮減到空字串，則直接返回
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;

    }
}
