public class Vampire extends Enemy {
    private float enemymisschance=0.3f;

    public Vampire(int health) {
        super(health);
        setAttackPoint(50);
    }



    public void attackHero(Hero hero)
    {
        System.out.println(String.format("Вампир атаковал врага %s", hero.getName()));
        hero.takeDamage(getAttackPoint());
        System.out.println(String.format("Вампир нанес %s урона", getAttackPoint()));

    }

    @Override
    public void takeDamage(int damage)
    { if (Math.random()<enemymisschance)
        {
        System.out.println("Противник промахнулся");
        }
       else
       {
           setHealth(getHealth()-damage);
       }
    }

    @Override
    public boolean isAlive()
    {
        if (getHealth()<=0)
        {
        System.out.println("Вампир мертв");
        }
        return getHealth()>0;

    }
}
