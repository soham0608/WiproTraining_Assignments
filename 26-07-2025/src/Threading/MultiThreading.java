package Threading;

class MyTask extends Thread{

	public void run() {
		
		for(char i = 'A'; i<='J';i++)
		{
			System.out.println(i);
		}
	}
}

class MyTask2 extends Thread
{
	public void run() {
		
		for(int i =0; i<=10 ;i++)
		{
			System.out.println(i);
		}
	}
}

public class MultiThreading {

	public static void main(String[] args) {
		
		MyTask task = new MyTask();
		MyTask2 task2 = new MyTask2();
		
		task.start();
		task2.start();
	}
}
