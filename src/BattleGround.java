import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BattleGround {
    public static void main(String[] args)
    {
        List<Hero> heroes=new ArrayList<>();
        heroes.add(new Warrior("Воин1",100,20,3));
        heroes.add(new Mage("Маг2",50,40,2));
        heroes.add(new Archer("Лучник3",70,10,5));

        List<Enemy> emenyes=new ArrayList<>();
        emenyes.add(new Zombie(100));
        emenyes.add(new Zombie(50));
        emenyes.add(new Vampire(100));
        ArrayDeque<Mortal> turns = createDeque(heroes,emenyes);

        while(heroes.size()>0 && emenyes.size()>0)
        {
           if(turns.peek().isAlive()==true)
           {
            if(turns.peek() instanceof Hero)
            {
              Hero hero=(Hero)turns.poll();
              int enemyId=(int)(Math.random() * (emenyes.size()-1));

              hero.attackEnemy(emenyes.get(enemyId));
                try {
                    Thread.sleep(1500);
                }catch(InterruptedException e) {

                }
              if(emenyes.get(enemyId).isAlive()==false)
              {
                  emenyes.remove(enemyId);
              }

              turns.addLast(hero);

            }
            else if (turns.peek() instanceof Enemy)
            {
                Enemy enemy=(Enemy)turns.poll();
                int heroId=(int)(Math.random() * (heroes.size()-1));

                enemy.attackHero(heroes.get(heroId));
                try {
                    Thread.sleep(1500);
                }catch(InterruptedException e) {}
                if(heroes.get(heroId).isAlive()==false)
                {
                    heroes.remove(heroId);
                }


                turns.addLast(enemy);

            }
           }
           else
           {
               turns.poll();
           }
        }

    }

   static ArrayDeque<Mortal> createDeque(List<Hero> heroes,List<Enemy> enemies)
    {   ArrayDeque turns=new ArrayDeque();
        List<Mortal> units=new ArrayList<Mortal>(heroes);
        units.addAll(enemies);

        while (units.size()>0)
        {   int i=(int) (Math.random() * (units.size()-1));
            turns.offer(units.get(i));
            units.remove(i);
        }
        return  turns;
    }
}
