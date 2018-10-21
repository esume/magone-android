package com.xoul.ru.magone.model.entitys;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.PlayerModel;

public class PermanentEffectEntity extends Entity {
    public PermanentEffectEntity(int MaxSteps) {
        this.MaxSteps = MaxSteps;
        this.StepsToGo = MaxSteps;
    }

    public void effect(Damage damage, PlayerModel target){

    }
}
