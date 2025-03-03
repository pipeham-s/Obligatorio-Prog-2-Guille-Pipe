/**
 * 
 */
package uy.edu.um.prog2.adt.arbolitos.naryTree;

/**
 * @author danielpereda
 *
 */
public interface Tree<T> {

	void add(T oValueToAdd, T oParentValue);

	T getValue();

	void setValue(T oValue);

	Tree<T>[] getChilds();

	Tree<T> searchValue(T oValueToSearch);
}
