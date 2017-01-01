package ea.project.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ea.project.dao.IConfirmationDAO;
import ea.project.domain.Confirmation;


/**
 * @author swoven
 *@version 1.0
 */

@Repository
@Transactional
public class ConfirmationDAOImpl implements IConfirmationDAO 
{	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void createConfirmation(Confirmation confirmation) {
		manager.persist(confirmation);
		System.out.println("Confirmation Object Saved");
		
	}

	@Override
	public void updateConfirmation(Confirmation confirmation) {
		manager.merge(confirmation);
		System.out.println("Confirmation Object Updated");
		
	}

	@Override
	public List<Confirmation> listConfirmation() {
		List<Confirmation> confirmationList = manager.createQuery("from Confirmation",Confirmation.class).getResultList();
		for(Confirmation p : confirmationList){
			System.out.println(p.getConfirmationNumber());
		}
		return confirmationList;
	}

	@Override
	public Confirmation getConfirmationById(int id) {	
		Confirmation confirmation  = (Confirmation) manager.getReference(Confirmation.class, new Integer(id));
		System.out.println("Confimration loaded successfully");
		return confirmation;
	}

	@Override
	public void removeConfirmationById(int id) {
		Confirmation confirmation = (Confirmation) manager.getReference(Confirmation.class, new Integer(id));
		if(null != confirmation){
			manager.remove(confirmation);
		}
		System.out.println("Confirmation object deleted");
	}

}
