/* Created by Rhese Soemo */
/* For CST-323 Cloud Computing */
/* On 1/7/2021 */
/* This is my own work */

package com.gcu;

import java.util.List;

public interface DatabaseInterface
{
	public int createObject(ObjectModel createdObject);  // Create Object Method Model
	public List<ObjectModel> readObjects();  // Read Object Method Model
	public void updateObject(ObjectModel updatedObject);  // Update Object Method Model
	public void deleteObject(ObjectModel deleteObject);  // Delete Object Method Model
}