package core;

public class Station implements Comparable {
    private Line line;
    private String name;
    private boolean connection;

    public Station(String name, Line line) {
        this.name = name;
        this.line = line;
    }

    public Line getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    public void setConnection(boolean connection){
        this.connection = connection;
    }

    public boolean getConnection() {
        return connection;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
