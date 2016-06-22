package co.jico.algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;

/**
 * http://www.codeproject.com/Tips/1107118/Find-Differences-Between-Two-
 * Collections
 * 
 * Introduction Having an existing collection of objects and a new collection of
 * objects, we need to find out which objects were added to the original
 * collection and which were removed from it.
 * 
 * Background
 * 
 * The easiest way to understand this is to think of collections as sets A and
 * B. A is the existing collection and B is the new collection.
 * 
 * Objects that were removed from A are the ones that are in A but are not in B.
 * 
 * Objects that were added to the collection are the ones that are in B but are
 * not in A.
 * 
 * @author merkhet
 *
 */
public class DifferenceTwoCollectionTest {

	public static <E> Collection<E> getAdded(Collection<E> existing, Collection<E> updated) {
		Collection<E> filter = existing;
		for (E e : filter) {
			filter = Collections2.filter(updated, Predicates.not(Predicates.equalTo(e)));
		}

		return filter;
	}

	public static void main(String[] args) {
		List<String> existing = new ArrayList<String>();
		List<String> updated = new ArrayList<String>();

		existing.add("a");
		existing.add("b");
		existing.add("c");

		updated.add("a");
		updated.add("b");
		updated.add("c");
		updated.add("d");

		Collection<String> added = getAdded(existing, updated);
		for (String string : added) {
			System.out.println(string);
		}

	}

}
