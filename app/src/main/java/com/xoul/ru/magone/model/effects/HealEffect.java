package com.xoul.ru.magone.model.effects;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.Effect;
import com.xoul.ru.magone.model.EffectType;

public class HealEffect extends Effect {
    public HealEffect(int timeleft, boolean available, EffectType type, int healAmmount, int damageAmmount) {
        super(timeleft, available, type, healAmmount, damageAmmount);
    }

    @Override
    public Damage damage(Damage damage) {
        if (damage.effectType == EffectType.DEATH) {
            damage.damage -= 3;
        }
        return damage;
    }

    @Override
    public boolean isOpposite(EffectType type) {
        if (type == EffectType.DEATH) {
            unavailable();
            return true;
        }
        return false;
    }
}
