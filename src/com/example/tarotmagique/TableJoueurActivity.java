package com.example.tarotmagique;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TableJoueurActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_joueur);
		
		Intent intent = getIntent();
		Table table = (Table) intent.getSerializableExtra("Table");
		Toast.makeText(getApplicationContext(), table.getCarteCercle().toString(), Toast.LENGTH_LONG).show();
		
	}
}
