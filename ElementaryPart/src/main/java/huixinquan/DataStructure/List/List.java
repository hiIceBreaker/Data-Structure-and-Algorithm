package huixinquan.DataStructure.List;

import huixinquan.Exception.OutOfBoundaryException;

public interface List {
    //1.返回线性表的大小，即数据元素的个数
    public int getSize();
    //2.如果线性表为空返回true,否则返回false
    public boolean isEmpty();
    //3.判断线性表是否包含数据元素e
    public boolean contains(Object e);
    //4.返回数据元素e在线性表中的序号
    public int indexOf(Object e);
    //5.将数据元素e插入到线性表中i号位置
    public void insert(int i,Object e) throws OutOfBoundaryException;
    //6.将数据元素e插入到元素obj之前
    public boolean insertBefore(Object obj,Object e);
    //7.将数据元素e插入到元素obj之后
    public boolean insertAfter(Object obj,Object e);
    //8.删除线性表中序号为i的元素，并返回之
    public Object remove(int i) throws OutOfBoundaryException;
    //9.删除线性表中第一个与e相同的元素
    public boolean remove(Object e);
    //10.替换线性表中序号为i的数据元素为e,返回原数据元素
    public Object replace(int i,Object e) throws OutOfBoundaryException;
    //11.返回线性表中序号为i的数据元素
    public Object get(int i) throws OutOfBoundaryException;
}
