package com.xoul.ru.magone.model.effects;

import com.xoul.ru.magone.model.Effect;
import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.Heal;

public class DeathEffect extends Effect {
    public DeathEffect(int timeleft, boolean available, EffectType type, int healAmmount, int damageAmmount) {
        super(timeleft, available, type, healAmmount, damageAmmount);
    }

    @Override
    public Heal heal(Heal healAmmount) {
        healAmmount.heal-=3;
        return healAmmount;
    }

    @Override
    public boolean isOpposite(EffectType type) {
        if (type == EffectType.HEAL){
            unavailable();
            return true;
        }
        return false;
    }
}
