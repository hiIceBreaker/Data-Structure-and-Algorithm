package huixinquan.Exception;

public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException(String err){
        super(err);
    }
}
