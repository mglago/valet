/*
/*******************************************************************************
 * Copyright (C) 2018 MINHAFP, Gobierno de España
 * This program is licensed and may be used, modified and redistributed under the  terms
 * of the European Public License (EUPL), either version 1.1 or (at your option)
 * any later version as soon as they are approved by the European Commission.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and
 * more details.
 * You should have received a copy of the EUPL1.1 license
 * along with this program; if not, you may find it at
 * http:joinup.ec.europa.eu/software/page/eupl/licence-eupl
 ******************************************************************************/

/**
 * <b>File:</b><p>es.gob.valet.persistence.configuration.cache.modules.tsl.elements.TSLLocationAndIdRelationCacheObject.java.</p>
 * <b>Description:</b><p>Class that represents a collection that stores the relation between a TSL Location
 * and its information into the configuration cache.</p>
 * <b>Project:</b><p>Platform for detection and validation of certificates recognized in European TSL.</p>
 * <b>Date:</b><p>24/10/2018.</p>
 * @author Gobierno de España.
 * @version 1.0, 24/10/2018.
 */
package es.gob.valet.persistence.configuration.cache.modules.tsl.elements;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import es.gob.valet.persistence.configuration.cache.common.exceptions.ConfigurationCacheObjectCloneException;
import es.gob.valet.persistence.configuration.cache.common.exceptions.ConfigurationCacheObjectStreamException;
import es.gob.valet.persistence.configuration.cache.common.impl.ConfigurationCacheObject;

/**
 * <p>Class that represents a collection that stores the relation between a TSL Location
 * and its information into the configuration cache.</p>
 * <b>Project:</b><p>Platform for detection and validation of certificates recognized in European TSL.</p>
 * @version 1.0, 24/10/2018.
 */
public class TSLLocationAndIdRelationCacheObject extends ConfigurationCacheObject {

	/**
	 * Constant attribute that represents the serial version UID.
	 */
	private static final long serialVersionUID = 6609828876194510908L;

	/**
	 * Constant attribute that represents the token ID.
	 */
	public static final String TOKEN_ID = "RelationMapBetweenURLLocationAndIds";

	/**
	 * Attribute that represents the map that stores the relation between the TSL location
	 * and its identifier.
	 */
	private Map<String, Long> relationMap = null;

	/**
	 * Constructor method for the class TSLLocationAndIdRelationCacheObject.java.
	 */
	public TSLLocationAndIdRelationCacheObject() {
		super();
		relationMap = new ConcurrentHashMap<String, Long>();
	}

	/**
	 * Adds a relation between the TSL Location and its information.
	 * @param tdco TSL Data Cache object from which take the information.
	 */
	public final void addUpdateRelation(TSLDataCacheObject tdco) {

		// Lo añadimos al map.
		relationMap.put(tdco.getTslLocationUri(), tdco.getTslDataId());

	}

	/**
	 * Get the TSL Data Id associated to the input tsl location.
	 * @param tslLocation URL with the TSL location to search.
	 * @return the TSL Data Id associated to the input tsl location. <code>null</code> if there is not.
	 */
	public final Long getTslDataIdFromLocation(String tslLocation) {

		return relationMap.get(tslLocation);

	}

	/**
	 * Removes a relation between the TSL Location and the TSL identifier.
	 * @param tdco TSL Data Cache object from which take the information to remove.
	 */
	public final void removeRelation(TSLDataCacheObject tdco) {

		// Lo eliminamos del Map.
		relationMap.remove(tdco.getTslLocationUri());

	}

	/**
	 * {@inheritDoc}
	 * @see es.gob.valet.persistence.configuration.cache.common.impl.ConfigurationCacheObject#writeReplace()
	 */
	@Override
	protected Object writeReplace() throws ConfigurationCacheObjectStreamException {

		try {
			return this.clone();
		} catch (CloneNotSupportedException e) {
			throw new ConfigurationCacheObjectStreamException(e.getMessage());
		}

	}

	/**
	 * {@inheritDoc}
	 * @see es.gob.valet.persistence.configuration.cache.common.impl.ConfigurationCacheObject#readResolve()
	 */
	@Override
	protected Object readResolve() throws ConfigurationCacheObjectStreamException {

		try {
			return this.clone();
		} catch (CloneNotSupportedException e) {
			throw new ConfigurationCacheObjectStreamException(e.getMessage());
		}

	}

	/**
	 * {@inheritDoc}
	 * @see es.gob.valet.persistence.configuration.cache.common.impl.ConfigurationCacheObject#clone()
	 */
	@Override
	public ConfigurationCacheObject clone() throws ConfigurationCacheObjectCloneException {

		TSLLocationAndIdRelationCacheObject tlairco = new TSLLocationAndIdRelationCacheObject();

		Set<String> keys = relationMap.keySet();
		for (String tslLocation: keys) {

			tlairco.relationMap.put(tslLocation, relationMap.get(tslLocation));

		}

		return tlairco;

	}

}
