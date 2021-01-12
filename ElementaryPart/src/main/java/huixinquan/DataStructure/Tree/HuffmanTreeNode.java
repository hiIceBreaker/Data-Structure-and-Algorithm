package huixinquan.DataStructure.Tree;

public class HuffmanTreeNode extends BinTreeNode {
    private int weight;//权值
    private String coding="";//编码

    public HuffmanTreeNode(int weight) {
        this(weight,null);
    }

    public HuffmanTreeNode(int weight,Object e) {
        super(e);
        this.weight = weight;
    }
    //改写父类方法

    @Override
    public HuffmanTreeNode getParent() {
        return (HuffmanTreeNode) super.getParent();
    }

    @Override
    public HuffmanTreeNode getLChild() {
        return (HuffmanTreeNode) super.getLChild();
    }

    @Override
    public HuffmanTreeNode getRChild() {
        return (HuffmanTreeNode) super.getRChild();
    }
    //get&set方法

    public int getWeight() {
        return weight;
    }

/*    public void setWeight(int weight) {
        this.weight = weight;
    }*/

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }
}
