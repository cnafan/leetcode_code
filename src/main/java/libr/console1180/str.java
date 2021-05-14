package libr.console1180;

public class str {
    public int countLetters(String S) {
        int sameLength=1; // 当前连续相同字符的个数
        int res=1; // 返回结果
        // 从下标1（第2位）开始循环
        for(int i=1;i<S.length();i++){
            // 如果当前字符与前一位不同
            if(S.charAt(i)!=S.charAt(i-1)){
                // sameLength还原为1（长度为当前字符）
                sameLength=1;
            }else{
                // 如果与前字符相同，sameLength加一。
                // 这一步相当于制作等差数列
                sameLength++;
            }
            // 将sameLength加入返回结果
            res+=sameLength;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new str().countLetters("aaaaaaaaaa"));
    }
}
