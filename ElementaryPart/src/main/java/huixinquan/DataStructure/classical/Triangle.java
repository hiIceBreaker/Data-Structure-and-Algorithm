package huixinquan.DataStructure.classical;

public class Triangle {
    /**
     * a:第k行第一个数的下标值
     * m:第k+1行第一个数的下标值
     * b:第k行最后一个数的下标值
     * n:第k+1行最后一个数的下标值
     *
     * 规律为除两侧的元素均为1以外，其余每个位置上数值都等于其左上角元素与右上角元素之和
     * 第k行有k个数
     * array[m+1]=array[a]+array[a+1];
     * array[m+2]=array[a+1]+array[a+2];
     * 即：
     * array[m+t+1]=array[a+t]+array[a+t+1];
     * t从零开始，t应该小于等于k-2 (保证 a+k-2+1=b);
     *
     * 由题已知:
     * array[a]=1;
     * array[b]=1;
     * array[m]=1;
     * array[n]=1;
     * b-a=k-1;
     * m=b+1;
     * n-m=k;
     */
    //int k;//行号
    // List list=new ArrayList((k+1)*k/2);//初始化大小

    public final static String SEPARATOR=" ";
    public final static String SEPARATOR_NUM=" ";
    public final static int LEN=6;
    public final static int SEPARATOR_LEN=3;
    public StringBuffer init(int k){
        int a,b,m,n;//下标
        int arr[]=new int[(k+1)*k/2];//初始化大小
        StringBuffer sb=new StringBuffer();

        //打印第一行
        if(k>0){
            sb.append(numSeparator(k).toString());
            sb.append(toStr(1,LEN));//此行第一个数
        }
        for(int L=1;L<k;L++){//行号循环
            a=L*(L-1)/2;//第1行的第一个数的下标值
            b=a+L-1;
            m=b+1;
            n=m+L;
            arr[a]=1;
            arr[b]=1;
            arr[m]=1;
            arr[n]=1;

            sb.append("\n");//新启一行
            //距离最左边占位符
            sb.append(numSeparator(k-L).toString());
            sb.append(toStr(arr[m],LEN)+separatorStr());//此行第一个数

            for(int t=0;t<=L-2;t++){//计算中间值
                arr[m+t+1]=arr[a+t]+arr[a+t+1];
                sb.append(toStr(arr[m+t+1],LEN)+separatorStr());
            }
            sb.append(toStr(arr[n],LEN));//此行最后一个数
        }
        return sb;
    }

    /***
     * //两个数字之间占位符长度的一半
     * @return
     */
    private String separatorStr() {
        StringBuffer sb=new StringBuffer("");
        for(int p=0;p<SEPARATOR_LEN;p++){//两个数字之间占位符长度的一半
            sb.append(SEPARATOR);
        }
        return sb.toString();
    }

    /***
     * 设定数字的长度为len
     * 不足长度的以空格补齐
     * @param x
     * @param len
     * @return
     */
    private String toStr(int x, int len) {
        StringBuffer sb=new StringBuffer("");
        String str=String.valueOf(x);
        if((str.length()<len)){
            int i=len-str.length();
            for(int k=0;k<i/2;k++){
                sb.append(Triangle.SEPARATOR_NUM);
            }
            sb.append(str);
            for(int k=i/2;k<i;k++){
                sb.append(Triangle.SEPARATOR_NUM);
            }
        }
        else{
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * (总行数-行数序号(从一开始))*两个数字之间占位长度/2
     * k行距离左边的占位符数
     * @param k
     * @return
     */
    private String numSeparator(int k) {
        StringBuffer sb=new StringBuffer("");
        for(int j=0;j<k-1;j++){
            for(int p=0;p<SEPARATOR_LEN/2;p++){//两个数字之间占位符长度的一半
                sb.append(SEPARATOR);
            }
            for(int p=0;p<LEN/2;p++){//预设数字本身长度的一半
                sb.append(SEPARATOR_NUM);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int k=20;
        if(args.length>=1){
            k=Integer.parseInt(args[0]);
        }
        Triangle t=new Triangle();
        System.out.print(t.init(k).toString());
    }
}


