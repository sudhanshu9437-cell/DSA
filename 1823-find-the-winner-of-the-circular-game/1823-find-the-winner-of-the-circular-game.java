class Solution {
    public int findTheWinner(int n, int k) {
        if(n == 1 || n == 0) return n;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.add(i);
        }

        while(q.size()>1){
            for(int i=1; i<k; i++){
                q.add(q.remove());
            }
            q.remove();
        }
        return q.peek();
    }
}