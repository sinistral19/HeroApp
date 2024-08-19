public abstract class Enemy implements Mortal {
    private int health;
    private  int attackPoint;

    public Enemy(int health) {
        this.health = health;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public abstract void attackHero(Hero hero);

    public void takeDamage(int damage)
    {
        setHealth(getHealth()-damage);
    }
    @Override
    public boolean isAlive()
    {   System.out.println("Враг мертв");
        return health>0;

    }
}
