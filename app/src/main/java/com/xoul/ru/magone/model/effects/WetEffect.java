package com.xoul.ru.magone.model.effects;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.Effect;
import com.xoul.ru.magone.model.EffectType;

public class WetEffect extends Effect {
    public WetEffect(int timeleft, boolean available, EffectType type, int healAmmount, int damageAmmount) {
        super(timeleft, available, type, healAmmount, damageAmmount);
    }

    @Override
    public Damage damage(Damage damage) {
        if (damage.effectType == EffectType.FIRE)
            damage.damage -= 3;
        return damage;
    }

    @Override
    public boolean isOpposite(EffectType type) {
        if (type == EffectType.FIRE){
            unavailable();
            return true;
        }
        return false;
    }
}
