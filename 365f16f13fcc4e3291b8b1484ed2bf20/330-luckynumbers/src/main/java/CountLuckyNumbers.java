public class CountLuckyNumbers {

    public static int judge(String m,int n){
        int w=1;
        while(w<=n){
            for(int i=0;i<=n-w;i++){
                String sub =m.substring(i,i+w);
                int num = Integer.parseInt(sub);
                if(num%3==0){
                    return 0;
                }
            }
            w++;
        }
        return -1;
    }
    public static int countLuckyNumbers(int L, int R) {
        // 你的代码
        int sum=0;
        for(int i=L;i<=R;i++){
            String m=i+"";
            int len=m.length();
            if(len>=3){
                sum++;
            }else {
                int en = judge(m, len);
                if (en == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

}