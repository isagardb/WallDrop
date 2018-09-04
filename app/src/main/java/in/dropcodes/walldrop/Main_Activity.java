package in.dropcodes.walldrop;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import in.dropcodes.walldrop.Adapter.FragmentAdapter;

public class Main_Activity extends AppCompatActivity {

    private ViewPager mViewPager;
    private FragmentAdapter mFragmentAdapter;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        mViewPager = findViewById(R.id.view_pager);
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Wall Drop");

    }
}
