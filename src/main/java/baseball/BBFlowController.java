package baseball;

public class BBFlowController {

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

        if("1".equals(reGame)){
            return true;
        }

        return false;
    }

    private void playGame(){

        do{

        bbInputController.inputNumber();
        checkUserStatus();

        }while(bbReferee.isEndGame(user));

    }

}
