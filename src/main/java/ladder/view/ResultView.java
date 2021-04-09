package ladder.view;

import java.util.Map.Entry;
import java.util.stream.Collectors;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Ladder;
import ladder.domain.Point;
import ladder.domain.Prize;
import ladder.domain.PrizeResult;
import ladder.domain.Prizes;
import ladder.domain.User;
import ladder.domain.Users;

public class ResultView {

  private static final String HYPHEN = "-----";
  private static final String EMPTY = "     ";
  private static final String RESULT = "실행결과";
  private static final String NAME_AND_PRIZE_FORMAT = "%6s";
  private static final String VERTICAL_LINE = "|";
  private static final String ALL= "all";

  public void printLadder(LadderGame ladderGame) {
    System.out.println(RESULT);
    System.out.println(printName(ladderGame.getGameInfo().getUsers()));
    String ladder = printLadderDetail(ladderGame.getLadder());
    System.out.println(ladder.substring(0, ladder.length() - 1));
    System.out.println(printPrize(ladderGame.getGameInfo().getPrizes()));
  }


  private String printLadderDetail(Ladder ladder) {
    return ladder.stream()
        .map(line -> EMPTY + printPoints(line) + System.lineSeparator())
        .collect(Collectors.joining());
  }


  private String printPoints(Line line) {
    return line.stream()
        .map(point -> VERTICAL_LINE + printUsedOrNot(point))
        .collect(Collectors.joining());
  }

  private String printUsedOrNot(Point point) {
    if (point.isDirectionRight()) {
      return HYPHEN;
    }
    return EMPTY;
  }

  private String printPrize(Prizes prizes) {
    return prizes.stream()
        .map(prize -> prize.getPrize())
        .map(prize -> String.format(NAME_AND_PRIZE_FORMAT, prize))
        .collect(Collectors.joining());
  }

  private String printName(Users users) {
    return users.stream()
        .map(user -> user.getName())
        .map(name -> String.format(NAME_AND_PRIZE_FORMAT, name))
        .collect(Collectors.joining());
  }

  public void printAllResult(PrizeResult prizeResult) {
    prizeResult.getPrizeResult()
        .entrySet()
        .forEach(result -> System.out.println(
            result.getKey().getName() + " : " + result.getValue().getPrize()));
  }

  public void printEachResult(PrizeResult prizeResult, String userName) {
    System.out.println(RESULT);
    String result = "";
    Prize prize = prizeResult.getPrizeResult().get(new User(userName));
    if (prize != null) {
      result = prize.getPrize();
    }
    System.out.println(result);
  }

  public boolean printResult(String input, PrizeResult prizeResult) {
    if (input.equals(ALL)) {
      printAllResult(prizeResult);
      return true;
    }

    printEachResult(prizeResult, input);
    return false;
  }
}
