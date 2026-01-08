class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] indegree=new int[n];
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
        }

        for(int i=0;i<n;i++){
            for(int it:adj.get(i))indegree[it]++;
        }
        Queue<Integer> q=new LinkedList<>();
        int[] ans=new int[n];
        int idx=0;

        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.offer(i);
        }

        while(!q.isEmpty()){
            int node=q.poll();
            ans[idx++]=node;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)q.offer(it);
            }
        }

        return idx==n?ans:new int[]{};
        
    }
}