package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BBReferee {

    public boolean isEndGame(Player player) {

        if(player.getStrike() == 3){
            return false;
        }

        return true;
    }

    public void doJudgment(Player defender, Player attaker) {

        List<BBall> defenderBalls = defender.getbBalls();
        List<BBall> attakerBalls = attaker.getbBalls();

        int strike = 0;
        int ball = 0;
        for(int i=0; i<BBallGenerator.MAX_BALL_COUNT; ++i){
            strike += doStrike(defenderBalls.get(i), attakerBalls.get(i));
            ball += doBall(defenderBalls, attakerBalls.get(i), i);
        }

        attaker.setBall(ball);
        attaker.setStrike(strike);

    }

    private int doStrike(BBall defense, BBall attake){

        if(defense.equals(attake)){
            return 1;
        }

        return 0;
    }

    private int doBall(List<BBall> defense, BBall attake, int index){

        if(defense.contains(attake) && !defense.get(index).equals(attake)){
            return 1;
        }

        return 0;

    }
}
