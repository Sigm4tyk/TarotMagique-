package com.example.tarotmagique;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TableJoueurActivity extends Activity {

	private Button button;
	private Table table;
	private Joueur joueurDevice;
	private final int SERVER_PORT = 8080; // Define the server port
	private Socket socket;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_joueur);
		// Déclaration interface
		Intent intent = getIntent();

		/////////////////////////////////// PARTIE SERVEUR
		/////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		if (intent.getBooleanExtra("Serveur", true)) {

			// CREER SOCKET SERVEUR
			// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						// Create a server socket object and bind it to
						// a port
						ServerSocket socServer = new ServerSocket(SERVER_PORT);
						// Create server side client socket reference
						Socket socClient = null;
						// Infinite loop will listen for client requests
						// to connect
						while (true) {
							// Accept the client connection and hand
							// over communication to server side client
							// socket
							socClient = socServer.accept();
							// For each client new instance of AsyncTask
							// will be created
							ServerAsyncTask serverAsyncTask = new ServerAsyncTask();
							// Start the AsyncTask execution
							// Accepted client socket object will pass
							// as the parameter
							serverAsyncTask.execute(new Socket[] { socClient });
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();

		}

		/////////////////////////////////// PARTIE CLIENT
		/////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		else {
			/*try {

				socket = new Socket(intent.getStringExtra("IP").toString(), SERVER_PORT);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

		}

		///////////////////////////////////// PARTIE COMMUNE
		///////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		table = Table.getInstance((String) intent.getStringExtra("NomTable"));

		Toast.makeText(getApplicationContext(), table.toString(), Toast.LENGTH_SHORT).show();
		joueurDevice = new Joueur("Joueur"); // Mettre id unique après connexion
												// et renseigner le nom par
												// interface
		joueurDevice.setNomJoueur(joueurDevice.getIdJoueur());
		button = (Button) findViewById(R.id.buttonListerAtouts);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(TableJoueurActivity.this, ListeAtoutsActivity.class);
				intent.putExtra("Joueur", (Serializable) joueurDevice);
				startActivity(intent);

			}
		});

		button = (Button) findViewById(R.id.buttonPiocher);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), joueurDevice.toString(), Toast.LENGTH_SHORT).show();
				if (joueurDevice.piocher(table.enleverCarteCercle())) {
					if (table.augmenterVerreDuRoi() == 3) {
						Toast.makeText(getApplicationContext(), "PAS DE BOL !!", Toast.LENGTH_SHORT).show();
						try {
							// Get the input stream of the client socket
							InputStream is = socket.getInputStream();
							// Get the output stream of the client socket
							PrintWriter out;
							out = new PrintWriter(socket.getOutputStream(), true);
							// Write data to the output stream of the client
							// socket
							out.println("saas");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}
		});

		button = (Button) findViewById(R.id.buttonHistorique);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(TableJoueurActivity.this, HistoriqueActivity.class);
				intent.putExtra("Joueur", (Serializable) joueurDevice);
				startActivity(intent);

			}
		});

	}

	/**
	 * AsyncTask which handles the communication with clients
	 */
	class ServerAsyncTask extends AsyncTask<Socket, Void, String> {
		// Background task which serve for the client
		@Override
		protected String doInBackground(Socket... params) {
			String result = null;
			// Get the accepted socket object
			Socket mySocket = params[0];

			try {

				// Get the data input stream comming from the client
				InputStream is = mySocket.getInputStream();
				// Get the output stream to the client
				PrintWriter out = new PrintWriter(mySocket.getOutputStream(), true);
				// Write data to the data output stream
				out.println("Hello from server");
				// Buffer the data input stream
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				// Read the contents of the data buffer
				while ((result = br.readLine()) != null) {
					out.println("Hello from server");
				}
				// Close the client connection
				// mySocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "Fin Partie";
		}

		@Override
		protected void onPostExecute(String s) {
			// After finishing the execution of background task data will be
			// write the text view
			// tvClientMsg.setText(s);
		}
	}

}
