package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Layer implements GIS_layer{

	Set<GIS_element> layer = new HashSet<GIS_element>();
	
	/**
	 * adding element to the layer
	 * @param e representing an element
	 */
	@Override
	public boolean add(GIS_element e) {
		return layer.add(e);
	}
	/**
	 * @param collection of elements
	 * adding the collection to the set
	 */
	@Override
	public boolean addAll(Collection<? extends GIS_element> e) {
		return layer.addAll(e);
	}
	/**
	 * clearing the Layer
	 */
	@Override
	public void clear() {
		layer.clear();

	}
	/**
	 * @param e 
	 * @return return true if the object is in the collection, otherwise false
	 */
	@Override
	public boolean contains(Object e) {
		return layer.contains(e);
	}
	/**
	 * @param e 
	 * @return return true if the objects are in the collection, otherwise false 
	 */
	@Override
	public boolean containsAll(Collection<?> e) {
		return layer.containsAll(e);
	}
	/**
	 *@return return true if the layer is empty otherwise return false
	 */
	@Override
	public boolean isEmpty() {
		return layer.isEmpty();

	}
	/**
	 * @return return iterator pointing to the elements in the layer
	 */
	@Override
	public Iterator<GIS_element> iterator() {
		Iterator<GIS_element> it= layer.iterator();  //questionable?
		return it;
	}
	/**
	 * remove an object from the layer
	 */
	@Override
	public boolean remove(Object e) {
		return layer.remove(e);
	}
	/**
	 * remove a from objects from the layer according to the collection given
	 */
	@Override
	public boolean removeAll(Collection<?> e) {
		return layer.removeAll(e);
	}
	/**
	 * retaining only the objects of the given collection
	 */
	@Override
	public boolean retainAll(Collection<?> e) {
		return layer.retainAll(e);
	}
	/**
	 * @return return the size of the layer (meaning how many element there is)
	 */
	@Override
	public int size() {
		return layer.size();
	} 
	/**
	 * @return turning the collection into array
	 */
	@Override
	public Object[] toArray() {
		return 	layer.toArray();

	}
	/**
	 *  @return turning the collection into array according to the array's given objects
	 */
	@Override
	public <T> T[] toArray(T[] e) {
		return layer.toArray(e);
	}
	/**
	 *  null at the moment
	 */
	@Override
	public Meta_data get_Meta_data() { 					//Missing Missing Missing Missing Missing Missing Missing Missing Missing Missing Missing Missing Missing Missing 
		return null;
	}

}
