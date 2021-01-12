package huixinquan.DataStructure.classical;

public class Selection {
    public static void main(String[] args) {
        Comparable[]c={4,9,23,1,45,27,5,2};
        selectionSort(c);
        for(int i=0;i<c.length;i++){
            System.out.println("选择排序: "+c[i]);
        }
    }

    private static void selectionSort(Comparable[] data) {
        int intLength=data.length;
        for(int i=0;i<intLength-1;i++){
            int minIndex=i;
            //寻找最小值
            for(int j=i+1;j<intLength;j++){
                Comparable a=data[j];
                Comparable b=data[minIndex];
                if(a.compareTo(b)<0){
                    minIndex=j;
                }
            }
            //如有需要交换的数据
            if(minIndex!=i){
                Comparable temp=data[i];
                data[i]=data[minIndex];
                data[minIndex]=temp;
            }
        }
    }

}
