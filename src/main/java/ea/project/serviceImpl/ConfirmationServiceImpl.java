package ea.project.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.project.dao.IConfirmationDAO;
import ea.project.domain.Confirmation;
import ea.project.service.IConfirmationService;

/**
 * @author swoven
 * @version 1.0
 */
@Service
@Transactional
public class ConfirmationServiceImpl implements IConfirmationService
{
	private IConfirmationDAO confirmationDao;
	
	public IConfirmationDAO getConfirmationDao() {
		return confirmationDao;
	}

	public void setConfirmationDao(IConfirmationDAO confirmationDao) {
		this.confirmationDao = confirmationDao;
	}

	@Override
	public void createConfirmation(Confirmation confirmation) {
		this.confirmationDao.createConfirmation(confirmation);
		
	}

	@Override
	public void updateConfirmation(Confirmation confirmation) {
		this.confirmationDao.updateConfirmation(confirmation);
	}

	@Override
	public List<Confirmation> listConfirmation() {
		return this.confirmationDao.listConfirmation();
	}

	@Override
	public Confirmation getConfirmationById(int id) {
		return this.confirmationDao.getConfirmationById(id);
	}

	@Override
	public void removeConfirmationById(int id) {
		this.confirmationDao.removeConfirmationById(id);
	}
	
}
