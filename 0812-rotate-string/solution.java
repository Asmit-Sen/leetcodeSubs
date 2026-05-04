class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String st = s + s;
        return st.contains(goal);
    }
}
