package strings;

import java.util.stream.IntStream;

public class Main {

	
	public static void main(String[] args) {
		//similar to String buffer we have StringBuilder
		String ss = "Harsha";
		
		StringBuffer s = new StringBuffer("Harsha"); // string buffer is thread safe multiple threads can access it at same time.
		System.out.println(s);
		System.out.println(s.capacity());
		System.out.println(s.charAt(0));
		System.out.println(new StringBuffer("Hars").compareTo(s)); // -3 as object on which comapreTo is called is 3 characters less than "s"
		System.out.println(s.indexOf("a")); // case sensitive
		System.out.println(s.lastIndexOf("a"));
		System.out.println(s.length());
		System.out.println(s.substring(3)); // here index is inclusive
		System.out.println(s.substring(1, 4)); // start index is inclusive and end index is exclusive return type is string
		System.out.println(s.subSequence(0, 3)); // same as substring but return type is charSequence which is interface and parent for string
		char [] ch = new char[10];
		s.getChars(0, 3, ch, 2); //
		System.out.println(new String(ch));
		System.out.println(s.reverse());
		s.trimToSize(); 
		System.out.println(s);
		//s.setLength(200);
		System.out.println(s.capacity());
	}
}
