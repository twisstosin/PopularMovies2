package com.twisstosin.popularmovies2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twisstosin.popularmovies2.DataModels.ReviewResults;
import com.twisstosin.popularmovies2.R;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<ReviewResults> review_results;
    Context context;

    public void setData(List<ReviewResults> reviewData){
        this.review_results = reviewData;
        notifyDataSetChanged();
    }

    public ReviewAdapter(ArrayList<ReviewResults> results){
        this.review_results = results;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView authorTextView, reviewTextView;

        public ViewHolder(View view){
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);
            authorTextView = (TextView) view.findViewById(R.id.review_author);
            reviewTextView = (TextView) view.findViewById(R.id.review_text);
        }
        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.review_content, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.authorTextView.setText(review_results.get(position).author);
        holder.reviewTextView.setText(review_results.get(position).content);

    }

    @Override
    public int getItemCount() {
        if (review_results != null) {
            return review_results.size();
        }
        return 0;
    }
}
