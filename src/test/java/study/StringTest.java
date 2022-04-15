package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void stringTest1() {
        String value = "1,2";
        assertThat(value.split(",")).contains("1","2");
    }


    @Test
    void stringTest2() {
        String value = "1,";
        assertThat(value.split(",")).containsExactly("1");
    }

    @Test
    void stringTest3() {
        String value = "(1,2)";
        assertThat(value.substring(1, value.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String Index 에러 테스트")
    void stringTest4() {

        assertThatThrownBy(() -> {

            String value = "abc";
            value.charAt(0);
            value.charAt(5);

        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index");

    }

}
