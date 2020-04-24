package com.company.players;

import com.company.players.AbilityType;
import com.company.players.GameEntity;
import com.company.players.HavingSuperAbility;

public abstract class Hero extends GameEntity implements HavingSuperAbility {

    private AbilityType abilityType;

    public Hero(int health, int damage, AbilityType abilityType) {
        super(health, damage);
        this.abilityType = abilityType;
    }
}