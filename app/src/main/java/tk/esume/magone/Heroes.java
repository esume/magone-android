package tk.esume.magone;

/**
 * Created by Виталий on 11.01.2017.
 */

public class Heroes {
    int maxCountHp;
    int curCountHp;
    int maxCountMana;
    int curCountMana;

    public int getCurCountHp() {
        return curCountHp;
    }

    public void setCurCountHp(int curCountHp) {
        this.curCountHp = curCountHp;
    }

    public int getCurCountMana() {
        return curCountMana;
    }

    public void setCurCountMana(int curCountMana) {
        this.curCountMana = curCountMana;
    }

    public int getMaxCountHp() {
        return maxCountHp;
    }

    public void setMaxCountHp(int maxCountHp) {
        this.maxCountHp = maxCountHp;
    }

    public int getMaxCountMana() {
        return maxCountMana;
    }

    public void setMaxCountMana(int maxCountMana) {
        this.maxCountMana = maxCountMana;
    }
}
