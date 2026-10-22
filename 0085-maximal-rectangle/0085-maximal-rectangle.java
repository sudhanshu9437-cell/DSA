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
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int x = matrix[0].length;
        int max = 0;
        int height[] = new int[x];
        for(int i = 0; i<n; i++){
            for(int j=0; j<x; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }
                else{
                    height[j] = 0;
                }
            }
            int ans = largestRectangleArea(height);
            max = Math.max(max, ans);
        }
        return max;
    }
}