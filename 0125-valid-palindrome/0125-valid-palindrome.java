class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end=s.length() - 1;
      
        while(start<end){
          char a = s.charAt(start);
          char b = s.charAt(end);
          if(!((a>='A' && a<= 'Z') || (a>='a' && a<='z') || (a>='0' && a<='9'))){
            start++;
            continue;
          }
          if(!((b>='A' && b<= 'Z') || (b>='a' && b<='z') || (b>='0' && b<='9'))){
            end--;
            continue;
          }
          if(a==b || Character.toLowerCase(a) == Character.toLowerCase(b)){
            start++;
            end--;
          }
          else{
            return false;
          }
        }
        return true;
    }
}