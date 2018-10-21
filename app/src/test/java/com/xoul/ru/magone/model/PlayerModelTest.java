package com.xoul.ru.magone.model;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class PlayerModelTest {
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
        pl1 = gm.getPlayer1();
        pl2 = gm.getPlayer2();
    }

    @Test
    public void testGetHp() throws Exception {
        assertEquals("Полученное хп не верно", 50, gm.getPlayer1().getHp());
    }

    @Test
    public void testGetMp() throws Exception {
        assertEquals("Полученное mp не верно", 10, pl1.getMp());

    }



    @Test
    public void testDamage() throws Exception {
        int hp = pl1.getHp();
        pl1.damage(new Damage(3, EffectType.DEATH));
        assertEquals("Что то не так с дамагом", hp - 3, pl1.getHp());
        hp = pl1.getHp();
        pl1.damage(new Damage(6, EffectType.DEATH));
        assertEquals("Что то не так с дамагом", hp - 6, pl1.getHp());
        hp = pl1.getHp();
        pl1.damage(new Damage(-2, EffectType.DEATH));
        assertEquals("Что то не так с дамагом", hp, pl1.getHp());
    }

    @Test
    public void testHeal() throws Exception {
        pl1.damage(new Damage(30, EffectType.DEATH));
        int hp = pl1.getHp();
        pl1.heal(new Heal(3));
        assertEquals("Что то не так с хилом", hp + 3, pl1.getHp());
        pl1.heal(new Heal(300));
        assertEquals("Что то не так с хилом", 50, pl1.getHp());
        pl1.heal(new Heal(-300));
        assertEquals("Что то не так с хилом", 50, pl1.getHp());
    }


    @Test
    public void testAddEffect() throws Exception {
        pl1.addEffect(EffectType.DEATH);
        assertTrue("Добавлен не тот эффект или не добаввлен вовсе", !pl1.currentEffects.isEmpty() && pl1.currentEffects.get(0).type == EffectType.DEATH);
    }

}