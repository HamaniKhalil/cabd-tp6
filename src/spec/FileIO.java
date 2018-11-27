/*
 * TP N°		: 07
 * Version N°	: 01
 * 
 * Titre du TP	: Disk Sort Merge
 * 
 * Date			: 23 Novembre 2018
 * 
 * Nom			: Hamani
 * Prenom		: Khalil
 * N° Etudiant	: 21810826
 * 
 * Email		: hamani_khalil@yahoo.fr
 * 
 * Remarques	: N/A
 * 
 * */

package spec;

public interface FileIO {
	
	public boolean create();
	public Block getBlock(int blockId);
	public boolean addBlock(Block block);
	public void removeBlock(int blockId);
}
