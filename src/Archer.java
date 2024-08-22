public class Archer extends Hero {
    private int endurance;
    private float doubleAttakChance=0.05f;
    public Archer(String name, int health,int attackPoints,int endurance) {
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
            System.out.println(String.format("Лучник %s атаковал врага", getName()));
            enemy.takeDamage(getAttackPoint());
            System.out.println(String.format("Лучник %s нанес %s урона", getName(), getAttackPoint()));
            setEndurance(getEndurance()-1);
            if (Math.random()<doubleAttakChance)
            {
                System.out.println(String.format("Лучник %s атаковал врага", getName()));
                enemy.takeDamage(getAttackPoint());
            }

        }
        else
        {
            System.out.println(String.format("Лучник %s обессилен и не может стрелять", getName()));
            setEndurance(getEndurance()+1);
        }
    }

    @Override
    public boolean isAlive()
    {   if (getHealth()<=0)
    {
        System.out.println("Лучник мертв");
    }
        return getHealth()>0;

    }
}
