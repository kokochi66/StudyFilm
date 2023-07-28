package src.Y2021.M12;

public class Test1220 {
    private static int a = 0;
    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();


        @Override
        public void run() {
            System.out.println("run 메소드 실행");

            threadLocal.set( (int) a );
            a *= 20;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args) throws Exception {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        a = 22;
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

/*        thread1.join(); //wait for thread 1 to terminate
    thread2.join(); //wait for thread 2 to terminate*/
    }


}
