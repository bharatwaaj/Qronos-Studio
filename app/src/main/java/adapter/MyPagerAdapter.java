package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import Fragments.HomeFragment;

/**
 * Created by Bharatwaaj on 21-07-2015.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    String[] tabs;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        tabs = new String[]{
                "Home",
                "Categories",
                "Profile"
                };
    }

    @Override
    public Fragment getItem(int position) {
        HomeFragment homeFragment = HomeFragment.getInstance(position);
        return homeFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabs[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
