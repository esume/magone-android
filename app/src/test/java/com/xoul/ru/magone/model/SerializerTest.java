package com.xoul.ru.magone.model;

import com.xoul.ru.magone.model.spells.SpellStorage;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class SerializerTest {

    Serializer s;

    public SerializerTest() {
        try {
            s = new Serializer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParse() throws Exception {

        List<Rune> list = new LinkedList<Rune>();
     //   list.add(Rune.LIFE);
        list.add(Rune.FIRE);

    }
}