package step2.hint;

import org.junit.jupiter.api.Test;

class LadderLineTest {

    @Test
    void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, new NotCreateLadderPointGenerator()));
    }

    @Test
    void move() {
        LadderLine line = LadderLine.init(2, new NotCreateLadderPointGenerator());
        System.out.println("line = " + line.move(0));
    }
}