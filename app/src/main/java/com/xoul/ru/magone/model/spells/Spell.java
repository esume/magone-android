package com.xoul.ru.magone.model.spells;

import com.xoul.ru.magone.Targetable;
import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.Heal;
import com.xoul.ru.magone.model.PlayerModel;
import com.xoul.ru.magone.model.entitys.SpawnNamesOfEntitys;

public class Spell implements Targetable {
    public SpellType spellType;
    public Heal heal;
    public EffectType effectType;
    public Damage damage;
    public PlayerModel target;
    public int manaAmountToCut;
    private boolean settingEffect = true;
    public SpawnNamesOfEntitys SpawnName;

    public Spell(PlayerModel target, SpellType spellType, Heal heal, Damage damage, int manaAmountToCut, SpawnNamesOfEntitys SpawnName) {
        this.target = target;
        this.spellType = spellType;
        this.heal = heal;
        this.damage = damage;
        this.manaAmountToCut = manaAmountToCut;
        if (damage != null)
            effectType = damage.effectType;
        this.SpawnName = SpawnName;
    }

    public boolean isSettingEffect() {
        return settingEffect;
    }

    public void findOppositEffect() {
        settingEffect = false;
    }

    @Override
    public boolean hasTarget() {
        if (target == null)
            return false;
        return true;
    }

    @Override
    public void setTarget(PlayerModel target) {
        this.target = target;
    }
}
