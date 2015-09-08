package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import DataFiles.HomeFragmentNewsFeedData;
import design.material.myapplication.R;

/**
 * Created by Bharatwaaj on 25-07-2015.
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyHomeRecyclerViewHolder> {

    private LayoutInflater inflater;
    List<HomeFragmentNewsFeedData> information = Collections.emptyList();

    public HomeRecyclerViewAdapter(Context context , List<HomeFragmentNewsFeedData> information){
        inflater = LayoutInflater.from(context);
        this.information=information;
    }

    @Override
    public MyHomeRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_view_item_home,parent,false);
        MyHomeRecyclerViewHolder myHomeRecyclerViewHolder = new MyHomeRecyclerViewHolder(view);
        return myHomeRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(MyHomeRecyclerViewHolder holder, int position) {
        HomeFragmentNewsFeedData current = information.get(position);
        holder.titleTextView.setText(current.setTitleResourceHomeFragmentNewsFeed());
        holder.imageView.setImageResource(current.setImageResourceHomeFragmentNewsFeed());
    }

    @Override
    public int getItemCount() {
        return information.size();
    }

    class MyHomeRecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        ImageView imageView;
        public MyHomeRecyclerViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.text_view_home_card);
            imageView = (ImageView) itemView.findViewById(R.id.image_view_home_card);
        }
    }
}
