package algorithms.hashmap;

import java.util.ArrayList;

public class Map<K,V> {
	ArrayList<HashNode<K,V>> bucket = new ArrayList<HashNode<K,V>>();	
	int size = 0;
	int noOfBuckets = 10;
	
	public Map(){
		for(int i=0;i<noOfBuckets;i++){
			bucket.add(null);
		}
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int getSize(){
		return size;
	}
	
	public int getBucketIndex(K key){
		int hashCode = key.hashCode();
		return hashCode % noOfBuckets;
	}
	
	public V get(K key){
		int index = getBucketIndex(key);
		HashNode node = bucket.get(index);
		while(node!=null){
			if(node.key.equals(key)){
				return (V)node.value;
			}
			node=node.next;
		}
		return null;
	}
	
	public V remove(K key){
		int index= getBucketIndex(key);
		HashNode<K,V> node= bucket.get(index);
		if(node==null){
			return null;
		}
		
		V val=null;
		if(node.key.equals(key)){
			val = node.value;
			bucket.set(index, node.next);
			size--;
		}else{
			HashNode prev = node;
			while(node!=null){
				if(node.key.equals(key)){
					val = node.value;
					break;
				}
				prev=node;
				node=node.next;
			}
			prev.next=node.next;
			size--;
		}
		return val;
	}
	
	public void add(K key, V val){
		int index = getBucketIndex(key);
		HashNode<K,V> node = bucket.get(index);
		HashNode<K,V> newNode = new HashNode<K,V>(key,val);
		if(node==null){
			bucket.set(index, newNode);
			newNode.next=null;
			size++;
		}
		else{
			HashNode<K,V> prev = node;
			while(node!=null){
				if(node.key.equals(key)){
					node.value=val;
					return;
				}
				prev=node;
				node=node.next;
			}
			HashNode head = bucket.get(index);
			newNode.next=head;
			prev.next=newNode;
			bucket.set(index, newNode);
			size++;
		}
		// Load factor and doubling no Of Buckets
		if(((size*0.1)/noOfBuckets)>=0.7){
			ArrayList<HashNode<K,V>> existingBucket = bucket;
			bucket = new ArrayList<HashNode<K,V>>();
			noOfBuckets= noOfBuckets*2;
			size=0;
			for(int i=0;i<noOfBuckets;i++){
				bucket.add(null);
			}
			for(HashNode<K,V> existingNode: existingBucket){
				while(existingNode!=null){
					add(existingNode.key,existingNode.value);
					existingNode=existingNode.next;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Map<Integer,String> myMap= new Map<Integer,String>();
		myMap.add(1, "Shuchi");
		myMap.add(2, "Nirali");
		myMap.add(3,"Nisha");
		System.out.println(myMap);
		System.out.println("Size of Map: "+myMap.getSize());
		myMap.add(3,"Stuti");
		System.out.println(myMap);
		System.out.println("Size of Map: "+myMap.getSize());
		String val = myMap.remove(2);
		System.out.println("Removed: "+val);
		System.out.println("Size of Map: "+myMap.getSize());
		myMap.add(4, "Niti");
		System.out.println("Size of Map: "+myMap.getSize());
		System.out.println(myMap);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Map-----------------\n");
		for (HashNode<K, V> hashNode : bucket) {
			while(hashNode!=null){
				sb.append(hashNode.key+":"+hashNode.value+"\n");
				hashNode=hashNode.next;
			}
		}
		
		return sb.toString();
	}
	
}
