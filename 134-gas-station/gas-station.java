class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGas=0;
        int defc=0;
        int start=0;
        int n=gas.length;

        for(int i=0;i<n;i++){
            currGas+=gas[i]-cost[i];
            if(currGas<0){
                start=i+1;
                defc+=currGas;
                currGas=0;
            }
        }

        return (defc+currGas>=0)?start:-1;

    }
}