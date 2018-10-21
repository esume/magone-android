package com.xoul.ru.magone;

import com.xoul.ru.magone.model.PlayerModel;

public interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();

    void endOfGame(PlayerModel winner);
}
