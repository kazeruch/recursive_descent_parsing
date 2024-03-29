package java_ver;
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

public class PosRefactor {

    static final String number(Source s) {
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = s.peek()) >= 0 && Character.isDigit(ch)) {
            sb.append((char) ch);
            s.next();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(number(new Source("12+34+56")));
    }
}