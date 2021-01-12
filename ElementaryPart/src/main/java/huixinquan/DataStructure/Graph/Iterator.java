package huixinquan.DataStructure.Graph;

public interface Iterator {
    //1.移动到第一个元素
    public void first();
    //2.移动到下一个元素
    public void next();
    //3.检查迭代器中是否还有剩余的元素
    public boolean isDone();
    //4.返回当前元素
    public Object currentItem();

}
