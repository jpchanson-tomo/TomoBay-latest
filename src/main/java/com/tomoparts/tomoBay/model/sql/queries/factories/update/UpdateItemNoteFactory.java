package com.tomoparts.tomoBay.model.sql.queries.factories.update;

import com.tomoparts.tomoBay.model.sql.framework.queryFactories.AbstractModifyQueryParamsFactory;
import com.tomoparts.tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams;
import com.tomoparts.tomoBay.model.sql.queries.concreteQueries.update.UpdateItemNote;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class UpdateItemNoteFactory implements AbstractModifyQueryParamsFactory
{
	/**
	 * default ctor
	 */
	public UpdateItemNoteFactory()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.queries.AbstractQueryFactory#make()
	 */
	@Override
	public AbstractModifyQueryParams make()
	{
		return new UpdateItemNote();
	}

}
