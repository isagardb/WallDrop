package in.dropcodes.walldrop.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.dropcodes.walldrop.Fragments.LatestFragment;
import in.dropcodes.walldrop.Fragments.PopularFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                LatestFragment latestFragment = new LatestFragment();
                return latestFragment;
            case 1:
                PopularFragment popularFragment = new PopularFragment();
                return popularFragment;

                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Latest";
            case 1:
                return "Popular";
                default:
                    return null;
        }
    }
}
