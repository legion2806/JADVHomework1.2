import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args)throws ExecutionException, InterruptedException {

        Callable<Integer> myCallable1 = new MyCallable("Поток 1");
        Callable<Integer> myCallable2 = new MyCallable("Поток 2");
        Callable<Integer> myCallable3 = new MyCallable("Поток 3");
        Callable<Integer> myCallable4 = new MyCallable("Поток 4");

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        ArrayList tasks = new ArrayList();
        tasks.add(myCallable1);
        tasks.add(myCallable2);
        tasks.add(myCallable3);
        tasks.add(myCallable4);

        ArrayList oneTask = new ArrayList();
        tasks.add(myCallable1);

        threadPool.invokeAll(tasks);

        threadPool.invokeAny(oneTask);

        threadPool.shutdown();

    }
}
