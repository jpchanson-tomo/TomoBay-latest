package com.tomoparts.tomoBay.model.services.factories;

import com.tomoparts.tomoBay.model.services.AbstractService;
import com.tomoparts.tomoBay.model.services.checkErrorsService.CheckErrorsService;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class CheckErrorsFactory implements AbstractServiceFactory
{
	/**
	 * default ctor
	 */
	public CheckErrorsFactory()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.factories.AbstractServiceFactory#make()
	 */
	@Override
	public AbstractService make()
	{
		return new CheckErrorsService();
	}

}
