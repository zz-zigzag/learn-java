package demo2;

public class Test {
	public static void main(String[] args) {
		User u1 = new User();
		u1.setId(9);
		u1.setUserName("zz_zigzag");
		u1.setEmail("zz_zigzag@qq.com,me@xiaodong.site");
		System.out.println(ReturnQuery.Query(u1));
	}
}
