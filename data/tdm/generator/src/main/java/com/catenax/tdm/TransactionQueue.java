/*
 *
 */
package com.catenax.tdm;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.dao.QueueDao;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionQueue.
 */
public class TransactionQueue {

	/** The Constant entities. */
	private static final List<Object> entities = new ArrayList<>();

	/**
	 * Adds the.
	 *
	 * @param o the o
	 */
	public static void add(Object o) {
		entities.add(o);
	}

	/**
	 * Adds the all.
	 *
	 * @param ol the ol
	 */
	public static void addAll(List ol) {
		if (ol != null) {
			entities.addAll(ol);
		}
	}

	/**
	 * Clear.
	 */
	public static void clear() {
		entities.clear();
	}

	/**
	 * Flush.
	 *
	 * @param dao the dao
	 */
	public static void flush(QueueDao dao) {
		for (final Object o : entities) {
			dao.create(o);
		}
		clear();
		dao.flush();
	}

	/**
	 * Removes the.
	 *
	 * @param o the o
	 */
	public static void remove(Object o) {
		entities.remove(o);
	}

	/**
	 * Removes the all.
	 *
	 * @param ol the ol
	 */
	public static void removeAll(List<Object> ol) {
		if (ol != null) {
			for (final Object o : ol) {
				remove(o);
			}
		}
	}

}
