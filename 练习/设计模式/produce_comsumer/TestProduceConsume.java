package produce_comsumer;

import java.util.LinkedList;
import java.util.Queue;

public class TestProduceConsume {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Consumer con = new Consumer(10, queue);
		Producer pro = new Producer(10, queue);
		con.start();
		pro.start();
	}
}
