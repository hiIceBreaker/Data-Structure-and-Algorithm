package huixinquan.DataStructure.classical;

public class Bisection {
    public static void main(String[] args) {
        int [] iArray={4,12,23,33,45,53,65,78,88,90};
        //要查找的值
        int seek=33;
        //类似于指针的东西
        int index=0;
        //查找起始下标
        int start=0;
        //查找结束下标
        int end=iArray.length-1;
        //计数器
        int count=0;

        while (true){
            count++;
            //初始化数组中间值的下标
            //原来为index=(start+end)/2;当start+end值超过了最大的正int值的时候，
            // index会变成负值，这个时候就会抛出异常，故改为这样
            index=start+((end-start)/2);
            if(iArray[index]<seek){
                start=index;
            }
            else if(iArray[index]<seek){
                end=index;
            }
            else{
                break;
            }
        }
        System.out.println("二分法查找，需要比较的次数:"+count);
    }
}
