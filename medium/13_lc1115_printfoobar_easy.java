import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    // Start fooSemaphore with 1 permit so "foo" prints first
    private Semaphore fooSemaphore = new Semaphore(1);
    // Start barSemaphore with 0 permits so "bar" waits for "foo"
    private Semaphore barSemaphore = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Acquire permit to print "foo"
            fooSemaphore.acquire();
            
            // printFoo.run() outputs "foo"
            printFoo.run();
            
            // Release permit so bar() can run next
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Wait for foo() to release a permit
            barSemaphore.acquire();
            
            // printBar.run() outputs "bar"
            printBar.run();
            
            // Release permit so foo() can run the next iteration
            fooSemaphore.release();
        }
    }
}
