package com.xoul.ru.magone.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xoul.ru.magone.model.entitys.SpawnNamesOfEntitys;
import com.xoul.ru.magone.model.spells.SpellDescriptor;
import com.xoul.ru.magone.model.spells.SpellStorage;
import com.xoul.ru.magone.model.spells.SpellType;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class Serializer {
    InputStreamReader inputStreamReader;
    private GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson = gsonBuilder.create();

    public Serializer(InputStream inputStream) throws FileNotFoundException {
        inputStreamReader = new InputStreamReader(inputStream);
    }

    public SpellStorage parse(SpellStorage spellStorage) throws FileNotFoundException {
        spellStorage = gson.fromJson(inputStreamReader, SpellStorage.class);
//        Log.d("serializer:",gson.toJson(spellStorage));
//        List<Rune> l = new LinkedList<Rune>();
//        l.add(Rune.DEATH);
//        l.add(Rune.FIRE);
//        SpellDescriptor spellDescriptor = new SpellDescriptor(true, 5, 0, SpellType.Spawn, EffectType.DEATH, Target.ENEMY, "sdfs", "sdfsdf", 1, SpawnNamesOfEntitys.DoubleDamage, l);
//        Log.d("serializer:", gson.toJson(spellDescriptor));
        return spellStorage;
    }

}
