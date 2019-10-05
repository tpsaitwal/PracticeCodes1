
public class StringPool {

	public static void main(String[] args) {
	
		String str = "Tejas";
		String st1 = new String("Tejas");
		System.out.println("str = "+ str.hashCode());
		System.out.println("st1 = "+ st1.hashCode());
		System.out.println("Tejas".hashCode());;
		
		StringBuffer stb = new StringBuffer("Tejas");
		System.out.println("stb = "+ stb.hashCode());
	}

}
