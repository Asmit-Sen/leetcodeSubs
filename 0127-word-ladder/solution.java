class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int cnt = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
            // instead of doing a level wise bfs, store a pair <String, steps> and 
            // increment stepswhenever a word present in the disctionary is visited
                String word = q.poll();

                for (int i = 0; i < word.length(); i++) {
                    char[] str = word.toCharArray();
                    char originalChar = str[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        str[i] = c;
                        String newWord = new String(str);

                        if (newWord.equals(endWord)) return cnt + 1;

                        if (set.contains(newWord)) {
                            q.offer(newWord);
                            set.remove(newWord);  // avoid revisiting
                        }
                    }
                    str[i] = originalChar;
                }
            }
            cnt++;
        }

        return 0;
    }
}

