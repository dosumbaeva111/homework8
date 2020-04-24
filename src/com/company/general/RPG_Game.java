package com.company.general;

import com.company.players.*;

public class RPG_Game {
    private static int round_counter = 0;

    public static void startGame() {
        Boss boss = new Boss(700, 50);

        Warrior warrior = new Warrior(250, 20);
        Magic magic = new Magic(280, 10);
        Medic medic = new Medic(260, 15, 10);
        Hunter hunter = new Hunter(270, 25);
        Medic youngMedic = new Medic(290, 0, 5);

        Hero[] heroes = {warrior, magic, medic, hunter, youngMedic};

        printStatistics(boss, heroes, "Before game start");
        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }

    }

    private static void round(Boss boss, Hero[] heroes) {
        round_counter++;
        if (boss.getHealth() > 0) {
            bossHit(boss, heroes);
        }
        heroesHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistics(boss, heroes, "After Round " + round_counter);
    }

    private static void printStatistics(Boss boss, Hero[] heroes, String round_name) {
        System.out.println(round_name + " _________________");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth());
        }
        System.out.println("_________________");
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (boss.getHealth() - heroes[i].getDamage() < 0) {
                    boss.setHealth(0);
                } else {
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                }
            }
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i].getHealth() - boss.getDamage() < 0) {
                    heroes[i].setHealth(0);
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                }
            }
        }
    }

    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() < 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}