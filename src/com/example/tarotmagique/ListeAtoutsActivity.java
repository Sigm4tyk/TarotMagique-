package com.example.tarotmagique;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListeAtoutsActivity extends Activity {

	private Joueur joueur;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_liste_atouts);

		Intent intent = getIntent();
		Table table = (Table) intent.getSerializableExtra("Table");
		// Toast.makeText(getApplicationContext(),
		// table.getCarteCercle().toString(), Toast.LENGTH_LONG).show();

		ListView lv = (ListView) findViewById(R.id.listViewAtouts);

		ArrayList<String> liste = new ArrayList<String>();

		// Test
		for (int i = 0; i < table.getJoueurs().get(0).getAtouts().size(); i++) {
			liste.add(table.getJoueurs().get(0).getAtouts().get(i).toString());
		}

		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste));

	}
}
