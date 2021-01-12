package huixinquan.DataStructure.Graph;

import huixinquan.Exception.InvalidNodeException;
import huixinquan.Exception.OutOfBoundaryException;

public interface LinkedList {

    //1.查询链接表当前的规模
    public int getSize();
    //2.判断链接表是否为空
    public boolean isEmpty();
    //3.返回第一个结点
    public Node first()throws OutOfBoundaryException;
    //4.返回最后一个结点
    public Node last()throws OutOfBoundaryException;
    //5.返回p之后的结点
    public Node getNext(Node p)throws InvalidNodeException,OutOfBoundaryException;
    //6.返回p之前的结点
    public Node getPre(Node p)throws InvalidNodeException,OutOfBoundaryException;
    //7.将e作为第一个元素插入链接表，并返回e所在结点
    public Node insertFirst(Object e);
    //8.将e作为最后一个元素插入列表，并返回e所在结点
    public Node insertLast(Object e);
    //9.将e插入至p之后的位置，并返回e所在结点
    public Node insertAfter(Node p,Object e)throws InvalidNodeException;
    //10.将e插入至p之前的位置，并返回e所在结点
    public Node insertBefore(Node p,Object e)throws InvalidNodeException;
    //11.删除给定位置处的元素，并返回之
    public Object remove(Node p)throws InvalidNodeException;
    //12.删除首元素，并返回之
    public Object removeFirst()throws OutOfBoundaryException;
    //13.删除末元素，并返回之
    public Object removeLast()throws OutOfBoundaryException;
    //14.将处于给定位置的元素替换为新元素，并返回被替换的元素
    public Object replace(Node p,Object e)throws InvalidNodeException;
    //15.元素迭代器
    public Iterator elements();

}
