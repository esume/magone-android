package com.xoul.ru.magone.model.entitys;

import com.xoul.ru.magone.model.Hero;
import com.xoul.ru.magone.model.PlayerModel;

public class DoubleManaChargeEntity extends EndOfTurnEffectEntity {
    public DoubleManaChargeEntity(int MaxSteps) {
        super(MaxSteps);
    }

    @Override
    public void effect(Hero hero, PlayerModel target) {
        target.addMP();
    }

}
