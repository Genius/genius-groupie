package com.genius.groupie.example.item;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;

import com.genius.groupie.Item;
import com.genius.groupie.example.R;
import com.genius.groupie.example.databinding.ItemTitleBinding;

public class TitleItem extends Item<ItemTitleBinding> {

    @StringRes private int titleStringResId;
    @StringRes private int subtitleResId;
    @DrawableRes private int iconResId;
    private View.OnClickListener onIconClickListener;

    public TitleItem(@StringRes int titleStringResId) {
        this(titleStringResId, 0);
    }

    public TitleItem(@StringRes int titleStringResId, @StringRes int subtitleResId) {
        this(titleStringResId, subtitleResId, 0, null);
    }

    public TitleItem(@StringRes int titleStringResId, @StringRes int subtitleResId, @DrawableRes int iconResId, View.OnClickListener onIconClickListener) {
        this.titleStringResId = titleStringResId;
        this.subtitleResId = subtitleResId;
        this.iconResId = iconResId;
        this.onIconClickListener = onIconClickListener;
    }

    @Override public int getLayout() {
        return R.layout.item_title;
    }

    @Override public void bind(ItemTitleBinding viewBinding, int position) {
        viewBinding.title.setText(titleStringResId);
        if (subtitleResId > 0) {
            viewBinding.subtitle.setText(subtitleResId);
        }
        viewBinding.subtitle.setVisibility(subtitleResId > 0 ? View.VISIBLE : View.GONE);

        if (iconResId > 0) {
            viewBinding.icon.setImageResource(iconResId);
            viewBinding.icon.setOnClickListener(onIconClickListener);
        }
        viewBinding.icon.setVisibility(iconResId > 0 ? View.VISIBLE : View.GONE);
    }
}
