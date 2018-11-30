package GIS;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class project implements GIS_project {
	
		Set<GIS_layer> project= new HashSet<GIS_layer>();
	
	/**
	 * 	@param GIS_layer l layer
	 * @return return true if the addition succeeded
	 */
	@Override
	public boolean add(GIS_layer l) {
		return project.add(l);
	}
	/**
	 * 	@param GIS_layer Collection l 
	 * @return return true if the addition succeeded 
	 */
	@Override
	public boolean addAll(Collection<? extends GIS_layer> l) {
		return project.addAll(l);
	}
	/**
	 * Clearing the project
	 */
	@Override
	public void clear() {
		project.clear();
	}
	/**
	 * checking if the object exist
	 * @return return true if it exist otherwise return false
	 */
	@Override
	public boolean contains(Object l) {
		return project.contains(l);
	}
/**
 * @param collection of <>
 * @return return wheter the collection exist or not
 */
	@Override
	public boolean containsAll(Collection<?> l) {
		return project.containsAll(l);
	}
/**
 * @return return true if the project doesnt contains layer otherwise return false
 */
	@Override
	public boolean isEmpty() {
		return project.isEmpty();
	}
/**
 * @return iterator to the layer collection
 */
	@Override
	public Iterator<GIS_layer> iterator() {
		return project.iterator();
	}
/**
 * remove and object from the project
 */
	@Override
	public boolean remove(Object l) {
		return project.remove(l);
	}
/**
 * remove bunch of objects from the sets
 */
	@Override
	public boolean removeAll(Collection<?> l) {
		return project.removeAll(l);
	}
/**
 *retaining the objects of the given set 
 */
	@Override
	public boolean retainAll(Collection<?> l) {
		return project.retainAll(l);
	}
/**
 * @return return the project size
 */
	@Override
	public int size() {
		return project.size();
	}
/**
 * @return return array of the project
 */
	@Override
	public Object[] toArray() {
		return project.toArray();
	}
/**
 * @return return an array with only the elements of the given array 
 */
	@Override
	public <T> T[] toArray(T[] l) {
		return project.toArray(l);
	}
/**
 * 
 */
	@Override
	public Meta_data get_Meta_data() { // Missing Missing Missing Missing Missing Missing Missing Missing Missing Missing
		return null;
	}
	

}
