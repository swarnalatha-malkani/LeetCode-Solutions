class Solution {
    public List<Integer> partitionLabels(String s) {
       int[] lastOccurence = new int[26];
       for(int i=0;i<s.length();++i){
           lastOccurence[s.charAt(i) - 'a'] = i;


       }
       int partitionEnd=0,partitionStart=0;
       List<Integer> partitionsizes = new ArrayList<>();
       for(int i=0;i<s.length();++i){
        partitionEnd=Math.max(partitionEnd, lastOccurence[s.charAt(i)-'a']);
        if(i==partitionEnd){
          partitionsizes.add(i-partitionStart+1);
          partitionStart=i+1;
        }
       }
       return partitionsizes;
    }
}