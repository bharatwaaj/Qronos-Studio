package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import DataFiles.HomeFragmentNewsFeedData;
import adapter.HomeRecyclerViewAdapter;
import design.material.myapplication.R;

/**
 * Created by Bharatwaaj on 21-07-2015.
 */
public class BuyFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeRecyclerViewAdapter homeRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.recycler_view_home);
        homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(getActivity(),getDataToNewsFeed());
        recyclerView.setAdapter(homeRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    public static List<HomeFragmentNewsFeedData> getDataToNewsFeed() {
        List<HomeFragmentNewsFeedData> information = new ArrayList<>();
        int[] imageAdded = {
                R.drawable.image,
                };
        String[] titleAdded = {
                "A"
        };
        for(int i=0;i<titleAdded.length && i<imageAdded.length ;i++){
            information.add(new HomeFragmentNewsFeedData(titleAdded[i],imageAdded[i]));
        }
        return information;
    }
}
