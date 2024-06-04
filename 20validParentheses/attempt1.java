import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character a : s.toCharArray()) {
            // open bracket
            if (a == '{' | a == '(' || a == '[') {
                stack.addFirst(a);
            } else // closed
            {
                Character removed;
                try {
                    removed = stack.removeFirst();
                } catch (Exception e) {
                    return false;
                }
                switch (a) {
                    case '}':
                        if (removed != '{'){
                            return false;
                        }
                        break;
                    case ')':
                        if (removed != '(')
                        {
                            return false;
                        }
                        break;
                    case ']':
                        if (removed != '[')
                        {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        if (stack.size() > 0)
        {
            return false;
        }
        return true;
    }
}