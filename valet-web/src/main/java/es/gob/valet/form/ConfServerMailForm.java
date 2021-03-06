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
 * <b>File:</b><p>es.gob.valet.form.ConfServerMailForm.java.</p>
 * <b>Description:</b><p> .</p>
  * <b>Project:</b><p>Platform for detection and validation of certificates recognized in European TSL.</p>
 * <b>Date:</b><p>4 oct. 2018.</p>
 * @author Gobierno de España.
 * @version 1.0, 4 oct. 2018.
 */
package es.gob.valet.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import es.gob.valet.rest.exception.CheckItFirst;
import es.gob.valet.rest.exception.ThenCheckIt;

/** 
 * <p>Class that represents the backing form for adding/editing a alarm.</p>
 * <b>Project:</b><p>Platform for detection and validation of certificates recognized in European TSL.</p>
 * @version 1.0, 2 oct. 2018.
 */
public class ConfServerMailForm {

	/**
	 * Attribute that represents the value of the primary key as a hidden input
	 * in the form.
	 */
	private Long idConfServerMail;

	/**
	 * Attribute that represents the issuer.
	 */
	//@NotBlank(groups = CheckItFirst.class, message = "{form.valid.confServerMail.issuer.notempty}")
	//@Size(min = 3, max = 200, groups = ThenCheckIt.class)
	private String issuerMail;

	/**
	 * Attribute that represents the host.
	 */
	//@NotBlank(groups = CheckItFirst.class, message = "{form.valid.confServerMail.host.notempty}")
	//@Size(min = 3, max = 200, groups = ThenCheckIt.class)
	private String hostMail;

	/**
	 * Attribute that represents the port.
	 */
	private Long portMail;

	/**
	 * Attribute that represents the user.
	 */
	private String userMail;

	/**
	 * Attribute that represents the password.
	 */
	private String passwordMail;

	/**
	 * Gets the value of the attribute {@link #idConfServerMail}.
	 * @return the value of the attribute {@link #idConfServerMail}.
	 */
	public Long getIdConfServerMail() {
		return idConfServerMail;
	}

	/**
	 * Sets the value of the attribute {@link #idConfServerMail}.
	 * @param idConfServerMail The value for the attribute {@link #idConfServerMail}.
	 */
	public void setIdConfServerMail(Long idConfServerMail) {
		this.idConfServerMail = idConfServerMail;
	}

	/**
	 * Gets the value of the attribute {@link #issuer}.
	 * @return the value of the attribute {@link #issuer}.
	 */
	public String getIssuerMail() {
		return issuerMail;
	}

	/**
	 * Sets the value of the attribute {@link #issuer}.
	 * @param issuer The value for the attribute {@link #issuer}.
	 */
	public void setIssuerMail(String issuerMail) {
		this.issuerMail = issuerMail;
	}

	/**
	 * Gets the value of the attribute {@link #host}.
	 * @return the value of the attribute {@link #host}.
	 */
	public String getHostMail() {
		return hostMail;
	}

	/**
	 * Sets the value of the attribute {@link #host}.
	 * @param host The value for the attribute {@link #host}.
	 */
	public void setHostMail(String hostMail) {
		this.hostMail = hostMail;
	}

	/**
	 * Gets the value of the attribute {@link #port}.
	 * @return the value of the attribute {@link #port}.
	 */
	public Long getPortMail() {
		return portMail;
	}

	/**
	 * Sets the value of the attribute {@link #port}.
	 * @param port The value for the attribute {@link #port}.
	 */
	public void setPortMail(Long portMail) {
		this.portMail = portMail;
	}

	/**
	 * Gets the value of the attribute {@link #user}.
	 * @return the value of the attribute {@link #user}.
	 */
	public String getUserMail() {
		return userMail;
	}

	/**
	 * Sets the value of the attribute {@link #user}.
	 * @param user The value for the attribute {@link #user}.
	 */
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	/**
	 * Gets the value of the attribute {@link #password}.
	 * @return the value of the attribute {@link #password}.
	 */
	public String getPasswordMail() {
		return passwordMail;
	}

	/**
	 * Sets the value of the attribute {@link #password}.
	 * @param password The value for the attribute {@link #password}.
	 */
	public void setPasswordMail(String passwordMail) {
		this.passwordMail = passwordMail;
	}

}
