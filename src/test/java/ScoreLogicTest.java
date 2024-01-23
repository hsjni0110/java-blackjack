import static org.assertj.core.api.Assertions.assertThat;

import domain.cards.Card;
import domain.cards.constant.CardEnums.CardRank;
import domain.cards.constant.CardEnums.CardSuit;
import domain.logics.ScoreLogic;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreLogicTest {

    @DisplayName("ACE가 포함된, 값을 더하는 로직 테스트")
    @Test
    void sumLogicWithAceTest() {
        // given
        Card card1 = new Card(CardSuit.SPADE, CardRank.J);
        Card card2 = new Card(CardSuit.DIAMOND, CardRank.A);
        List<Card> ownCards = Arrays.asList(card1, card2);

        // when
        ScoreLogic scoreLogic = new ScoreLogic();
        int sum = scoreLogic.applyLogic(ownCards);

        // then
        assertThat(sum).isEqualTo(21);
    }

    @DisplayName("ACE가 포함된, 값을 더하는 로직 테스트2")
    @Test
    void sumLogicWithAce2Test() {
        // given
        Card card1 = new Card(CardSuit.SPADE, CardRank.J);
        Card card2 = new Card(CardSuit.DIAMOND, CardRank.A);
        Card card3 = new Card(CardSuit.HEART, CardRank.Q);
        List<Card> ownCards = Arrays.asList(card1, card2, card3);

        // when
        ScoreLogic scoreLogic = new ScoreLogic();
        int sum = scoreLogic.applyLogic(ownCards);

        // then
        assertThat(sum).isEqualTo(21);
    }

    @DisplayName("ACE가 포함된, 값을 더하는 로직 테스트3")
    @Test
    void sumLogicWithAce3Test() {
        // given
        Card card1 = new Card(CardSuit.SPADE, CardRank.J);
        Card card2 = new Card(CardSuit.DIAMOND, CardRank.Q);
        Card card3 = new Card(CardSuit.HEART, CardRank.A);
        List<Card> ownCards = Arrays.asList(card1, card2, card3);

        // when
        ScoreLogic scoreLogic = new ScoreLogic();
        int sum = scoreLogic.applyLogic(ownCards);

        // then
        assertThat(sum).isEqualTo(21);
    }

    @DisplayName("ACE가 포함된, 값을 더하는 로직 테스트4")
    @Test
    void sumLogicWithAce4Test() {
        // given
        Card card1 = new Card(CardSuit.SPADE, CardRank.EIGHT);
        Card card2 = new Card(CardSuit.DIAMOND, CardRank.NINE);
        Card card3 = new Card(CardSuit.HEART, CardRank.A);
        List<Card> ownCards = Arrays.asList(card1, card2, card3);

        // when
        ScoreLogic scoreLogic = new ScoreLogic();
        int sum = scoreLogic.applyLogic(ownCards);

        // then
        assertThat(sum).isEqualTo(18);
    }

    @DisplayName("ACE가 포함된, 값을 더하는 로직 테스트5")
    @Test
    void sumLogicWithAce5Test() {
        // given
        Card card1 = new Card(CardSuit.SPADE, CardRank.EIGHT);
        Card card2 = new Card(CardSuit.DIAMOND, CardRank.A);
        Card card3 = new Card(CardSuit.HEART, CardRank.A);
        List<Card> ownCards = Arrays.asList(card1, card2, card3);

        // when
        ScoreLogic scoreLogic = new ScoreLogic();
        int sum = scoreLogic.applyLogic(ownCards);

        // then
        assertThat(sum).isEqualTo(20);
    }

    @DisplayName("ACE가 포함된, 값을 더하는 로직 테스트6")
    @Test
    void sumLogicWithAce6Test() {
        // given
        Card card1 = new Card(CardSuit.SPADE, CardRank.A);
        Card card2 = new Card(CardSuit.DIAMOND, CardRank.A);
        Card card3 = new Card(CardSuit.HEART, CardRank.A);
        List<Card> ownCards = Arrays.asList(card1, card2, card3);

        // when
        ScoreLogic scoreLogic = new ScoreLogic();
        int sum = scoreLogic.applyLogic(ownCards);

        // then
        assertThat(sum).isEqualTo(13);
    }

    @DisplayName("ACE가 포함된, 값을 더하는 로직 테스트7")
    @Test
    void sumLogicWithAce7Test() {
        // given
        Card card1 = new Card(CardSuit.SPADE, CardRank.Q);
        Card card2 = new Card(CardSuit.DIAMOND, CardRank.J);
        Card card3 = new Card(CardSuit.HEART, CardRank.K);
        Card card4 = new Card(CardSuit.HEART, CardRank.A);
        List<Card> ownCards = Arrays.asList(card1, card2, card3, card4);

        // when
        ScoreLogic scoreLogic = new ScoreLogic();
        int sum = scoreLogic.applyLogic(ownCards);

        // then
        assertThat(sum).isEqualTo(31);
    }

    @DisplayName("일반적인 값을 더하는 로직 테스트")
    @Test
    void normalAddCardTest() {
        // given
        Card card1 = new Card(CardSuit.SPADE, CardRank.Q);
        Card card2 = new Card(CardSuit.DIAMOND, CardRank.TWO);
        Card card3 = new Card(CardSuit.HEART, CardRank.THREE);
        List<Card> ownCards = Arrays.asList(card1, card2, card3);

        // when
        ScoreLogic scoreLogic = new ScoreLogic();
        int sum = scoreLogic.applyLogic(ownCards);

        // then
        assertThat(sum).isEqualTo(15);
    }

    @DisplayName("Bust 메서드 테스트")
    @Test
    void bustTest() {
        // given
        ScoreLogic scoreLogic = new ScoreLogic();
        int sumOfCards = 23;
        int sumOfCards2 = 20;

        // when
        boolean result = scoreLogic.isBust(sumOfCards);
        boolean result2 = scoreLogic.isBust(sumOfCards2);

        // then
        assertThat(result).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }

    @DisplayName("BlackJack 메서드 테스트")
    @Test
    void blackJackTest() {
        // given
        ScoreLogic scoreLogic = new ScoreLogic();
        int sumOfCards = 21;

        // when
        boolean result = scoreLogic.isBlackJack(sumOfCards);

        // then
        assertThat(result).isEqualTo(true);
    }
}