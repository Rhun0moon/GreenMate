package com.example.greenmate.eco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.greenmate.R;

public class EcoPlaceFragment extends Fragment{

    private Button searchBtn, mapBtn;
    EcoPlaceMapFragment ecoPlaceMapFragment;
    public EcoPlaceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_ecoplace, container, false);

        ecoPlaceMapFragment = new EcoPlaceMapFragment();

        // 검색 버튼
        searchBtn = view.findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"검색 버튼 선택",Toast.LENGTH_SHORT).show();
            }
        });

        // 지도 출력 버튼
        mapBtn = view.findViewById(R.id.mapBtn);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, ecoPlaceMapFragment).addToBackStack(null).commit();
                Toast.makeText(getActivity(),"지역별배출요령",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
