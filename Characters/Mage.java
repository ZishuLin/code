package Characters;

import Attacks.Attack;
import Attacks.DamageSpell;
import Attacks.MeleeAttack;

import java.awt.Point;
import java.util.ArrayList;

public class Mage extends Caster{

    public Mage(String name, int intellect, int maxHP, Point position, int maxMana){
        super(name, intellect, maxHP, position, maxMana);
        MeleeAttack staff = new MeleeAttack(0, "Staff", 3, 3);
        DamageSpell fire_ball = new DamageSpell(20, "Fire Ball", 10, 20);
        DamageSpell frost_ball = new DamageSpell(15, "Frost Ball", 7, 15);
        DamageSpell lightning = new DamageSpell(30, "Lightning", 15, 20);
        attackList.add(staff);
        attackList.add(fire_ball);
        attackList.add(frost_ball);
        attackList.add(lightning);
    }
}