package adapter;

public class Banner {
	private String string;
	public Banner(String string) {
		this.string = string;
	}
	public void show1() {
		System.out.println("(" + string + ")");
	}
	public void show2() {
		System.out.println("[" + string + "]");
	}
}
