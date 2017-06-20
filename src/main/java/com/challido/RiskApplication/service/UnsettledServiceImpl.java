/**
 * 
 */
package com.challido.RiskApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challido.RiskApplication.models.Unsettled;
import com.challido.RiskApplication.repository.UnsettledRepository;

/**
 * @author URK7KOR
 *
 */

@Service
public class UnsettledServiceImpl implements UnsettledService {
	
	@Autowired
	UnsettledRepository unsettledRepository;

	/* (non-Javadoc)
	 * @see com.challido.RiskApplication.service.UnsettledService#addSettledBet(com.challido.RiskApplication.models.Unsettled)
	 */
	@Override
	public void addSettledBet(Unsettled unsettled) {
		// TODO Auto-generated method stub
		this.unsettledRepository.save(unsettled);

	}

	/* (non-Javadoc)
	 * @see com.challido.RiskApplication.service.UnsettledService#updateSettledBet(com.challido.RiskApplication.models.Unsettled)
	 */
	@Override
	public void updateSettledBet(Unsettled unsettled) {
		// TODO Auto-generated method stub
		this.unsettledRepository.save(unsettled);

	}

	/* (non-Javadoc)
	 * @see com.challido.RiskApplication.service.UnsettledService#deleteSettledBet(java.lang.Long)
	 */
	@Override
	public void deleteSettledBet(Long unsettledId) {
		// TODO Auto-generated method stub
		this.unsettledRepository.delete(unsettledId);

	}

	/* (non-Javadoc)
	 * @see com.challido.RiskApplication.service.UnsettledService#getSettledBet(java.lang.Long)
	 */
	@Override
	public Unsettled getSettledBet(Long unsettledId) {
		// TODO Auto-generated method stub
		return this.unsettledRepository.findOne(unsettledId);
	}

	/* (non-Javadoc)
	 * @see com.challido.RiskApplication.service.UnsettledService#getAllSettledBets()
	 */
	@Override
	public List<Unsettled> getAllSettledBets() {
		// TODO Auto-generated method stub
		return this.unsettledRepository.findAll();
	}

}
