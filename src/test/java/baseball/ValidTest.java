package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 111})
    @DisplayName("1~9 아닌 숫자 테스트")
    void numberRangeTest(int input){

        assertThatThrownBy(() -> {

            BBall bBall = new BBall(input);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9");

    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "12", "1234", ""})
    @DisplayName("1~9 아닌 숫자 테스트")
    void bBallSizeTest(String input){

        assertThatThrownBy(() -> {

            BBallGenerator bBallGenerator = new BBallGenerator();
            bBallGenerator.generateInputBall(input);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리");

    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "112", "122"})
    @DisplayName("1~9 아닌 숫자 테스트")
    void bBallDuplicateTest(String input){

        assertThatThrownBy(() -> {

            BBallGenerator bBallGenerator = new BBallGenerator();
            bBallGenerator.generateInputBall(input);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른");

    }

}
