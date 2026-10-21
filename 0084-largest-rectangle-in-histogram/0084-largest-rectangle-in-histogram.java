class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int right[] = new int[n];
        Stack <Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(st.size()>0 && heights[st.peek()] >= heights[i]){
                int a = st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int left[] = new int[n];
        Stack <Integer> stl = new Stack<>();
        for(int i = 0; i<n; i++){
            while(stl.size()>0 && heights[stl.peek()] >= heights[i]){
                int a = stl.pop();
            }
            left[i] = stl.isEmpty() ? -1 : stl.peek();
            stl.push(i);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            int h = heights[i];
            int w = right[i]-left[i]-1;
            int area = w*h;
            ans = Math.max(ans, area);
        }
        return ans;
    }
}