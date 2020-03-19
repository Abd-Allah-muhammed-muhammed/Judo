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
import com.example.judo.model.about_model.AboutUsModel;
import com.example.judo.ui.about_us.know_union.KnowUnionFragment;
import com.example.judo.ui.about_us.union_message.UnionMessageFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.judo.helper.HelperMethods.replace;

public class AboutUsAdapter extends RecyclerView.Adapter<AboutUsAdapter.VH> {

    List<AboutUsModel> aboutUsModels = new ArrayList<>();
    Context context;

    @NonNull
    @Override
    public AboutUsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAboutUnionBinding binding
                = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_about_union, parent, false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AboutUsAdapter.VH holder, final int position) {

        context = holder.itemView.getContext();
        AboutUsModel aboutUsModel = aboutUsModels.get(position);
        holder.binding.setAbout(aboutUsModel);

        holder.binding.layoutAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        KnowUnionFragment knowUnionFragment = new KnowUnionFragment();
                        openFragment(knowUnionFragment);
                        break;
                    case 1:
                        UnionMessageFragment unionMessageFragment = new UnionMessageFragment();
                        openFragment(unionMessageFragment);
                        break;

                }
            }
        });

    }

    private void openFragment(Fragment fragment) {
        replace(fragment, R.id.container_about_us, ((FragmentActivity) context).getSupportFragmentManager().beginTransaction(),"about us");

    }

    @Override
    public int getItemCount() {
        return aboutUsModels.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        ItemAboutUnionBinding binding;

        public VH(@NonNull ItemAboutUnionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    public void setAboutUsModels(List<AboutUsModel> aboutUsModels) {
        this.aboutUsModels = aboutUsModels;
        notifyDataSetChanged();
    }
}
