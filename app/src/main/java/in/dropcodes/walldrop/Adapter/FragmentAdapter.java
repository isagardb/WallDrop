package in.dropcodes.walldrop.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.dropcodes.walldrop.Fragments.AllFragment;
import in.dropcodes.walldrop.Fragments.CategoryFragment;
import in.dropcodes.walldrop.Fragments.LatestFragment;

public class FragmentAdapter extends FragmentPagerAdapter{
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                AllFragment allFragment = new AllFragment();
                return allFragment;
            case 1:
                LatestFragment latestFragment = new LatestFragment();
                return latestFragment;
            case 2:
                CategoryFragment categoryFragment = new CategoryFragment();
                return categoryFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){

        switch (position){
            case 0:
                return "All";
            case 1:
                return "New";
            case 2:
                return "Category";
            default:return null;
        }
    }
}
