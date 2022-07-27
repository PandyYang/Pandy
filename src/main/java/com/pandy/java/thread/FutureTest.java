package com.pandy.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author: Pandy
 * @create: 2022/6/9
 * <p>
 * Future + CountDownLatch + 线程池
 * 分批异步执行任务 全部任务组执行完毕之后返回
 **/
public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTest futureTest = new FutureTest();
        // 假设一次请求的接口并发数最多为5
        int taskCount = 5;
        List<Future<String>> futures = new ArrayList<>(taskCount);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(taskCount, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        // 100个任务，每5个一组执行，同时启动20个线程执行
        // 全部执行完毕之后 返回结果
        int n = 0;
        CountDownLatch countDownLatch = new CountDownLatch(2);
        for (int i = 0; i < 10 / 5; i++) {
            n += 1;
            System.out.println("第" + n + "批任务正在执行。");

            Future<String> submit = threadPoolExecutor.submit(
                    new Callable<String>() {
                        @Override
                        public String call() throws Exception {
//                            TimeUnit.SECONDS.sleep(3);
                            return "done";
                        }
                    }
            );

            if (Objects.equals(submit.get(), "done")) {
                countDownLatch.countDown();
            }
            countDownLatch.await();
        }
        System.out.println("任务全部执行完成");
//        countDownLatch.await();
//        try {
//            threadPoolExecutor.shutdown();
//            List<String> results = futureTest.getFutureResult(futures);
//            for (String result : results) {
//                if ("done".equals(result)) {
//                    countDownLatch.countDown();
//                }
//            }
//            countDownLatch.await();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
//    public List<String> getFutureResult(List<Future<String>> futures) {
//        List<String> result = new ArrayList<>(3);
//        for (Future<String> future : futures) {
//            if (future.isDone() && !future.isCancelled()) {
//                try {
//                    result.add(future.get());
//                } catch (InterruptedException | ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }
}
