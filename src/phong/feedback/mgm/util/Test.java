package phong.feedback.mgm.util;

public class Test {

	public static void main(String[] args) {
		String str = "login";
		String[] partialUrl = str.split("/");
		System.out.println(partialUrl.length + "  ");
		System.out.println(partialUrl[0]);
	}

}
