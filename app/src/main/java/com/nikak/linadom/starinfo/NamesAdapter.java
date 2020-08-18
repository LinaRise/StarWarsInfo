package com.nikak.linadom.starinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

//public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NumberViewHolder> {
//
//    private static int viewHolderCount;
//    private int numberItems;
//
//    public NamesAdapter(int numberItems) {
//        this.numberItems = numberItems;
//        viewHolderCount = 0;
//    }
//
//    @Override
//    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        int layoutIdForListItem = R.layout.name_list_item;
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(layoutIdForListItem, parent, false);
//        NumberViewHolder viewHolder = new NumberViewHolder(view);
//        viewHolder.viewHolderIndex.setText("ViewHolder " + viewHolderCount);
//        viewHolderCount++;
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
//        holder.bind(position);
//    }
//
//    @Override
//    public int getItemCount() {
//        return numberItems;
//    }
//
//    class NumberViewHolder extends RecyclerView.ViewHolder {
//        TextView listItemNameView;
//        TextView viewHolderIndex;
//
//        public NumberViewHolder(@NonNull View itemView) {
//            super(itemView);
//            listItemNameView = itemView.findViewById(R.id.name_item_tv);
//            viewHolderIndex = itemView.findViewById(R.id.view_holder_number_tv);
//        }
//
//        void bind(int listIndex) {
//            listItemNameView.setText(String.valueOf(listIndex));
//        }
//    }
//}

//public class PagerAdapter extends FragmentStateAdapter {
//    private int numOfTabs;
//
//    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
//        super(fragmentActivity);
//    }
//
//    @NonNull
//    @Override
//    public Fragment createFragment(int position) {
//        switch (position) {
//            case 0:
//                return new PlanetsFragment();
//            default:
//                return new PlanetsFragment();
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return numOfTabs;
//    }


//    private int numOfTabs;
//
//    public PagerAdapter(@NonNull FragmentManager fm) {
//        super(fm);
//        this.numOfTabs = numOfTabs;
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return new PlanetsFragment();
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return numOfTabs;
//    }
//}
