package java_ver;
public class Number {

    static final String number(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                return s.substring(0, i);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(number("12+34+56"));
    }
}
