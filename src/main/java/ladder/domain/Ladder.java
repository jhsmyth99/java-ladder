package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Ladder {

  private final List<Line> lines;

  public Ladder(int height, int countOfPerson) {
    lines = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      lines.add(Line.init(countOfPerson));
    }
  }

  public Stream<Line> stream() {
    return lines.stream();
  }

  public Position goThroughLinesFrom(Position position) {
    for (Line line : lines) {
      position = line.move(position);
    }
    return position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ladder ladder1 = (Ladder) o;
    return Objects.equals(lines, ladder1.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lines);
  }

  @Override
  public String toString() {
    return "Ladder{" +
        "lines=" + lines +
        '}';
  }
}
