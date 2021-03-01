package org.di.unito.yarel.utils

import java.util.Comparator

class Utils {
	
	public static final Comparator<String> STRING_COMPARATOR = [String s1, String s2 |
		if(s1==s2){return 0;}
		else if (s1 === null ){return -1;}
		else if (s2 === null ){return 1;}
		else return s1.compareTo(s2);
	];
}