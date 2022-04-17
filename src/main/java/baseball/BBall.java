package baseball;

import java.util.Objects;

public class BBall {

    public static final int MAX_BALL_NUMBER = 9;
    public static final int MIN_BALL_NUMBER = 1;

    private int number;

    public BBall(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BBall bBall = (BBall) o;
        return number == bBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
