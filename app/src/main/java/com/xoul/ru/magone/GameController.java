package com.xoul.ru.magone;

import com.xoul.ru.magone.activity.HelpOpener;
import com.xoul.ru.magone.model.GameModel;
import com.xoul.ru.magone.model.PlayerModel;
import com.xoul.ru.magone.model.Rune;
import com.xoul.ru.magone.model.spells.Spell;
import com.xoul.ru.magone.view.Drawer;
import com.xoul.ru.magone.view.player.PlayerField;
import com.xoul.ru.magone.view.player.PlayerListener;
import com.xoul.ru.magone.view.player.unit.Unit;
import com.xoul.ru.magone.view.player.unit.UnitField;

import java.util.List;

public class GameController implements PlayerListener {
    private GameModel model;
    private Drawer drawer;

    private PlayerField player1;
    private PlayerField player2;
    private boolean isPlayer1;
    private HelpOpener helpOpener;

    private PlayerModel player1model;
    private PlayerModel player2model;

    private Spell spell;

    public GameController(GameModel model, PlayerField player1, PlayerField player2, HelpOpener helpOpener) {
        this.model = model;
        this.player1 = player1;
        this.player2 = player2;
        player1model = model.getPlayer1();
        player2model = model.getPlayer2();
        this.helpOpener = helpOpener;
        this.player1.setListener(this);
        this.player2.setListener(this);
        drawer = new Drawer(model, player1, player2);
        isPlayer1 = model.getCurrentPlayer() == model.getPlayer1();
        this.player1.setEnabled(isPlayer1);
        this.player2.setEnabled(!isPlayer1);
    }

    private void togglePlayer() {
        isPlayer1 = !isPlayer1;
        player1.setEnabled(isPlayer1);
        player2.setEnabled(!isPlayer1);
    }

    private PlayerField getCurrentPlayerField() {
        if (isPlayer1) {
            return player1;
        } else {
            return player2;
        }
    }

    @Override
    public void onCast(List<Rune> spell) {
        model.getCurrentPlayer().addRuneToCurrentSpell(spell);
        this.spell = model.createSpell();
        if (this.spell != null) {
            if (this.spell.hasTarget()) {
                model.castASpell(this.spell);
                this.spell = null;
            } else {
                getCurrentPlayerField().setChooseUnit(true);
            }
        }
    }

    @Override
    public void onUnitSelected(PlayerField target, Unit unit, UnitField.Slot slot) {
        if (spell != null) {
            getCurrentPlayerField().setChooseUnit(false);
            PlayerModel player;
            if (target == player1)
                player = player1model;
            else
                player = player2model;
            spell.setTarget(player);
            model.castASpell(spell);
            spell = null;
        }
    }

    @Override
    public void onClear() {
        spell = null;
    }

    @Override
    public void onHelp() {
        helpOpener.openHelp(!isPlayer1);
    }

    @Override
    public void onNextTurn() {
        model.endOfTurn();
        togglePlayer();
    }
}
