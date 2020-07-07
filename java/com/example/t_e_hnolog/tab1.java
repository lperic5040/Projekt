package com.example.t_e_hnolog;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 */

public class tab1 extends Fragment {

    private RadioGroup groupButton;
    private RadioButton SilosOne;
    private RadioButton SilosTwo;
    private RadioButton SilosThree;
    private RadioButton SilosNew;
    private TextView KolicinaRobeIzracun;
    private TextView VisinaRobeIzracun;
    private TextView VolumenRobeIzracun;

    private TextInputLayout textInputCelija;
    private TextInputLayout textInputVisina;
    private TextInputLayout textInputHl;
    private Button buttonIzracunaj;

    public tab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        groupButton = view.findViewById(R.id.radgroup);
        SilosOne = view.findViewById(R.id.radSilosOne);
        SilosTwo = view.findViewById(R.id.radSilosTwo);
        SilosThree = view.findViewById(R.id.radSilosThree);
        SilosNew = view.findViewById(R.id.radSilosNew);
        KolicinaRobeIzracun = view.findViewById(R.id.tvKolRobIzr);
        VisinaRobeIzracun = view.findViewById(R.id.tvVisRobIzr);
        VolumenRobeIzracun = view.findViewById(R.id.tvVolRobIzr);

        textInputCelija = view.findViewById(R.id.txt_in_br_celije);
        textInputVisina = view.findViewById(R.id.txt_in_prazni_prostor);
        textInputHl = view.findViewById(R.id.txt_in_Hl);
        buttonIzracunaj = view.findViewById(R.id.btnIracunaj);

        buttonIzracunaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validateBrCelije() | !validateVisinaPraznog() | !validateHl()){ // stavili smo | da pozove sve metode,a ne || jer bi onda ispiso samo prvu ako je false
                    return;
                }

                if(!validateSilosOne() | !validateSilosTwo() | !validateSilosThree() | !validateSilosNew()){
                    return;
                }

                int checkedID = groupButton.getCheckedRadioButtonId();

                findRadioButton(checkedID);

            }
        });

        return view;
    }


    private boolean validateBrCelije(){ //provjera jeli unesen broj ćelije,ako nije izbacuje error
        String CelijaInput = textInputCelija.getEditText().getText().toString().trim();

        if(CelijaInput.isEmpty()) {
            textInputCelija.setError("Polje ne može biti prazno!");
            return false;
        }else{
            textInputCelija.setError(null);
            return true;
        }
    }

    private boolean validateVisinaPraznog(){ //provjera jeli unesena visina,ako nije izbacuje error
        String VisinaPraznogInput = textInputVisina.getEditText().getText().toString().trim();

        if(VisinaPraznogInput.isEmpty()){
            textInputVisina.setError("Polje ne može biti prazno!");
            return false;
        }else{
            textInputVisina.setError(null);
            return true;
        }
    }

    private boolean validateHl(){ //provjera jeli unesen Hl,ako nije izbacuje error
        String HlInput = textInputHl.getEditText().getText().toString().trim();

        if(HlInput.isEmpty()){
            textInputHl.setError("Polje je prazno!");
            return false;
        }else{
            textInputHl.setError(null);
            return true;
        }
    }

    private boolean validateSilosOne(){
        int silosInp = Integer.parseInt(textInputCelija.getEditText().getText().toString().trim());

        if(silosInp >= 23 && SilosOne.isChecked()){
            Toast.makeText(getActivity(),"Silos 1 ima 22 ćelije!",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    private boolean validateSilosTwo(){
        int silosInp = Integer.parseInt(textInputCelija.getEditText().getText().toString().trim());

        if(silosInp >= 23 && SilosTwo.isChecked()){
            Toast.makeText(getActivity(),"Silos 2 ima 22 ćelije!",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    private boolean validateSilosThree(){
        int silosInp = Integer.parseInt(textInputCelija.getEditText().getText().toString().trim());

        if(silosInp >= 23 && SilosThree.isChecked()){
            Toast.makeText(getActivity(),"Silos 3 ima 22 ćelije!",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    private boolean validateSilosNew(){
        int silosInp = Integer.parseInt(textInputCelija.getEditText().getText().toString().trim());

        if(silosInp >= 31 && SilosNew.isChecked()){
            Toast.makeText(getActivity(),"Novi silos ima 30 ćelija!",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    private void findRadioButton(int checkedID) {
        switch (checkedID){
            case R.id.radSilosOne:
                MeasureSilosOne();
                break;
            case R.id.radSilosTwo:
                MeasureSilosTwo();
                break;
            case R.id.radSilosThree:
                MeasureSilosThree();
                break;
            case R.id.radSilosNew:
                MeasureSilosNew();
                break;
        }
    }

    private void MeasureSilosOne(){
        int CelijaInp = Integer.parseInt(textInputCelija.getEditText().getText().toString().trim());
        float VisPraInp = Float.parseFloat(textInputVisina.getEditText().getText().toString().trim());
        float HlInp = Float.parseFloat(textInputHl.getEditText().getText().toString().trim());

        switch(CelijaInp){
            case 5:
            case 9:
            case 14:
            case 18:
                float rez2 = (float) (624.6-(22.17* VisPraInp));
                float rez3 = (float) ((27.5+(2.06/2))- VisPraInp);
                float rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
            default:
                rez2 = (float) (300.8-(10.67* VisPraInp));
                rez3 = (float) ((27.5+(2.06/3))- VisPraInp);
                rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
        }
    }

    private void MeasureSilosTwo(){
        int CelijaInp = Integer.parseInt(textInputCelija.getEditText().getText().toString().trim());
        float VisPraInp = Float.parseFloat(textInputVisina.getEditText().getText().toString().trim());
        float HlInp = Float.parseFloat(textInputHl.getEditText().getText().toString().trim());

        switch(CelijaInp){
            case 5:
            case 9:
            case 14:
            case 18:
                float rez2 = (float) (624.6-(22.17* VisPraInp));
                float rez3 = (float) ((27.5+(2.06/2))- VisPraInp);
                float rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
            default:
                rez2 = (float) (300.8-(10.67* VisPraInp));
                rez3 = (float) ((27.5+(2.06/3))- VisPraInp);
                rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
        }
    }

    private void MeasureSilosThree(){
        int CelijaInp = Integer.parseInt(textInputCelija.getEditText().getText().toString().trim());
        float VisPraInp = Float.parseFloat(textInputVisina.getEditText().getText().toString().trim());
        float HlInp = Float.parseFloat(textInputHl.getEditText().getText().toString().trim());

        switch(CelijaInp){
            case 5:
            case 9:
            case 14:
            case 18:
                float rez2 = (float) (624.6-(22.17* VisPraInp));
                float rez3 = (float) ((27.5+(2.06/2))- VisPraInp);
                float rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
            default:
                rez2 = (float) (300.8-(10.67* VisPraInp));
                rez3 = (float) ((27.5+(2.06/3))- VisPraInp);
                rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
        }
    }

    private void MeasureSilosNew(){
        int CelijaInp = Integer.parseInt(textInputCelija.getEditText().getText().toString().trim());
        float VisPraInp = Float.parseFloat(textInputVisina.getEditText().getText().toString().trim());
        float HlInp = Float.parseFloat(textInputHl.getEditText().getText().toString().trim());

        switch(CelijaInp){
            case 5:
            case 6:
            case 7:
            case 15:
            case 16:
                float rez2 = (float) (1870.74-(54.74* VisPraInp));
                float rez3 = (float) ((31.95+(4.45/2))- VisPraInp);
                float rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
            case 20:
            case 21:
            case 22:
            case 23:
                rez2 = (float) (1684.4-(50.24* VisPraInp));
                rez3 = (float) ((32.4+(3.2/3))- VisPraInp);
                rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
            case 24:
            case 25:
            case 26:
                rez2 = (float) (1710-(52.25* VisPraInp));
                rez3 = (float) ((31.3+(4.3/3))- VisPraInp);
                rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
            default:
                rez2 = (float) (1724.7-(50.24* VisPraInp));
                rez3 = (float) ((33.21+(3.19/3))- VisPraInp);
                rez1 = rez2 * HlInp;
                VolumenRobeIzracun.setText(String.valueOf(rez2));
                VisinaRobeIzracun.setText(String.valueOf(rez3));
                KolicinaRobeIzracun.setText(String.valueOf(rez1));
                break;
        }
    }
}