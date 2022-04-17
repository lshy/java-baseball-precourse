package baseball;

public class BBOutputController {
    public void outputPlayer(Player user) {

        StringBuffer sb = new StringBuffer();
        sb.append(user.getBall())
                .append("볼 ")
                .append(user.getStrike())
                .append("스트라이크");

        System.out.println(sb.toString());

    }

    public void outputNothing() {

        System.out.println("낫싱");

    }

    public void outputEndGame() {

        StringBuffer sb = new StringBuffer();
        sb.append(BBallGenerator.MAX_BALL_COUNT)
                .append("개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println(sb.toString());

    }
}
