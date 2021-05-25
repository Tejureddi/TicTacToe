package ticTacToeProblem;

/**
 * 
 * @author 
 *
 */

public class TicTacToe {
	
    private String[][] board;
    private int turn;
    
    /**
     * Creates a new Tic Tac Toe board.  Instantiates the 3x3 board
     * with all dashes or other place holders.
     * 
     * initializes number of turns taken to equal 0
     */
    
    public TicTacToe() {
    	board = new String[3][3]; //All null values
        for(int row = 0; row < board.length; row++) //Row
        {
          for(int col = 0; col < board[0].length; col++)
          {
              //Fill all elements with "-";
              board[row][col] = "-";
          }
        }
      
    }
    
    /**
     * Getter method for current turn number
     * @return number of turns taken
     */
    
    public int getTurn() {
    	 return turn;
    	
    }
    
   
   /**
    * This method prints out the board array on to the console
    */
    
   public void printBoard()
   {
	   System.out.println("  0 1 2");
       int row = 0;
       for(String[] temp: board)
       {
           System.out.print(row + " ");
           for(String item: temp)
           {
               System.out.print(item + " ");
           }
           row++;
           System.out.println();
       }
       
   }
   
   /**
    * 
    * This method determines if space row, col is an available space to choose
    * @return: true if the board[row][col] is available, false otherwise
    * 
    */
   
   public boolean pickLocation(int row, int col)
   {
	   if(row < 3 && col < 3)
       {
           if(board[row][col] == "-")
           {
               return true;
           }
       }
       return false;
   }
   
   /**
    * 
    * This method places an X or O at board[row][col] based on the int turn
    */
   
   public void takeTurn(int row, int col)
   {
	   if(turn % 2 == 0)
       {
           board[row][col] = "X";
       }
       else
       {
           board[row][col] = "O";
       }
       turn++;
   }
   
   /**
    * 
    * This method checks if any row has all X's or all Os
    * @return: true if there is a row with all the same value, false otherwise. 
    */
   
   
   public boolean checkRow()
   {
	   boolean win = false;
       for(int i = 0; i < board.length; i++)
       {
           if(!board[i][0].equals("-"))
           {
               if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]))
               {
                   win = true;
               }
           }
       }
       return win;
   }
   
   
   /**
    * 
    * This method checks if any col has all X's or all Os
    * @return: true if there is a col with all the same value, false otherwise. 
    */
   
   public boolean checkCol()
   {
	   boolean win = false;
       for(int i = 0; i < board[0].length; i++)
       {
           if(!board[0][i].equals("-"))
           {
               if(board[i][0].equals(board[1][i]) && board[0][i].equals(board[2][i]))
               {
                   win = true;
               }
           }
       }
       return win;
   }
   
   
   /**
    * 
    * This method checks if either diagonal has all X's or all Os
    * @return: true if either diagonal with all the same value, false otherwise. 
    */
   
   public boolean checkDiag()
   {
	   boolean win = false;
       if(!board[0][0].equals("-")){
           if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])){
               win = true;
           }
       }
       if(!board[0][2].equals("-")){
           if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][2])){
               win = true;
           }
       }
       return win;
   }
   
   /**
    * 
    * This method checks if a player has won the game via a row, col, or diagonal
    * @return: true if the game is won, false otherwise  
    */
   public boolean checkWin()
   {
	   return checkCol() || checkRow() || checkDiag();
   }

}
