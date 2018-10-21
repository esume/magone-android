package com.xoul.ru.magone.model.entitys;

import com.xoul.ru.magone.model.Hero;
import com.xoul.ru.magone.model.PlayerModel;

public class EndOfTurnEffectEntity extends Entity {
    public EndOfTurnEffectEntity(int MaxSteps) {
        this.MaxSteps = MaxSteps;
        this.StepsToGo = MaxSteps;
    }

    public void effect(Hero hero, PlayerModel target){

    }

}
