package com.example.tarotmagique;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class ClientActivity extends Activity {
        
        private EditText serverIp;
     
        private Button connectPhones;
     
        private String serverIpAddress = "";
     
        private boolean connected = false;
     
        private Handler handler = new Handler();
     
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.client);
     
            serverIp = (EditText) findViewById(R.id.server_ip);
            connectPhones = (Button) findViewById(R.id.connect_phones);
            connectPhones.setOnClickListener(connectListener);
        }
     
        private OnClickListener connectListener = new OnClickListener() {
     
            @Override
            public void onClick(View v) {
                if (!connected) {
                    serverIpAddress = serverIp.getText().toString();
                    if (!serverIpAddress.equals("")) {
                        Thread cThread = new Thread(new ClientThread());
                        cThread.start();
                    }
                }
            }
        };
     
        public class ClientThread implements Runnable {
     
            public void run() {
                try {
                    InetAddress serverAddr = InetAddress.getByName(serverIpAddress);
                    Log.d("ClientActivity", "C: Connecting...");
                    Socket socket = new Socket(serverAddr, ServerActivity.SERVERPORT);
                    //connected = true;
                    while (socket.isConnected()) {
                        try {
                            Log.d("ClientActivity", "C: Sending command.");
                            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
     
                                out.println("Hey Server!");
                                Log.d("ClientActivity", "C: Sent.");
                        } catch (Exception e) {
                            Log.e("ClientActivity", "S: Error", e);
                        }
                    }
                    socket.close();
                    Log.d("ClientActivity", "C: Closed.");
                } catch (Exception e) {
                    Log.e("ClientActivity", "C: Error", e);
                    connected = false;
                }
            }
        }
    }



}