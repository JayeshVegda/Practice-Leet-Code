class Solution {
    public String toGoatLatin(String str) {
        int count=0;
      StringBuilder sb=new StringBuilder();

      String[] arrOfStr = str.split(" ");

  for (int i = 0; i < arrOfStr.length; i++) {
      count++;
      if (arrOfStr[i].charAt(0)=='a'||arrOfStr[i].charAt(0)=='e'||arrOfStr[i].charAt(0)=='i'||arrOfStr[i].charAt(0)=='o'||arrOfStr[i].charAt(0)=='u' || arrOfStr[i].charAt(0)=='A'||arrOfStr[i].charAt(0)=='E'||arrOfStr[i].charAt(0)=='I'||arrOfStr[i].charAt(0)=='O'||arrOfStr[i].charAt(0)=='U') {
          sb.append(arrOfStr[i]+"ma");
      } else {
          sb.append(arrOfStr[i].substring(1)+arrOfStr[i].charAt(0)+"ma");
      }
      for (int j = 1; j <=count; j++) {
          sb.append("a");
      }
      sb.append(" ");
  }
  sb.deleteCharAt(sb.length()-1);
  return sb.toString();
    }
}