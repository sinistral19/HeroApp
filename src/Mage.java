public class Mage extends Hero {
    private int mane;
    private float oneHitKillChance=0.01f;
    public Mage(String name, int health,int attackPoints,int mane) {
        super(name, health);
        setAttackPoint(attackPoints);
        this.mane=mane;
    }

    public int getMane() {
        return mane;
    }

    public void setMane(int mane) {
        this.mane = mane;
    }

    @Override
    public void attackEnemy(Enemy enemy)
    {
        if (Math.random()<oneHitKillChance)
        {
            System.out.println(String.format("Маг %s атаковал врага", getName()));
            enemy.takeDamage(enemy.getHealth());
        }
        else if(mane>0) {
            System.out.println(String.format("Маг %s атаковал врага", getName()));
            enemy.takeDamage(getAttackPoint());
            System.out.println(String.format("Маг %s нанес %s урона", getName(), getAttackPoint()));
            setMane(getMane()-1);


        }
        else
        {
            System.out.println(String.format("Магу %s не хватает маны для сотворения заклинания", getName()));
            setMane(getMane()+1);
        }
    }

    @Override
    public boolean isAlive()
    {  if (getHealth()<=0)
    {
        System.out.println("Маг мертв");
    }
        return getHealth()>0;

    }
}
