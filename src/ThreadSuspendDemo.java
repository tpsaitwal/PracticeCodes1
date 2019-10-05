

class NewRunnable implements Runnable{
	String threadName;
	Thread thread;
	
	NewRunnable(final String threadName) {
		this.threadName = threadName;
		thread = new Thread(this, threadName);
		System.out.println("Starting new thread " + thread.getName());
		thread.start();
	}

	@Override
	public void run() {
		for(int j =10; j>0; j--) {
			System.out.println(thread.getName() + " : " +j);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted thread " + thread.getName());
		}
		System.out.println(thread.getName() + " finished!");
	}
}

public class ThreadSuspendDemo {

	public static void main(String[] args) {
		NewRunnable obj1 = new NewRunnable("obj1");
		NewRunnable obj2 = new NewRunnable("obj2");
			
		try {
			System.out.println("Sleeping thread " + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("Suspend obj1");
			obj1.thread.suspend();
			System.out.println(Thread.currentThread().getName() + " sleeping is progress!");
			Thread.sleep(1000);
			obj1.thread.resume();
			System.out.println(Thread.currentThread().getName() + " waking up!");
			obj2.thread.suspend();
			System.out.println(Thread.currentThread().getName() + " starting to sleep!");
			Thread.sleep(1000);
			obj2.thread.resume();
			System.out.println(Thread.currentThread().getName() + " waking up!");
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " is broken!");
		}
		
		
		try {
			System.out.println("Joining threads and waiting for them to finish!");
			obj1.thread.join();
			obj2.thread.join();
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " is broken!");
		}
		
		System.out.println(Thread.currentThread().getName() + " finishing!");
	}

}
