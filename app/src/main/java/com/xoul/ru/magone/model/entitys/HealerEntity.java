package com.xoul.ru.magone.model.entitys;

import com.xoul.ru.magone.model.Heal;
import com.xoul.ru.magone.model.Hero;
import com.xoul.ru.magone.model.PlayerModel;

public class HealerEntity extends EndOfTurnEffectEntity {
    public HealerEntity(int MaxSteps) {
        super(MaxSteps);
    }

    @Override
    public void effect(Hero hero, PlayerModel target) {
        hero.heal(new Heal(5));
    }
}
