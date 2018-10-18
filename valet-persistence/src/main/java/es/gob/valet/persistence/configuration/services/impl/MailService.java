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
 * <b>File:</b><p>es.gob.valet.persistence.configuration.services.impl.MailService.java.</p>
 * <b>Description:</b><p>Class that implements the communication with the operations of the persistence layer for Mail.</p>
  * <b>Project:</b><p>Platform for detection and validation of certificates recognized in European TSL.</p>
 * <b>Date:</b><p>2 oct. 2018.</p>
 * @author Gobierno de España.
 * @version 1.0, 2 oct. 2018.
 */
package es.gob.valet.persistence.configuration.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import es.gob.valet.persistence.configuration.model.entity.Mail;
import es.gob.valet.persistence.configuration.model.repository.MailRepository;
import es.gob.valet.persistence.configuration.model.repository.datatable.MailDataTablesRepository;
import es.gob.valet.persistence.configuration.services.ifaces.IMailService;

/** 
 * <p>Class that implements the communication with the operations of the persistence layer for Mail.</p>
 * <b>Project:</b><p>Platform for detection and validation of certificates recognized in European TSL.</p>
 * @version 1.0, 2 oct. 2018.
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MailService implements IMailService {

	/**
	 * Attribute that represents the injected interface that provides CRUD operations for the persistence.
	 */
	@Autowired
	private MailRepository repository;
	
	/**
	 * Attribute that represents the injected interface that provides CRUD operations for the persistence.
	 */
	@Autowired
	private MailDataTablesRepository dtRepository;

	/**
	 * 
	 * {@inheritDoc}
	 * @see es.gob.valet.persistence.configuration.services.ifaces.IMailService#getAllMail()
	 */
	@Override
	public List<Mail> getAllMail() {
		List<Mail> result = new ArrayList<Mail>();
		result = repository.findAll();
		return result;
	}

	/**
	 * {@inheritDoc}
	 * @see es.gob.valet.persistence.configuration.services.ifaces.IMailService#getMailById(java.lang.Long)
	 */
	@Override
	public Mail getMailById(Long idMail) {
		return repository.findByIdMail(idMail);
	}

	/**
	 * {@inheritDoc}
	 * @see es.gob.valet.persistence.configuration.services.ifaces.IMailService#saveMail(es.gob.valet.persistence.configuration.model.entity.Mail)
	 */
	@Override
	public Mail saveMail(Mail Mail) {
		return repository.save(Mail);
	}

	/**
	 * {@inheritDoc}
	 * @see es.gob.valet.persistence.configuration.services.ifaces.IMailService#deleteMail(java.lang.Long)
	 */
	@Override
	public void deleteMail(Long idMail) {
		repository.deleteById(idMail);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @see es.gob.valet.persistence.configuration.services.ifaces.IMailService#getAllMail(org.springframework.data.jpa.datatables.mapping.DataTablesInput)
	 */
	@Override
	public DataTablesOutput<Mail> getAllMail(DataTablesInput input) {
		return dtRepository.findAll(input);
	}
	
	/**
	 * 
	 * {@inheritDoc}
	 * @see es.gob.valet.persistence.configuration.services.ifaces.IMailService#splitMails(java.lang.String)
	 */
	@Override
	public Set<Mail> splitMails(String concatString) {
		Set<Mail> result = new HashSet<Mail>();
		String[] aux = concatString.split("&");
		
		for (int i=0; i<aux.length; i++) {
			result.add(getMailById(Long.parseLong(aux[i], 10)));
		}
		
		return result;
	}

}
