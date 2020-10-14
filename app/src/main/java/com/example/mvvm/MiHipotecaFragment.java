package com.example.mvvm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm.databinding.FragmentMiHipotecaBinding;

public class MiHipotecaFragment extends Fragment {

    private FragmentMiHipotecaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentMiHipotecaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimuladorHipoteca simulador = new SimuladorHipoteca();

                double capital = Double.parseDouble(binding.capital.getText().toString());
                int plazo = Integer.parseInt(binding.plazo.getText().toString());

                SolicitudHipoteca solicitud = new SolicitudHipoteca(capital, plazo);

                double cuota = simulador.calcular(solicitud);

                binding.cuota.setText(String.format("%.2f",cuota));
            }
        });
    }
}