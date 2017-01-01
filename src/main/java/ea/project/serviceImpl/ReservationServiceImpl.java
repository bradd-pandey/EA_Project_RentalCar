package ea.project.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.project.dao.IReservationDAO;
import ea.project.domain.Reservation;
import ea.project.service.IReservationService;

/**
 * @author swoven
 *@version 1.0
 */

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService
{
	private IReservationDAO reservationDao;
	
	
	public IReservationDAO getReservationDao() {
		return reservationDao;
	}

	public void setReservationDao(IReservationDAO reservationDao) {
		this.reservationDao = reservationDao;
	}

	@Override
	public void createReservation(Reservation reservation) {
		this.reservationDao.createReservation(reservation);
		
	}

	@Override
	public void updateReservation(Reservation reservation) {
		this.reservationDao.updateReservation(reservation);
		
	}

	@Override
	public List<Reservation> listReservation() {
		return this.reservationDao.listReservation();
	}

	@Override
	public Reservation getReservationById(int id) {
		return this.reservationDao.getReservationById(id);
	}

	@Override
	public void removeReservation(int id) {
		this.reservationDao.removeReservation(id);
		
	}

	@Override
	public Boolean isAvailable(Integer vehicleId, Date checkoutDate, Date returnDate) {
		return reservationDao.isAvailable(vehicleId, checkoutDate, returnDate);
	}

}
