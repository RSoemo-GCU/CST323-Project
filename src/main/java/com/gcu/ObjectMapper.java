/* Created by Rhese Soemo */
/* For CST-323 Cloud Computing */
/* On 1/7/2021 */
/* This is my own work */

package com.gcu;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//reference articture
public class ObjectMapper implements RowMapper<ObjectModel>
{
	@Override
	public ObjectModel mapRow(ResultSet resultSet, int rowNum) throws SQLException
	{
		ObjectModel object = new ObjectModel
			(
				resultSet.getInt("id"),
				resultSet.getString("type"),
				resultSet.getString("name"),
				resultSet.getString("description")
			);
		return object;
	}
}
