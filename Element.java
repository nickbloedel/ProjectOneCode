

/**
 * 
 * @author ananth
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class Element<KeyType, ValueType> {
	
	private ValueType value;
	private KeyType key;

	public Element(ValueType value, KeyType key) {
		this.value = value;
		this.key = key;
	}

	public ValueType getValue() {
		return value;
	}

	public KeyType getKey() {
		return key;
	}

}
