package huixinquan.DataStructure.Tree;

import huixinquan.DataStructure.Graph.Iterator;
import huixinquan.DataStructure.Graph.LinkedList;
import huixinquan.DataStructure.Graph.LinkedListDLNode;
import huixinquan.DataStructure.Graph.Node;
import huixinquan.strategy.DefaultStrategy;
import huixinquan.strategy.Strategy;

public class BSTree extends BinaryTreeLinked implements SearchTable {
    protected BinTreeNode startBN;//在AVL树中重新平衡的起始结点
    //构造方法
    public BSTree(){this(new DefaultStrategy());}

    public BSTree(Strategy strategy) {
        this.root=null;
        this.strategy=strategy;
        startBN=null;
    }

    @Override//查询查找表当前的规模
    public int getSize() {
        return root==null?0:root.getSize();
    }

    @Override//判断查找表是否为空
    public boolean isEmpty() {
        return getSize()==0;
    }

    @Override//返回查找表中与元素ele关键字相同的元素位置，否则返回null
    public Node search(Object ele) {
        return binTsearch(root,ele);
    }

    private Node binTsearch(BinTreeNode rt, Object ele) {
        while (rt!=null){
            switch (strategy.compare(ele,rt.getData())){
                case 0:return rt;//等于
                case -1:rt=rt.getLChild();break;//小于
                default:rt=rt.getRChild();//大于
            }
        }
        return null;
    }

    @Override//返回所有关键字与元素ele相同的元素的位置
    public Iterator searchAll(Object ele) {
        LinkedList list=new LinkedListDLNode();
        binTSearchAll(root,ele,list);
        return list.elements();
    }

    private void binTSearchAll(BinTreeNode rt, Object ele, LinkedList list) {
        if(rt==null) return;
        int comp=strategy.compare(ele,rt.getData());
        if(comp<=0) binTSearchAll(rt.getLChild(),ele,list);
        if(comp==0) list.insertLast(rt);
        if(comp>=0) binTSearchAll(rt.getRChild(),ele,list);
    }

    @Override//按关键字插入元素ele
    public void insert(Object ele) {
        BinTreeNode p=null;
        BinTreeNode current=root;
        while(current!=null){//找到待插入位置
            p=current;
            if(strategy.compare(ele,current.getData())<0)
                current=current.getLChild();
            else
                current=current.getRChild();
        }
        startBN=p;//待平衡出发点
        if(p==null)
            root=new BinTreeNode(ele);//树为空
        else if(strategy.compare(ele,p.getData())<0)
            p.setLChild(new BinTreeNode(ele));
        else
            p.setRChild(new BinTreeNode(ele));
    }

    @Override//若查找表中存在与元素ele关键字相同元素，则删除一个并返回，否则返回null
    public Object remove(Object ele) {
        BinTreeNode v= (BinTreeNode) binTsearch(root,ele);
        if(v==null) return null; //查找失败
        BinTreeNode del=null;//待删结点
        BinTreeNode subT=null;//del的子树
        if(!v.hasLChild()||!v.hasRChild())//确定待删结点
            del=v;
        else{
            del=getPredecessor(v);
            Object old=v.getData();
            v.setData(del.getData());
            del.setData(old);
        }
        startBN=del.getParent();//待平衡出发点
        //此时待删结点只有左子树或右子树
        if(del.hasLChild())
            subT=del.getLChild();
        else
            subT=del.getRChild();
        if(del==root){//若待删结点为根
            if(subT!=null) subT.sever();
            root=subT;
        }else{
            if(subT!=null){
                //del为非叶子结点
                if(del.isLChild()) del.getParent().setLChild(subT);
                else del.getParent().setRChild(subT);
            }
            else
                //del为叶子结点
                del.sever();
        }
        return del.getData();
    }


    private Node max(BinTreeNode v) {
        if(v!=null)
            while(v.hasRChild()) { v=v.getRChild();}
        return v;
    }

    //返回结点v在中序遍历序列中的前驱结点
    private BinTreeNode getPredecessor(BinTreeNode v) {
        if(v==null) return null;
        if(v.hasLChild()) return (BinTreeNode) max(v.getLChild());
        while (v.isLChild()) v=v.getParent();
        return v.getParent();
    }


}
