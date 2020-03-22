package com.example.judo.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.judo.R;
import com.example.judo.databinding.ItemCopetitionsBinding;
import com.example.judo.model.copmetitions.CompetitionModel;
import com.example.judo.ui.competitions.details.CompetitionDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.judo.helper.HelperMethods.replace;


public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.VH>{

    private List<CompetitionModel> list = new ArrayList<>();
    private Context context ;
    private Activity activity ;

    public CompetitionsAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public CompetitionsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        ItemCopetitionsBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_copetitions,parent,false);

        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final CompetitionsAdapter.VH holder, int position) {


        CompetitionModel competitionModel = list.get(position);
        holder.binding.setCompetitions(competitionModel);

        if (competitionModel.isOfficial()){

            holder.binding.isOfficial.setImageResource(R.drawable.tag);
        }else {
            holder.binding.isOfficial.setImageResource(R.drawable.tag2);


        }

        Glide.with(context).load(competitionModel.getImage()).into(holder.binding.topicImage);
        holder.binding.competitionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                context.startActivity(new Intent(activity, CompetitionDetailsActivity.class));

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


public void setCompetitions(List<CompetitionModel> list){

        this.list = list;
        notifyDataSetChanged();

}

    public class VH  extends   RecyclerView.ViewHolder{
        ItemCopetitionsBinding binding ;
        public VH(@NonNull ItemCopetitionsBinding itemView) {
            super(itemView.getRoot());
            this.binding =itemView;
        }
    }





}
