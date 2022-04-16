package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BBallGenerator {

    public static final int MAX_BALL_COUNT = 3;

    public List<BBall> generateRandomBall() {

        List<Integer> intList = Randoms.pickUniqueNumbersInRange(BBall.MIN_BALL_NUMBER,BBall.MAX_BALL_NUMBER,MAX_BALL_COUNT);

        return convertInt2BBall(intList);
    }

    public List<BBall> generateInputBall(String input) {

        List<Integer> intList = new ArrayList<>();

        for(int i=0; i<MAX_BALL_COUNT; ++i){
            int now = Character.getNumericValue(input.charAt(i));
            intList.add(now);
        }

        return convertInt2BBall(intList);
    }

    private List<BBall> convertInt2BBall(List<Integer> intList){

        List<BBall> bBallList = new ArrayList<>();

        for(int i =0; i<MAX_BALL_COUNT; ++i){
            BBall bBall = new BBall(intList.get(i));
            bBallList.add(bBall);
        }

        return bBallList;
    }
}
