package Characters;

import Attacks.Attack;
import Attacks.DamageSpell;
import Attacks.HealingSpell;
import Attacks.MeleeAttack;

import java.awt.*;
public abstract class Caster extends RPGCharacter {
    private int maxMana;
    private int currentMana;

    public Caster(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, 1, maxHP, position);
        this.currentMana = maxMana;


    }

    public int getCurrentMana() {
        return currentMana;
    }

    @Override
    public int attack(RPGCharacter target, int attackIndex) {

        double a = Math.pow(target.getPosition().getX() - getPosition().getX(), 2);
        double b = Math.pow(target.getPosition().getY() - getPosition().getY(), 2);
        double distance = Math.sqrt(a - b);
        if (attackIndex >= attackList.size()) {return -1;}
        else if (distance > attackList.get(attackIndex).getRange()){ return -2;}
        else if (currentMana < attackList.get(attackIndex).getCost()){ return -3;}
        else{


        if (attackList.get(attackIndex) instanceof MeleeAttack) {
            this.currentMana =currentMana- attackList.get(attackIndex).getCost();
            attackList.get(attackIndex).interactWithTarget(target, 0);

        } else if (attackList.get(attackIndex) instanceof HealingSpell) {
            this.currentMana =currentMana- attackList.get(attackIndex).getCost();
            attackList.get(attackIndex).interactWithTarget(this, intellect);

        } else if (attackList.get(attackIndex) instanceof DamageSpell) {
            this.currentMana =currentMana- attackList.get(attackIndex).getCost();
            attackList.get(attackIndex).interactWithTarget(target, intellect);

        }

        return target.getCurrentHP();
    }
        }



    public String toString() {
        return super.toString()+"\n"+"Mana: "+currentMana+"/"+maxMana;
    }

}