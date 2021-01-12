package huixinquan.DataStructure.Graph;

public class Vtime {
    private int ve;//最早发生时间
    private int vl;//最迟发生时间

    //构造方法
    public Vtime() {
        this(0,Integer.MAX_VALUE);
    }

    public Vtime(int ve, int vl) {
        this.ve=ve;
        this.vl=vl;
    }
    //get&set method

    public int getVe() {
        return ve;
    }

    public void setVe(int t) {
        this.ve = t;
    }

    public int getVl() {
        return vl;
    }

    public void setVl(int t) {
        this.vl = t;
    }
}
