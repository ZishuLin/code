package Characters;

import Attacks.*;

import java.awt.Point;
import java.util.ArrayList;

public class Priest extends Caster{

    public Priest(String name, int intellect, int maxHP, Point position, int maxMana){
        super(name, intellect, maxHP, position, maxMana);
        MeleeAttack wand = new MeleeAttack(0, "Wand", 3, 3);
        DamageSpell smite = new DamageSpell(10, "Smite", 10, 7);
        HealingSpell flash_heal = new HealingSpell(20, "Flash Heal", 15, 15);
        Resurrection resurrection = new Resurrection();
        attackList.add(wand);
        attackList.add(smite);
        attackList.add(flash_heal);
        attackList.add(resurrection);
    }
}