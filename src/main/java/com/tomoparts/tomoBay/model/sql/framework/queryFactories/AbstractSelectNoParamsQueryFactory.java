package com.tomoparts.tomoBay.model.sql.framework.queryFactories;

import com.tomoparts.tomoBay.model.sql.framework.queryTypes.select.AbstractSelectNoParamsQuery;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractSelectNoParamsQueryFactory extends AbstractSelectQueryFactory
{

	@Override
	public AbstractSelectNoParamsQuery make();

}
