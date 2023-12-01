public class backtrack4{
     public static boolean isSafe(int Sudoku[][],int row,int col,int digit){
        for (int i=0;i<9;i++){
            if (Sudoku[row][i]==digit){
                return false;
            }
        }

        for (int i=0;i<9;i++){
            if (Sudoku[i][col]==digit){
                return false;

            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for (int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if (Sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
     }
    
    public static boolean SudokuSolver(int Sudoku[][],int row ,int col){
        if (row==9 && col==0){
            return true;
        }
        int nextrow=row;
        int nextcol=col+1;
        if (col+1==9){
            nextrow=row+1;
            nextcol=0;
        }
        
        if (Sudoku[row ][col]!=0){
            return SudokuSolver(Sudoku, nextrow, nextcol);
        }
        for (int i=1;i<=9;i++){
            if (isSafe( Sudoku, row ,col,i )){
                Sudoku[row][col]=i;
                 if (SudokuSolver(Sudoku, nextrow, nextcol)){
            return true;

           }
                 }
          

           }
           Sudoku[row][col]=0;
        }

    
    return false;
}
public static void printSudoku(int sudoku[][]){
    for (int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            System.out.print(sudoku[i][j]);
        }
        System.out.println();
    }
}
public static void main(String args[]){
 int sudoku[][]=   
 { { 0,0,8,0,0,0,0,0,0}, 
{4,9,0,1,5,7,0,0,2},
{0,0,3,0,0,4,1,9,0},
{1,8,5,0,6,0,0,2,0}, 
{0,0,0,0,2,0,0,6,0},
{9,6,0,4,0,5,3,0,0},
{0,3,0,0,7,2,0,0,4}, 
{0,4,9,0,3,0,0,5,7}, 
{8,2,7,0,0,9,0,1,3} };

if (SudokuSolver(sudoku,0,0)){
    System.out.println("Solution exists");
    printSudoku(sudoku);

}
else {
    System.out.println("solution doesnt exist");
}
}
}
