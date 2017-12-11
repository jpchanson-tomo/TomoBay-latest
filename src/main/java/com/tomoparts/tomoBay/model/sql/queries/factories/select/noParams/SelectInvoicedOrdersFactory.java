package com.tomoparts.tomoBay.model.sql.queries.factories.select.noParams;

import com.tomoparts.tomoBay.model.sql.framework.queryFactories.AbstractSelectNoParamsQueryFactory;
import com.tomoparts.tomoBay.model.sql.framework.queryTypes.select.AbstractSelectNoParamsQuery;
import com.tomoparts.tomoBay.model.sql.queries.concreteQueries.select.noParams.SelectInvoicedOrders;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SelectInvoicedOrdersFactory implements AbstractSelectNoParamsQueryFactory
{

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.queries.AbstractQueryFactory#make()
	 */
	@Override
	public AbstractSelectNoParamsQuery make()
	{
		return new SelectInvoicedOrders();
	}

}
