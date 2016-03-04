package com.example.tarotmagique;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ParametresConnexionPartieActivity extends Activity {

	private Button buttonJouer;
	private EditText editIP;
	private String iP;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parametres_connexion_partie);
		buttonJouer = (Button) findViewById(R.id.buttonJouer);

		buttonJouer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				editIP = (EditText) findViewById(R.id.editTextIP);
				iP = editIP.getText().toString();

				Intent intent = new Intent(ParametresConnexionPartieActivity.this, TableJoueurActivity.class);
				intent.putExtra("IP", iP);
				intent.putExtra("Serveur", false);
				startActivity(intent);
			}
		});

	}

}
