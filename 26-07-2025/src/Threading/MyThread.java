package Threading;

public class MyThread extends Thread {
	
    Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() 
    {
        for (int i = 0; i < 10; i++) 
        {
            counter.increment();
            try 
            {
				Thread.sleep(1000);
			} 
            catch (InterruptedException e) 
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
