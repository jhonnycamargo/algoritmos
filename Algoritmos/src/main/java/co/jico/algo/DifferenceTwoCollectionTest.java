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

		return Collections2.filter(updated, Predicates.not(Predicates.in(existing)));
	}

	public static <E> Collection<E> getRemoved(Collection<E> existing, Collection<E> updated) {

		return Collections2.filter(existing, Predicates.not(Predicates.in(updated)));
	}

	public static void main(String[] args) {
		List<String> existing = new ArrayList<String>();
		List<String> updated = new ArrayList<String>();

		existing.add("a");
		existing.add("b");
		existing.add("c");
		existing.add("e");

		updated.add("a");
		updated.add("b");
		updated.add("c");
		updated.add("d");

		Collection<String> added = getAdded(existing, updated);
		for (String a : added) {
			System.out.println("Added = " + a);
		}

		Collection<String> removed = getRemoved(existing, updated);
		for (String r : removed) {
			System.out.println("Removed = " + r);
		}
	}

}
