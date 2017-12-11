package com.tomoparts.tomoBay.presenters.crm;/** Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import com.tomoparts.tomoBay.presenters.AbstractPresenter;
import com.tomoparts.tomoBay.presenters.presenterActions.PresenterActionFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.PresenterActionFactory.PresenterActions;
import com.tomoparts.tomoBay.view.AbstractView;
import com.tomoparts.tomoBay.view.ViewFactory;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class CRMDetailPresenter implements AbstractPresenter
{

	/**
	 * default ctor
	 */
	public CRMDetailPresenter()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#present(tomoBay.view.AbstractView, java.lang.String, java.lang.String)
	 */
	@Override
	public String present(AbstractView view, String type, String data)
	{return PresenterActionFactory.make(PresenterActions.valueOf(type)).execute(data);}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#accept(tomoBay.view.ViewFactory)
	 */
	@Override
	public AbstractView accept(ViewFactory viewFactory)
	{return viewFactory.visit(this);}

}
