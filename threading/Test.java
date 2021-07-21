package threading;

public class Test {

    public static void  main(String[] args){
        //menggunakan implements runnable
        RunnableThread runnableThread1 = new RunnableThread("runnableThread1");
        RunnableThread runnableThread2 = new RunnableThread("runnableThread2");
        RunnableThread runnableThread3 = new RunnableThread("runnableThread3");
        RunnableThread runnableThread4 = new RunnableThread("runnableThread4");
        RunnableThread runnableThread5 = new RunnableThread("runnableThread5");
        RunnableThread runnableThread6 = new RunnableThread("runnableThread6");
        RunnableThread runnableThread7 = new RunnableThread("runnableThread7");
        RunnableThread runnableThread8 = new RunnableThread("runnableThread8");
        RunnableThread runnableThread9 = new RunnableThread("runnableThread9");
        RunnableThread runnableThread10 = new RunnableThread("runnableThread10");

        //menggunakan extends thread
        Thread thisThread1 = new ThisThread("thisThread1");
        Thread thisThread2 = new ThisThread("thisThread2");
        Thread thisThread3 = new ThisThread("thisThread3");
        Thread thisThread4 = new ThisThread("thisThread4");
        Thread thisThread5 = new ThisThread("thisThread5");
        Thread thisThread6 = new ThisThread("thisThread6");
        Thread thisThread7 = new ThisThread("thisThread7");
        Thread thisThread8 = new ThisThread("thisThread8");
        Thread thisThread9 = new ThisThread("thisThread9");
        Thread thisThread10 = new ThisThread("thisThread10");

    }

    public static void funcA(){
        System.out.print("ini fungsi A : ");
        for (int x = 0; x < 10; x++){
            System.out.print(x);
        }
        System.out.print("\n");
    }

    public static void funcB(){
        System.out.print("ini fungsi B : ");
        for (int x = 10; x > 0; x--){
            System.out.print(x);
        }
        System.out.print("\n");
    }

}

//dengan meng implements Runnable
class RunnableThread implements Runnable {
    Thread runner;
    public RunnableThread(String threadName) {
        runner = new Thread(this, threadName);
        //System.out.println(runner.getName());
        runner.start();
    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread());
        Test.funcA();
    }
}

//dengan meng extends Thread
class ThisThread extends Thread{
    ThisThread(String threadName){
        super(threadName);
        //System.out.println(this);
        start();
    }

    public void run(){
        //System.out.println(Thread.currentThread().getName());
        Test.funcB();
    }
}