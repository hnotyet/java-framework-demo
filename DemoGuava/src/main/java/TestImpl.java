import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: yest
 * @copyright: taofen8.com
 * <p>
 * Created on: 2019/12/16
 */
public class TestImpl implements TestInterface {

  @Override
  public void test() {

    try {
      new Thread().join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      new Thread().wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

    public static void main (String[]args) throws InterruptedException {
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          System.out.println(
              "线程一正在执行，将进入等待状态，当前时间= " + System.currentTimeMillis() + ", 此时的中断标志位：" + Thread
                  .currentThread().isInterrupted());
          LockSupport.park();
          System.out.println(
              "线程一从等待状态中醒来，当前时间= " + System.currentTimeMillis() + ", 此时的中断标志位：" + Thread
                  .currentThread().isInterrupted());
          LockSupport.park();
          System.out.println(
              "线程一从等待状态中醒来，当前时间= " + System.currentTimeMillis() + ", 此时的中断标志位：" + Thread
                  .currentThread().isInterrupted());
        }
      });

      System.out.println("主线程正在执行");
      thread.start();
      System.out.println("主线程等待，睡眠两秒");
      TimeUnit.SECONDS.sleep(2);
      System.out.println("主线程开始interupt");
      thread.interrupt();
    }


  }
