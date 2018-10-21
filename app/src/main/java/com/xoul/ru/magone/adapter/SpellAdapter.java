package com.xoul.ru.magone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xoul.ru.magone.R;
import com.xoul.ru.magone.model.spells.SpellDescriptor;
import com.xoul.ru.magone.view.player.control.SpellField;
import com.xoul.ru.magone.view.player.rune.Rune;

import java.util.List;

public class SpellAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<SpellDescriptor> spells;

    public SpellAdapter(Context context, List<SpellDescriptor> spells) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.spells = spells;
    }

    @Override
    public int getCount() {
        return spells.size();
    }

    @Override
    public SpellDescriptor getItem(int position) {
        return spells.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_spell, null);
        }
        TextView titleText = (TextView) convertView.findViewById(R.id.spell_title);
        TextView descriptionText = (TextView) convertView.findViewById(R.id.spell_description);
        SpellField spellView = (SpellField) convertView.findViewById(R.id.spell_field);

        SpellDescriptor spell = getItem(position);

        titleText.setText(spell.getName());
        descriptionText.setText(spell.getDescription());
        spellView.clear();
        // TODO replace with real spell
        spellView.addRune(Rune.RuneStyle.FIRE);
        return convertView;
    }
}
