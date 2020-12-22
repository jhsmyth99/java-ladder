package ladder.domain.next;

import ladder.domain.LadderItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLineTest {

    @DisplayName("이동위치가 참가자수 보다 크면 exception 을 던진다")
    @Test
    public void invalidPosition() {
        LadderLine line = LadderLine.init(5);
        assertThatThrownBy(() -> line.move(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("좌,우 또는 제자리로 이동 할 수 있다")
    @Test
    public void move() {
        int sizeOfPerson = 5;
        for( int i = 0 ; i < 100 ; i++ ) {
            LadderLine line = LadderLine.init(sizeOfPerson);
            assertThat(line.move(2)).isGreaterThanOrEqualTo(1);
            assertThat(line.move(2)).isLessThanOrEqualTo(3);
        }
    }

    @DisplayName("LadderItem 으로 변환할 수 있다")
    @Test
    void toLadderItems(){
        LadderLine line = LadderLine.builder().first(true).next(false).last().build();
        assertThat(line.toLadderItems())
                .containsExactly(LadderItem.Bar, LadderItem.Step, LadderItem.Bar, LadderItem.Empty, LadderItem.Bar);

        LadderLine line2 = LadderLine.builder().first(false).next(false).last().build();
        assertThat(line2.toLadderItems())
                .containsExactly(LadderItem.Bar, LadderItem.Empty, LadderItem.Bar, LadderItem.Empty, LadderItem.Bar);

        LadderLine line3 = LadderLine.builder().first(false).next(true).last().build();
        assertThat(line3.toLadderItems())
                .containsExactly(LadderItem.Bar, LadderItem.Empty, LadderItem.Bar, LadderItem.Step, LadderItem.Bar);


    }

}