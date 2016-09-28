package com.genius.groupie.example.item;

import android.support.annotation.ColorRes;

import com.genius.groupie.Item;
import com.genius.groupie.example.MainActivity;
import com.genius.groupie.example.R;
import com.genius.groupie.example.databinding.ItemTallCardBinding;

import java.util.HashMap;
import java.util.Map;

public class FullBleedCardItem extends Item<ItemTallCardBinding> {

    private final int colorRes;

    public FullBleedCardItem(@ColorRes int colorRes) {
        this.colorRes = colorRes;
    }

    @Override public void bind(ItemTallCardBinding viewBinding, int position) {
        viewBinding.getRoot().setBackgroundResource(getColorRes());
    }

    public int getColorRes() {
        return colorRes;
    }

    @Override public int getLayout() {
        return R.layout.item_tall_card;
    }

    @Override public Map<String, Object> getExtras() {
        Map<String, Object> map = new HashMap<>();
        map.put(MainActivity.INSET_TYPE_KEY, MainActivity.FULL_BLEED);
        return map;
    }
}
