import java.util.*;
class Main {
    public static boolean isSafe(char board[][],int row, int col){
        int n = board.length;
        // Check same column
        for (int i = 0; i < n; i++) {
            if (i != row && board[i][col] == 'Q') return false;
        }
        // Check same row
        for (int j = 0; j < n; j++) {
            if (j != col && board[row][j] == 'Q') return false;
        }
        // Check diagonals (all directions)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i != row || j != col) && board[i][j] == 'Q') {
                    if (Math.abs(i - row) == Math.abs(j - col)) return false;
                }
            }
        }
        return true;
    }
    
    public static int nQueen(char board[][],int row){
        //Base Case
        if(row==board.length){
            
            return 1;
        }
        int count=0;
        int n = board.length;
        // If there's already a queen in this row (pre-placed), skip placing and validate
        int existingCol = -1;
        for (int c = 0; c < n; c++) {
            if (board[row][c] == 'Q') { existingCol = c; break; }
        }
        if (existingCol != -1) {
            // If that queen conflicts with others, this branch is invalid
            if (!isSafe(board, row, existingCol)) return 0;
            return nQueen(board, row + 1);
        }

        for(int i=0;i<n;i++){
            if(board[row][i]=='.' && isSafe(board, row, i)){
                board[row][i]='Q';
                count += nQueen(board, row+1);
                board[row][i]='.';
            }
        }
        return count;
    }

    public static boolean validateInitialBoard(char board[][]) {
        int n = board.length;
        java.util.List<int[]> queens = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q') queens.add(new int[]{i,j});
            }
        }
        for (int a = 0; a < queens.size(); a++) {
            for (int b = a+1; b < queens.size(); b++) {
                int r1 = queens.get(a)[0], c1 = queens.get(a)[1];
                int r2 = queens.get(b)[0], c2 = queens.get(b)[1];
                if (r1 == r2 || c1 == c2 || Math.abs(r1-r2) == Math.abs(c1-c2)) return false;
            }
        }
        return true;
    }
    
    public static void print(char board[][]){
        System.out.println("Chess Board");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        // Read first non-empty row to determine n
        String firstLine = "";
        while (firstLine.trim().isEmpty() && sc.hasNextLine()) {
            firstLine = sc.nextLine();
        }
        if (firstLine == null || firstLine.trim().isEmpty()) {
            System.out.println("No input received.");
            sc.close();
            return;
        }
        firstLine = firstLine.replaceAll("\\s+", "");
        int n = firstLine.length();
        if (n == 0) {
            System.out.println("Invalid first row.");
            sc.close();
            return;
        }

        char board [][] = new char[n][n];
        // process first line
        for (int j = 0; j < n; j++) {
            char ch = firstLine.charAt(j);
            if (ch == '.') board[0][j] = '.';
            else if (ch == '*') board[0][j] = 'Q';
            else {
                System.out.println("Invalid character '" + ch + "' in first row. Use only '.' or '*'.");
                sc.close();
                return;
            }
        }

        // read remaining n-1 rows
        for (int i = 1; i < n; i++) {
            String line = "";
            while (line.trim().isEmpty() && sc.hasNextLine()) {
                line = sc.nextLine();
            }
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Insufficient rows provided. Expected " + n + " rows.");
                sc.close();
                return;
            }
            line = line.replaceAll("\\s+", "");
            if (line.length() != n) {
                System.out.println("Invalid input on row " + (i+1) + ". Expected " + n + " characters ('.' or '*').");
                sc.close();
                return;
            }
            for (int j = 0; j < n; j++) {
                char ch = line.charAt(j);
                if (ch == '.') board[i][j] = '.';
                else if (ch == '*') board[i][j] = 'Q';
                else {
                    System.out.println("Invalid character '" + ch + "' on row " + (i+1) + ". Use '.' or '*'.");
                    sc.close();
                    return;
                }
            }
        }
        sc.close();

        if(!validateInitialBoard(board)){
            System.out.println("Invalid initial board: two or more queens attack each other.");
            return;
        }

        int solutions = nQueen(board, 0);
        System.out.println( solutions);
    }
}