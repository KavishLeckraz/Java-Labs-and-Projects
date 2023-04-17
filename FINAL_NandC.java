
public class FINAL_NandC {
	
	public static void main(String[] args) 
	{
		char character = 'X';
		char [][] a = new char[3][3];
		a [0][0] = 'X';
		a [0][1] = 'X';
		a [0][2] = 'X';
		a [1][0] = 'O';
		a [1][1] = 'O';
		a [1][2] = 'X';
		a [2][0] = 'O';
		a [2][1] = 'X';
		a [2][2] = 'o';
		
		char [][] odd = new char[3][2];
		odd [0][0] = 'X';
		odd [0][1] = 'O';
		odd [1][0] = 'O';
		odd [1][1] = 'X';
		odd [2][0] = 'X';
		odd [2][1] = 'X';
		System.out.println(CountGameBoard(a, character));
		System.out.println(ValidGameBoard(a));
		System.out.println(CountInvalidCharacters(a));
		char [][] b = new char[3][3];
		b [0][0] = 'X';
		b [0][1] = 'X';
		b [0][2] = 'O';
		b [1][0] = 'O';
		b [1][1] = 'O';
		b [1][2] = 'X';
		b [2][0] = 'X';
		b [2][1] = 'O';
		b [2][2] = 'X';
		System.out.println(gameIsADraw(b));
		
	}
	public static boolean ValidGameCharacter(char c) {
		if(c == 'X' || c == 'O' || c == '.') {
			return true;
		}else {
			return false;
		}
	}
	public static int CountInvalidCharacters(char b [][]) {
		
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b.length; j++) {
				if(b[i][j] != 'X' && b[i][j] != 'O' && b[i][j] != '.' && b[i][j] != ' ') {
					return -2;
				}
			}
		}
		return 0;
	}
	public static int CountGameBoard(char b[][], char c) {
		
		if(ValidGameCharacter(c) == false || b.length != b[0].length || b == null || b.length * b[0].length != 9) 
		{
			return -1;
		}
		
		if(CountInvalidCharacters(b) == -2) {
			return -2;
		}
		
		
		if(ValidGameCharacter(c) == true) 
		{
			int count = 0;
			
			for(int i = 0; i < b.length; i++) {
				for(int j = 0; j < b.length; j++) {
					if(b[i][j] == c) {
						count++;
					}
				}
			}
			return count;
		}else 
			return -1;	
	}
	public static boolean ValidGameBoard(char board[][]) {
		
		if(board.length != 9 || board == null) {
			return false;
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] != 'X' && board[i][j] != 'O' && board[i][j] != '.' && board[i][j] != ' ') {
					return false;
				}
			}
		}
		
		int Xcount = 0, Ocount = 0; 
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if (board[i][j] == 'X') 
	            { 
	                Xcount++; 
	            } 
	            if (board[i][j] == 'O') 
	            { 
	                Ocount++; 
	            }
			}
		}
		
		if(Xcount == Ocount || Xcount == Ocount + 1) {
			return true;
		}else 
			return false;
	}
	/*public static char WhoHasWonXO(char board[][]) {
		
		if(board.length * board[0].length != 9 || board == null || CountInvalidCharacters(board) > 0) {
			return 'E';
		}
		if(CheckWin(board, 'X') || CheckWin(board, 'O') || CheckWin(board, '.')) {
			return ' ';
		}
		if(gameIsADraw(board) == true) {
			return 'D';
		}
		
	}*/
	public static boolean CheckWin(char[][] board, char c) {
		    for (int i = 0; i < 3; i++) {
		        if (board[i][0] == c && board[i][1] == c && board[i][0] == c)
		            return true;
		        }
		    for (int j = 0; j < 3; j++) {
		        if (board[0][j] == c && board[1][j] == c && board[0][j] == c) 
		            return true;
		        }
		    if (board[0][0] == c && board[1][1] == c && board[0][0] == c)
		        return true;

		    if (board[0][2] == c && board[1][1] == c && board[2][0] == c)
		        return true;

		    return false;
		}
	public static boolean gameIsADraw(char board[][]){
		   for(int i = 0; i <= 9; i++){
			   if(!board[i].equals(' ') && CheckWin(board, 'X') == false || !board[i].equals(' ') && CheckWin(board, 'O') == false){
				   break;
		    }else if(i == 9) return true;
		 }
		   return false; 
	}
}	