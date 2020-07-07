package com.example.t_e_hnolog;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 */

public class tab2 extends Fragment {

    private TextInputLayout textInputtem;
    private TextInputLayout textInputvlaga;
    private Button buttonProvjeri;

    private TextView tvZitniZizak;
    private TextView tvKukuruzniZizak;
    private TextView tvRizoperta;
    private TextView tvZitniMoljac;
    private TextView tvHambarskiMoljac;
    private TextView tvSurinamskiBrasnar;
    private TextView tvCryptolestes;
    private TextView tvKestenjastiBrasnar;
    private TextView tvMaliBrasnar;
    private TextView tvMauritanskiBrasnar;

    public tab2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        textInputtem = view.findViewById(R.id.txt_in_tem_robe);
        textInputvlaga = view.findViewById(R.id.txt_in_vlaga_robe);
        buttonProvjeri = view.findViewById(R.id.btnProvjeri);

        tvZitniZizak = view.findViewById(R.id.tvZitniZizak);
        tvKukuruzniZizak = view.findViewById(R.id.tvKukuruzniZizak);
        tvRizoperta = view.findViewById(R.id.tvRizoperta);
        tvZitniMoljac = view.findViewById(R.id.tvZitniMoljac);
        tvHambarskiMoljac = view.findViewById(R.id.tvHambarskiMoljac);
        tvSurinamskiBrasnar = view.findViewById(R.id.tvSurinamskiBrasnar);
        tvCryptolestes = view.findViewById(R.id.tvCryptolestes);
        tvKestenjastiBrasnar = view.findViewById(R.id.tvKestenjastiBrasnar);
        tvMaliBrasnar = view.findViewById(R.id.tvMaliBrasnar);
        tvMauritanskiBrasnar = view.findViewById(R.id.tvMauritanskiBrasnar);

        buttonProvjeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validateTem() | !validateVlaga()){ // stavili smo | da pozove sve metode,a ne || jer bi onda ispiso samo prvu ako je false
                    return;
                }

                MeasureZitniZizak();
                MeasureKukuruzniZizak();
                MeasureRizoperta();
                MeasureZitniMoljac();
                MeasureHambarskiMoljac();
                MeasureSurinamskiBrasnar();
                MeasureCryptolestes();
                MeasureKestenjastiBrasnar();
                MeasureMaliBrasnar();
                MeasureMauritanskiBrasnar();

            }
        });

        return view;
    }


    private boolean validateTem(){ //provjera jeli unesena tem,ako nije izbacuje error
        String temInput = textInputtem.getEditText().getText().toString().trim();

        if(temInput.isEmpty()){
            textInputtem.setError("Polje ne može biti prazno!");
            return false;
        }else{
            textInputtem.setError(null);
            return true;
        }
    }

    private boolean validateVlaga(){ //provjera jeli unesena vlaga,ako nije izbacuje error
        String vlagaInput = textInputvlaga.getEditText().getText().toString().trim();

        if(vlagaInput.isEmpty()){
            textInputvlaga.setError("Polje ne može biti prazno!");
            return false;
        }else{
            textInputvlaga.setError(null);
            return true;
        }
    }


    private void MeasureZitniZizak(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 13 && vlaInp <= 15) && (temInp >= 21 && temInp <= 25) ){
            tvZitniZizak.setText("Visoka razina pojave");
            tvZitniZizak.setTextColor(Color.RED);
        }
        else if((vlaInp >= 8 &&  vlaInp <= 20) && (temInp >= 10 && temInp <= 35)){
            tvZitniZizak.setText("Srednja razina pojave");
            tvZitniZizak.setTextColor(Color.YELLOW);
        }
        else{
            tvZitniZizak.setText("Niska razina pojave");
            tvZitniZizak.setTextColor(Color.GREEN);
        }
    }

    private void MeasureKukuruzniZizak(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 13 && vlaInp <= 15) && (temInp >= 24 && temInp <= 28) ){
            tvKukuruzniZizak.setText("Visoka razina pojave");
            tvKukuruzniZizak.setTextColor(Color.RED);
        }
        else if((vlaInp >= 8 &&  vlaInp <= 20) && (temInp >= 10 && temInp <= 35)){
            tvKukuruzniZizak.setText("Srednja razina pojave");
            tvKukuruzniZizak.setTextColor(Color.YELLOW);
        }
        else{
            tvKukuruzniZizak.setText("Niska razina pojave");
            tvKukuruzniZizak.setTextColor(Color.GREEN);
        }
    }

    private void MeasureRizoperta(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 11 && vlaInp <= 15) && (temInp >= 28 && temInp <= 32) ){
            tvRizoperta.setText("Visoka razina pojave");
            tvRizoperta.setTextColor(Color.RED);
        }
        else if((vlaInp >= 9  &&  vlaInp <= 17) && (temInp >= 21 && temInp <= 38)){
            tvRizoperta.setText("Srednja razina pojave");
            tvRizoperta.setTextColor(Color.YELLOW);
        }
        else{
            tvRizoperta.setText("Niska razina pojave");
            tvRizoperta.setTextColor(Color.GREEN);
        }
    }

    private void MeasureZitniMoljac(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 13 && vlaInp <= 17) && (temInp >= 33 && temInp <= 37) ){
            tvZitniMoljac.setText("Visoka razina pojave");
            tvZitniMoljac.setTextColor(Color.RED);
        }
        else if((vlaInp >= 75  &&  vlaInp <= 85) && (temInp >= 15 && temInp <= 35)){
            tvZitniMoljac.setText("Srednja razina pojave");
            tvZitniMoljac.setTextColor(Color.YELLOW);
        }
        else{
            tvZitniMoljac.setText("Niska razina pojave");
            tvZitniMoljac.setTextColor(Color.GREEN);
        }
    }

    private void MeasureHambarskiMoljac(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 13 && vlaInp <= 17) && (temInp >= 15 && temInp <= 20) ){
            tvHambarskiMoljac.setText("Visoka razina pojave");
            tvHambarskiMoljac.setTextColor(Color.RED);
        }
        else if((vlaInp >= 75  &&  vlaInp <= 85) && (temInp >= 10 && temInp <= 27)){
            tvHambarskiMoljac.setText("Srednja razina pojave");
            tvHambarskiMoljac.setTextColor(Color.YELLOW);
        }
        else{
            tvHambarskiMoljac.setText("Niska razina pojave");
            tvHambarskiMoljac.setTextColor(Color.GREEN);
        }
    }

    private void MeasureSurinamskiBrasnar(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 88 && vlaInp <= 92) && (temInp >= 30 && temInp <= 35) ){
            tvSurinamskiBrasnar.setText("Visoka razina pojave");
            tvSurinamskiBrasnar.setTextColor(Color.RED);
        }
        else if((vlaInp >= 50  &&  vlaInp <= 90) && (temInp >= 21 && temInp <= 38)){
            tvSurinamskiBrasnar.setText("Srednja razina pojave");
            tvSurinamskiBrasnar.setTextColor(Color.YELLOW);
        }
        else{
            tvSurinamskiBrasnar.setText("Niska razina pojave");
            tvSurinamskiBrasnar.setTextColor(Color.GREEN);
        }
    }

    private void MeasureCryptolestes(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 70 && vlaInp <= 90) && (temInp >= 25 && temInp <= 40) ){
            tvCryptolestes.setText("Visoka razina pojave");
            tvCryptolestes.setTextColor(Color.RED);
        }
        else if((vlaInp >= 68  &&  vlaInp <= 99) && (temInp >= 20 && temInp <= 43)){
            tvCryptolestes.setText("Srednja razina pojave");
            tvCryptolestes.setTextColor(Color.YELLOW);
        }
        else{
            tvCryptolestes.setText("Niska razina pojave");
            tvCryptolestes.setTextColor(Color.GREEN);
        }
    }

    private void MeasureKestenjastiBrasnar(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 50 && vlaInp <= 70) && (temInp >= 35 && temInp <= 38) ){
            tvKestenjastiBrasnar.setText("Visoka razina pojave");
            tvKestenjastiBrasnar.setTextColor(Color.RED);
        }
        else if((vlaInp >= 30  &&  vlaInp <= 90) && (temInp >= 20 && temInp <= 42)){
            tvKestenjastiBrasnar.setText("Srednja razina pojave");
            tvKestenjastiBrasnar.setTextColor(Color.YELLOW);
        }
        else{
            tvKestenjastiBrasnar.setText("Niska razina pojave");
            tvKestenjastiBrasnar.setTextColor(Color.GREEN);
        }
    }

    private void MeasureMaliBrasnar(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 38 && vlaInp <= 72) && (temInp >= 30 && temInp <= 35) ){
            tvMaliBrasnar.setText("Visoka razina pojave");
            tvMaliBrasnar.setTextColor(Color.RED);
        }
        else if((vlaInp >= 30  &&  vlaInp <= 70) && (temInp >= 20 && temInp <= 38)){
            tvMaliBrasnar.setText("Srednja razina pojave");
            tvMaliBrasnar.setTextColor(Color.YELLOW);
        }
        else{
            tvMaliBrasnar.setText("Niska razina pojave");
            tvMaliBrasnar.setTextColor(Color.GREEN);
        }
    }

    private void MeasureMauritanskiBrasnar(){
        int temInp = Integer.parseInt(textInputtem.getEditText().getText().toString().trim());
        int vlaInp = Integer.parseInt(textInputvlaga.getEditText().getText().toString().trim());

        if((vlaInp >= 38 && vlaInp <= 72) && (temInp >= 29 && temInp <= 33) ){
            tvMauritanskiBrasnar.setText("Visoka razina pojave");
            tvMauritanskiBrasnar.setTextColor(Color.RED);
        }
        else if((vlaInp >= 30  &&  vlaInp <= 90) && (temInp >= 20 && temInp <= 42)){
            tvMauritanskiBrasnar.setText("Srednja razina pojave");
            tvMauritanskiBrasnar.setTextColor(Color.YELLOW);
        }
        else{
            tvMauritanskiBrasnar.setText("Niska razina pojave");
            tvMauritanskiBrasnar.setTextColor(Color.GREEN);
        }
    }
}