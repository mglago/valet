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
 * <b>File:</b><p>es.gob.valet.tsl.exceptions.TSLException.java.</p>
 * <b>Description:</b><p>Class that manages the exceptions of the TSL module.</p>
 * <b>Project:</b><p>Platform for detection and validation of certificates recognized in European TSL.</p>
 * <b>Date:</b><p>19/10/2018.</p>
 * @author Gobierno de España.
 * @version 1.0, 19/10/2018.
 */
package es.gob.valet.tsl.exceptions;

import es.gob.valet.exceptions.ValetException;

/**
 * <p>Class that manages the exceptions of the TSL module.</p>
 * <b>Project:</b><p>Platform for detection and validation of certificates recognized in European TSL.</p>
 * @version 1.0, 19/10/2018.
 */
public class TSLException extends ValetException {

	/**
	 * Constant attribute that represents the serial version UID.
	 */
	private static final long serialVersionUID = 7799947847895400848L;

	/**
	 * Constructor method for the class TSLException.java.
	 */
	public TSLException() {
		super();
	}

	/**
	 * Constructor method for the class TSLException.java.
	 * @param errorCodeParam Error code.
	 * @param errorDescParam Error description.
	 */
	public TSLException(String errorCodeParam, String errorDescParam) {
		super(errorCodeParam, errorDescParam);
	}

	/**
	 * Constructor method for the class TSLException.java.
	 * @param errorCodeParam Error code.
	 * @param errorDescParam Error description.
	 * @param exceptionParam Error cause.
	 */
	public TSLException(String errorCodeParam, String errorDescParam, Exception exceptionParam) {
		super(errorCodeParam, errorDescParam, exceptionParam);
	}

}
