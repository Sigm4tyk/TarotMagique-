package com.example.tarotmagique;


public class Carte {
    //Numéros allant de 0 à 77, selon les numéro traiter couleurs etc
    //0 à 13 coeur 14 à 27 carreau 28 à 41 trèfle 42 à 55 pique 56 à 76 atouts 77 excuse
    private int numeroCarte;
    
    //Pour version base de données
    private String description;
    private Regle regle; 
    
    
    public  Carte(int numeroCarte) {
        this.numeroCarte = numeroCarte;
    }
    
    //Pour version base de données
    public  Carte(int numeroCarte, String description, Regle regle) {
        this.numeroCarte = numeroCarte;
        this.regle = regle;
    }
    
    public int getNumeroCarte(){
        return this.numeroCarte;
    }

    @Override
    public String toString() {
        switch (this.numeroCarte) {
            case 0:
                return "As de coeur";
            case 1:
                return "2 de coeur";
            case 2:
                return "3 de coeur";
            case 3:
                return "4 de coeur";
            case 4:
                return "5 de coeur";
            case 5:
                return "6 de coeur";
            case 6:
                return "7 de coeur";
            case 7:
                return "8 de coeur";
            case 8:
                return "9 de coeur";
            case 9:
                return "10 de coeur";
            case 10:
                return "Valet de coeur";
            case 11:
                return "Cavalier de coeur";
            case 12:
                return "Dame de coeur";
            case 13:
                return "Roi de coeur";
            case 14:
                return "As de carreau";
            case 15:
                return "2 de carreau";
            case 16:
                return "3 de carreau";
            case 17:
                return "4 de carreau";
            case 18:
                return "5 de carreau";
            case 19:
                return "6 de carreau";
            case 20:
                return "7 de carreau";
            case 21:
                return "8 de carreau";
            case 22:
                return "9 de carreau";
            case 23:
                return "10 de carreau";
            case 24:
                return "Valet de carreau";
            case 25:
                return "Cavalier de carreau";
            case 26:
                return "Dame de carreau";
            case 27:
                return "Roi de carreau";
            case 28:
                return "As de trèfle";
            case 29:
                return "2 de trèfle";
            case 30:
                return "3 de trèfle";
            case 31:
                return "4 de trèfle";
            case 32:
                return "5 de trèfle";
            case 33:
                return "6 de trèfle";
            case 34:
                return "7 de trèfle";
            case 35:
                return "8 de trèfle";
            case 36:
                return "9 de trèfle";
            case 37:
                return "10 de trèfle";
            case 38:
                return "Valet de trèfle";
            case 39:
                return "Cavalier de trèfle";
            case 40:
                return "Dame de trèfle";
            case 41:
                return "Roi de trèfle";
            case 42:
                return "As de pique";
            case 43:
                return "2 de pique";
            case 44:
                return "3 de pique";
            case 45:
                return "4 de pique";
            case 46:
                return "5 de pique";
            case 47:
                return "6 de pique";
            case 48:
                return "7 de pique";
            case 49:
                return "8 de pique";
            case 50:
                return "9 de pique";
            case 51:
                return "10 de pique";
            case 52:
                return "Valet de pique";
            case 53:
                return "Cavalier de pique";
            case 54:
                return "Dame de pique";
            case 55:
                return "Roi de pique";
            case 56:
                return "Le petit";
            case 57:
                return "2 d'atout";
            case 58:
                return "3 d'atout";
            case 59:
                return "4 d'atout";
            case 60:
                return "5 d'atout";
            case 61:
                return "6 d'atout";
            case 62:
                return "7 d'atout";
            case 63:
                return "8 d'atout";
            case 64:
                return "9 d'atout";
            case 65:
                return "10 d'atout";
            case 66:
                return "11 d'atout";
            case 67:
                return "12 d'atout";
            case 68:
                return "13 d'atout";
            case 69:
                return "14 d'atout";
            case 70:
                return "15 d'atout";
            case 71:
                return "16 d'atout";
            case 72:
                return "17 d'atout";
            case 73:
                return "18 d'atout";
            case 74:
                return "19 d'atout";
            case 75:
                return "20 d'atout";
            case 76:
                return "21 d'atout";
            case 77:
                return "Excuse";
            default:
                return "Error";
        }
    }
}
