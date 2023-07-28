import java.util.*;
import java.util.concurrent.*;

// https://codechacha.com/ko/java-executors/ 에서의 실습내용을 보고 공부하였음.
public class Ex_chExec_Test1 {
    public static void P1() throws InterruptedException {   //다중 스레드를 이용해서 입력을 한번에 처리하기
        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        exec.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        exec.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        exec.shutdown();
        if(exec.awaitTermination(5, TimeUnit.SECONDS)) System.out.println("Complete");
        else {
            System.out.println("fail");
            exec.shutdownNow();
        }
        System.out.println("End");
    }
    public static void P2() throws InterruptedException {   //단일 스레드로 차례차례 입력처리
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        exec.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        exec.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        exec.shutdown();
        exec.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("End");
    }
    public static void P3() { //Future을 사용한 작업예약 -> 작업은 순서대로 처리되지 않아도 로그는 순서대로 처리된다.
        final int Max = Runtime.getRuntime().availableProcessors();
        final ExecutorService exec = Executors.newFixedThreadPool(Max); 
        final List<Future<String>> fut = new ArrayList<>();
        for(int i=1;i<5;i++){
            final int index = i;
            fut.add(exec.submit(() -> {
                System.out.println("insert Job" + index);
                return index + " " + Thread.currentThread().getName();
            }));
        }
        for(Future<String> futs : fut){
            String result = "";
            try {
                result = futs.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
        exec.shutdownNow();
        System.out.println("end");
    }
    public static void main(String[] args) throws InterruptedException{
        P3();
    }
}
