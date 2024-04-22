// AAG-Literals/Literals.java
 
public class Literals {
    public static void main(String[] args) {
        System.out.println(22);         // decimal
        System.out.println(022);        // octal
        System.out.println(0x22);       // hexadecimal
        System.out.println(0b1001);     // binary
        System.out.println(22.22);      // double
        System.out.println(2.22e-1);    // "scientific"
        System.out.println(1/3 );       // this is 0 !
        System.out.println(1/3.);       // one third
        System.out.println(1/3D);       // 3D -> double
        System.out.println(2147483648L);// long
        System.out.println(2147483647  + 1 ); // ooops!
        System.out.println(2147483647L + 1 );
        System.out.println('A');        // char
        System.out.println('A'+2);      // char
        System.out.println((char)('A'+2));
        System.out.println('\u0042');   // also char
        System.out.println("Hello, World");
        System.out.println("\u017b\u00F3\u0142w");
        System.out.println("number = " +  2+2);
        System.out.println("number = " + (2+2));
        System.out.println(false);
        System.out.println(2*3 == 6);
        System.out.println("\"TAB\"s and 'NL'\n"+
                           "a\tb\tc\te\tf\n\tg\th\ti\tj");
        System.out.println("C:\\Program Files\\java");
    }
}
