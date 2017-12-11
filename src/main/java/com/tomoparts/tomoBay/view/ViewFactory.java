package com.tomoparts.tomoBay.view;
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
import com.tomoparts.tomoBay.presenters.admin.AdminPresenter;
import com.tomoparts.tomoBay.presenters.crm.CRMDetailPresenter;
import com.tomoparts.tomoBay.presenters.crm.CRMOverviewPresenter;
import com.tomoparts.tomoBay.presenters.error.ErrorPresenter;
import com.tomoparts.tomoBay.presenters.orderDetails.OrderDetailsPresenter;
import com.tomoparts.tomoBay.presenters.root.RootPresenter;
import com.tomoparts.tomoBay.presenters.sales.OutOfHoursPresenter;
import com.tomoparts.tomoBay.presenters.sales.SalesHistoryPresenter;
import com.tomoparts.tomoBay.presenters.sales.SalesOrderPresenter;
import com.tomoparts.tomoBay.presenters.warehouse.WarehouseOrderPresenter;
import com.tomoparts.tomoBay.view.views.AdminServiceView;
import com.tomoparts.tomoBay.view.views.CRMDetailView;
import com.tomoparts.tomoBay.view.views.CRMOverviewView;
import com.tomoparts.tomoBay.view.views.ErrorView;
import com.tomoparts.tomoBay.view.views.OrderView;
import com.tomoparts.tomoBay.view.views.OutOfHoursView;
import com.tomoparts.tomoBay.view.views.RootView;
import com.tomoparts.tomoBay.view.views.SalesHistoryView;
import com.tomoparts.tomoBay.view.views.WarehouseOrderView;
import com.tomoparts.tomoBay.view.views.salesOrderView.SalesOrderView;
/**
 * This class is the visitor in a visitor/double dispatch type setup where the AbstractPresenter
 * concrete classes are the visitables and contain the corresponding accept() methods. This 
 * visitor acts as a view factory allowing the presenters to be responsible for the creation of
 * their own views.
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class ViewFactory
{
	/**
	 * factory method for ErrorView
	 * @param presenter a valid ErrorPresenter
	 * @return ErrorView
	 */
	public AbstractView visit(ErrorPresenter presenter)
	{return new ErrorView();}
	
	/**
	 * factory method for the RootView
	 * @param presenter a valid RootPresenter
	 * @return RootView
	 */
	public AbstractView visit(RootPresenter presenter)
	{return new RootView();}
	
	/**
	 * factory method for the SalesHistoryView
	 * @param presenter a valid SalesHistoryPresenter
	 * @return SalesHistoryView
	 */
	public AbstractView visit(SalesHistoryPresenter presenter)
	{return new SalesHistoryView();}
	
	/**
	 * factory method for the SalesOrderView
	 * @param presenter a valid SalesOrderPresenter
	 * @return SalesOrderView
	 */
	public AbstractView visit(SalesOrderPresenter presenter)
	{return new SalesOrderView();}
	
	/**
	 * factory method for the SalesOrderView
	 * @param presenter a valid WarehouseOrderPresenter
	 * @return WarehouseOrderView
	 */
	public AbstractView visit(WarehouseOrderPresenter presenter)
	{return new WarehouseOrderView();}

	/**
	 * @param orderDetailsPresenter
	 * @return
	 */
	public AbstractView visit(OrderDetailsPresenter orderDetailsPresenter)
	{return new OrderView();}
	
	/**
	 * 
	 * @param adminPresenter
	 * @return
	 */
	public AbstractView visit(AdminPresenter adminPresenter)
	{return new AdminServiceView();}
	
	/**
	 * 
	 * @param outOfHoursPresenter
	 * @return
	 */
	public AbstractView visit(OutOfHoursPresenter outOfHoursPresenter)
	{return new OutOfHoursView();}
	
	/**
	 * @param crmOverviewPresenter
	 * @return
	 */
	public AbstractView visit(CRMOverviewPresenter crmOverviewPresenter)
	{return new CRMOverviewView();}
	
	/**
	 * @param crmDetailPresenter
	 * @return
	 */
	public AbstractView visit(CRMDetailPresenter crmDetailPresenter)
	{return new CRMDetailView();}
}