package location;

import base.Coordinate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Location {
    private Set<Coordinate> coordinates;

    public Location(Coordinate... coordinates) {
        this.coordinates = new HashSet<>();
        this.coordinates.addAll(Arrays.asList(coordinates));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Coordinate coordinate : coordinates)
            s.append("coordinate ").append(coordinate.getX()).append(", ").append(coordinate.getY()).append("; ");

        return "Location{" +
                "coordinates=" + s + '}';
    }
}
