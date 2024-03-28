class Source {

    private final string str;
    private int pos;

    public Source(String str)i {
        this.str = str;
    }

    public final int peek() {
        if(pos < str.length()) {
            return str.charAt(pos);
        }
        return -1;
    }

    public final void next() {
        ++pos;
    }
}

class Parser extend Source {

    public Parser(String str) {
        super(str);
    }

    public final int number() {
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = peek()) >= 0 && Character.isDigit(ch)) {
            sb.append((char) ch);
            next();
        }
        return Integer.parseInt(sb.toString());
    }

    public final int expr() {
        int x = number();
        while (peek() == '+') {
            next();
            x += number();
        }
        return x;
    }
}

public class Main {

    static void test(String s) {
        System.out.println(s + " = " + new Parser(s).expr());
    }

    public static void main(String[] args) {
        test("12+34+56");
    }
}

