/* Created by Rhese Soemo */
/* For CST-323 Cloud Computing */
/* On 1/7/2021 */
/* This is my own work */

package com.gcu;

import java.util.List;

public interface DatabaseInterface
{
	public int createObject(ObjectModel createdObject);
	public List<ObjectModel> readObjects();
	public void updateObject(ObjectModel updatedObject);
	public void deleteObject(ObjectModel deleteObject);
}