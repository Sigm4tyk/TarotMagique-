package com.example.tarotmagique;

import java.io.Serializable;
import java.util.Calendar;

public class Log implements Serializable {

	private Carte carte;
	private Calendar date;

	public Log(Carte carte) {
		this.carte = carte;
		this.date = Calendar.getInstance();
	}

	@Override
	public String toString() {
		return this.carte.toString() + " à " + this.date.get(Calendar.HOUR_OF_DAY) + "h" + this.date.get(Calendar.MINUTE) + "m"
				+ this.date.get(Calendar.SECOND) + "s" + this.date.get(Calendar.MILLISECOND) + "ms";
	}
}
