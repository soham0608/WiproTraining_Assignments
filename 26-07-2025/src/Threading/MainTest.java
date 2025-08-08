package Threading;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try
        {	
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Final Count: " + counter.getCount());
    }
}
