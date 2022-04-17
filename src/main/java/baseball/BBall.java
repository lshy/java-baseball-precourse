package baseball;

import java.util.Objects;

public class BBall {

    public static final int MAX_BALL_NUMBER = 9;
    public static final int MIN_BALL_NUMBER = 1;

    private int number;

    public BBall(int number){

        checkNumberValid(number);
        this.number = number;

    }

    private void checkNumberValid(int number) {

        if(number<MIN_BALL_NUMBER || number >MAX_BALL_NUMBER){
            throw new IllegalArgumentException("1~9사이 숫자로 이루어져야 합니다.");
        }

    }

    public int getNumber() {

        return number;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BBall bBall = (BBall) o;
        return number == bBall.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);

    }

}
