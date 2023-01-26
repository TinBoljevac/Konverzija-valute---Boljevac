package com.example.konverzijavalute_boljevac; // ime aplikacije

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context; //omogućuje pristup resursima i klasama za specifičnu aplikaciju
import android.os.Bundle; //prenošenje jedne aktivnosti na drugu
import android.view.View; //omogućuje stvaranje grafičkog sučelja
import android.widget.ArrayAdapter; //omogućuje povezivanje komponenti i podataka
import android.widget.Button; //omogućuje korištenje gumba
import android.widget.EditText; // uređivanje teksta
import android.widget.Spinner; // omogućuje korištenje padajućeg
import android.widget.Toast; // omogućava prikazivanje poruka

public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2; //deklaracija prvog i drugog padajuceg izbornika
    EditText ed1; //deklaracija textboxa u koji unosimo novac u kunama
    Button b1; //deklaracija gumba

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.iznos); //povezivanje texboxa sa tipkovnicom
        sp1=findViewById(R.id.Iz); //povezivanje padajuceg izbornika Iz
        sp2=findViewById(R.id.U); //povezivanje padajuceg izbornika U
        b1=findViewById(R.id.btn1); //povezivanje button

        String[] Iz ={"HRK"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Iz);
        sp1.setAdapter(ad); // postavljanje prvog padajuceg izbornika za novac u kunama

        String[]U={"EUR","USD","CHF"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,U);
        sp2.setAdapter(ad1); // postavljanje prvog padajuceg izbornika za novac u eurima, dolarima i francima

        b1.setOnClickListener(new View.OnClickListener() { //postavljanje gumba za konverzije
            @Override
            public void onClick(View v) {
                Double ukupno; // deklaracija varijable za ukupan iznos
                Double iznos = Double.parseDouble(ed1.getText().toString()); // deklarcije varijabla za unos iznosa u kunama

                if (sp1.getSelectedItem().toString()=="HRK" && sp2.getSelectedItem().toString()=="EUR"){
                    ukupno=iznos/7.53450; // pretvaranje kuna u eure
                    Toast.makeText(getApplicationContext(),ukupno.toString(),Toast.LENGTH_LONG).show(); // prikazivanje rezultata
                } else if (sp1.getSelectedItem().toString()=="HRK" && sp2.getSelectedItem().toString()=="USD"){
                    ukupno=iznos/6.91883; // pretvaranje kuna u dolare
                    Toast.makeText(getApplicationContext(),ukupno.toString(),Toast.LENGTH_LONG).show(); // prikazivanje rezultata
                }else if (sp1.getSelectedItem().toString()=="HRK" && sp2.getSelectedItem().toString()=="CHF"){
                    ukupno=iznos/7.52289; // pretvaranje kuna u franke
                    Toast.makeText(getApplicationContext(),ukupno.toString(),Toast.LENGTH_LONG).show(); // prikazivanje rezultata
                }
            }
        });

    }
}