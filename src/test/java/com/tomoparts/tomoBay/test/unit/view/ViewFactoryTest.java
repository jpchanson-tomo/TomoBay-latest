package com.tomoparts.tomoBay.test.unit.view;
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tomoparts.tomoBay.presenters.error.ErrorPresenter;
import com.tomoparts.tomoBay.presenters.root.RootPresenter;
import com.tomoparts.tomoBay.presenters.sales.SalesHistoryPresenter;
import com.tomoparts.tomoBay.presenters.sales.SalesOrderPresenter;
import com.tomoparts.tomoBay.presenters.warehouse.WarehouseOrderPresenter;
import com.tomoparts.tomoBay.view.ViewFactory;
import com.tomoparts.tomoBay.view.views.ErrorView;
import com.tomoparts.tomoBay.view.views.RootView;
import com.tomoparts.tomoBay.view.views.SalesHistoryView;
import com.tomoparts.tomoBay.view.views.WarehouseOrderView;
import com.tomoparts.tomoBay.view.views.salesOrderView.SalesOrderView;
/**
 * Tests the ViewFactory class
 * @author Jan P.C. Hanson
 *
 */
public class ViewFactoryTest
{
	/**test copy of ViewFactory**/
	ViewFactory viewFactory = new ViewFactory();
	ErrorPresenter errorPresenter = new ErrorPresenter();
	RootPresenter rootPresenter = new RootPresenter();
	SalesHistoryPresenter sHpresenter = new SalesHistoryPresenter();
	SalesOrderPresenter sOpresenter = new SalesOrderPresenter();
	WarehouseOrderPresenter wOpresenter = new WarehouseOrderPresenter();
	
	/**
	 * Test method for {@link com.tomoparts.tomoBay.view.ViewFactory#visit(com.tomoparts.tomoBay.presenters.error.ErrorPresenter)}.
	 */
	@Test
	public void testVisitErrorPresenter()
	{
		assertTrue("this method does not provide the right output given valid input",
				viewFactory.visit(errorPresenter) instanceof ErrorView);
		
		assertFalse("this method does not provide the right output givin invalid input",
				viewFactory.visit(rootPresenter) instanceof ErrorView);
	}

	/**
	 * Test method for {@link com.tomoparts.tomoBay.view.ViewFactory#visit(com.tomoparts.tomoBay.presenters.root.RootPresenter)}.
	 */
	@Test
	public void testVisitRootPresenter()
	{
		assertTrue("this method does not provide the right output given valid input",
				viewFactory.visit(rootPresenter) instanceof RootView);
		
		assertFalse("this method does not provide the right output givin invalid input",
				viewFactory.visit(errorPresenter) instanceof RootView);
	}

	/**
	 * Test method for {@link com.tomoparts.tomoBay.view.ViewFactory#visit(com.tomoparts.tomoBay.presenters.sales.SalesHistoryPresenter)}.
	 */
	@Test
	public void testVisitSalesHistoryPresenter()
	{
		assertTrue("this method does not provide the right output given valid input",
				viewFactory.visit(sHpresenter) instanceof SalesHistoryView);
		
		assertFalse("this method does not provide the right output givin invalid input",
				viewFactory.visit(errorPresenter) instanceof SalesHistoryView);
	}

	/**
	 * Test method for {@link com.tomoparts.tomoBay.view.ViewFactory#visit(com.tomoparts.tomoBay.presenters.sales.SalesOrderPresenter)}.
	 */
	@Test
	public void testVisitSalesOrderPresenter()
	{
		assertTrue("this method does not provide the right output given valid input",
				viewFactory.visit(sOpresenter) instanceof SalesOrderView);
		
		assertFalse("this method does not provide the right output givin invalid input",
				viewFactory.visit(errorPresenter) instanceof SalesOrderView);
	}

	/**
	 * Test method for {@link com.tomoparts.tomoBay.view.ViewFactory#visit(com.tomoparts.tomoBay.presenters.warehouse.WarehouseOrderPresenter)}.
	 */
	@Test
	public void testVisitWarehouseOrderPresenter()
	{
		assertTrue("this method does not provide the right output given valid input",
				viewFactory.visit(wOpresenter) instanceof WarehouseOrderView);
		
		assertFalse("this method does not provide the right output givin invalid input",
				viewFactory.visit(errorPresenter) instanceof WarehouseOrderView);
	}

}
