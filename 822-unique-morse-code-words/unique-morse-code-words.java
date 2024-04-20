class Solution {
    public int uniqueMorseRepresentations(String[] words) {
     int list_len = words.length;
          String morse[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
          String demo[] = new String[list_len];
          HashSet<String> set = new HashSet<>();
          int counter = 0;
          
          
          for(int i = 0; i<list_len; i++)
          {
              for(int j = 0; j<words[i].length(); j++)
              {
                  Character m = words[i].charAt(j);
                  int myindex = m - 'a';
                  demo[i] = demo[i] + morse[myindex]; 
              }
          }


          
            for (String element : demo) {
                set.add(element);
            }
    
          return set.size();
}
}