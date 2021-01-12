package huixinquan.DataStructure.Graph;

public class Path {
    private  int distance;//起点与终点的距离
    private Vertex start;//起点信息
    private Vertex end;//终点信息
    private LinkedList pathInfo;//起点到终点的完整路径

    public Path() {
        this(Integer.MAX_VALUE,null,null);
    }

    public Path(int distance, Vertex start, Vertex end) {
        this.distance=distance;
        this.start=start;
        this.end=end;
        pathInfo=new LinkedListDLNode();
    }

    //get&set方法

    public int getDistance() {
        return distance;
    }

    public void setDistance(int dis) {
        this.distance = dis;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex v) {
        this.start = v;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex v) {
        this.end = v;
    }

    public Iterator getPathInfo() {
        return pathInfo.elements();
    }

 /*   public void setPathInfo(LinkedList pathInfo) {
        this.pathInfo = pathInfo;
    }*/

    //清空路径信息
    public void clearPathInfo() {
        pathInfo=new LinkedListDLNode();
    }
    //添加路径信息
    public void addPathInfo(Object info){
        pathInfo.insertLast(info);
    }
}
