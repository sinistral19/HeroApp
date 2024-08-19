public class Warrior extends Hero {
   private int endurance;
    private int rageAddAttack=1;
    public Warrior(String name, int health,int attackPoints,int endurance) {
        super(name, health);
        setAttackPoint(attackPoints);
        this.endurance=endurance;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    @Override
    public void attackEnemy(Enemy enemy)
    {
if(endurance>0) {
    System.out.println(String.format("Воин %s атаковал врага", getName()));
    enemy.takeDamage(getAttackPoint());
    System.out.println(String.format("Воин %s нанес %s урона", getName(), getAttackPoint()));
    setEndurance(getEndurance()-1);
}
else
{
    System.out.println(String.format("Воин %s оббессилен и не может атаковать", getName()));
    setEndurance(getEndurance()+1);
}
    }

    @Override
    public void takeDamage(int damage)
    {
        super.takeDamage(damage);
        setAttackPoint(getAttackPoint()+rageAddAttack);
    }

    @Override
    public boolean isAlive()
    {
        if (getHealth()<=0)
    {
        System.out.println("Воин мертв");
    }
        return getHealth()>0;

    }
}
