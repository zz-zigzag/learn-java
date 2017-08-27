package demo1;

@Description("hello Person")
public class Person {

	@Description("hello name")
	private String name;

	@Description("hello getName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
