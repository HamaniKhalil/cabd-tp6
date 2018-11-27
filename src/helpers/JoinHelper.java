package helpers;

import static system.SystemConfiguration.BUFFER_SIZE;
import static system.SystemConfiguration.FIRST_ARRAY_ELEMENT_INDEX;
import static system.SystemConfiguration.THE_NONE_CHARACTER;

import java.util.Arrays;

public class JoinHelper {
	
	public static String [] mergeJoinOnBlocks(String [] r, String [] s) {
		if(r.length > BUFFER_SIZE || s.length > BUFFER_SIZE) {
			return null;
		}

		String [] rs	= new String[BUFFER_SIZE];
		int		index	= 0;
		int		i		= 0;
		int		j		= 0;
		
		Arrays.sort(r);
		Arrays.sort(s);
		
		while(i < r.length && j < s.length) {
			if(r[i].compareTo(s[j]) > 0) {
				j ++;
			}
			else {
				if(r[i] == s[j]) {
					rs[index ++] = r[i];
				}
				i ++;
			}
		}
		
		return rs[FIRST_ARRAY_ELEMENT_INDEX] == null ||
				rs[FIRST_ARRAY_ELEMENT_INDEX].isEmpty() ?
				null :
					rs;
	}
}
