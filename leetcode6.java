class leetcode6 {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        Character[][] mat = new Character[numRows][s.length()];
        int ctr = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(i%2 == 0 && ctr < s.length()){
                for(int j = 0;j<numRows;j++)
                {
                    if(ctr < s.length())
                        mat[j][i] = s.charAt(ctr++);
                }
            }else{
                for(int j = numRows-2;j>0;j--){
                    if(ctr < s.length())
                        mat[j][i] = s.charAt(ctr++);
                }
            }
        }

        String res = "";
        for(int i = 0;i<numRows;i++){
            for(int j = 0;j<s.length();j++){
                if(mat[i][j] != null)
                    res += mat[i][j];
            }
        }

        return res;
    }
}