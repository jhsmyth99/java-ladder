package my.project.common.view;

import my.project.common.domain.*;
import my.project.step3.domain.Line;
import my.project.common.dto.ResultSet;
import my.project.step4.domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static final String TITLE = "\n사다리 결과\n";
    public static final String DELIMITER = " ";
    public static final String REWARD_TITLE = "\n실행 결과";
    public static final String COLON = ":";

    private ResultView() {
    }

    public static void print(Users users, Ladder ladder, Rewards rewards) {
        printTitle();
        printUsers(users);
        printLadder(ladder);
        printRewards(rewards);
    }

    private static void printTitle() {
        System.out.println(TITLE);
    }

    private static void printUsers(Users users) {
        System.out.println(users.getUsers().stream()
                .map(User::getName)
                .collect(Collectors.joining(DELIMITER)));
    }

    private static void printLadder(Ladder ladder) {
        //ladder.getLines().get().forEach(ResultView::printPoints);
        ladder.getLadder().stream()
                .forEach(System.out::println);
    }

    private static void printPoints(Line line) {
        System.out.println(
                line.getPoints().stream()
                        .map(Symbol::getSymbol)
                        .collect(Collectors.joining())
        );
    }

    private static void printRewards(Rewards rewards) {
        System.out.println(rewards.getRewards().stream()
                .map(Reward::get)
                .collect(Collectors.joining(DELIMITER)));
    }

    public static void printResults(List<ResultSet> results) {
        System.out.println(REWARD_TITLE);
        results.forEach(result -> System.out.println(result.getUsername() + COLON + result.getReward()));
    }
}