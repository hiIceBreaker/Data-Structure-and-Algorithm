package huixinquan.DataStructure.Tree;

import huixinquan.DataStructure.Graph.Queue;
import huixinquan.Exception.QueueEmptyException;

public class QueueArray implements Queue {
    private static final int CAP=7;//队列默认大小
    private Object[] elements;//数据元素数组
    private int capacity;//数组的大小 elements.length
    private int front;//队首指针，指向队首
    private int rear;//队尾指针，指向队尾后一个位置

    public QueueArray() {
        this(CAP);
    }

    public QueueArray(int cap) {
        capacity=cap+1;
        elements=new Object[capacity];
        front=rear=0;
    }

    @Override//返回队列的大小
    public int getSize() {
        return (capacity-front+rear)%capacity;
    }

    @Override//判断队列是否为空
    public boolean isEmpty() {
        return front==rear;
    }

    @Override//数据元素e入队
    public void enqueue(Object e) {
        if(getSize()==capacity-1) expandSpace();
    }

    private void expandSpace() {
        Object[]a=new Object[elements.length*2];
        int i=front;
        int j=0;
        while (i!=rear){
            a[j++]=elements[i];
            i=(i+1)%capacity;
        }
        elements=a;
        capacity=elements.length;
        front=0;
        rear=j;
    }

    @Override//队首元素出队
    public Object dequeue() throws QueueEmptyException {
        if(isEmpty())
            throw new QueueEmptyException("错误:队列为空");
        Object obj=elements[front];
        elements[front]=null;
        front=(front+1)%capacity;
        return obj;
    }

}