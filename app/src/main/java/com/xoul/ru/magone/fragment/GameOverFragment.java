package com.xoul.ru.magone.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xoul.ru.magone.R;
import com.xoul.ru.magone.activity.GameFieldActivity;

public class GameOverFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gameover, container, false);
        View layout = view.findViewById(R.id.gameOverLayout);
        layout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        ((GameFieldActivity) getActivity()).closeGameOver();
    }
}
