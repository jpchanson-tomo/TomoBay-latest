package com.tomoparts.tomoBay.model.dataTypes.financial.SalesOrderDayBook.factories;
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
import com.tomoparts.tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import com.tomoparts.tomoBay.model.dataTypes.order.Order;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractSalesDayBookLineFactory
{

	/**
	 * make an AbstractSalesDayBookLine specific to this child class.
	 * @return AbstractSalesDayBookLine specified by the derived class
	 */
	public AbstractSalesDayBookLine make(Order order);
	
}
