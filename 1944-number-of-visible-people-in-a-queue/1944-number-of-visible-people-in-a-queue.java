// class Solution {
//     public int[] canSeePersonsCount(int[] heights) {
//         int n = heights.length;
//         int arr[] = new int[n];
//         for(int i = 0; i<n-1; i++){
//             Stack <Integer> st = new Stack<>();
//             for(int j = i+1; j<n; j++){
//                 if(st.size() == 0) st.push(heights[j]);

//                 else{
//                     if(st.peek() < heights[j]) st.push(heights[j]);
//                 }

//                 if(st.peek() > heights[i]) break;
//             }
//             int k = st.size();
//             arr[i] = ;
//         }
//         arr[n-1] = 0;
//         return arr;

//     }
// }

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int arr[] = new int[n];
        Stack <Integer> st = new Stack<>();

        for(int i = n-1; i>=0; i--){
            int count = 0;
            if(st.size() == 0){
                st.push(heights[i]);
                arr[i] = 0;
            }
            else{
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
        }
        return arr;
    }
}