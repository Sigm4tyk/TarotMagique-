package com.example.tarotmagique;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TableJoueurActivity extends Activity {

	private Button button;
	public Table table;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_joueur);

		Intent intent = getIntent();

		/////////////////////////////////// PARTIE SERVEUR \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		//table = (Table) intent.getSerializableExtra("Table");
		if (intent.getBooleanExtra("Serveur", true)) {
			button = (Button) findViewById(R.id.buttonListerAtouts);

			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					table = new Table("SAlu", 4);

					Intent intent = new Intent(TableJoueurActivity.this, ListeAtoutsActivity.class);
					startActivity(intent);

				}
			});
		} 
		
		
		
		
		
		
		/////////////////////////////////// PARTIE CLIENT \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		else {
			
		}

	}
}
