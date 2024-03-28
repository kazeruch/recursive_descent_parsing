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

    // スーパークラスのコンストラクタを呼び出す
    public Parser(String str) {
        super(str);
    }

    public final String number() {
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = peek()) >= 0 && Character.isDigit(ch)) {
            sb.append((char) ch);
            next();
        }
        return sb.toString();
    }
}

public class ClassifyingParser {

    public static void main(String[] args) {
        System.out.println(new Parser("12+34+56").number());
    }
}