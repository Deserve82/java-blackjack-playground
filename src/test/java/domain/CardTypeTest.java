package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CardTypeTest {

    @Test
    void getName() {
        assertThat(CardType.CLOVER.getName()).isEqualTo("클로버");
        assertThat(CardType.HEART.getName()).isEqualTo("하트");
        assertThat(CardType.SPADE.getName()).isEqualTo("스페이드");
        assertThat(CardType.DIAMOND.getName()).isEqualTo("다이아몬드");
    }

    @Test
    void isSpade() {
        assertThat(CardType.SPADE.isSpade()).isTrue();
        assertThat(CardType.HEART.isSpade()).isFalse();
    }

}
