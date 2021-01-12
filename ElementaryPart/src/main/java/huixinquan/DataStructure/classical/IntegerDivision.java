package huixinquan.DataStructure.classical;

public class IntegerDivision {
    public static void main(String[] args) {
        IntegerDivision id=new IntegerDivision(6);
        int count=id.divInteger(id.getN(),id.getN());
        System.out.println(count);
    }


    private int n;
    public IntegerDivision(int n) {
        this.n = n;
    }
    //递归求解
    public int divInteger(int n,int m){
        if(n<1||m<1){
            System.out.println("输出参数错误！");
        }else if(n==1||m==1){
            return 1;
        }else if(n<m){
            return divInteger(n,n);
        }else if(n==m){
            return divInteger(n,n-1)+1;
        }else{
            return divInteger(n,m-1)+divInteger(n-m,m);
        }
        return 0;
    }

    private int getN() {
        return n;
    }
}
