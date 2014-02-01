/* Copyright (C) 2013 Johannes Schnatterer
 * 
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *  
 * This file is part of nusic.
 * 
 * nusic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * nusic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with nusic.  If not, see <http://www.gnu.org/licenses/>.
 */
package info.schnatterer.nusic.db.dao;

import info.schnatterer.nusic.db.DatabaseException;
import info.schnatterer.nusic.db.model.Release;

import java.util.Date;
import java.util.List;

public interface ReleaseDao extends GenericDao<Release> {

	/**
	 * Finds out of if release with a specific
	 * {@link Release#getMusicBrainzId()} exists.
	 * 
	 * @param musicBrainzId
	 * @return the {@link Release#getId()} of the release if the release exists.
	 *         Otherwise <code>null</code>.
	 * @throws DatabaseException
	 */
	Long findByMusicBrainzId(String musicBrainzId) throws DatabaseException;

	/**
	 * Finds all releases.
	 * 
	 * @return
	 * @throws DatabaseException
	 */
	List<Release> findAll() throws DatabaseException;

	/**
	 * Finds all releases that were created after a specific date.
	 * 
	 * @param gtDateCreated
	 *            all releases whose creation data is greater than this date are
	 *            returned.
	 * 
	 * @return all releases that were created after <code>gtDateCreated</code>
	 * @throws DatabaseException
	 */
	List<Release> findJustCreated(Date gtDateCreated) throws DatabaseException;

}
