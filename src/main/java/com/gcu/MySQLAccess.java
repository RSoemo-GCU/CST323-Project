/* Created by Rhese Soemo */
/* For CST-323 Cloud Computing */
/* On 1/7/2021 */
/* This is my own work */

package com.gcu;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//DATA BASE ACCESS LAYER
@Repository
public class MySQLAccess implements DatabaseInterface
{
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public MySQLAccess(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int createObject(ObjectModel createdObject)
	{
		return jdbcTemplate.update
			(
				"insert into objects (type, name, description) value (?, ?, ?)",
				createdObject.getType(),
				createdObject.getName(),
				createdObject.getDescription()
			);
	}
	
	@Override
	public List<ObjectModel> readObjects()
	{
		return jdbcTemplate.query("select * from objects", new ObjectMapper());
	}
	
	@Override
	public void updateObject(ObjectModel updatedObject)
	{
		jdbcTemplate.update
			(
				"update objects set type=?, name=?, description=? where id=?",
				updatedObject.getType(),
				updatedObject.getName(),
				updatedObject.getDescription(),
				updatedObject.getId()
			);
	}
	
	@Override
	public void deleteObject(ObjectModel deleteObject)
	{
		jdbcTemplate.update
			(
				"delete from objects where id=?",
				deleteObject.getId()
			);
	}
}
