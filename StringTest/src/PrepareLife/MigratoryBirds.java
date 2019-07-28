package PrepareLife;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * in will be identified by an integer value. Each time a particular kind of
 * bird is spotted, its id number will be added to your array of sightings. You
 * would like to be able to find out which type of bird is most common given a
 * list of sightings. Your task is to print the type number of that bird and if
 * two or more types of birds are equally common, choose the type with the
 * smallest ID number.
 * 
 * For example, assume your bird sightings are of types . There are two each of
 * types and , and one sighting of type . Pick the lower of the two types seen
 * twice: type .
 * 
 * @author jjjwo
 *
 */
public class MigratoryBirds {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(1);
		
		migratoryBirds(list);
		
	}

	public static int migratoryBirds(List<Integer> arr) {
		int listSize = arr.size();
		
		//List to ObjectArray
		Object[] arrInter = arr.toArray();
		for(int i = 0 ; i < listSize ; i ++) {
			//System.out.println(arrInter[i]);
		}
		System.out.println("==================");
		//Integer List to Array
		Integer[] newIntegerAry = arr.toArray(new Integer[listSize]);
		int newIntegerArySize = newIntegerAry.length;
		
		for(int i = 0 ; i < listSize ; i ++) {
			//System.out.println(newIntegerAry[i]);
		}
		
		
		//solution
		int [] rstAry = {0,0,0,0,0,0};
		int i = 0;
		for(i = 0 ; i < listSize ; i++) {
			rstAry[arr.get(i)] = ++rstAry[arr.get(i)];
		}
		int rstAryLength = rstAry.length;
		int maxValue = rstAry[1];
		int maxIdx = 1;
		for(i = 1 ; i < rstAryLength-1 ; i++) {
			if(maxValue < rstAry[i+1] ) {
				maxValue = rstAry[i+1];
				maxIdx = i+1;
			}
		}
		
		Arrays.sort(rstAry);
		for(i = 1 ; i < rstAryLength-1 ; i++) {
			if(rstAry[i] == maxValue) {
				break;
			}
		}
		System.out.println(i);
		
		return 0;
	}

}
