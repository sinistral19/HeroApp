public abstract class Hero implements Mortal{
    private String name;
    private int health;
    private int attackPoint;

    public Hero(String name,int health) {
        this.name = name;
        this.health=health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int Health) {
        health = Health;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public abstract void attackEnemy(Enemy enemy);
    //public void attackEnemy(){System.out.println("Атака");}

   public void takeDamage(int damage)
   {
       setHealth(getHealth()-damage);
   }


   public boolean isAlive()
    {
        return health>0;
    }
}
