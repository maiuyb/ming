public class Game {
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String s){

        int n=s.length();
        char[][] sun=new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
sun[i][j]='_';
            }
        }
        int a=0;
        while(a-1<n){
            String w=s.substring(a,a+2);
            judge(a,sun,w);
            System.out.println("  A B C");
            for(int i=0;i<3;i++){
                int y=i+1;
                System.out.print(y);
                for(int j=0;j<3;j++){
                    System.out.print(" ");
                    System.out.print(sun[i][j]);
                }
                System.out.println();
            }
            a+=3;
        }

if(Xwin(sun)){
    return Result.X_WIN;
}
if(Owin(sun)){
    return Result.O_WIN;
}
if(!Xwin(sun)&&!Owin(sun)) {
    return Result.DRAW;
}
return null;
    }
public boolean Xwin(char[][] sun){

            for(int j=0;j<3;j++){
                if(sun[j][0]==sun[j][1]&&sun[j][0]==sun[j][2]&&sun[j][0]=='X'){
                    return true;
                }
                if(sun[0][j]==sun[1][j]&&sun[0][j]==sun[2][j]&&sun[0][j]=='X'){
                    return true;
                }
            }
        if(sun[0][0]==sun[1][1]&&sun[0][0]==sun[2][2]&&sun[0][0]=='X'){
            return true;
        }
    if(sun[2][0]==sun[1][1]&&sun[2][0]==sun[0][2]&&sun[2][0]=='X'){
        return true;
    }
        return false;
}
public boolean Owin(char[][] sun){
    for(int j=0;j<3;j++){
        if(sun[j][0]==sun[j][1]&&sun[j][0]==sun[j][2]&&sun[j][0]=='O'){
            return true;
        }
        if(sun[0][j]==sun[1][j]&&sun[0][j]==sun[2][j]&&sun[0][j]=='O'){
            return true;
        }
    }
    if(sun[0][0]==sun[1][1]&&sun[0][0]==sun[2][2]&&sun[0][0]=='O'){
        return true;
    }
    if(sun[2][0]==sun[1][1]&&sun[2][0]==sun[0][2]&&sun[2][0]=='O'){
        return true;
    }
    return false;
    }

    public void judge(int a,char[][] sun,String w){
        char t=w.charAt(0);
        int v=w.charAt(1)-'1';
        int x;
        switch (t) {
            case 'A':
                x=0;
                break;
            case 'B':
                x=1;
                break;
            default:
                x=2;
        }
        if(a%2==0){//X
            sun[v][x]='X';
        }else{//O
            sun[v][x]='O';
        }
    }
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("B2,C2,C1,A3,B3,B1,A2,B2,C3,A1,A3,B3,C2,B1,B2,A2,A1,C1,C3");
        System.out.println(result);
    }
}
