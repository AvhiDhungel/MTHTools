package dhu.avhi.SqlUtilities;

public class SqlQueryBuilder {

    private StringBuilder sb = new StringBuilder();

    public SqlQueryBuilder(){}
    public SqlQueryBuilder(String str) {
        sb.append(str);
    }

    public void append(String str) {
        sb.append(str);
    }
    public void append(String str, Object... args) {
        sb.append(String.format(str, args));
    }

    public void appendLine(String str) {
        if (sb.length() > 0) {append("\n");}
        append(str);
    }
    public void appendLine(String str, Object... args) {
        if (sb.length() > 0) {append("\n");}
        append(str, args);
    }

    public String toString() {
        return sb.toString();
    }

}
