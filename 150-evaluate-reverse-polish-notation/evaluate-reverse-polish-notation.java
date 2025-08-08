class Solution {
    public int evalRPN(String[] tokens) {
    
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<tokens.length;i++){

            if(tokens[i].equals("+")){
                int right=Integer.valueOf(st.pop());
                int left=Integer.valueOf(st.pop());
                int value=left+right;
                st.push(value);

            } 
            else if(tokens[i].equals("/"))
            {
                int right=Integer.valueOf(st.pop());
                int left=Integer.valueOf(st.pop());
                int value=left/right;
                st.push(value);
            }
            else if(tokens[i].equals("*")){
                int right=Integer.valueOf(st.pop());
                int left=Integer.valueOf(st.pop());
                int value=left*right;
                st.push(value);

            }
            else if(tokens[i].equals("-")){
                int right=Integer.valueOf(st.pop());
                int left=Integer.valueOf(st.pop());
                int value=left-right;
                st.push(value);

            }

            
            else{
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.peek();
    }

}