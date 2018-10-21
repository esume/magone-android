package com.xoul.ru.magone;

import com.xoul.ru.magone.model.PlayerModel;

public interface Observer {
    void update();

    void endOfGame(PlayerModel winner);
}

