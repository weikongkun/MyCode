package factory;

public class IDCard implements Product {
	private String owner;
	public IDCard(String owner) {
		System.out.println("制作" + owner + "的ID卡");
		this.owner = owner;
	}
	@Override
	public void use() {
		System.out.println("使用" + owner + "的ID卡");
	}
	
	public String getOwner() {
		return owner;
	}
	
}
