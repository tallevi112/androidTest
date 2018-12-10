package paket.talerez.androidtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import paket.talerez.androidtest.Models.Results;
import paket.talerez.androidtest.R;
import paket.talerez.androidtest.View.WebArticle;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    List<Results> newsList;
    Context context;

    public NewsAdapter(List<Results> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_news, viewGroup, false);
        NewsHolder nm = new NewsHolder(view);
        return nm;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, final int i) {

        newsHolder.nwTitle.setText(newsList.get(i).getTitle());
        newsHolder.nwOverview.setText(newsList.get(i).getAuthor());
        newsHolder.nwReleaseDate.setText(newsList.get(i).getPublishedAt());
        Glide.with(context).load(newsList.get(i).getUrlToImage()).into(newsHolder.ivNews);

        // Click Listener for RecyclerView item
        newsHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent to Webartical for Article
                Intent intent = new Intent(context, WebArticle.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("results", newsList.get(i).getUrl());
                intent.putExtras(bundle);
                context.startActivity(intent)

                ;

            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    public class NewsHolder extends RecyclerView.ViewHolder {
        TextView nwTitle, nwOverview, nwReleaseDate;
        ImageView ivNews;
        LinearLayout parent_layout;

        public NewsHolder(View v) {
            super(v);
            nwTitle = (TextView) v.findViewById(R.id.nwTitle);
            nwOverview = (TextView) v.findViewById(R.id.nwReleaseDate);
            nwReleaseDate = (TextView) v.findViewById(R.id.twDescreption);
            ivNews = (ImageView) v.findViewById(R.id.ivNews);
            parent_layout = (LinearLayout) v.findViewById(R.id.parentLayout);
        }

    }
}
