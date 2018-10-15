package com.hythesvivania.pegangansiswav3.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hythesvivania.pegangansiswav3.Fragment.FragmentJadwalHari.FragmentJumat;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentJadwalHari.FragmentKamis;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentJadwalHari.FragmentRabu;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentJadwalHari.FragmentSelasa;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentJadwalHari.FragmentSenin;

public class AdapterTabJadwal extends FragmentPagerAdapter {
    public static int PAGE_COUNT = 5;

    private String judulTab[] = new String[]{"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};

    public AdapterTabJadwal(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentSenin();
            case 1:
                return new FragmentSelasa();
            case 2:
                return new FragmentRabu();
            case 3:
                return new FragmentKamis();
            case 4:
                return new FragmentJumat();

        }
        return null;
    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return judulTab[position];
        // return super.getPageTitle(position);
    }
}
