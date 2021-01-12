package huixinquan.DataStructure.Tree;

import huixinquan.DataStructure.Graph.Iterator;

public interface BinTree {
    //1.返回树的规模
    public int getSize();
    //2.判断树是否为空
    public boolean isEmpty();
    //3.返回根结点引用
    public BinTreeNode getRoot();
    //4.获取树的高度
    public int getHeight();
    //5.在数中查找元素e，返回其所在结点
    public BinTreeNode find(Object e);
    //6.先序遍历二叉树
    public Iterator preOrder();
    //7.中序遍历二叉树
    public Iterator inOrder();
    //8.后序遍历二叉树
    public Iterator postOrder();
    //9.按层遍历二叉树
    public Iterator levelOrder();
}
