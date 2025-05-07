public class DecompressMessage {
    public static String decompressMessage(String message) {
        // 你的代码
        int right=0,left=0;
        char[] str=message.toCharArray();
        int length=str.length;
        int flag=0;
        String ans;
        for(int i=0;i<length;i++){
if(str[i]=='['){
    left=i;
}
if(str[i]==']'){
    right=i;
}
if(left!=0&&right!=0){
    flag=1;
    break;
}
        }
        if(flag==1){
            //不对，没有拼接好比如3[a2[we]],没有把a与we连起来
            int n=left-1;
            String sub1 = message.substring(0,n-1);
            String sub2 = message.substring(right+1,length-1);
            String sub3 = message.substring(left+1,right-1);
            for(int i=0;i<n;i++){
                sub1=sub1.concat(sub3);
            }
            ans=sub1.concat(sub2);
            return decompressMessage(ans);
        }else {
            return message;
        }
    }
}
