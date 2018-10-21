package com.xoul.ru.magone.model.entitys;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.PlayerModel;

public class HalfDamageEntity extends PermanentEffectEntity {
    public HalfDamageEntity(int MaxSteps) {
        super(MaxSteps);
    }

    @Override
    public void effect(Damage damage, PlayerModel target) {
        damage.damage/=2;
    }
}
