package com.tomoparts.tomoBay.model.sql.schema.nonDBFields;
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
import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.AbstractField;
import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.TypeDef;

/**
 * This represents a resultcode that comes back from an update or insert query. it is not an actual 
 * database field, but is necessary none the less.
 * - Type: Integer
 * - Size: 1 ..... probably :)
 * @author Jan P.C. Hanson
 *
 */
public final class ResultCode implements AbstractField
{
	/**the reprasentative size of this field.......maybe**/
	private static final int size_M = 1;
	/**
	 * default ctor
	 */
	public ResultCode()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.heteroTypeContainer.AbstractField#type()
	 */
	@Override
	public String type()
	{return TypeDef.INTEGER;}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.heteroTypeContainer.AbstractField#size()
	 */
	@Override
	public int size()
	{return ResultCode.size_M;}

}
