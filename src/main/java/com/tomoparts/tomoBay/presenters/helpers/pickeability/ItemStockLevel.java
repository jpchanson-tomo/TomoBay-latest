package com.tomoparts.tomoBay.presenters.helpers.pickeability;
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
import gnu.trove.set.hash.THashSet;

import java.util.List;
import java.util.Set;

import com.tomoparts.tomoBay.helpers.BrandToCode;
import com.tomoparts.tomoBay.model.dataTypes.PartList;
import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import com.tomoparts.tomoBay.model.sql.framework.SelectQueryInvoker;
import com.tomoparts.tomoBay.model.sql.framework.SelectQueryInvoker.SelectQueryTypeParams;
import com.tomoparts.tomoBay.model.sql.schema.itemsTable.ItemsTable;
import com.tomoparts.tomoBay.model.sql.schema.ordersTable.OrdersTable;
import com.tomoparts.tomoBay.model.winstock.Stock;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
final class ItemStockLevel
{

	/**
	 * 
	 */
	public ItemStockLevel()
	{super();}
	
	/**
	 * @param orderId
	 * @return
	 */
	static final Set<Boolean> check(String orderId)
	{
		HeteroFieldContainer param = new HeteroFieldContainer();
		param.add(OrdersTable.ORDER_ID, orderId);

		List<HeteroFieldContainer> items 
									= SelectQueryInvoker.execute	(
														SelectQueryTypeParams.SELECT_BRAND_AND_PARTNO_BY_ORDERID, 
														param
																			);
		return  ItemStockLevel.checkStockLevelOfItems(items);
	}
	
	/**
	 * Takes the list of items generated in this.assembleItemsList and checks a PartList 
	 * associated with each item against Stock held in winstock. For every item with enough
	 * stock level it adds a true value to a Set<Boolean> i.e. if everything is in stock the
	 * set will only contain 1 element = true, if everything is out of stock the set will
	 * contain only 1 element = false, but if some items are in stock and others arn't it will
	 * contain 2 elements true and false.
	 * @param itemsVar the list of items to check off against Stock levels
	 * @return Set<Boolean> in stock - size=1 value={true}; out of stock - size=1 values={false};
	 * partial stock - size = 2 values = {true,false}
	 */
	private static Set<Boolean> checkStockLevelOfItems(List<HeteroFieldContainer> itemsVar)
	{
		final Set<Boolean> itemStatus = new THashSet<Boolean>();
		for (HeteroFieldContainer item : itemsVar)
		{
			final Stock stockAvailable = new Stock();
			final PartList partlist = new PartList(item.get(ItemsTable.PART_NO, ClassRef.STRING));
			
			for (int i = 0 ; i < partlist.size() ; ++i)
			{
				final int available = stockAvailable.requestStockLevel(partlist.getPartNumber(i), 
						BrandToCode.convertToWinstockInt(item.get(ItemsTable.BRAND, ClassRef.STRING))+"");
				
				final int required = partlist.getPartQty(i);
				
				boolean status = available >= required ? true : false;
				if(available == Stock.ERROR) {return null;}
				
				itemStatus.add(status);
			}
		}
		return itemStatus;
	}
}
