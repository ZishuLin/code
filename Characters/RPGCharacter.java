package Characters;
import java.awt.*;
import Attacks.Attack;
import java.util.ArrayList;

public abstract class  RPGCharacter{
    private String name;
    private int maxHP;
    private Point position;
    public int currentHP;
    public int intellect;
    public int strength;
    protected ArrayList<Attack> attackList;

    public RPGCharacter(String name, int intellect, int strength, int maxHP, Point position){
        this.name = name;
        this.intellect = intellect;
        this.strength = strength;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.position = position;
        attackList = new ArrayList<Attack>();
    }
    public int getCurrentHP(){return currentHP;}
    public Point getPosition(){
        return position;
    }
    public int getMaxHP(){return maxHP;}
    public String getName(){return name;}

    public void move(int x, int y){
        position.translate(x, y);
    }
    public boolean takeDamage(int damage){
        if (damage<0){damage=0;}
        this.currentHP-=damage;
        if (currentHP<0){
            currentHP=0;
            return false;
        }
        return true;
    }
    public boolean heal (int Hp){
        this.currentHP+=Hp;
        if (currentHP>maxHP){
            currentHP=maxHP;
            return true;
        }
        return false;
    }
    public abstract int attack(RPGCharacter target, int attackIndex );

    public String getAttacks(){
        String list="";
        for (int i=0;i<attackList.size();i++) {
            list+=i+" - "+attackList.get(i)+"\n";
        }
        return list;
    }
        public String toString(){
        return this.name+" ("+getClass().getSimpleName()+") "+" - "+currentHP+"/"+maxHP;
        }


}