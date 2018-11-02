package factory;

public class IDCard implements Product {
	private String owner;
	public IDCard(String owner) {
		System.out.println("����" + owner + "��ID��");
		this.owner = owner;
	}
	@Override
	public void use() {
		System.out.println("ʹ��" + owner + "��ID��");
	}
	
	public String getOwner() {
		return owner;
	}
	
}
