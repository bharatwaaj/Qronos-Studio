package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import design.material.myapplication.R;

/**
 * Created by Bharatwaaj on 21-07-2015.
 */
public class HomeFragment extends Fragment {

    public static HomeFragment getInstance(int position){
        String _POSITION = "position";
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(_POSITION,position);
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_home,container,false);
        return layout;
    }
}
