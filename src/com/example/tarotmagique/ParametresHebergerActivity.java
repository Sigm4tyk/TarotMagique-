package com.example.tarotmagique;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class ParametresHebergerActivity extends Activity {

	private Button buttonJouer;
	private String nomTable;
	private int nombreJoueurs;
	private EditText editNomTable, editNombreJoueurs;
	private TextView tvServerIP;
	private final int SERVER_PORT = 8080; // Port d'écoute

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parametres_heberger);

		buttonJouer = (Button) findViewById(R.id.buttonJouer);
		tvServerIP = (TextView) findViewById(R.id.textViewServerIP);

		// Appeler méthode pour connaître IP du serveur (Fonctionne parfaitement
		// à laisser là)
		this.getDeviceIpAddress();

		buttonJouer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				// Récupération des champs nom de table et nombre de joueurs
				// pour l'hébergement
				editNomTable = (EditText) findViewById(R.id.editNomTable);
				editNombreJoueurs = (EditText) findViewById(R.id.editNombreJoueurs);

				// Vérification des champs (à compléter plus tard)
				if ((editNomTable.getText().toString().equals(""))
						|| (editNombreJoueurs.getText().toString().equals(""))) {

					Toast.makeText(getApplicationContext(), "Champs incomplets", Toast.LENGTH_SHORT).show();

				} else {
					nomTable = editNomTable.getText().toString();
					nombreJoueurs = Integer.parseInt(editNombreJoueurs.getText().toString());
					Intent intent = new Intent(ParametresHebergerActivity.this, TableJoueurActivity.class);
					intent.putExtra("NomTable", nomTable);
					intent.putExtra("NombreJoueurs", nombreJoueurs);
					intent.putExtra("Serveur", true);
					startActivity(intent);

				}

			}
		});

	}

	// Permet de connaître son adresse IP (FONCTIONNE)
	public void getDeviceIpAddress() {
		try {
			// Loop through all the network interface devices

			for (Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces(); enumeration
					.hasMoreElements();) {

				NetworkInterface networkInterface = enumeration.nextElement();
				// Loop through all the ip addresses of the network interface
				// devices
				for (Enumeration<InetAddress> enumerationIpAddr = networkInterface.getInetAddresses(); enumerationIpAddr
						.hasMoreElements();) {
					InetAddress inetAddress = enumerationIpAddr.nextElement();
					// Filter out loopback address and other irrelevant ip
					// addresses
					if (!inetAddress.isLoopbackAddress() && inetAddress.getAddress().length == 4) {
						// Print the device ip address in to the text view
						tvServerIP.setText(inetAddress.getHostAddress());

					}
				}
			}
		} catch (SocketException e) {
			Log.e("ERROR:", e.toString());
		}
	}

}
