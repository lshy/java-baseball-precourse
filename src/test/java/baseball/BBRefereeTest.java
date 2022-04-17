package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BBRefereeTest {

    private BBReferee bBReferee;
    private List<BBall> defBallList;

    @BeforeEach
    void setUp() {
        bBReferee = new BBReferee();
        defBallList = new ArrayList<>();
        defBallList.add(new BBall(1));
        defBallList.add(new BBall(3));
        defBallList.add(new BBall(4));

    }

    @ParameterizedTest
    @CsvSource(value = {"0:1:1", "1:2:0", "2:3:0"}, delimiter = ':')
    @DisplayName("스트라이크 테스트")
    void BBRefreeStrikeTest(int index, int strikeNumber, int expected){
        assertThat(bBReferee.doStrike(defBallList.get(index), new BBall(strikeNumber))).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:2:0", "1:1:1", "2:3:1"}, delimiter = ':')
    @DisplayName("볼 테스트")
    void BBRefreeBallTest(int index, int ballNumber, int expected){
        assertThat(bBReferee.doBall(defBallList, new BBall(ballNumber), index)).isEqualTo(expected);
    }

}
