package huixinquan.DataStructure.classical;

public class EightQueen {
    static boolean[][] hh=new boolean[8][8];//8*8棋盘
    static int count=0;//已经放上的皇后数
    static int num=0;//拜访方式的总数
    public boolean tj1(int line){//条件一，判断此列是否有摆放皇后
        for(int i=0;i<8;i++){
            if(hh[i][line]==true){
                return false;
            }
        }
        return true;
    }
    public boolean tj2(int k,int m){//条件二，判断对角线是否有摆放皇后
        int i,j;
        for(i=k,j=m;i<8&&j<8;i++,j++){
            if(hh[i][j]==true){
                return false;
            }
        }
        for(i=k,j=m;i>=0&&j>=0;i--,j--){
            if(hh[i][j]==true){
                return false;
            }
        }
        for(i=k,j=m;i>=0&&j<8;i--,j++){
            if(hh[i][j]==true){
                return false;
            }
        }
        for(i=k,j=m;i<8&&j>=0;i++,j--){
            if(hh[i][j]==true){
                return false;
            }
        }
        return true;
    }

    //主要的递归实现方法
    public void mk(int line){
        if(line==8) return;//超过8行则退出
        for(int i=0;i<8;i++){
            if(tj1(i)&&tj2(line,i)){
                hh[line][i]=true;
                count++;
                if(count==8){
                    System.out.println("\r\n");
                    pr();//摆放皇后8个则打印结果
                    hh[line][i]=false;//再次寻找其他情况
                    count--;
                    continue;
                }
                mk(line+1);//递归
                hh[line][i]=false;
                count--;
            }
        }
        return;
    }

    private void pr() {//打印满足条件的摆放方法
        num++;
        System.out.println("<<<<<<"+num+">>>>>>>>>>>");
        for(int i=0;i<8;i++){
            System.out.println();
            for(int j=0;j<8;j++){
                if(hh[i][j]==true){
                    System.out.print("x");
                }
                else{
                    System.out.print("o");
                }
            }
        }
    }

    public static void main(String[] args) {
        new EightQueen().mk(0);
        System.out.println("\r\n\r\nnum = "+num);
    }
}
