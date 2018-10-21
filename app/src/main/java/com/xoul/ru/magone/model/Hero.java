package com.xoul.ru.magone.model;

public class Hero {
    private int currenthp;
    private int mpcharge;
    private final int MAXHP;

    public int getMAXHP() {
        return MAXHP;
    }

    public Hero(int MAXHP, int mpcharge) {
        this.mpcharge = mpcharge;
        this.MAXHP = MAXHP;
        currenthp = MAXHP;

    }

    public int getCurrenthp() {
        return currenthp;
    }

    public int getMpcharge() {
        return mpcharge;
    }

    public void damage(Damage damage) {
        if (damage.damage >= 0)
            currenthp -= damage.damage;
    }

    public void heal(Heal heal) {
        if (heal.heal >= 0)
            currenthp += heal.heal;
        if (currenthp > MAXHP) currenthp = MAXHP;
    }
}
