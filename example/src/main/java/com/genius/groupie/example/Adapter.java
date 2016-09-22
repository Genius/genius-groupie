package com.genius.groupie.example;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static com.genius.groupie.example.ItemTypes.CARD;
import static com.genius.groupie.example.ItemTypes.FULL_BLEED_CARD;
import static com.genius.groupie.example.ItemTypes.HEADER;
import static com.genius.groupie.example.ItemTypes.SMALL_CARD;
import static com.genius.groupie.example.ItemTypes.SQUARE_CARD;

public class Adapter extends RecyclerView.Adapter {

    List<Wrapper> wrappers;

@Override public RecyclerView.ViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {

    LayoutInflater inflater = LayoutInflater
            .from(parent.getContext());

    View view;
    switch (viewType) {
        case HEADER:
            view = inflater.inflate(
                    R.layout.item_header,
                    parent, false);
            return new HeaderViewHolder(view);
        case CARD:
            view = inflater.inflate(
                    R.layout.item_card,
                    parent, false);
            return new CardViewHolder(view);
        case FULL_BLEED_CARD:
            break;
        case SQUARE_CARD:
            break;
        case SMALL_CARD:
            break;
    }
}

    @Override public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        wrappers.get(position).onBind(viewHolder, position);
    }
//        Model model = models.get(position);
//        switch (viewHolder.getItemViewType()) {
//            case HEADER:
//                HeaderViewHolder headerVH = (HeaderViewHolder) viewHolder;
//                headerVH.title.setText(model.getTitle());
//                if (model.getSubtitle() != null) {
//                    headerVH.subtitle.setText(model.getSubtitle());
//                }
//                headerVH.subtitle.setVisibility(
//                        model.getSubtitle() != null ? View.VISIBLE : View.GONE);
//                headerVH.icon.setImageDrawable(model.getIcon());
//                break;
//            case CARD:
//                CardViewHolder cardHV = (CardViewHolder) viewHolder;
//                if (model.getTitle() != null) {
//                    cardHV.text.setText(model.getTitle());
//                }
//                cardHV.text.setVisibility(
//                        model.getTitle() != null ? View.VISIBLE : View.GONE);
//                break;
//            case FULL_BLEED_CARD:
//                break;
//            case SQUARE_CARD:
//                break;
//            case SMALL_CARD:
//                break;
//        }
    }

    @Override public int getItemCount() {
        return 0;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView subtitle;
        ImageView icon;

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public CardViewHolder(View itemView) {
            super(itemView);
        }
    }

    class Model {
        String title;
        String subtitle;
        Drawable icon;

        public String getTitle() {
            return title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public Drawable getIcon() {
            return icon;
        }
    }

    abstract class Wrapper {

        Wrapper(Model model) {}

        abstract void onBind(RecyclerView.ViewHolder viewHolder, int position);
        abstract int getItemViewType();
    }
}
