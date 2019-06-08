package base;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        setCoordinate(x, y);
    }

    public Coordinate() {

    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void setCoordinate(Coordinate coordinate) {
        x = coordinate.getX();
        y = coordinate.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


    public double distance(Coordinate coordinate) {
        return Math.sqrt(Math.pow(coordinate.x - x, 2) + Math.pow(coordinate.y - y, 2));
    }


}
