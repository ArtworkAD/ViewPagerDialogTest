package de.azzoft.viewpagerdialogtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstLevelFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        View root = inflater.inflate(R.layout.first_level_fragment, container, false);
        root.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondLevelFragment nestedNestedFragment = (SecondLevelFragment) getActivity().getSupportFragmentManager().findFragmentByTag("NESTED");
                if (nestedNestedFragment == null) {
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.root_frame, new SecondLevelFragment(), "NESTED").addToBackStack(null).commit();
                }
            }
        });
        return root;
    }

    public static class SecondLevelFragment extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            setRetainInstance(true);
            return inflater.inflate(R.layout.second_level_fragment, container, false);
        }
    }
}