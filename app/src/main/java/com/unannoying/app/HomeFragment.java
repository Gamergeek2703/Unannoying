package com.unannoying.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    // TODO: Find a way to take the global toggle and make it actually global please lol
    public boolean globalToggle = false;
    private CardView globalToggleButton;

    private TextView statusBar;

    ContactsAdapter adapter;
    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.layout_main, container, false);
        globalToggleButton = v.findViewById(R.id.cardView);
        List<Contacts> list = new ArrayList<>();
        list = getData();

        recyclerView
                = (RecyclerView)v.findViewById(
                R.id.list_contacts);

        adapter
                = new ContactsAdapter(
                list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider_space));
        recyclerView.addItemDecoration(dividerItemDecoration);
        statusBar = v.findViewById(R.id.status);
        globalToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalToggle = !globalToggle;
                if (globalToggle) {
                  //  globalToggleButton.getDrawable().setTint(ContextCompat.getColor(getContext(), R.color.green_500));

                    statusBar.setText("Protected");

                    statusBar.setTextColor(getActivity().getResources().getColor(R.color.green_500));
                } else {
//                    globalToggleButton.getDrawable().setTint(ContextCompat.getColor(getContext(), R.color.red_500));
                    statusBar.setText("Unprotected");

                    statusBar.setTextColor(getActivity().getResources().getColor(R.color.red_500));
                }
            }
        });
        return v;

    }

    private List<Contacts> getData()
    {
        List<Contacts> list = new ArrayList<>();
        list.add(new Contacts("+91 9988776655",
                "05:00PM"
                ));
        list.add(new Contacts("+91 9988776655",
                "05:10PM"
        ));
        list.add(new Contacts("+91 9988776655",
                "11:00AM"
        ));

        return list;
    }
}