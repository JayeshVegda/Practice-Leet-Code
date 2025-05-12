class Pair{
    String word;
    int count;
    
    Pair(){}
    Pair(String word, int count){
        this.word = word;
        this.count = count;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // add every word in set
        HashSet<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        if(set.contains(beginWord)) set.remove(beginWord);
        if(!set.contains(endWord)) return 0;
        // impliment bfs
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Stack<Pair> stk = new Stack<>();
        while(!q.isEmpty()){
            Pair rem = q.poll();
            stk.push(rem);

            // Pair Properties
            String word = rem.word;
            int count = rem.count;

            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                String preSub = word.substring(0, i);
                String postSub = word.substring(i+1, word.length());

                for(char c = 'a'; c <= 'z'; c++)
                {
                    String newWord = preSub + c + postSub;
                    if(set.contains(newWord))
                    {
                        if(newWord.equals(endWord)) return count + 1;
                        q.add(new Pair(newWord, count + 1));
                        set.remove(newWord);
                    }
                }
            }
        }


        return 0;

    }
}