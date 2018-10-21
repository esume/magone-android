package com.xoul.ru.magone.model.spells;

import com.xoul.ru.magone.model.Rune;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SpellStorage {
    private Map<String, SpellDescriptor> spellMap;

    public SpellStorage() {
        spellMap = new LinkedHashMap<String, SpellDescriptor>();
    }

    public Map<String, SpellDescriptor> getSpellMap() {
        return spellMap;
    }

    public SpellDescriptor getSpellDescriptor(List<Rune> spell) {
        String key = "";
        for (Rune r : spell) {
            if (r.equals(Rune.DEATH)) key += "DEATH";
            if (r.equals(Rune.FIRE)) key += "FIRE";
            if (r.equals(Rune.WATER)) key += "WATER";
            if (r.equals(Rune.LIFE)) key += "LIFE";
        }
        return spellMap.get(key);
    }
}
