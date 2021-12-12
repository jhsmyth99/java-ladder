package ladder.view;

import ladder.domain.Lines;
import ladder.domain.Users;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();

    public static void resultLadder() {
        System.out.println("실행결과");
    }

    public static void drawLadderUsers(Users users) {
        System.out.println(users.getUserNames());
    }

    public static void drawLadderLines(Lines lines) {
        lines.getLines().stream()
                .forEach(line -> {

                });
    }
}
