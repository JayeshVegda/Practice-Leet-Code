public class Solution 
{
    public  static String reversePrefix(String word, char ch) {
        int n = word.length();
        StringBuffer rev = new StringBuffer();
        int pivot = 0;

        for(int i = 0; i<n; i++){
            char curr = word.charAt(i);
            if(curr == ch){
                pivot = i;
                break;
            }
        }


        for(int i = pivot; i>=0; i--){
             rev.append(word.charAt(i));
        }
        for(int last=pivot+1; last<n; last++){
            rev.append(word.charAt(last));
        }


        return rev.toString();
    }

    public static void main(String[] args) 
    {
        String s = "abcdefd";
        char tar = 'd';
        System.out.println(reversePrefix(s, tar));

    }
}