package com.venom.assignment.contact.view.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.venom.assignment.contact.model.Constants;
import com.venom.assignment.contact.view.ContactFragment;
import com.venom.assignment.contact.view.MessageHistoryFragment;

public class TabAdapter extends FragmentPagerAdapter {
    private static final String[] mTITLES = {Constants.CONTACTS, Constants.MESSAGES};
    private static int NUM_ITEMS = 2;

    public TabAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 -
                return new ContactFragment();
            case 1: // Fragment # 1 -
                return new MessageHistoryFragment();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return mTITLES[position];
    }

}
