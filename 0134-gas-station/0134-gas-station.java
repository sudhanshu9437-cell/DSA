class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int a = 0;
        int b = 0;
        for(int i=0; i<n; i++){
            a = a + gas[i];
            b = b + cost[i];
        }
        if(a<b) return -1;

        int start = 0;
        int currGas = 0;
        for(int i=0; i<n; i++){
            currGas = currGas + gas[i] - cost[i];
            if(currGas<0){
                start = i+1;
                currGas = 0;
            }
        }
        return start;
    }
}