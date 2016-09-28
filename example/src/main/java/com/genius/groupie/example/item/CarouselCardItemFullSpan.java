package com.genius.groupie.example.item;

import android.support.annotation.ColorRes;

import com.genius.groupie.Item;
import com.genius.groupie.example.R;
import com.genius.groupie.example.databinding.ItemFullSpanBinding;
import com.genius.groupie.example.databinding.ItemSquareCardBinding;

/**
 * A card item with a fixed width so it can be used with a horizontal layout manager.
 */
public class CarouselCardItemFullSpan extends Item<ItemFullSpanBinding> {

    @ColorRes private int colorRes;

    public CarouselCardItemFullSpan(@ColorRes int colorRes) {
        this.colorRes = colorRes;
    }

    @Override public int getLayout() {
        return R.layout.item_full_span;
    }

    @Override public void bind(ItemFullSpanBinding viewBinding, int position) {
        viewBinding.getRoot().setBackgroundColor(colorRes);
    }
}
