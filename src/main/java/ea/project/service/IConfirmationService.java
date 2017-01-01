package ea.project.service;

import java.util.List;

import ea.project.domain.Confirmation;

/**
 * @author swoven
 *@version 1.0
 */
public interface IConfirmationService 
{
	public void createConfirmation(Confirmation confirmation);
	public void updateConfirmation(Confirmation confirmation);
	public List<Confirmation> listConfirmation();
	public Confirmation getConfirmationById(int id);
	public void removeConfirmationById(int id);
}
