package edu.etzion.koletzion.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.ViewPager;
import edu.etzion.koletzion.Adapters.ViewPagerAdapter;
import edu.etzion.koletzion.R;
import edu.etzion.koletzion.models.Profile;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainViewPagerFragment extends Fragment {
    ViewPager vpMain;

    public MainViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vpMain = view.findViewById(R.id.vpMain);

        ViewPagerAdapterMainActivity();
    }

    private void ViewPagerAdapterMainActivity() {
        //this method includes the viewpager adapter that includes all the mainactivity fragments.
        ViewPagerAdapter vpMainAdapter = new ViewPagerAdapter(getFragmentManager());
        vpMainAdapter.addFragment(PersonalAreaFragment.newInstance(/*todo get from firebsae*/
                new Profile("yair", "frid")),"PersonalAreaFragment");
        vpMainAdapter.addFragment(new BroadcastersListFragment(), "BroadcastersListFragment");
        vpMainAdapter.addFragment(new FeedFragment(),"FeedFragment");

        vpMainAdapter.addFragment(new SuggestContentFragment(),"Suggest Content Fragment");

        vpMain.setAdapter(vpMainAdapter);
        vpMain.setCurrentItem(2);
    }
}