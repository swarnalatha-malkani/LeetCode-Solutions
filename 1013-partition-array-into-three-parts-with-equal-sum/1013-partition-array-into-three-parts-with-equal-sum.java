class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n=arr.length;
        int sum=0;
        for (int num : arr) {
            sum += num;
        }
        if(sum%3!=0) return false;
        int target = sum / 3;
        int currSum = 0;
        int count = 0;
        for(int num : arr){
          currSum+=num;
          if(currSum==target){
            count++;
            currSum=0;
          }
        
        }
      return count>=3;
    }
}
        

    
        
      
    
