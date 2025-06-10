package random_4;

public class Sstring1 {

    public static void main(String[] args) {
    	String s1 = "Java";
    	String s2 = "Javax";
    	StringBuilder sb1 = new StringBuilder();
    	sb1.append("Ja").append("va");
    	System.out.println(sb1);
    	System.out.println(s1 == s2);
    	System.out.println(s1.equals(s2));
    	System.out.println(sb1.toString() == s1);
    	System.out.println(sb1.toString().equals(s1));

    	String str = "Hello";
    	str += " World!";
    	System.out.println(str.length());
    }
}
