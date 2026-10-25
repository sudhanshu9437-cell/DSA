class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int x = n-k+1;
        int ans[] = new int[x];
        for(int i=0; i<k; i++){
            while(dq.size()>0 && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(int i=k; i<n; i++){
            ans[i-k] = nums[dq.peekFirst()];

            while(dq.size()>0 && dq.peekFirst() <= i-k){
                dq.removeFirst();
            }
            while(dq.size()>0 && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[x-1] = nums[dq.peekFirst()];
        return ans;
    }
}