package com.tomoparts.tomoBay.model.sql.queries.factories.select.params;
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
import com.tomoparts.tomoBay.model.sql.framework.queryFactories.AbstractSelectParamsQueryFactory;
import com.tomoparts.tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery;
import com.tomoparts.tomoBay.model.sql.queries.concreteQueries.select.params.SelectTransactionByOrder;

/**
 * creates a SelectTransactionByOrder query object
 * @see {@link tomoBay.model.sql.queries.concreteQueries.select.params.SelectTransactionByOrder}
 * @author Jan P.C. Hanson
 *
 */
public final class SelectTransactionByOrderIDFactory implements AbstractSelectParamsQueryFactory
{
	/**
	 * default ctor
	 */
	public SelectTransactionByOrderIDFactory()
	{super();}

	/* (non-Javadoc)
	 * @see openDMS.model.sql.queries.AbstractQueryFactory#make()
	 */
	@Override
	public AbstractSelectParamsQuery make()
	{
		return new SelectTransactionByOrder();
	}

}
