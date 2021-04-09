package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import ladder.domain.generator.Generator;
import ladder.domain.generator.PointsGenerator;

public class Line {

  private final List<Point> points;

  public Line(List<Point> points) {
    this.points = points;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Line line = (Line) o;
    return Objects.equals(points, line.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }

  public Stream<Point> stream() {
    return points.stream();
  }

  public Position move(Position position) {
    return points.get(position.getValue()).move();
  }

  public static Line init(int sizeOfPerson) {
    List<Point> points = new ArrayList<>();
    Point point = initFirst(points);
    point = initBody(sizeOfPerson, points, point);
    initLast(points, point);
    return new Line(points);
  }

  private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
    for (int i = 1; i < sizeOfPerson - 1; i++) {
      point = point.next();
      points.add(point);
    }
    return point;
  }

  private static void initLast(List<Point> points, Point point) {
    point = point.last();
    points.add(point);
  }

  private static Point initFirst(List<Point> points) {
    Generator generator = new PointsGenerator();
    Point point = Point.first(generator.generatePoint());
    points.add(point);
    return point;
  }

  @Override
  public String toString() {
    return "LadderLine{" +
        "points=" + points +
        '}';
  }

}
