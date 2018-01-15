package puissance4.modele;

public class ByteTableauJoueur {
	private byte[] hauteur = new byte[7];
	private byte[] diagonal1 = new byte[7];
	private byte[] diagonal2 = new byte[7];
	// le tableau devrait etre 6 mais pour simplifier et etre homogene on met 7
	private byte[] horizontal = new byte[7];

	public byte getHauteur(int hauteur, int colonne) {
		return this.hauteur[colonne];
	}

	public byte getDiagonal1(int hauteur, int colonne) {
		int i = (hauteur + colonne) - 3;
		if ((i >= 0) && (i < 6)) {
			return diagonal1[i];
		} else {
			return 0x00;
		}
	}

	public byte getDiagonal2(int hauteur, int colonne) {
		int i = (colonne - hauteur) + 2;
		if ((i >= 0) && (i < 6)) {
			return diagonal2[i];
		} else {
			return 0x00;
		}
	}

	public byte getHorizontal(int hauteur, int colonne) {
		return this.horizontal[hauteur];
	}

	public byte[] getTabJoueur(int hauteur, int colonne) {
		byte[] resultat = new byte[4];
		resultat[0] = getHauteur(hauteur, colonne);
		resultat[1] = getDiagonal1(hauteur, colonne);
		resultat[2] = getDiagonal2(hauteur, colonne);
		resultat[3] = getHorizontal(hauteur, colonne);
		return resultat;
	}
	// -------------------------------------------------------------------------------------

	public void setHauteur(int hauteur, int colonne) {
		this.hauteur[colonne] = (byte) (this.hauteur[colonne] | ((byte) 1 << (byte) hauteur));
	}

	public void setDiagonal1(int hauteur, int colonne) {
		int i = (hauteur + colonne) - 3;
		if ((i >= 0) && (i < 6)) {
			this.diagonal1[i] = (byte) (this.diagonal1[i] | ((byte) 1 << (byte) hauteur));
		}
	}

	public void setDiagonal2(int hauteur, int colonne) {
		int i = (+colonne - hauteur) + 2;
		if ((i >= 0) && (i < 6)) {
			this.diagonal2[i] = (byte) (this.diagonal2[i] | ((byte) 1 << (byte) hauteur));
		}
	}

	public void setHorizontal(int hauteur, int colonne) {
		this.horizontal[hauteur] = (byte) (this.horizontal[hauteur] | ((byte) 1 << (byte) colonne));
	}

	public void ajouterPion(int hauteur, int colonne) {
		setHauteur(hauteur, colonne);
		setDiagonal1(hauteur, colonne);
		setDiagonal2(hauteur, colonne);
		setHorizontal(hauteur, colonne);
	}

	// ---------------------------------------------------------------------------------------------------------

	public void remHauteur(int hauteur, int colonne) {
		this.hauteur[colonne] = (byte) (this.hauteur[colonne] & ~((byte) 1 << (byte) hauteur));
	}

	public void remDiagonal1(int hauteur, int colonne) {
		int i = (hauteur + colonne) - 3;
		if ((i >= 0) && (i < 6)) {
			this.diagonal1[i] = (byte) (this.diagonal1[i] & ~((byte) 1 << (byte) hauteur));
		}
	}

	public void remDiagonal2(int hauteur, int colonne) {
		int i = (+colonne - hauteur) + 2;
		if ((i >= 0) && (i < 6)) {
			this.diagonal2[i] = (byte) (this.diagonal2[i] & ~((byte) 1 << (byte) hauteur));
		}
	}

	public void remHorizontal(int hauteur, int colonne) {
		this.horizontal[hauteur] = (byte) (this.horizontal[hauteur] & ~((byte) 1 << (byte) colonne));
	}

	public void enleverPion(int hauteur, int colonne) {
		remHauteur(hauteur, colonne);
		remDiagonal1(hauteur, colonne);
		remDiagonal2(hauteur, colonne);
		remHorizontal(hauteur, colonne);
	}
	// ---------------------------------------------------------------------------------------------------------------

	public int getPion(int hauteur, int colonne) {
		int resultat = 0;
		if ((byte) (this.hauteur[colonne] & ((byte) 1 << (byte) hauteur)) != 0) {
			resultat = 1;
		}
		return resultat;
	}
}
