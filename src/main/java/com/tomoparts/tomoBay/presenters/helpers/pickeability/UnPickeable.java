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
import com.tomoparts.tomoBay.model.dataTypes.conditionalStatement.Condition;


import java.util.Set;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class UnPickeable extends Condition
{
	private final Set<Boolean> itemStatus_M;
	/**
	 * 
	 */
	public UnPickeable(Set<Boolean> itemStatus)
	{
		super();
		this.itemStatus_M = itemStatus;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.conditionalStatement.Condition#expression()
	 */
	@Override
	protected boolean expression()
	{return this.itemStatus_M.size()==1 && this.itemStatus_M.contains(false);}

}
