package algorithms.hashmap;

public class HashNode<K,V> {
	K key;
	V value;
	
	HashNode next;
	
	public HashNode(K k, V v){
		key=k;
		value=v;
	}
}
