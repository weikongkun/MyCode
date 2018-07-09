package singleton;

public class Singleton_01 {
	private static Singleton_01 instance;;

	public static Singleton_01 getInstance() {
		if (instance == null) instance = new Singleton_01();
		return instance;
	}
}
