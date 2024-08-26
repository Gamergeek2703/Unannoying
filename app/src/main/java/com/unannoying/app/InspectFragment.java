package com.unannoying.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class InspectFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "InspectFragment";

    Context context;

    public InspectFragment() {
        // Required empty public constructor
    }

    public static InspectFragment newInstance() {
        InspectFragment fragment = new InspectFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inspect, container, false);

        // Find the button and editText by ID
        Button inspectButton = view.findViewById(R.id.inspectButton);
        EditText inspectText = view.findViewById(R.id.inspectText);

        // Set an OnClickListener for the button
        inspectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity and pass in the text to be inspected
                String text = inspectText.getText().toString();
                Intent intent = new Intent(getActivity(), InspectText.class);
                intent.putExtra("inspectText", text);
                startActivity(intent);
            }
        });

        return view;
    }
}