package com.xoul.ru.magone.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameModelTest {
    GameModel gm;
    PlayerModel pl1;
    PlayerModel pl2;

    @Before
    public void init() {
        try {
            gm = new GameModel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pl1 = gm.getCurrentPlayer();
        pl2 = gm.getEnemy();
    }

    @Test
    public void testEndOfTurn() throws Exception {
        gm.getCurrentPlayer().addEffect(EffectType.DEATH);
        gm.getCurrentPlayer().addEffect(EffectType.FIRE);
        int hp = gm.getCurrentPlayer().getHp();
        gm.endOfTurn();
        assertTrue("Не очищается текущее заклинание", gm.getCurrentPlayer().currentSpell.isEmpty());
        assertEquals("Не работают эффекты в конце хода", hp - 4, gm.getEnemy().getHp());
    }

    @Test
    public void testCastASpell() throws Exception {
        pl1.currentEffects.clear();
        pl2.currentEffects.clear();
        int hp;
        pl1.addRuneToCurrentSpell(Rune.FIRE);
        hp = pl2.getHp();
        gm.castASpell();
        Assert.assertEquals("Тест валится на заклинании огня", hp - Constants.SMALLFIREDAMAGE, pl2.getHp());
        pl2.currentEffects.clear();

        pl1.addRuneToCurrentSpell(Rune.DEATH);
        hp = pl2.getHp();
        gm.castASpell();
        Assert.assertEquals("Тест валится на заклинании смерти", hp - Constants.SMALLDEATHAMMOUNT, pl2.getHp());
        pl2.currentEffects.clear();

        pl1.addRuneToCurrentSpell(Rune.WATER);
        hp = pl2.getHp();
        gm.castASpell();
        Assert.assertEquals("Тест валится на заклинании водицы", hp - Constants.SMALLWATERAMMOUNT, pl2.getHp());
        pl2.currentEffects.clear();

        pl1.damage(new Damage(4,null));
        pl1.addRuneToCurrentSpell(Rune.LIFE);
        pl1.currentEffects.clear();
        hp = pl1.getHp();
        gm.castASpell();
        Assert.assertEquals("Тест валится на заклинании лечения", hp + Constants.SMALLHEALAMMOUNT, pl1.getHp());
        pl1.currentEffects.clear();
    }
}

