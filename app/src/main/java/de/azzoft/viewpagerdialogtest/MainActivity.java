package de.azzoft.viewpagerdialogtest;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        /**
         * Show dialog from activity when not already there.
         */

        MainActivity.CustomDialog dialog = (MainActivity.CustomDialog) getSupportFragmentManager().findFragmentByTag(MainActivity.CustomDialog.TAG);

        if (dialog == null) {
            new MainActivity.CustomDialog().show(getSupportFragmentManager().beginTransaction(), MainActivity.CustomDialog.TAG);
        }
    }

    /**
     * Dialog as fragment.
     */
    public static class CustomDialog extends android.support.v4.app.DialogFragment {

        public static final String TAG = "DIALOG";

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle);
            builder.setTitle("Dialog");
            builder.setMessage("This is a message!");
            builder.setNegativeButton("No", null);
            builder.setPositiveButton("Okay", null);
            return builder.create();
        }
    }

    /**
     * View pager adapter.
     */
    public static class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new RootFragment();
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Foobar";
        }
    }
}
