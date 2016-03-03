package com.example.tarotmagique;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ParametresHebergerActivity extends Activity {

	private Button buttonJouer;
	public Table table;
	public String nomTable;
	public int nombreJoueurs;
	public EditText editNomTable, editNombreJoueurs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parametres_heberger);

		buttonJouer = (Button) findViewById(R.id.buttonJouer);

		buttonJouer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				editNomTable = (EditText) findViewById(R.id.editNomTable);
				editNombreJoueurs = (EditText) findViewById(R.id.editNombreJoueurs);
				nomTable =  editNomTable.getText().toString();
				nombreJoueurs =  Integer.parseInt(editNombreJoueurs.getText().toString());
				
				// CREER SOCKET SERVEUR
			
				Intent intent = new Intent(ParametresHebergerActivity.this, TableJoueurActivity.class);
				intent.putExtra("NomTable", nomTable);
				intent.putExtra("NombreJoueurs", nombreJoueurs);
				intent.putExtra("Servuer", true);
				startActivity(intent);
			}
		});

	}

}
