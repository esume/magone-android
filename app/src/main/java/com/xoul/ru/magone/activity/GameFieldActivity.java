package com.xoul.ru.magone.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.xoul.ru.magone.GameController;
import com.xoul.ru.magone.R;
import com.xoul.ru.magone.fragment.GameOverFragment;
import com.xoul.ru.magone.fragment.SpellListFragment;
import com.xoul.ru.magone.model.GameModel;
import com.xoul.ru.magone.model.Serializer;
import com.xoul.ru.magone.view.player.PlayerField;

import java.io.IOException;
import java.io.InputStream;

public class GameFieldActivity extends Activity implements HelpOpener {
    private SpellListFragment spellListFragment;
    private GameOverFragment gameOverFragment;
    private LinearLayout layout;

    private GameModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
        PlayerField playerField1 = (PlayerField) findViewById(R.id.playerField1);
        PlayerField playerField2 = (PlayerField) findViewById(R.id.playerField2);
        layout = (LinearLayout) findViewById(R.id.container);
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.spells);
            Serializer serializer = new Serializer(inputStream);
            model = new GameModel(serializer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameController controller = new GameController(model, playerField1, playerField2, this);

        spellListFragment = new SpellListFragment();
        spellListFragment.setBackButtonClickListener(new CloseHelpButtonListener());
        gameOverFragment = new GameOverFragment();
    }

    @Override
    public void openHelp(boolean rotated) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.container, spellListFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        if (rotated) {
            layout.setRotation(180);
        }
    }

    @Override
    public void closeHelp() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        }
        layout.setRotation(0);
    }

    public void openGameOver(boolean rotated) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.container, gameOverFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        if (rotated) {
            layout.setRotation(180);
        }
    }

    public void closeGameOver() {
        closeHelp();
    }

    public GameModel getModel() {
        return model;
    }

    private class CloseHelpButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            closeHelp();
        }
    }
}
