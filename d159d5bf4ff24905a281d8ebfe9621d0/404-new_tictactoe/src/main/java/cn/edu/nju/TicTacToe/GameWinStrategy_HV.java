package cn.edu.nju.TicTacToe;
/**
 * 横竖方式获胜对应的类
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HV {
	/**
	 * 自行实现检测获胜的方法
	 * @param cells  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] cells)
	{
		int flag=0;
		int n=cells.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(cells[i][j]!='_'){
					if(i+2<n){
						if(cells[i][j]==cells[i+1][j]&&cells[i][j]==cells[i+2][j]&&cells[i][j]=='X'){
							return Result.X_WIN;
						}
						if(cells[i][j]==cells[i+1][j]&&cells[i][j]==cells[i+2][j]&&cells[i][j]=='O'){
							return Result.O_WIN;
						}
					}
					if(j+2<n){
						if(cells[i][j]==cells[i][j+1]&&cells[i][j]==cells[i][j+2]&&cells[i][j]=='X'){
							return Result.X_WIN;
						}
						if(cells[i][j]==cells[i][j+1]&&cells[i][j]==cells[i][j+2]&&cells[i][j]=='O'){
							return Result.O_WIN;
						}
					}
				}
				else{
					flag=1;
				}
			}
		}
		if(flag==0) {
			return Result.DRAW;
		}else{
			return Result.GAMING;
		}
	}
}