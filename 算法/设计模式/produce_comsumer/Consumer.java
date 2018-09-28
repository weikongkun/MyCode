package produce_comsumer;

import java.util.Queue;
import java.util.Random;

public class Consumer extends Thread{
	private Queue queue;
	private int maxSize;
	public Consumer(int maxSize, Queue<Integer> q) {
		this.maxSize = maxSize;
		this.queue = q;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is emypt, Consumer thread wait");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Consuming value: " + queue.remove());
				queue.notifyAll();
			}
		}
	}
	
	
}
