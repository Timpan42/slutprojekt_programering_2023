public class tank {
    public int hp = 3;
    public int warPoints;
    public int x;
    public int y;
    public int damage = 1;
    public boolean living = true;

    public int getHp() {
        return hp;
    }

    public void setHp(int number) {
        this.hp = hp + number;
    }

    public int getWarPoints() {
        return warPoints;
    }

    public void setWarPoints(int Points) {
        this.warPoints =  warPoints + Points;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDamage(){
        return damage;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public void shot(){
        warPoints -= 2;
    }
    public void move(){
        warPoints -= 1;
    }
    public void heal(){
        warPoints -= 2;
        hp += 1;
    }
    public void takeDamage(){
        hp -= damage;
    }
}

