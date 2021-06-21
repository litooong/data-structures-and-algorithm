package litooong.com.github.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No.22 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 参考：https://leetcode.wang/leetCode-22-Generate-Parentheses.html
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int a = 0; a < n; a++) {
                for (String left : generateParenthesis(a)) {
                    for (String right : generateParenthesis(n - 1 - a)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }
}
