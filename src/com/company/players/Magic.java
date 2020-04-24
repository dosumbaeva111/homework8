package com.company.players;

import com.company.players.AbilityType;
import com.company.players.Boss;
import com.company.players.Hero;

public class Magic extends Hero {

    public Magic(int health, int damage) {
        super(health, damage, AbilityType.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this != heroes[i] && heroes[i].getHealth() > 0) {
                heroes[i].setDamage(heroes[i].getDamage() + 5);

            }
        }
    }
}