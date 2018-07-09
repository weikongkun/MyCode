package adapter;

public class PrintBanner extends Banner implements Print{
	public PrintBanner(String string) {
		super(string);
	}

	@Override
	public void printWeak() {
		show1();
	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		show2();
	}
	
}
