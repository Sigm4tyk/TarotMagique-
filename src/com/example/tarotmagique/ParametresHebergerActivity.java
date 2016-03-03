package com.example.tarotmagique;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ParametresHebergerActivity extends Activity {

	private Button buttonJouer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parametres_heberger);

		buttonJouer = (Button) findViewById(R.id.buttonJouer);

		buttonJouer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(ParametresHebergerActivity.this, TableJoueurActivity.class);
				startActivity(intent);
			}
		});

	}

}
