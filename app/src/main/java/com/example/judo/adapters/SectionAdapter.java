package com.example.judo.adapters;

import android.content.Context;
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
import com.example.judo.databinding.ItemAboutUnionBinding;
import com.example.judo.databinding.ItemMangmentBinding;
import com.example.judo.model.about_model.AboutUsModel;
import com.example.judo.model.sections.SectionModel;
import com.example.judo.ui.about_us.know_union.KnowUnionFragment;
import com.example.judo.ui.about_us.union_message.UnionMessageFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.judo.helper.HelperMethods.replace;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.VH> {

    List<SectionModel>  sectionModels = new ArrayList<>();
    Context context;
    private AdapterView.OnItemClickListener mItemClickListener;

    @NonNull
    @Override
    public SectionAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMangmentBinding binding
                = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_mangment, parent, false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionAdapter.VH holder, final int position) {

        context = holder.itemView.getContext();
        SectionModel sectionModel = sectionModels.get(position);
        holder.binding.setSection(sectionModel);
        holder.binding.layoutSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }

    private void openFragment(Fragment fragment) {
        replace(fragment, R.id.container_about_us, ((FragmentActivity) context).getSupportFragmentManager().beginTransaction(),"about us");

    }

    @Override
    public int getItemCount() {
        return sectionModels.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        ItemMangmentBinding binding;

        public VH(@NonNull ItemMangmentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    public void setSectionModels (List<SectionModel>   sectionModels) {
        this.sectionModels = sectionModels ;
        notifyDataSetChanged();
    }
}
