/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.chola.trainingcalendar.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.chola.trainingcalendar.exception.NoSuchtrainingpersonalisedparameterscontentstoreException;
import com.chola.trainingcalendar.model.impl.trainingpersonalisedparameterscontentstoreImpl;
import com.chola.trainingcalendar.model.impl.trainingpersonalisedparameterscontentstoreModelImpl;
import com.chola.trainingcalendar.model.trainingpersonalisedparameterscontentstore;
import com.chola.trainingcalendar.service.persistence.trainingpersonalisedparameterscontentstorePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the trainingpersonalisedparameterscontentstore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CloverLiferay01
 * @see trainingpersonalisedparameterscontentstorePersistence
 * @see com.chola.trainingcalendar.service.persistence.trainingpersonalisedparameterscontentstoreUtil
 * @generated
 */
@ProviderType
public class trainingpersonalisedparameterscontentstorePersistenceImpl
	extends BasePersistenceImpl<trainingpersonalisedparameterscontentstore>
	implements trainingpersonalisedparameterscontentstorePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link trainingpersonalisedparameterscontentstoreUtil} to access the trainingpersonalisedparameterscontentstore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = trainingpersonalisedparameterscontentstoreImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreModelImpl.FINDER_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreModelImpl.FINDER_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTID =
		new FinderPath(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreModelImpl.FINDER_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCONTENTID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTID =
		new FinderPath(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreModelImpl.FINDER_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCONTENTID",
			new String[] { Long.class.getName() },
			trainingpersonalisedparameterscontentstoreModelImpl.CONTENT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENTID = new FinderPath(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCONTENTID", new String[] { Long.class.getName() });

	/**
	 * Returns all the trainingpersonalisedparameterscontentstores where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @return the matching trainingpersonalisedparameterscontentstores
	 */
	@Override
	public List<trainingpersonalisedparameterscontentstore> findByCONTENTID(
		long content_id) {
		return findByCONTENTID(content_id, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainingpersonalisedparameterscontentstores where content_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link trainingpersonalisedparameterscontentstoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content_id the content_id
	 * @param start the lower bound of the range of trainingpersonalisedparameterscontentstores
	 * @param end the upper bound of the range of trainingpersonalisedparameterscontentstores (not inclusive)
	 * @return the range of matching trainingpersonalisedparameterscontentstores
	 */
	@Override
	public List<trainingpersonalisedparameterscontentstore> findByCONTENTID(
		long content_id, int start, int end) {
		return findByCONTENTID(content_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainingpersonalisedparameterscontentstores where content_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link trainingpersonalisedparameterscontentstoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content_id the content_id
	 * @param start the lower bound of the range of trainingpersonalisedparameterscontentstores
	 * @param end the upper bound of the range of trainingpersonalisedparameterscontentstores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainingpersonalisedparameterscontentstores
	 */
	@Override
	public List<trainingpersonalisedparameterscontentstore> findByCONTENTID(
		long content_id, int start, int end,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator) {
		return findByCONTENTID(content_id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainingpersonalisedparameterscontentstores where content_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link trainingpersonalisedparameterscontentstoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content_id the content_id
	 * @param start the lower bound of the range of trainingpersonalisedparameterscontentstores
	 * @param end the upper bound of the range of trainingpersonalisedparameterscontentstores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching trainingpersonalisedparameterscontentstores
	 */
	@Override
	public List<trainingpersonalisedparameterscontentstore> findByCONTENTID(
		long content_id, int start, int end,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTID;
			finderArgs = new Object[] { content_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTID;
			finderArgs = new Object[] { content_id, start, end, orderByComparator };
		}

		List<trainingpersonalisedparameterscontentstore> list = null;

		if (retrieveFromCache) {
			list = (List<trainingpersonalisedparameterscontentstore>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore : list) {
					if ((content_id != trainingpersonalisedparameterscontentstore.getContent_id())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE_WHERE);

			query.append(_FINDER_COLUMN_CONTENTID_CONTENT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(trainingpersonalisedparameterscontentstoreModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(content_id);

				if (!pagination) {
					list = (List<trainingpersonalisedparameterscontentstore>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<trainingpersonalisedparameterscontentstore>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first trainingpersonalisedparameterscontentstore in the ordered set where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainingpersonalisedparameterscontentstore
	 * @throws NoSuchtrainingpersonalisedparameterscontentstoreException if a matching trainingpersonalisedparameterscontentstore could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore findByCONTENTID_First(
		long content_id,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator)
		throws NoSuchtrainingpersonalisedparameterscontentstoreException {
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore =
			fetchByCONTENTID_First(content_id, orderByComparator);

		if (trainingpersonalisedparameterscontentstore != null) {
			return trainingpersonalisedparameterscontentstore;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content_id=");
		msg.append(content_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchtrainingpersonalisedparameterscontentstoreException(msg.toString());
	}

	/**
	 * Returns the first trainingpersonalisedparameterscontentstore in the ordered set where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainingpersonalisedparameterscontentstore, or <code>null</code> if a matching trainingpersonalisedparameterscontentstore could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore fetchByCONTENTID_First(
		long content_id,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator) {
		List<trainingpersonalisedparameterscontentstore> list = findByCONTENTID(content_id,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainingpersonalisedparameterscontentstore in the ordered set where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainingpersonalisedparameterscontentstore
	 * @throws NoSuchtrainingpersonalisedparameterscontentstoreException if a matching trainingpersonalisedparameterscontentstore could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore findByCONTENTID_Last(
		long content_id,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator)
		throws NoSuchtrainingpersonalisedparameterscontentstoreException {
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore =
			fetchByCONTENTID_Last(content_id, orderByComparator);

		if (trainingpersonalisedparameterscontentstore != null) {
			return trainingpersonalisedparameterscontentstore;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content_id=");
		msg.append(content_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchtrainingpersonalisedparameterscontentstoreException(msg.toString());
	}

	/**
	 * Returns the last trainingpersonalisedparameterscontentstore in the ordered set where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainingpersonalisedparameterscontentstore, or <code>null</code> if a matching trainingpersonalisedparameterscontentstore could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore fetchByCONTENTID_Last(
		long content_id,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator) {
		int count = countByCONTENTID(content_id);

		if (count == 0) {
			return null;
		}

		List<trainingpersonalisedparameterscontentstore> list = findByCONTENTID(content_id,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainingpersonalisedparameterscontentstores before and after the current trainingpersonalisedparameterscontentstore in the ordered set where content_id = &#63;.
	 *
	 * @param id the primary key of the current trainingpersonalisedparameterscontentstore
	 * @param content_id the content_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainingpersonalisedparameterscontentstore
	 * @throws NoSuchtrainingpersonalisedparameterscontentstoreException if a trainingpersonalisedparameterscontentstore with the primary key could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore[] findByCONTENTID_PrevAndNext(
		long id, long content_id,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator)
		throws NoSuchtrainingpersonalisedparameterscontentstoreException {
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore =
			findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			trainingpersonalisedparameterscontentstore[] array = new trainingpersonalisedparameterscontentstoreImpl[3];

			array[0] = getByCONTENTID_PrevAndNext(session,
					trainingpersonalisedparameterscontentstore, content_id,
					orderByComparator, true);

			array[1] = trainingpersonalisedparameterscontentstore;

			array[2] = getByCONTENTID_PrevAndNext(session,
					trainingpersonalisedparameterscontentstore, content_id,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected trainingpersonalisedparameterscontentstore getByCONTENTID_PrevAndNext(
		Session session,
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore,
		long content_id,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE_WHERE);

		query.append(_FINDER_COLUMN_CONTENTID_CONTENT_ID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(trainingpersonalisedparameterscontentstoreModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(content_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trainingpersonalisedparameterscontentstore);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<trainingpersonalisedparameterscontentstore> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainingpersonalisedparameterscontentstores where content_id = &#63; from the database.
	 *
	 * @param content_id the content_id
	 */
	@Override
	public void removeByCONTENTID(long content_id) {
		for (trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore : findByCONTENTID(
				content_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trainingpersonalisedparameterscontentstore);
		}
	}

	/**
	 * Returns the number of trainingpersonalisedparameterscontentstores where content_id = &#63;.
	 *
	 * @param content_id the content_id
	 * @return the number of matching trainingpersonalisedparameterscontentstores
	 */
	@Override
	public int countByCONTENTID(long content_id) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTENTID;

		Object[] finderArgs = new Object[] { content_id };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE_WHERE);

			query.append(_FINDER_COLUMN_CONTENTID_CONTENT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(content_id);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONTENTID_CONTENT_ID_2 = "trainingpersonalisedparameterscontentstore.content_id = ?";

	public trainingpersonalisedparameterscontentstorePersistenceImpl() {
		setModelClass(trainingpersonalisedparameterscontentstore.class);
	}

	/**
	 * Caches the trainingpersonalisedparameterscontentstore in the entity cache if it is enabled.
	 *
	 * @param trainingpersonalisedparameterscontentstore the trainingpersonalisedparameterscontentstore
	 */
	@Override
	public void cacheResult(
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore) {
		entityCache.putResult(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreImpl.class,
			trainingpersonalisedparameterscontentstore.getPrimaryKey(),
			trainingpersonalisedparameterscontentstore);

		trainingpersonalisedparameterscontentstore.resetOriginalValues();
	}

	/**
	 * Caches the trainingpersonalisedparameterscontentstores in the entity cache if it is enabled.
	 *
	 * @param trainingpersonalisedparameterscontentstores the trainingpersonalisedparameterscontentstores
	 */
	@Override
	public void cacheResult(
		List<trainingpersonalisedparameterscontentstore> trainingpersonalisedparameterscontentstores) {
		for (trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore : trainingpersonalisedparameterscontentstores) {
			if (entityCache.getResult(
						trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
						trainingpersonalisedparameterscontentstoreImpl.class,
						trainingpersonalisedparameterscontentstore.getPrimaryKey()) == null) {
				cacheResult(trainingpersonalisedparameterscontentstore);
			}
			else {
				trainingpersonalisedparameterscontentstore.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trainingpersonalisedparameterscontentstores.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(trainingpersonalisedparameterscontentstoreImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trainingpersonalisedparameterscontentstore.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore) {
		entityCache.removeResult(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreImpl.class,
			trainingpersonalisedparameterscontentstore.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<trainingpersonalisedparameterscontentstore> trainingpersonalisedparameterscontentstores) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore : trainingpersonalisedparameterscontentstores) {
			entityCache.removeResult(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
				trainingpersonalisedparameterscontentstoreImpl.class,
				trainingpersonalisedparameterscontentstore.getPrimaryKey());
		}
	}

	/**
	 * Creates a new trainingpersonalisedparameterscontentstore with the primary key. Does not add the trainingpersonalisedparameterscontentstore to the database.
	 *
	 * @param id the primary key for the new trainingpersonalisedparameterscontentstore
	 * @return the new trainingpersonalisedparameterscontentstore
	 */
	@Override
	public trainingpersonalisedparameterscontentstore create(long id) {
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore =
			new trainingpersonalisedparameterscontentstoreImpl();

		trainingpersonalisedparameterscontentstore.setNew(true);
		trainingpersonalisedparameterscontentstore.setPrimaryKey(id);

		return trainingpersonalisedparameterscontentstore;
	}

	/**
	 * Removes the trainingpersonalisedparameterscontentstore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trainingpersonalisedparameterscontentstore
	 * @return the trainingpersonalisedparameterscontentstore that was removed
	 * @throws NoSuchtrainingpersonalisedparameterscontentstoreException if a trainingpersonalisedparameterscontentstore with the primary key could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore remove(long id)
		throws NoSuchtrainingpersonalisedparameterscontentstoreException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the trainingpersonalisedparameterscontentstore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trainingpersonalisedparameterscontentstore
	 * @return the trainingpersonalisedparameterscontentstore that was removed
	 * @throws NoSuchtrainingpersonalisedparameterscontentstoreException if a trainingpersonalisedparameterscontentstore with the primary key could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore remove(
		Serializable primaryKey)
		throws NoSuchtrainingpersonalisedparameterscontentstoreException {
		Session session = null;

		try {
			session = openSession();

			trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore =
				(trainingpersonalisedparameterscontentstore)session.get(trainingpersonalisedparameterscontentstoreImpl.class,
					primaryKey);

			if (trainingpersonalisedparameterscontentstore == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchtrainingpersonalisedparameterscontentstoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trainingpersonalisedparameterscontentstore);
		}
		catch (NoSuchtrainingpersonalisedparameterscontentstoreException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected trainingpersonalisedparameterscontentstore removeImpl(
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore) {
		trainingpersonalisedparameterscontentstore = toUnwrappedModel(trainingpersonalisedparameterscontentstore);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(trainingpersonalisedparameterscontentstore)) {
				trainingpersonalisedparameterscontentstore = (trainingpersonalisedparameterscontentstore)session.get(trainingpersonalisedparameterscontentstoreImpl.class,
						trainingpersonalisedparameterscontentstore.getPrimaryKeyObj());
			}

			if (trainingpersonalisedparameterscontentstore != null) {
				session.delete(trainingpersonalisedparameterscontentstore);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (trainingpersonalisedparameterscontentstore != null) {
			clearCache(trainingpersonalisedparameterscontentstore);
		}

		return trainingpersonalisedparameterscontentstore;
	}

	@Override
	public trainingpersonalisedparameterscontentstore updateImpl(
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore) {
		trainingpersonalisedparameterscontentstore = toUnwrappedModel(trainingpersonalisedparameterscontentstore);

		boolean isNew = trainingpersonalisedparameterscontentstore.isNew();

		trainingpersonalisedparameterscontentstoreModelImpl trainingpersonalisedparameterscontentstoreModelImpl =
			(trainingpersonalisedparameterscontentstoreModelImpl)trainingpersonalisedparameterscontentstore;

		Session session = null;

		try {
			session = openSession();

			if (trainingpersonalisedparameterscontentstore.isNew()) {
				session.save(trainingpersonalisedparameterscontentstore);

				trainingpersonalisedparameterscontentstore.setNew(false);
			}
			else {
				trainingpersonalisedparameterscontentstore = (trainingpersonalisedparameterscontentstore)session.merge(trainingpersonalisedparameterscontentstore);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!trainingpersonalisedparameterscontentstoreModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trainingpersonalisedparameterscontentstoreModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trainingpersonalisedparameterscontentstoreModelImpl.getOriginalContent_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTID,
					args);

				args = new Object[] {
						trainingpersonalisedparameterscontentstoreModelImpl.getContent_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONTENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTID,
					args);
			}
		}

		entityCache.putResult(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
			trainingpersonalisedparameterscontentstoreImpl.class,
			trainingpersonalisedparameterscontentstore.getPrimaryKey(),
			trainingpersonalisedparameterscontentstore, false);

		trainingpersonalisedparameterscontentstore.resetOriginalValues();

		return trainingpersonalisedparameterscontentstore;
	}

	protected trainingpersonalisedparameterscontentstore toUnwrappedModel(
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore) {
		if (trainingpersonalisedparameterscontentstore instanceof trainingpersonalisedparameterscontentstoreImpl) {
			return trainingpersonalisedparameterscontentstore;
		}

		trainingpersonalisedparameterscontentstoreImpl trainingpersonalisedparameterscontentstoreImpl =
			new trainingpersonalisedparameterscontentstoreImpl();

		trainingpersonalisedparameterscontentstoreImpl.setNew(trainingpersonalisedparameterscontentstore.isNew());
		trainingpersonalisedparameterscontentstoreImpl.setPrimaryKey(trainingpersonalisedparameterscontentstore.getPrimaryKey());

		trainingpersonalisedparameterscontentstoreImpl.setId(trainingpersonalisedparameterscontentstore.getId());
		trainingpersonalisedparameterscontentstoreImpl.setContent_id(trainingpersonalisedparameterscontentstore.getContent_id());
		trainingpersonalisedparameterscontentstoreImpl.setBusiness(trainingpersonalisedparameterscontentstore.getBusiness());
		trainingpersonalisedparameterscontentstoreImpl.setUnit(trainingpersonalisedparameterscontentstore.getUnit());
		trainingpersonalisedparameterscontentstoreImpl.setFunction(trainingpersonalisedparameterscontentstore.getFunction());
		trainingpersonalisedparameterscontentstoreImpl.setDepartment(trainingpersonalisedparameterscontentstore.getDepartment());
		trainingpersonalisedparameterscontentstoreImpl.setDesignation(trainingpersonalisedparameterscontentstore.getDesignation());
		trainingpersonalisedparameterscontentstoreImpl.setProduct(trainingpersonalisedparameterscontentstore.getProduct());
		trainingpersonalisedparameterscontentstoreImpl.setZone(trainingpersonalisedparameterscontentstore.getZone());
		trainingpersonalisedparameterscontentstoreImpl.setBranch(trainingpersonalisedparameterscontentstore.getBranch());
		trainingpersonalisedparameterscontentstoreImpl.setGrade(trainingpersonalisedparameterscontentstore.getGrade());
		trainingpersonalisedparameterscontentstoreImpl.setRegion(trainingpersonalisedparameterscontentstore.getRegion());
		trainingpersonalisedparameterscontentstoreImpl.setLocation(trainingpersonalisedparameterscontentstore.getLocation());
		trainingpersonalisedparameterscontentstoreImpl.setUser_id(trainingpersonalisedparameterscontentstore.getUser_id());
		trainingpersonalisedparameterscontentstoreImpl.setGender(trainingpersonalisedparameterscontentstore.getGender());
		trainingpersonalisedparameterscontentstoreImpl.setAge_type(trainingpersonalisedparameterscontentstore.getAge_type());
		trainingpersonalisedparameterscontentstoreImpl.setAge_value(trainingpersonalisedparameterscontentstore.getAge_value());
		trainingpersonalisedparameterscontentstoreImpl.setNotification_type(trainingpersonalisedparameterscontentstore.getNotification_type());

		return trainingpersonalisedparameterscontentstoreImpl;
	}

	/**
	 * Returns the trainingpersonalisedparameterscontentstore with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainingpersonalisedparameterscontentstore
	 * @return the trainingpersonalisedparameterscontentstore
	 * @throws NoSuchtrainingpersonalisedparameterscontentstoreException if a trainingpersonalisedparameterscontentstore with the primary key could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchtrainingpersonalisedparameterscontentstoreException {
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore =
			fetchByPrimaryKey(primaryKey);

		if (trainingpersonalisedparameterscontentstore == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchtrainingpersonalisedparameterscontentstoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return trainingpersonalisedparameterscontentstore;
	}

	/**
	 * Returns the trainingpersonalisedparameterscontentstore with the primary key or throws a {@link NoSuchtrainingpersonalisedparameterscontentstoreException} if it could not be found.
	 *
	 * @param id the primary key of the trainingpersonalisedparameterscontentstore
	 * @return the trainingpersonalisedparameterscontentstore
	 * @throws NoSuchtrainingpersonalisedparameterscontentstoreException if a trainingpersonalisedparameterscontentstore with the primary key could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore findByPrimaryKey(long id)
		throws NoSuchtrainingpersonalisedparameterscontentstoreException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the trainingpersonalisedparameterscontentstore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainingpersonalisedparameterscontentstore
	 * @return the trainingpersonalisedparameterscontentstore, or <code>null</code> if a trainingpersonalisedparameterscontentstore with the primary key could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore fetchByPrimaryKey(
		Serializable primaryKey) {
		trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore =
			(trainingpersonalisedparameterscontentstore)entityCache.getResult(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
				trainingpersonalisedparameterscontentstoreImpl.class, primaryKey);

		if (trainingpersonalisedparameterscontentstore == _nulltrainingpersonalisedparameterscontentstore) {
			return null;
		}

		if (trainingpersonalisedparameterscontentstore == null) {
			Session session = null;

			try {
				session = openSession();

				trainingpersonalisedparameterscontentstore = (trainingpersonalisedparameterscontentstore)session.get(trainingpersonalisedparameterscontentstoreImpl.class,
						primaryKey);

				if (trainingpersonalisedparameterscontentstore != null) {
					cacheResult(trainingpersonalisedparameterscontentstore);
				}
				else {
					entityCache.putResult(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
						trainingpersonalisedparameterscontentstoreImpl.class,
						primaryKey,
						_nulltrainingpersonalisedparameterscontentstore);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
					trainingpersonalisedparameterscontentstoreImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return trainingpersonalisedparameterscontentstore;
	}

	/**
	 * Returns the trainingpersonalisedparameterscontentstore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trainingpersonalisedparameterscontentstore
	 * @return the trainingpersonalisedparameterscontentstore, or <code>null</code> if a trainingpersonalisedparameterscontentstore with the primary key could not be found
	 */
	@Override
	public trainingpersonalisedparameterscontentstore fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, trainingpersonalisedparameterscontentstore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, trainingpersonalisedparameterscontentstore> map = new HashMap<Serializable, trainingpersonalisedparameterscontentstore>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore =
				fetchByPrimaryKey(primaryKey);

			if (trainingpersonalisedparameterscontentstore != null) {
				map.put(primaryKey, trainingpersonalisedparameterscontentstore);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore =
				(trainingpersonalisedparameterscontentstore)entityCache.getResult(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
					trainingpersonalisedparameterscontentstoreImpl.class,
					primaryKey);

			if (trainingpersonalisedparameterscontentstore == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, trainingpersonalisedparameterscontentstore);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore : (List<trainingpersonalisedparameterscontentstore>)q.list()) {
				map.put(trainingpersonalisedparameterscontentstore.getPrimaryKeyObj(),
					trainingpersonalisedparameterscontentstore);

				cacheResult(trainingpersonalisedparameterscontentstore);

				uncachedPrimaryKeys.remove(trainingpersonalisedparameterscontentstore.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(trainingpersonalisedparameterscontentstoreModelImpl.ENTITY_CACHE_ENABLED,
					trainingpersonalisedparameterscontentstoreImpl.class,
					primaryKey, _nulltrainingpersonalisedparameterscontentstore);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the trainingpersonalisedparameterscontentstores.
	 *
	 * @return the trainingpersonalisedparameterscontentstores
	 */
	@Override
	public List<trainingpersonalisedparameterscontentstore> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainingpersonalisedparameterscontentstores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link trainingpersonalisedparameterscontentstoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainingpersonalisedparameterscontentstores
	 * @param end the upper bound of the range of trainingpersonalisedparameterscontentstores (not inclusive)
	 * @return the range of trainingpersonalisedparameterscontentstores
	 */
	@Override
	public List<trainingpersonalisedparameterscontentstore> findAll(int start,
		int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainingpersonalisedparameterscontentstores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link trainingpersonalisedparameterscontentstoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainingpersonalisedparameterscontentstores
	 * @param end the upper bound of the range of trainingpersonalisedparameterscontentstores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainingpersonalisedparameterscontentstores
	 */
	@Override
	public List<trainingpersonalisedparameterscontentstore> findAll(int start,
		int end,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainingpersonalisedparameterscontentstores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link trainingpersonalisedparameterscontentstoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainingpersonalisedparameterscontentstores
	 * @param end the upper bound of the range of trainingpersonalisedparameterscontentstores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of trainingpersonalisedparameterscontentstores
	 */
	@Override
	public List<trainingpersonalisedparameterscontentstore> findAll(int start,
		int end,
		OrderByComparator<trainingpersonalisedparameterscontentstore> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<trainingpersonalisedparameterscontentstore> list = null;

		if (retrieveFromCache) {
			list = (List<trainingpersonalisedparameterscontentstore>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE;

				if (pagination) {
					sql = sql.concat(trainingpersonalisedparameterscontentstoreModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<trainingpersonalisedparameterscontentstore>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<trainingpersonalisedparameterscontentstore>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the trainingpersonalisedparameterscontentstores from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore : findAll()) {
			remove(trainingpersonalisedparameterscontentstore);
		}
	}

	/**
	 * Returns the number of trainingpersonalisedparameterscontentstores.
	 *
	 * @return the number of trainingpersonalisedparameterscontentstores
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return trainingpersonalisedparameterscontentstoreModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trainingpersonalisedparameterscontentstore persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(trainingpersonalisedparameterscontentstoreImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE =
		"SELECT trainingpersonalisedparameterscontentstore FROM trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore";
	private static final String _SQL_SELECT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE_WHERE_PKS_IN =
		"SELECT trainingpersonalisedparameterscontentstore FROM trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore WHERE id_ IN (";
	private static final String _SQL_SELECT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE_WHERE =
		"SELECT trainingpersonalisedparameterscontentstore FROM trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore WHERE ";
	private static final String _SQL_COUNT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE =
		"SELECT COUNT(trainingpersonalisedparameterscontentstore) FROM trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore";
	private static final String _SQL_COUNT_TRAININGPERSONALISEDPARAMETERSCONTENTSTORE_WHERE =
		"SELECT COUNT(trainingpersonalisedparameterscontentstore) FROM trainingpersonalisedparameterscontentstore trainingpersonalisedparameterscontentstore WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trainingpersonalisedparameterscontentstore.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No trainingpersonalisedparameterscontentstore exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No trainingpersonalisedparameterscontentstore exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(trainingpersonalisedparameterscontentstorePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static final trainingpersonalisedparameterscontentstore _nulltrainingpersonalisedparameterscontentstore =
		new trainingpersonalisedparameterscontentstoreImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<trainingpersonalisedparameterscontentstore> toCacheModel() {
				return _nulltrainingpersonalisedparameterscontentstoreCacheModel;
			}
		};

	private static final CacheModel<trainingpersonalisedparameterscontentstore> _nulltrainingpersonalisedparameterscontentstoreCacheModel =
		new CacheModel<trainingpersonalisedparameterscontentstore>() {
			@Override
			public trainingpersonalisedparameterscontentstore toEntityModel() {
				return _nulltrainingpersonalisedparameterscontentstore;
			}
		};
}