package io.github.changjiashuai.template.view.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import io.github.changjiashuai.template.view.main.fragment.TemplateFragment;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/14 09:43.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<TemplateFragment> mFragments;

    public ViewPagerAdapter(FragmentManager fm, List<TemplateFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
