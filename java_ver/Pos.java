package java_ver;
class Source {

    public String str;
    public int pos;

    public Source(String str) {
        this.str = str;
    }
}

public class Pos {

    static final String number(Source s) {
        int start = s.pos;
        for (; s.pos < s.str.length(); ++s.pos) {
            if(!Character.isDigit(s.str.charAt(s.pos))) {
                return s.str.substring(start, s.pos);
            }
        }
        return s.str;
    }

    public static void main(String[] args) {
        System.out.println(number(new Source("12+34+56")));
    }
}