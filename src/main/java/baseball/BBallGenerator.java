package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BBallGenerator {

    public static final int MAX_BALL_COUNT = 3;

    public List<BBall> generateRandomBall() {

        Set<Integer> randomIntSet = makeRandomIntSet();
        List<Integer> intList = new ArrayList<>();

        Iterator<Integer> it = randomIntSet.iterator();
        while(it.hasNext()){
            intList.add(it.next());
        }

        return convertInt2BBall(intList);
    }

    public List<BBall> generateInputBall(String input) {

        checkInputLengthValid(input);

        List<Integer> intList = new ArrayList<>();

        for(int i=0; i<BBallGenerator.MAX_BALL_COUNT; ++i){
            intList.add(Character.getNumericValue(input.charAt(i)));
        }

        checkInputDuplicateValid(intList);

        return convertInt2BBall(intList);
    }

    private void checkInputDuplicateValid(List<Integer> intList) {

        Set<Integer> inputIntSet = new HashSet<>();

        for(int i=0; i<MAX_BALL_COUNT; ++i){
            inputIntSet.add(intList.get(i));
        }

        if(inputIntSet.size() != BBallGenerator.MAX_BALL_COUNT){
            throw new IllegalArgumentException("서로 다른 수로 이루어져야 합니다.");
        }

    }

    private void checkInputLengthValid(String input) {

        if(input.length() != BBallGenerator.MAX_BALL_COUNT){
            throw new IllegalArgumentException("3자리 숫자를 입력해 주세요.");
        }

    }

    private List<BBall> convertInt2BBall(List<Integer> intList){

        List<BBall> bBallList = new ArrayList<>();

        for(int i =0; i<MAX_BALL_COUNT; ++i){
            BBall bBall = new BBall(intList.get(i));
            bBallList.add(bBall);
        }

        return bBallList;
    }

    public Set<Integer> makeRandomIntSet(){

        Set<Integer> randomIntSet = new HashSet<>();

        while(randomIntSet.size() != BBallGenerator.MAX_BALL_COUNT){
            randomIntSet.add(Randoms.pickNumberInRange(BBall.MIN_BALL_NUMBER, BBall.MAX_BALL_NUMBER));
        }

        return randomIntSet;

    }
}
