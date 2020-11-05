package com.zullynoelia.tarea5.adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;

/**
 * Created by Zully on 12/05/2017.
 */

public class PageAdaptador extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;


    public PageAdaptador(FragmentManager fm, ArrayList<Fragment> fragments) {

        super(fm);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


}

