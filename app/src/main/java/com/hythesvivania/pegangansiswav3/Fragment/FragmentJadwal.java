package com.hythesvivania.pegangansiswav3.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hythesvivania.pegangansiswav3.Adapter.AdapterTabJadwal;
import com.hythesvivania.pegangansiswav3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJadwal extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    AdapterTabJadwal adapter;

    public FragmentJadwal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_fragment_jadwal, container, false);

        View rootView = inflater.inflate(R.layout.fragment_fragment_jadwal, container, false);

        viewPager = (ViewPager) rootView.findViewById(R.id.main_viewpager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.main_tab_layout);

        adapter = new AdapterTabJadwal(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

//        setViewPager(viewPager);
        //      return rootView;


        return rootView;
    }

}
