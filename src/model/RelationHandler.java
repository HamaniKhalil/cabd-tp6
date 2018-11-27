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

package model;

import static system.SystemConfiguration.JOIN_FILENAME;

import helpers.JoinHelper;
import io.BlockHandler;
import io.FileHandler;
import spec.Relation;

public class RelationHandler implements Relation {

	private FileHandler	file;
	
	// Constructors
	
	// Setters
	public void setFile(FileHandler file) {
		this.file = file;
	}
	
	// Getters
	public FileHandler getFile() {
		return file;
	}
	
	@Override
	public RelationHandler mergeJoin(Relation relation) {
		RelationHandler	s	= (RelationHandler) relation;
		
		RelationHandler	rs	= new RelationHandler();
		rs.setFile(new FileHandler(JOIN_FILENAME));
		rs.getFile().create();
		
		int	index	= 0;
		
		String []	merge;
		
		for(int i = 0; i < file.getBlocks().length; i ++) {
			for(int j = 0; j < s.getFile().getBlocks().length; j ++) {
				merge	= JoinHelper.mergeJoinOnBlocks(file.getBlock(i).read(), s.getFile().getBlock(j).read());
				if(merge != null) {
					rs.getFile().getBlocks()[index]	= new BlockHandler(index);
					rs.getFile().getBlocks()[index].create();
					rs.getFile().getBlocks()[index].write(merge);
					index ++;
				}
			}
		}
		
		return null;
	}


}
