package com.tomoparts.tomoBay.model.services.basicEbayUpdateService;
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
import java.sql.SQLException;
import java.sql.Timestamp;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import com.tomoparts.tomoBay.model.services.helpers.EbayOrderCancellationStatus;
import com.tomoparts.tomoBay.model.sql.framework.ModifyQueryInvoker;
import com.tomoparts.tomoBay.model.sql.framework.ModifyQueryInvoker.ModifyQueryTypeParams;
import com.tomoparts.tomoBay.model.sql.schema.ordersTable.OrdersTable;
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
 * updates the database orders table with information taken from the ebay api orders call.
 * @author Jan P.C. Hanson
 *
 */
final class Orders_Table
{
	/**
	 * default ctor
	 */
	public Orders_Table()
	{super();}
	
	/**
	 * populates the Orders Table in the database with data grabbed from the ebay API
	 * @param accountID The accountId representing the account whose orders to search for.
	 * @param orders list of orders.
	 * @throws SQLException 
	 */
	public static void populate(OrderType[] orders, int accountID) throws SQLException
	{
		for (OrderType order : orders)
		{
			if(order != null)
			{
				HeteroFieldContainer insertVals = new HeteroFieldContainer(); 
				
				if(order.isIsMultiLegShipping()==false)
				{
					insertVals.add(OrdersTable.ORDER_ID, order.getOrderID());
					insertVals.add(OrdersTable.BUYERID, order.getBuyerUserID());
					insertVals.add(OrdersTable.SALES_REC_NO, order.getShippingDetails().getSellingManagerSalesRecordNumber());
					insertVals.add(OrdersTable.SHIPPING_TYPE, order.getShippingServiceSelected().getShippingService());
					insertVals.add(OrdersTable.CREATED_TIME, new Timestamp(order.getCreatedTime().getTime().getTime()));
					insertVals.add(OrdersTable.ORDER_TOTAL, (float)order.getTotal().getValue());
					insertVals.add(OrdersTable.ACCOUNT, accountID);
				}
				else
				{Orders_Table.populateGSP(order, accountID, insertVals);}
				
				if(EbayOrderCancellationStatus.isCancelled(order.getCancelStatus())==true)
				{ModifyQueryInvoker.execute(ModifyQueryTypeParams.INSERT_EBAY_ORDERS, insertVals);}
			}
		}
	}
	
	/**
	 * @param order
	 * @param accountID
	 * @param insertVals
	 */
	public static void populateGSP(OrderType order, int accountID, HeteroFieldContainer insertVals)
	{
		System.out.println("gsp");
		insertVals.add(OrdersTable.ORDER_ID, order.getOrderID());
		insertVals.add(OrdersTable.BUYERID, order.getBuyerUserID());
		insertVals.add(OrdersTable.SALES_REC_NO, order.getShippingDetails().getSellingManagerSalesRecordNumber());
		insertVals.add(OrdersTable.SHIPPING_TYPE, order.getShippingServiceSelected().getShippingService());
		insertVals.add(OrdersTable.CREATED_TIME, new Timestamp(order.getCreatedTime().getTime().getTime()));
		insertVals.add(OrdersTable.ORDER_TOTAL, (float)order.getSubtotal().getValue());
		insertVals.add(OrdersTable.ACCOUNT, accountID);
	}
}
