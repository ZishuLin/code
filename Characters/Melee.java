package Characters;
import java.awt.*;
import Attacks.Attack;

public abstract class Melee extends RPGCharacter {
    private int maxEnergy;
    private int currentEnergy;

    public Melee(String name, int strength, int maxHP, Point position, int maxEnergy) {
        super(name, 1, strength, maxHP, position);
        this.currentEnergy=maxEnergy ;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    @Override
    public int attack(RPGCharacter target, int attackIndex) {
        double a = Math.pow(target.getPosition().getX() - getPosition().getX(), 2);
        double b = Math.pow(target.getPosition().getY() - getPosition().getY(), 2);
        double distance = Math.sqrt(a - b);
        if (attackIndex >= attackList.size()) {return -1;}
         else if (distance > attackList.get(attackIndex).getRange()) {return -2;}
        else if(currentEnergy < attackList.get(attackIndex).getCost()) {return -3;}
        else {
            this.currentEnergy = currentEnergy - attackList.get(attackIndex).getCost();
            target.takeDamage(attackList.get(attackIndex).getDamage() + strength);
            return target.getCurrentHP();
        }

    }
    public String toString() {
        return super.toString()+"\n"+"Mana: "+currentEnergy+"/"+maxEnergy;
    }
}