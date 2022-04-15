package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int strike;
    private int ball;
    private List<BBall> bBalls;

    public Player(){
        strike = 0;
        ball = 0;
    }

    public Player(List<BBall> bBalls){
        strike = 0;
        ball = 0;
        this.bBalls = bBalls;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public List<BBall> getbBalls() {
        return bBalls;
    }

    public void setbBalls(List<BBall> bBalls) {
        this.bBalls = bBalls;
    }

    public boolean isNothing(){
        return strike+ball == 0 ? true : false;
    }
}
