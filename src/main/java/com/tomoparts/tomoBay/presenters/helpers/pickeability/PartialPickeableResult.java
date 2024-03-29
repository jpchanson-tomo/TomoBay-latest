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


import java.util.Set;

import com.tomoparts.tomoBay.model.dataTypes.conditionalStatement.Conditional;
import com.tomoparts.tomoBay.model.dataTypes.conditionalStatement.False;
import com.tomoparts.tomoBay.model.dataTypes.conditionalStatement.Result;
import com.tomoparts.tomoBay.model.dataTypes.conditionalStatement.True;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class PartialPickeableResult extends Result<PickeableStatus>
{
	
	public PartialPickeableResult(Set<Boolean> itemStatus, String orderNo, Conditional<PickeableStatus> nextHandler)
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.conditionalStatement.Result#result(tomoBay.model.dataTypes.conditionalStatement.True)
	 */
	@Override
	public PickeableStatus result(True yes)
	{return PickeableStatus.PARTIAL;}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.conditionalStatement.Result#result(tomoBay.model.dataTypes.conditionalStatement.False)
	 */
	@Override
	public PickeableStatus result(False no)
	{return PickeableStatus.ERROR;}

}
