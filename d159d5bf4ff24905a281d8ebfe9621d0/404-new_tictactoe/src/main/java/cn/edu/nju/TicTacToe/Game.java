package cn.edu.nju.TicTacToe;

import java.util.Map;

public class Game {
    /**
     * Game的接口方法，我们会通过该方法进行测试
     * @param gameMode 游戏模式,有四种可能，00,01,10,11
	 * 00：正常规则落子，横竖斜均能胜利
	 * 01：正常规则落子，横竖能胜利
	 * 10：5子模式，横竖斜均能胜利
	 * 11: 5子模式，横竖能胜利
     * @param moveStr 落子序列
     * @param size 棋盘大小，size最小为3， 最大为9
     * @return 游戏结果
     * 
     * 根据需要改写方法，参数，返回结果类型不可修改
     */
    public Result playGame(String gameMode, String moveStr, int size){
    	Board board = new Board(size);
    	String[] moves = moveStr.split(",");
    	Result res = Result.GAMING;
		if(gameMode.equals("00")){
			for(String move: moves){
				res = board.nextMove00(move);
				board.print(size);
				// 游戏结束
				if( !res.equals(Result.GAMING) )
					break;
			}
			return res;
		}
		if(gameMode.equals("01")){
			for(String move: moves){
				res = board.nextMove01(move);
				board.print(size);
				// 游戏结束
				if( !res.equals(Result.GAMING) )
					break;
			}
			return res;
		}
		if(gameMode.equals("10")){
			int x=0;
			int v=0;
			int w=0;
			for(String move: moves){
				if(w%2==0){
					x++;
				}else{
					v++;
				}
				if(x==6){
					x=0;
					String jud=moves[w-10];
					int i = jud.charAt(1) - '1';
					int j = jud.charAt(0) - 'A';
					board.cells[i][j]='_';
				}
				if(v==5){
					v=0;
					String jud=moves[w-10];
					int i = jud.charAt(1) - '1';
					int j = jud.charAt(0) - 'A';
					board.cells[i][j]='_';
				}
				res = board.nextMove10(move);
				board.print(size);
				// 游戏结束
				if( !res.equals(Result.GAMING) )
					break;
				w++;
			}
			return res;
		}
		if(gameMode.equals("11")){
			int x=0;
			int v=0;
			int w=0;
			for(String move: moves){
				if(w%2==0){
					x++;
				}else{
					v++;
				}
				if(x==6){
					x=0;
					String jud=moves[w-10];
					int i = jud.charAt(1) - '1';
					int j = jud.charAt(0) - 'A';
					board.cells[i][j]='_';
				}
				if(v==5){
					v=0;
					String jud=moves[w-10];
					int i = jud.charAt(1) - '1';
					int j = jud.charAt(0) - 'A';
					board.cells[i][j]='_';
				}
				res = board.nextMove11(move);
				board.print(size);
				// 游戏结束
				if( !res.equals(Result.GAMING) )
					break;
				w++;
			}
			return res;
		}
		return null;
    }
}