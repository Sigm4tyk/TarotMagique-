package com.example.tarotmagique;

import java.util.ArrayList;
import java.util.Collections;

// Singleton (pour instance unique)
public class Table {

	// Instance unique non préinitialisée
	private static Table INSTANCE = null;

	// La table possède un cercle, une liste de joueurs, le numéro de dernier
	// joueur freeze, maître des pouces etc.
	private final int NB_CARTES = 78;

	private int niveauVerreDuRoi;
	private String nomTable;
	private ArrayList<Carte> cercle;

	public static Table getInstance(String nomTable) {
		if (INSTANCE == null) {
			if (INSTANCE == null) {
				INSTANCE = new Table(nomTable);
			}
		}
		return INSTANCE;
	}

	// Constructeur privé
	private Table (String nomTable) {
		this.niveauVerreDuRoi = 0;
		this.nomTable = nomTable;

		// Initialisation du cercle
		this.initialisation();
	}

	private void initialisation() {

		// Initialisation du cercle
		this.cercle = new ArrayList<Carte>();
		for (int i = 0; i < NB_CARTES; i++) {
			this.cercle.add(new Carte(i));
		}

		// Mélange des cartes
		Collections.shuffle(this.cercle);
	}

	// Niveau Verre du Roi
	public int augmenterVerreDuRoi() {
		return niveauVerreDuRoi++;
	}

	public Carte enleverCarteCercle() {
		return this.cercle.remove(this.cercle.size() - 1);
	}

	@Override
	public String toString() {
		return this.nomTable;
	}

}
