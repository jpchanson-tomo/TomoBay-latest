package com.tomoparts.tomoBay.model.services.outOfHoursService;

import java.util.List;

import com.tomoparts.tomoBay.helpers.checkTime.CheckTime;
import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import com.tomoparts.tomoBay.model.services.AbstractServiceState;
import com.tomoparts.tomoBay.model.sql.framework.ModifyQueryInvoker;
import com.tomoparts.tomoBay.model.sql.framework.ModifyQueryInvoker.ModifyQueryTypeParams;
import com.tomoparts.tomoBay.model.sql.framework.SelectQueryInvoker;
import com.tomoparts.tomoBay.model.sql.framework.SelectQueryInvoker.SelectQueryTypeNoParams;
import com.tomoparts.tomoBay.model.sql.schema.ordersTable.OrdersTable;
import com.tomoparts.tomoBay.model.sql.schema.outOfHoursTable.OutOfHoursTable;
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
public final class OnRunning implements AbstractServiceState
{

	/**
	 * default ctor
	 */
	public OnRunning()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractServiceState#execute()
	 */
	@Override
	public String execute()
	{
		final List<HeteroFieldContainer> results = SelectQueryInvoker.execute(SelectQueryTypeNoParams.SELECT_UNINVOICED_ORDERS);
		String orders="";
		for (HeteroFieldContainer data : results)
		{
			HeteroFieldContainer params = new HeteroFieldContainer();
			params.add(OutOfHoursTable.SALES_REC_NO, data.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER));
			params.add(OutOfHoursTable.DATE, this.getDate());
			ModifyQueryInvoker.execute(ModifyQueryTypeParams.INSERT_OUT_OF_HOURS, params);
			orders+=data.get(OrdersTable.SALES_REC_NO, ClassRef.INTEGER)+", ";
		}
		return "Exiting: "+orders+" in Out of Hours table";
	}

	/**
	 * 
	 * @return
	 */
	private java.sql.Date getDate()
	{return new java.sql.Date(CheckTime.OutOfHoursDate().getTime());}
}
