package com.example.tarotmagique;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TableJoueurActivity extends Activity {

	public Table table;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_joueur);
		table = new Table("Table", 4);

		button = (Button) findViewById(R.id.buttonListerAtouts);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(TableJoueurActivity.this, ListeAtoutsActivity.class);
				intent.putExtra("Table", table);
				startActivity(intent);

			}
		});

	}
}
