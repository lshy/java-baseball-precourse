package baseball;

public class BBOutputController {
    public void outputPlayer(Player user) {

        StringBuffer sb = new StringBuffer();
        sb.append(user.getStrike())
                .append("스트라이크 ")
                .append(user.getBall())
                .append("볼");

        System.out.println(sb.toString());

    }

    public void outputNothing() {
        System.out.println("낫싱");
    }
}
