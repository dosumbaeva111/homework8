package com.company.players;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, AbilityType.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
    setDamage(20);
        Random random= new Random(15);
        int number2=random.nextInt(2)+2;
        setDamage(getDamage()*2);
    }
}
