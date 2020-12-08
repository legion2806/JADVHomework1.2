import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer call() throws Exception {
        int i = 0;
        try {
            while (i < 10) {
                System.out.printf("Я " + getName() + ". Всем привет!\n");
                i++;
                Thread.sleep(2500);
            }
        } catch(InterruptedException e){

        } finally{
            System.out.printf(getName() + " завершён, число исполнений - " + i + "\n");
        }
        return i;
    }
}
