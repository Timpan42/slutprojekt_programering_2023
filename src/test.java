public class test {
    private  client c;

    public test(client c) {
        this.c = c;
    }

    public static void main(String[] args) {
        client c1 = new client();
        client c2 = new client();
        c1.setWarPoints(1);
        c1.setX(100);
        c1.setY(100);
        c1.movePlayer();
        c1.setHp(-2);
        c1.setWarPoints(2);
        c1.healPlayer();
        System.out.println("WP: " +c1.getWarPoints() + "\n"
                + "X: " + c1.getX() + "\n"
                + "Y: " + c1.getY() + "\n"
                + "HP: "+ c1.getHp()
        );

    }
}
