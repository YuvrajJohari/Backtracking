public class backtrack3{
    public static boolean isSafe(char board[][],int row ,int col){
        //vertically up- no queen in vertically up direc
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){          
                return false;
            }

        }
        //no queen in diogonal left
        for (int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--){
            if(board[i][j]=='Q'){
              return false;
            }
        }
        //no queen in diogonal right
        for(int i=row-1, j=col+1;i>=0 &&j<board.length;i--,j++){
            if (board[i][j]=='Q'){
                return false;
            }
            
        }
        return true;
    }
    public static void nqueens(char board[][] ,int row){
        //basecase
        if (row==board.length){
            printboard(board);
            return;

        }

        for(int j=0;j<board.length;j++){
            if (isSafe(board, row,j )){
            
            board[row][j]='Q';
            nqueens(board, row+1);
            board[row][j]='.';
            }
        }
    }
    public static void printboard( char board[][]){
        System.out.println("____________chess board_____________");
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String args[]){
        int n=4;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        nqueens(board, 0);
    }
}