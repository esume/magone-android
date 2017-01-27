package tk.esume.magone.tk.esume.magone.essential;

/**
 * Created by Виталий on 27.01.2017.
 */

public class Hero {
    int maxHp;
    int currentHp;
    int maxMana;
    int currentMana;

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }
}
