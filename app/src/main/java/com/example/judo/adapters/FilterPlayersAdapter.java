package com.example.judo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.judo.R;
import com.example.judo.databinding.ItemFilterBinding;
import com.example.judo.databinding.ItemMangmentBinding;
import com.example.judo.model.sections.SectionModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.judo.helper.HelperMethods.replace;

public class FilterPlayersAdapter extends RecyclerView.Adapter<FilterPlayersAdapter.VH> {

    List<String>  filters = new ArrayList<>();
    Context context;

    @NonNull
    @Override
    public FilterPlayersAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilterBinding binding
                = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_filter, parent, false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterPlayersAdapter.VH holder, final int position) {

        context = holder.itemView.getContext();
        String filter = filters.get(position);
        holder.binding.tvPlayFilter.setText(filter);

        if (position!=0){

            holder.binding.tvPlayFilter.setBackgroundResource(R.drawable.shap_filter);
            holder.binding.tvPlayFilter.setTextColor(Color.GRAY);

        }

    }

    private void openFragment(Fragment fragment) {
        replace(fragment, R.id.container_about_us, ((FragmentActivity) context).getSupportFragmentManager().beginTransaction(),"about us");

    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        ItemFilterBinding binding;

        public VH(@NonNull ItemFilterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    public void  setFilters (List<String>   filters) {
        this.filters =  filters ;
        notifyDataSetChanged();
    }
}
