package com.example.tarotmagique;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HistoriqueActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        Intent intent = getIntent();
        Joueur joueur = (Joueur) intent.getSerializableExtra("Joueur");

        ListView lv = (ListView) findViewById(R.id.listViewHistorique);

        ArrayList<String> liste = new ArrayList<String>();

        // Test
        for (int i = 0; i <joueur.getHistorique().size(); i++) {
            liste.add(joueur.getHistorique().get(i).toString());
        }

        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste));
    }
}
