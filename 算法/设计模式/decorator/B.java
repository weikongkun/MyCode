package decorator;

public class B implements Do{
	private Do a;
	
	public B(Do a) {
		this.a = a;
	}
	@Override
	public void doSomething() {
		System.out.println("BBBBBBBB");
		a.doSomething();
		System.out.println("BBBBBBBB");
	}
	
	public static void main(String[] args) {
		Do b = new B(new A());
		b.doSomething();
	}
}
