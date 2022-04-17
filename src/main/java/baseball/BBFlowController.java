package baseball;

import java.util.List;

public class BBFlowController {

    public static final String REGAME_FLAG = "1";
    public static final String ENDGAME_FLAG = "2";

    BBInputController bbInputController;
    BBOutputController bbOutputController;
    BBallGenerator bBallGenerator;
    BBReferee bbReferee;
    Player computer;
    Player user;

    public BBFlowController(){

        bbInputController = new BBInputController();
        bbOutputController = new BBOutputController();
        bBallGenerator = new BBallGenerator();
        bbReferee = new BBReferee();
        computer = new Player();
        user = new Player();

    }
    public void executeGame() {

        do {

            playGame();

        }while(checkReGame());

    }

    private void checkUserStatus(){

        if(user.isNothing()){
            bbOutputController.outputNothing();
            return;
        }

        bbOutputController.outputPlayer(user);

    }

    private boolean checkReGame(){

        String reGame = bbInputController.inputReGame();

        reGameFlagValid(reGame);

        if(REGAME_FLAG.equals(reGame)){
            return true;
        }

        return false;
    }

    private void reGameFlagValid(String reGame) {

        if(!REGAME_FLAG.equals(reGame) && !ENDGAME_FLAG.equals(reGame)){
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요.");
        }
    }

    private void playGame(){

        computer.setbBalls(bBallGenerator.generateRandomBall());

        do{
            String userInput = bbInputController.inputNumber();
            List<BBall> bBallList = bBallGenerator.generateInputBall(userInput);
            user.setbBalls(bBallList);

            bbReferee.doJudgment(computer, user);
            checkUserStatus();

        }while(bbReferee.isEndGame(user));

        bbOutputController.outputEndGame();

    }

}
