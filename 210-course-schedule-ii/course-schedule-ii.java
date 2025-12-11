class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[numCourses];
        int[] ans=new int[numCourses];

        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int []it:prerequisites){
            adj.get(it[1]).add(it[0]);
            indegree[it[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.offer(i);
        }   

        int idx=0;

        while(!q.isEmpty()){
            int node=q.poll();
            ans[idx++]=node;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)q.offer(it);
            }
        }

        return idx==numCourses?ans:new int[]{};
    
    }
}