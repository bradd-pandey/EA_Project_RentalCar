package ea.project.daoImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ea.project.dao.IReservationDAO;
import ea.project.domain.Reservation;


/**
 * @author swoven
 *@version 1.0
 */
@Repository
@Transactional
public class ReservationDAOImpl implements IReservationDAO 
{
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void createReservation(Reservation reservation) {
		manager.persist(reservation);
		System.out.println("Reservation Object Saved");
		
	}

	@Override
	public void updateReservation(Reservation reservation) {
		manager.merge(reservation);
		System.out.println("Reservation Object Updated");
		
	}

	@Override
	public List<Reservation> listReservation() {
		List<Reservation> reservationList =manager.createQuery("from Reservation", Reservation.class).getResultList();
		for(Reservation p : reservationList){
			System.out.println(p.getId());
		}
		return reservationList;
	}

	@Override
	public Reservation getReservationById(int id) {		
		Reservation reservation  = (Reservation) manager.getReference(Reservation.class, new Integer(id));
		System.out.println("Reservation loaded successfully");
		return reservation;
	}

	@Override
	public void removeReservation(int id) {
		Reservation reservation = (Reservation) manager.getReference(Reservation.class, new Integer(id));
		if(null != reservation){
			manager.remove(reservation);
		}
		System.out.println("Reservation object deleted");
		
	}
	
	@SuppressWarnings("unused")
	@Override
	public Boolean isAvailable(Integer vehicleId, Date checkoutDate, Date returnDate) {
		Reservation reservation = null;
		TypedQuery<Reservation> query = manager.createQuery(""
				+ "FROM Reservation r"
				+ " WHERE r.vehicleId = :vehicleID"
				+ " AND ((r.pickUpDate BETWEEN :checkOutDate AND :returnDate)"
				+ " OR (r.returnDate BETWEEN :checkOutDate AND :returnDate))", Reservation.class);
		query.setParameter("vehicleID", vehicleId);
		query.setParameter("checkOutDate", checkoutDate, TemporalType.DATE);
		query.setParameter("returnDate", returnDate, TemporalType.DATE);
		
		reservation = query.getSingleResult();
		
		System.out.println("---checkoutDate----" + checkoutDate);
		System.out.println(reservation.getPickUpDate());
		System.out.println("---returnDate----" + returnDate);
		System.out.println(reservation.getReturnDate());
		
		if(reservation != null)
			return false;
		else
			return true;
	}

}
