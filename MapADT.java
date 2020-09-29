// --== CS400 File Header Information ==--
// Name: Ananth Subramanya Mudigere
// Email: amsubramanya@wisc.edu
// Team: HE
// TA: Na Li
// Lecturer: florian heimerl
// Notes to Grader: hope you have a good day :))

import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {


	public boolean put(KeyType key, ValueType value);
	public ValueType get(KeyType key) throws NoSuchElementException;
	public int size();
	public boolean containsKey(KeyType key);
	public ValueType remove(KeyType key);
	public void clear();
	
}