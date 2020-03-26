package com.example.judo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.judo.R;
import com.example.judo.databinding.ItemAboutUnionBinding;
import com.example.judo.databinding.ItemSectionUnionBinding;
import com.example.judo.model.about_model.AboutUsModel;
import com.example.judo.model.sections.SectionsInputModel;
import com.example.judo.ui.about_us.know_union.KnowUnionFragment;
import com.example.judo.ui.about_us.union_message.UnionMessageFragment;
import com.example.judo.ui.sections.mangment.MangmentFragment;
import com.example.judo.ui.sections.players.PlayersFragment;
import com.example.judo.ui.sections.referee.RefereeFragment;
import com.example.judo.ui.sections.trainers.TrainersFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.judo.helper.HelperMethods.isEnglish;
import static com.example.judo.helper.HelperMethods.replace;

public class SectionsAdapter extends RecyclerView.Adapter<SectionsAdapter.VH> {

    List<SectionsInputModel> sectionsInputModels = new ArrayList<>();
    Context context;

    @NonNull
    @Override
    public SectionsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSectionUnionBinding binding
                = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_section_union, parent, false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionsAdapter.VH holder, final int position) {
        context = holder.itemView.getContext();

        if (isEnglish(context)){


            holder.binding.icArrowSection.setImageResource(R.drawable.ic_arrow_right);

        }

        SectionsInputModel sectionsInputModel = sectionsInputModels.get(position);
        holder.binding.setSections(sectionsInputModel);


        holder.binding.layoutSections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:

                        openFragment(new MangmentFragment());
                        break;
                    case 1:

                        openFragment(new PlayersFragment());

                        break;

                    case 2:

                        openFragment(new TrainersFragment());
                        break;

                    case 3:

                        openFragment(new RefereeFragment());
                }
            }
        });

    }

    private void openFragment(Fragment fragment) {
        replace(fragment, R.id.sections_container, ((FragmentActivity) context).getSupportFragmentManager().beginTransaction(), "sections");

    }

    @Override
    public int getItemCount() {
        return sectionsInputModels.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        ItemSectionUnionBinding binding;

        public VH(@NonNull ItemSectionUnionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    public void setSectionsInputModels(List<SectionsInputModel> sectionsInputModels) {
        this.sectionsInputModels = sectionsInputModels;
        notifyDataSetChanged();
    }
}
