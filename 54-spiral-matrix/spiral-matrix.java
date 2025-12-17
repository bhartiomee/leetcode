class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int top=0,
        rightCol=matrix[0].length-1,
        bottom=matrix.length-1,
        leftCol=0;

        while(top<=bottom && leftCol<=rightCol){
            //print top

            for(int j=leftCol;j<=rightCol;j++){
                ans.add(matrix[top][j]);
            }
            top++;

            //print right col
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][rightCol]);
            }
            rightCol--;

            //print bottom
            if(top<=bottom){
                for(int j=rightCol;j>=leftCol;j--){
                    ans.add(matrix[bottom][j]);
                }
            }
            bottom--;

            //print left col
            if(leftCol<=rightCol){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][leftCol]);
                }
            }
            leftCol++;
        }

        return ans;
    }
}