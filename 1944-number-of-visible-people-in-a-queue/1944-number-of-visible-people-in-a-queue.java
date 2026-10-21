class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int arr[] = new int[n];
        Stack <Integer> st = new Stack<>();
        st.push(heights[n-1]);
        arr[n-1] = 0;
        for(int i = n-2; i>=0; i--){
            int count = 0;
                if(heights[i] < st.peek()){
                    st.push(heights[i]);
                    arr[i] = 1;
                }
                else{
                    while(!st.isEmpty() && heights[i] > st.peek()){
                    int a = st.pop();
                    count++;
                    }
                    st.push(heights[i]);
                    if(st.size() == 1) arr[i] = count;
                    else arr[i] = count + 1;
                }
        }
        return arr;
    }
}