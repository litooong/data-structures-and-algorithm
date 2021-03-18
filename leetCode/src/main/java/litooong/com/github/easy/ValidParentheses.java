package litooong.com.github.easy;


import java.util.LinkedList;

/**
 * @author litooong
 * @date 2021/3/18 10:07 上午
 * No.20 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 40 '('
 * 41 ')'
 * <p>
 * 91 '['
 * 93 ']'
 * <p>
 * 123 '{'
 * 125 '}'
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList();
        char[] chars = s.toCharArray();
        // 如果是左括号，则压栈
        for (char c : chars) {
            // 如果是左括号，则压栈，是右括号，则判断栈顶元素和其是不是相配，配则弹栈
            if (c == 40 || c == 91 || c == 123) {
                stack.push(c);
            } else {
                if (stack.peek() == null) {
                    return false;
                }
                if (Math.abs(stack.peek() - c) > 2) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vps = new ValidParentheses();
        System.out.println(vps.isValid(""));
    }

}
