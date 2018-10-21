package com.xoul.ru.magone.model.entitys;

import com.xoul.ru.magone.model.TypeOfEntity;

public class Entity {
    //оставшееся количество ходов до удаления
    protected int StepsToGo;
    //максимальное количество ходов которые существо будет существовать если его не убрать ранее или не создать такое же, что продлит жизнь
    protected int MaxSteps;
    //Имя существа
    private String name;
    //описание
    private String Description;
    //ключ-набор рун по которому его можно будет отыскать в листе
    private String Key;
    //тип существа с постоянным эффектом/с эффектом в конце хода
    private TypeOfEntity type;

    public int getStepsToGo() {
        return StepsToGo;
    }

    public TypeOfEntity getType() {
        return type;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return Key;
    }

    public void endofturn(){
        StepsToGo--;
    }
}
