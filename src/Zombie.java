public class Zombie extends Enemy{
    private float chanceReborn=0.1f;

    public Zombie(int health) {
        super(health);
        setAttackPoint(50);
    }



    public void attackHero(Hero hero)
    {
        System.out.println(String.format("Зомби атаковал врага %s", hero.getName()));
        hero.takeDamage(getAttackPoint());
        System.out.println(String.format("зомби нанес %s урона", getAttackPoint()));

    }

    @Override
    public boolean isAlive()
    {
        if (getHealth()<=0)
        {
            System.out.println("Зомби мертв");
        }
        if (getHealth()<=0 && Math.random()<chanceReborn)
        {
            setHealth(100);
            System.out.println("Зомби снова поднимается");
        }
        return getHealth()>0;
    }
}

