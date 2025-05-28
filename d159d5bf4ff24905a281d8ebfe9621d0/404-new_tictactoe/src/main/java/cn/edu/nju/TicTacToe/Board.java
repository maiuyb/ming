package cn.edu.nju.TicTacToe;
public class Board {
	/**
	 * 成员变量的初始化代码请修改，请灵活选择初始化方式
	 * 必要时可添加成员变量
	 */
	protected char[][] cells;
	protected GameChessStrategy chessStrategy;
	protected GameWinStrategy_HVD winStrategy;
	protected Player player = Player.X;
	protected GameWinStrategy_HV winStrategy2;
	/**
	 * 请修改构造方法，并添加合适的构造方法
	 */
	public Board(int size){
		cells = new char[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				cells[i][j] = '_';
			}
		}
		
		chessStrategy = new GameChessStrategy();
		winStrategy = new GameWinStrategy_HVD();
		winStrategy2 = new GameWinStrategy_HV();
	}
	
	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy_HVD winStrategy,GameWinStrategy_HV winStrategy2){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		
		this.chessStrategy = chessStrategy;
		this.winStrategy = winStrategy;
		this.winStrategy2= winStrategy2;
	}

	/**
	 * @param move 下棋的位置
	 * @return 落棋之后的结果
	 */
	public Result nextMove00(String move) {
		chessStrategy.putChess(cells, nextPlay(), move);
		return winStrategy.check(cells);
	}
	public Result nextMove01(String move) {
		chessStrategy.putChess(cells, nextPlay(), move );
		return winStrategy2.check(cells);
	}
	public Result nextMove10(String move) {

		chessStrategy.putChess(cells, nextPlay(), move );
		return winStrategy.check(cells);
	}
	public Result nextMove11(String move) {

		chessStrategy.putChess(cells, nextPlay(), move);
		return winStrategy2.check(cells);
	}
	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}
	
	/**
	 * 棋盘的输出方法，根据需要进行修改
	 */
	public void print(int size){
		switch(size) {
			case 3:
			System.out.println("  A B C");
			break;
			case 4:
				System.out.println("  A B C D");
				break;case 5:
				System.out.println("  A B C D E");
				break;case 6:
				System.out.println("  A B C D E F");
				break;case 7:
				System.out.println("  A B C D E F G");
				break;case 8:
				System.out.println("  A B C D E F G H");
				break;case 9:
				System.out.println("  A B C D E F G H I");
				break;
		}
		for(int i=0 ;i<size; i++){
			System.out.print(i+1);
			for(int j=0; j<size; j++){
				System.out.print(" "+cells[i][j]);
			}
			System.out.println();
		}
	}
}