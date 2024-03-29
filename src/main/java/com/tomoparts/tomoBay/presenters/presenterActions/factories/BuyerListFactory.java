package com.tomoparts.tomoBay.presenters.presenterActions.factories;

import com.tomoparts.tomoBay.presenters.presenterActions.AbstractPresenterAction;
import com.tomoparts.tomoBay.presenters.presenterActions.concreteActions.BuyerList;
/** Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class BuyerListFactory implements AbstractPresenterActionFactory
{

	/**
	 * 
	 */
	public BuyerListFactory()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.factories.AbstractPresenterActionFactory#make()
	 */
	@Override
	public AbstractPresenterAction make()
	{return new BuyerList();}

}
