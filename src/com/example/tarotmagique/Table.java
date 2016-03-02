package com.example.tarotmagique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.http.impl.io.SocketOutputBuffer;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.SyncStateContract.Constants;

public class Table implements Serializable {

	// La table possède un cercle, une liste de joueurs, le numéro de dernier
	// joueur freeze, maître des pouces etc.
	private final int nbCartes = 78;
	
	private static String nomTable;
	private static ArrayList<Carte> cercle;
	private static ArrayList<Joueur> joueurs;
	private static int nombreJoueurs;
	private static int niveauVerreDuRoi;
	private static Joueur joueurPanda;
	private static Joueur joueurCaribou;
	private static Joueur joueurMrFreeze;
	private static Joueur joueurMaitrePouces;
	private static Joueur joueurSnakeEyes;
	private static ArrayList<Joueur> joueursDames;

	public Table(String nomTable, int nombreJoueurs) {
		this.nomTable = nomTable;
		this.nombreJoueurs = nombreJoueurs;
		this.niveauVerreDuRoi = 0;
		this.joueurPanda = null;
		this.joueurCaribou = null;
		this.joueurMrFreeze = null;
		this.joueurMaitrePouces = null;
		this.joueurSnakeEyes = null;
		this.joueursDames = new ArrayList<Joueur>();

		// Initialisation des joueurs et du cercle
		this.initialisation();
	}

	public void initialisation() {

		// Initialisation des joueurs
		this.joueurs = new ArrayList<Joueur>();
		for (int i = 0; i < this.nombreJoueurs; i++) {
			this.joueurs.add(new Joueur("vue pour demande du nombre de joueur", i));
		}

		// Initialisation du cercle
		this.cercle = new ArrayList<Carte>();
		for (int i = 0; i < nbCartes; i++) {
			this.cercle.add(new Carte(i));
		}

		Collections.shuffle(this.cercle);
		
		

		// Test
		for (int i = 0; i < nbCartes; i++) {
			//System.out.println(this.getCarteCercle().toString());
			this.joueurs.get(0).piocher();
		}

	}

	// Met à jour les données des joueurs ayant des pouvoirs sur la table
	public static void miseAJourDesPouvoirsTable(int typePouvoir, Joueur joueur) {
		switch (typePouvoir) {
		case 0:
			if (Table.joueurPanda != null) {
				for (int i = 0; i < Table.nombreJoueurs; i++) {
					for (int j = 0; j < Table.joueurs.get(i).getListePouvoirs().size(); j++) {
						if (Table.joueurs.get(i).getListePouvoirs().get(j) == 0) {
							Table.joueurs.get(i).getListePouvoirs().remove(j);
							Table.joueurPanda = joueur;
						}
					}
				}
			} else {
				Table.joueurPanda = joueur;
			}
			break;
		case 1:
			if (Table.joueurCaribou != null) {
				for (int i = 0; i < Table.nombreJoueurs; i++) {
					for (int j = 0; j < Table.joueurs.get(i).getListePouvoirs().size(); j++) {
						if (Table.joueurs.get(i).getListePouvoirs().get(j) == 1) {
							Table.joueurs.get(i).getListePouvoirs().remove(j);
							Table.joueurCaribou = joueur;
						}
					}
				}
			} else {
				Table.joueurCaribou = joueur;
			}
			break;
		case 2:
			if (Table.joueurMrFreeze != null) {
				for (int i = 0; i < Table.nombreJoueurs; i++) {
					for (int j = 0; j < Table.joueurs.get(i).getListePouvoirs().size(); j++) {
						if (Table.joueurs.get(i).getListePouvoirs().get(j) == 2) {
							Table.joueurs.get(i).getListePouvoirs().remove(j);
							Table.joueurMrFreeze = joueur;
						}
					}
				}
			} else {
				Table.joueurMrFreeze = joueur;
			}
			break;
		case 3:
			if (Table.joueurMaitrePouces != null) {
				for (int i = 0; i < Table.nombreJoueurs; i++) {
					for (int j = 0; j < Table.joueurs.get(i).getListePouvoirs().size(); j++) {
						if (Table.joueurs.get(i).getListePouvoirs().get(j) == 3) {
							Table.joueurs.get(i).getListePouvoirs().remove(j);
							Table.joueurMaitrePouces = joueur;
						}
					}
				}
			} else {
				Table.joueurMaitrePouces = joueur;
			}
			break;
		case 4:
			if (Table.joueurSnakeEyes != null) {
				for (int i = 0; i < Table.nombreJoueurs; i++) {
					for (int j = 0; j < Table.joueurs.get(i).getListePouvoirs().size(); j++) {
						if (Table.joueurs.get(i).getListePouvoirs().get(j) == 4) {
							Table.joueurs.get(i).getListePouvoirs().remove(j);
							Table.joueurSnakeEyes = joueur;
						}
					}
				}
			} else {
				Table.joueurSnakeEyes = joueur;
			}
			break;
		case 5:
			// Dame
			Table.joueursDames.add(joueur);
			break;
		case 6:
			// Roi
			if (Table.niveauVerreDuRoi == 3) {

			} else {
				Table.niveauVerreDuRoi++;
			}
			break;
		default:
			System.out.println("ERROR404");

		}

	}

	public static Carte getCarteCercle() {
		return cercle.get(cercle.size() - 1);
	}

	public static void enleverCarteCercle() {
		cercle.remove(cercle.size() - 1);
	}

	public static ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}
}
