class Source {

    private final String str;
    private int pos;

    public Source(String str) {
        this.str = str;
    }

    public final int peek() {
        if (pos < str.length()) {
            return str.charAt(pos);
        }
        return -1;
    }

    public final void next() {
        ++pos;
    }
}

class Parser extends Source {

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

    // expr = term, {("+", term) | ("-", term)}
    public final int expr() {
        int x = term();
        for (;;) {
            switch (peek()) {
                case '+':
                    next();
                    x += term();
                    continue;
                case '-':
                    next();
                    x -= term();
                    continue;
            }
            break;
        }
        return x;
    }

    // term = factor, {("*", factor) | ("/", factor)}
    public final int term() {
        int x = factor();
        for (;;) {
            switch (peek()) {
                case '*':
                    next();
                    x *= factor();
                    continue;
                case '/':
                    next();
                    x /= factor();
                    continue;
            }
            break;
        }
        return x;
    }

    // factor, ("(", expr, ")") | number
    public final int factor() {
        if (peek() == '(') {
            next();
            int ret = expr();
            if (peek() == ')') {
                next();
            }
            return ret;
        }
        return number();
    }
}

public class Brackets {
    static void test(String s) {
        System.out.println(s + " = " + new Parser(s).expr());
    }

    public static void main(String[] args) {
        test("(2+3)*4");
        test("4*(2+3)");
    }
}
