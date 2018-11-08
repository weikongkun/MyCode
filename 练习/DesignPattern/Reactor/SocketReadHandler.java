package Reactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class SocketReadHandler {
	final SocketChannel socket;
	final SelectionKey sk;
	static final int READING = 0, SENDING = 1;
	int state = READING;
	
	public SocketReadHandler(Selector sel, SocketChannel c) throws IOException {
		socket = c;
		socket.configureBlocking(false);
		sk = socket.register(sel, 0);
		sk.attach(this);
		sk.interestOps(SelectionKey.OP_READ);
		sel.wakeup();
	}
	
	public void run() {
		try {
			
		}catch(Exception ex) {
			
		}
	}
}
