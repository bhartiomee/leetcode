class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> it:mp.entrySet()){
            pq.add(new int[]{it.getKey(),it.getValue()});

            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] ans=new int[k];
        int i=0;

        while(!pq.isEmpty()){
            ans[i]=pq.poll()[0];
            i++;
        }
        return ans;
    }
}