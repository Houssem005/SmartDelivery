package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.repositories.FournisseurRepository;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository reservationRepository;
		
		public Fournisseur addReservation(Fournisseur reservation) {
			return reservationRepository.save(reservation);

		}
		public List<Fournisseur> getAllReservation() {

			return reservationRepository.findAll();
		}
		
		public Fournisseur getByIdReservation(int id) {
			Fournisseur r = reservationRepository.findById(id).get();

			return r;
		}

		public String deleteReservation(int id) {

			if (reservationRepository.findById(id).isPresent()) {
				reservationRepository.deleteById(id);
				return "reservation supprimé";
			}
			else
				return " reservation non supprimé";
		}

		public Fournisseur updateReservation(int id, Fournisseur a) {

			if (reservationRepository.findById(id).isPresent()) {
				Fournisseur existingReservation = reservationRepository.findById(id).get();
				existingReservation.setEmail(a.getEmail());;
				existingReservation.setNom(a.getNom());;
				existingReservation.setPrenom(a.getPrenom());
				return reservationRepository.save(existingReservation);

			}
			else
				return null;

		}
}
