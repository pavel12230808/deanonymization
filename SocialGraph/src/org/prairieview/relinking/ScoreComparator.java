package org.prairieview.relinking;
import java.util.Comparator;

public class ScoreComparator implements Comparator<Similarities>{

	@Override
	public int compare(Similarities o1, Similarities o2) {
		// TODO Auto-generated method stub
		if(o1.score==o2.score)  
			return 0;  
		else if(o1.score>o2.score)  
			return 1;  
		else  
			return -1; 
	}

}
