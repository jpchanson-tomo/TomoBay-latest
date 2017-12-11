package com.tomoparts.tomoBay.model.sql.framework.queryFactories;

import com.tomoparts.tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQuery;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractModifyQueryFactory extends AbstractQueryFactory
{
	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryFactories.AbstractQueryFactory#make()
	 */
	@Override
	public AbstractModifyQuery make();
}
