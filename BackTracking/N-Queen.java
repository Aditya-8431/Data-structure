class Solution{
    public static boolean isSafe(char board[][],int row, int col){
        //vertically
        for(int i=row-1;i>=0;i--){ 
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //Digonaly left up
        for(int i=row-1,j=col-1;i>=0 &&j>=0 ;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //Diagonaly right up
        for(int i=row-1,j=col+1;i>=0 &&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
            
        }
        return true;
    }
    public static  nQueen(char board[][],int row){
        //Base Case
        int count=0;
        if(row==board.length){
            count++;
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(board, row, i)){
                 board[row][i]='Q';
                nQueen(board, row+1);
                board[row][i]='.';
            }
        }
        System.out.println(count);
    }
    public static void print(char board[][]){
        System.out.println("Chesh Board");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=4;
        char board [][]=new char[n][n];
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        
        
    }
}