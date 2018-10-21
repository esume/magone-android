package com.xoul.ru.magone.model.spells;

import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.Rune;
import com.xoul.ru.magone.model.Target;
import com.xoul.ru.magone.model.entitys.SpawnNamesOfEntitys;

import java.util.List;

public class SpellDescriptor {
    private boolean targetable;
    private int damage;
    private int heal;
    private int manatocut;
    private SpellType spellType;
    private EffectType effectType;
    private Target target;
    private String name;
    private String description;
    private SpawnNamesOfEntitys SpawnName;
    private List<Rune> runes;

    public SpellDescriptor(boolean targetable, int damage, int heal, SpellType spellType, EffectType effectType, Target target, String name, String description, int manatocut, SpawnNamesOfEntitys SpawnName, List<Rune> runes) {
        this.targetable = targetable;
        this.damage = damage;
        this.heal = heal;
        this.spellType = spellType;
        this.effectType = effectType;
        this.target = target;
        this.name = name;
        this.description = description;
        this.manatocut = manatocut;
        this.SpawnName = SpawnName;
        this.runes = runes;
    }

    public SpawnNamesOfEntitys getSpawnName() {
        return SpawnName;
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public boolean isTargetable() {
        return targetable;
    }

    public int getDamage() {
        return damage;
    }

    public int getHeal() {
        return heal;
    }

    public int getManatocut() {
        return manatocut;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public Target getTarget() {
        return target;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {

        return description;
    }
}
