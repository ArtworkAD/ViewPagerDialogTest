package de.azzoft.viewpagerdialogtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RootFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.root_fragment, container, false);
        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction().add(R.id.root_frame, new FirstLevelFragment(), "ROOT").commit();
        }
        return root;
    }
}
