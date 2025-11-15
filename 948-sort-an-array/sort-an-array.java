class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        mergeSort(nums,0,n-1);
        return nums;
    }

    private void mergeSort(int[] nums,int left,int right){
        if(left>=right)return;
        
            int mid=(right+left)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(left,mid,right,nums);
        
    }

    private void merge(int left,int mid,int right,int[] nums){
        int i=left;
        int j=mid+1;
        List<Integer> tmp=new ArrayList<>();

        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                tmp.add(nums[i]);
                i++;
            }else{
                tmp.add(nums[j]);
                j++;
            }
        }

        while(i<=mid){
            tmp.add(nums[i]);
            i++;
        }
        while(j<=right){
            tmp.add(nums[j]);
            j++;
        }

        for(int k=left;k<=right;k++){
            nums[k]=tmp.get(k-left);
        }

    }
}