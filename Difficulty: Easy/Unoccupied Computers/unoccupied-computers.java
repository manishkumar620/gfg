class Solution {
    public int solve(int n, String s) {

        HashSet<Character> seen = new HashSet<>();
        HashSet<Character> using = new HashSet<>();

        int reject = 0;

        for(char ch : s.toCharArray()) {

            if(!seen.contains(ch)) {

                seen.add(ch);

                if(using.size() < n) {
                    using.add(ch);
                }
                else {
                    reject++;
                }
            }
            else {
                using.remove(ch);
            }
        }

        return reject;
    }
}