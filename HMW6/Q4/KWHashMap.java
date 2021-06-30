

public interface KWHashMap<K,V>{
	/** Method get for class Hashtable.
	@param key The key being sought
	@return The value associated with this key if found;
	otherwise, null
	*/
	public V get(Object key);
	/** Method put for class Hashtable.
	@post This key value pair is inserted in the
	table and numKeys is incremented. If the key is already
	in the table, its value is changed to the argument
	value and numKeys is not changed.
	@param key The key of item being inserted
	@param value The value for this key
	@return The old value associated with this key if
	found; otherwise, null
	*/
	public V put(K key, V value);


}