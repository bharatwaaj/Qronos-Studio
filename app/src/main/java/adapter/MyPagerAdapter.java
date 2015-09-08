package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import Fragments.BuyFragment;
import Fragments.YouFragment;

/**
 * Created by Bharatwaaj on 21-07-2015.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    String[] tabs;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        tabs = new String[]{
                "Buy",
                "Sell",
                "You"
                };
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
            BuyFragment buyFragment = new BuyFragment();
            return buyFragment;
            case 1:
            YouFragment youFragment = new YouFragment();
            return youFragment;
            case 2:
            YouFragment myouFragment = new YouFragment();
            return myouFragment;
        }
        return new Fragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabs[position];
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
