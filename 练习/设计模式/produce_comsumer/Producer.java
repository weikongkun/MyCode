package produce_comsumer;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread{
	private int maxSize;
	private Queue<Integer> queue;
	public Producer(int maxSize, Queue<Integer> queue) {
		this.maxSize = maxSize;
		this.queue = queue;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.size() == maxSize) {
					try {
						System.out.println("Queue is full, Producer thread wait");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Random random = new Random();
				int i = random.nextInt();
				System.out.println("Producing value: " + i);
				queue.add(i);
				queue.notifyAll();
			}
		}
	}
	
	
}
