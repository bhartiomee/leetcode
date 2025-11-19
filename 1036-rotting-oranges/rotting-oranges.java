class Solution {
    int minutes=0;
    int fresh=0;
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
       
        Queue<int[]> que=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    que.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0)return 0;
        bfs(que,grid,n,m);
        return (fresh==0)?minutes:-1;
    }

    private void bfs(Queue<int[]> que,int[][] grid,int n,int m){
        while(!que.isEmpty()){ 
            int size=que.size();
            boolean rottedAny = false;

            for(int i=0;i<size;i++){
                int[] node=que.poll();
                for(int[] dir:dirs){
                    int newRow=dir[0]+node[0];
                    int newCol=dir[1]+node[1];

                    if(newRow>=0 && newRow<n && newCol>=0 
                    && newCol<m && grid[newRow][newCol]==1){
                        fresh--;
                        grid[newRow][newCol]=2;
                        rottedAny=true;
                        que.add(new int[]{newRow,newCol});
                    }

                }
            }
            if(rottedAny)minutes++;
        }
        return;
       
    }
}