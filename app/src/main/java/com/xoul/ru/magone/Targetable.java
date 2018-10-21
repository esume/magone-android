package com.xoul.ru.magone;

import com.xoul.ru.magone.model.PlayerModel;

public interface Targetable {
    boolean hasTarget();
    void setTarget(PlayerModel target);
}
