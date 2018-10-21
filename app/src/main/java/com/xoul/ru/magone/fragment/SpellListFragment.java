package com.xoul.ru.magone.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.xoul.ru.magone.R;
import com.xoul.ru.magone.activity.GameFieldActivity;
import com.xoul.ru.magone.adapter.SpellAdapter;
import com.xoul.ru.magone.model.spells.SpellDescriptor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpellListFragment extends Fragment {
    private View backButton;
    private View.OnClickListener backButtonClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spells, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        backButton = view.findViewById(R.id.backButton);
        if (backButtonClickListener != null) {
            backButton.setOnClickListener(backButtonClickListener);
        }
        List<SpellDescriptor> spells = new LinkedList<>();
        Map<String, SpellDescriptor> spellMap = ((GameFieldActivity) getActivity()).getModel().getSpellMap();
        spells.addAll(spellMap.values());
        listView.setAdapter(new SpellAdapter(getActivity(), spells));
        return view;
    }

    public void setBackButtonClickListener(View.OnClickListener listener) {
        backButtonClickListener = listener;
        if (backButton != null) {
            backButton.setOnClickListener(backButtonClickListener);
        }
    }
}
