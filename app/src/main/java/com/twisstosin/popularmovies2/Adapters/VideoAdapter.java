package com.twisstosin.popularmovies2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.twisstosin.popularmovies2.DataModels.VideoResults;
import com.twisstosin.popularmovies2.Networking.NetworkUtils;
import com.twisstosin.popularmovies2.R;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    List<VideoResults>video_results;
    private Context context;

    public void setData(List<VideoResults> videoData){
        this.video_results = videoData;
    }

    public VideoAdapter(Context context, ArrayList<VideoResults> results){
        this.context = context;
        this.video_results = results;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView youtubeImageView;
        TextView videoType;
        CircleImageView playImageView;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);
            youtubeImageView = (ImageView) view.findViewById(R.id.youtube_iv);
            videoType = (TextView) view.findViewById(R.id.video_type);
            playImageView = (CircleImageView) view.findViewById(R.id.circle_play);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            URL url = NetworkUtils.buildYoutubeVideoUrl(video_results.get(position).key);
            if (url != null){
                Uri uri = Uri.parse(url.toString());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);

                if (intent.resolveActivity(context.getPackageManager()) != null){
                    context.startActivity(intent);
                }else {
                    Log.i("Results", "Could not call" + uri.toString() + ", no receiving app installed on your device!");
                }
            }

        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.video_content, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String site = video_results.get(position).site;

            holder.videoType.setText(video_results.get(position).name);

            if (site.equals("YouTube")) {

                String url = NetworkUtils.buildYoutubeImageUrl(video_results.get(position).key).toString();
                holder.playImageView.setVisibility(View.VISIBLE);
                Glide.with(context)
                        .load(url)
                        .into(holder.youtubeImageView);
            }
        }

    @Override
    public int getItemCount() {
        if (video_results == null)return 0;
        return video_results.size();
    }


}


