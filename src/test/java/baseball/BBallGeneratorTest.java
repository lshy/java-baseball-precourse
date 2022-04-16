package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class BBallGeneratorTest {

    private BBallGenerator bBallGenerator;

    @BeforeEach
    void setUp() {
        bBallGenerator = new BBallGenerator();
    }

    @Test
    @DisplayName("랜덤볼 생성 함수 테스트")
    void BBallGeneratorRandomTest(){

        List<BBall> bBallList = bBallGenerator.generateRandomBall();
        assertThat(bBallList.size()).isEqualTo(3);

    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3"}, delimiter = ':')
    @DisplayName("입력볼 생성 함수 테스트")
    void BBallGeneratorInputTest(int input, int expected){

        String value = "123";
        List<BBall> bBallList = bBallGenerator.generateInputBall(value);
        assertThat(bBallList.get(input).getNumber()).isEqualTo(expected);

    }

}
