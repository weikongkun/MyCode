package singleton;

public class Singleton_03 {
	private static Singleton_03 instance = null;
	
	public static Singleton_03 getInstance() {
		if (instance == null) {
			synchronized (Singleton_03.class) {
				if (instance == null)
					instance = new Singleton_03();
			}
		}
		return instance;
	}
}
