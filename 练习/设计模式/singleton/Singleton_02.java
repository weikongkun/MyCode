package singleton;

public class Singleton_02 {
	private static Singleton_02 instance = null;
	
	public synchronized static Singleton_02 getInstance() {
		if (instance == null)
			instance = new Singleton_02();
		return instance;
	}
}


