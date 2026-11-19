import java.util.concurrent.Semaphore;

class Foo {
    // Initialize with 0 permits so second() and third() block until released
    private Semaphore runSecond = new Semaphore(0);
    private Semaphore runThird = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first"
        printFirst.run();
        
        // Release 1 permit to allow second() to proceed
        runSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until first() releases a permit
        runSecond.acquire();
        
        // printSecond.run() outputs "second"
        printSecond.run();
        
        // Release 1 permit to allow third() to proceed
        runThird.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second() releases a permit
        runThird.acquire();
        
        // printThird.run() outputs "third"
        printThird.run();
    }
}
