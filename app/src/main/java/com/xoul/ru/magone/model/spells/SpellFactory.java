package com.xoul.ru.magone.model.spells;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.Heal;
import com.xoul.ru.magone.model.PlayerModel;
import com.xoul.ru.magone.model.Rune;
import com.xoul.ru.magone.model.Target;

import java.util.List;

public class SpellFactory {
    public static Spell create(List<Rune> list, PlayerModel currentPlayer, PlayerModel enemy, SpellStorage spellStorage) {
        if (list.size() > 0) {
            SpellDescriptor sp = spellStorage.getSpellDescriptor(list);
            Damage damage = new Damage(sp.getDamage(), sp.getEffectType());
            Heal heal = new Heal(sp.getHeal());
            if (sp.getTarget() == Target.CURRENTPLAYER)
                return new Spell(currentPlayer, sp.getSpellType(), heal, damage, sp.getManatocut(), sp.getSpawnName());
            if (sp.getTarget() == Target.ENEMY)
                return new Spell(enemy, sp.getSpellType(), heal, damage, sp.getManatocut(), sp.getSpawnName());
            return new Spell(null, sp.getSpellType(), heal, damage, sp.getManatocut(), sp.getSpawnName());
        }
        return null;
    }

}
