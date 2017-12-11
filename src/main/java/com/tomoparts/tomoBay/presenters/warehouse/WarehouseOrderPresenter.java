package com.tomoparts.tomoBay.presenters.warehouse;

import com.tomoparts.tomoBay.presenters.AbstractPresenter;
import com.tomoparts.tomoBay.view.AbstractView;
import com.tomoparts.tomoBay.view.ViewFactory;

/**
 * This class is responsible for providing the dynamic information specific to the picking 
 * area of the warehouse section of the web app.
 * @author Jan P.C. Hanson
 *
 */
public final class WarehouseOrderPresenter implements AbstractPresenter
{
	/**
	 * default ctor
	 */
	public WarehouseOrderPresenter()
	{super();}

	/* (non-Javadoc)
	 * @see openDMS.presenters.AbstractPresenter#present()
	 */
	@Override
	public String present(AbstractView view, String type, String data)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#accept(tomoBay.view.ViewFactory)
	 */
	@Override
	public AbstractView accept(ViewFactory viewFactory)
	{return viewFactory.visit(this);}

}
