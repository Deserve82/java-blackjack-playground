package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CardFaceType {

    @Test
    void getName() {
        assertThat(CardFace.KING.getName()).isEqualTo("K");
        assertThat(CardFace.QUEEN.getName()).isEqualTo("Q");
        assertThat(CardFace.JACK.getName()).isEqualTo("J");
    }

    @Test
    void isNone() {
        assertThat(CardFace.JACK.isNone()).isFalse();
        assertThat(CardFace.NONE.isNone()).isTrue();
    }
}
