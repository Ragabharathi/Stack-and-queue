Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
  
Example 2:


Input: heights = [2,4]
Output: 4
  
  public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] hs = new int[heights.length + 2];
        
        for(int i=1; i<=heights.length; i++){
            hs[i] = heights[i-1];
        }
   
        int max = 0;
        
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<hs.length; i++){
            
            while(!s.empty() && hs[i] < hs[s.peek()]){
                int x = s.pop();
                int h = hs[x];
                int area = h * (i - s.peek() - 1);
                if(area > max) max = area;
            }
            
            s.push(i);
        }
        return max;
    }
}
