package com.example.journalquestionno8;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    private static final String TAG = "MyFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "onCreateView called", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreateView called");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.my_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), "onActivityCreated called", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onActivityCreated called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "onStart method called", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "onResume method called", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "onPause method called", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "onStop method called", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "onDestroyView method called", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroyView called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "onDestroy method called", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "onDetach called", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDetach called");
    }
}
