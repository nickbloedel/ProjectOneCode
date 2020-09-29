
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * 
 * @author ananth
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

	private int size; // maximum number of key value pairs the array can hold
	private int capacity; // maximum number of key value pairs the array can hold
	private LinkedList<Element>[] hashArr; // array that holds the key value pairs

	/**
	 * Constructor that gets invoked if the capacity is specified. Assigns the class
	 * array to have the specified capacity
	 * 
	 * @param capacity - the maximum number of key value pairs the array can hold
	 */
	public HashTableMap(int capacity) {

		hashArr = new LinkedList[capacity]; // creates an array with the specified capacity
		this.capacity = capacity;
		for (int i = 0; i < capacity; i++) {
			hashArr[i] = new LinkedList<>();
		}
		size = 0;
	}

	/**
	 * 
	 * Constructor that gets invoked if the capacity is not specified. Assigns the
	 * class array to hold at least 10 key value pairs by default.
	 * 
	 */
	public HashTableMap() {

		hashArr = new LinkedList[10];
		this.capacity = 10; // assigns capacity 10
		for (int i = 0; i < capacity; i++) {
			hashArr[i] = new LinkedList<>();
		}
		size = 0;
	}

	/**
	 * If the load capacity of 80% is exceeded, creates a new array with double the
	 * capacity and adds the values from the old array to it
	 */
	private void rehash() {

		int newCapacity = 2 * this.capacity; // doubles the capacity
		LinkedList<Element>[] newArr = new LinkedList[newCapacity]; // creates a new array with the doubled
																			// capacity
		for (int i = 0; i < newCapacity; i++) {
			newArr[i] = new LinkedList();
		}

		for (int i = 0; i < this.capacity; i++) {
			for (int j = 0; j < hashArr[i].size(); j++) {
				Element obj = hashArr[i].get(j);
				newArr[Math.abs(obj.getKey().hashCode() % this.capacity)].add(obj);
			}
		}
		this.hashArr = newArr;
		this.capacity = newCapacity;
	}

	/**
	 * Inserts key pair if the pair does not already exist into the array
	 * 
	 * @param key
	 * @param value
	 * @return true if key pair was inserted and false if not
	 */
	@Override
	public boolean put(KeyType key, ValueType value) {

		if ((double) (this.size + 1) / (this.capacity) >= 0.8) { // checks to see if the load capacity exceeds 80%. If
																	// yes it rehashes
			rehash();
		}

		int hashKey = Math.abs((key.hashCode()) % capacity);

		LinkedList<Element> list = hashArr[hashKey];

		for (Element x : list) {
			if (x.getKey().equals(key)) {
				return false;
			}
		}

		list.add(new Element<>(key, value));
		++size;
		return true;
	}

	/**
	 * Gets the key pair value specified if it exists in the hash table
	 * 
	 * @param key
	 * @return
	 * @throws NoSuchElementException if key not found
	 */
	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {

		if (!(containsKey(key))) {
			throw new NoSuchElementException("Item does not exist in the HashMapTable.");
		} else {

			int hashKey = Math.abs((key.hashCode()) % capacity);

			LinkedList<Element> list = hashArr[hashKey];

			for (Element x : list) {
				if (x.getKey().equals(key)) {
					return (ValueType) x.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * Returns the number of key value pairs in the table
	 * 
	 * @return
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * checks if key specified exists
	 * 
	 * @param key
	 * @return true if key exists on the table else false
	 */
	@Override
	public boolean containsKey(KeyType key) {

		int hashKey = Math.abs((key.hashCode()) % capacity);
		LinkedList<Element> list = hashArr[hashKey];

		for (Element x : list) { // checks if key specified exists
			if (x.getKey().equals(key)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * @param key
	 * @return value of ValueType that corresponds to the key
	 */
	@Override
	public ValueType remove(KeyType key) {

		ValueType value = null;

		int hashKey = Math.abs((key.hashCode()) % capacity);
		LinkedList<Element> list = hashArr[hashKey];

		for (Element x : list) {
			if (x.getKey().equals(key)) {
				ValueType toRemove = (ValueType) x.getValue();
				list.remove(x); // removes the specified key pair
				--size;
				return toRemove;
			}
		}

		return null;
	}

	/**
	 * clears hash table
	 */
	@Override
	public void clear() {

		for (int i = 0; i < capacity; i++) {
			hashArr[i] = new LinkedList<Element>();
		}
		size = 0;
	}

}
