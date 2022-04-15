package baseball;

public class BBReferee {
    public boolean isEndGame(Player player) {

        if(player.getStrike() == 3){
            return true;
        }

        return false;
    }
}
