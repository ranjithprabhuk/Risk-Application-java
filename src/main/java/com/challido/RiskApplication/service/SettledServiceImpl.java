/**
 * 
 */
package com.challido.RiskApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challido.RiskApplication.models.Settled;
import com.challido.RiskApplication.repository.SettledRepository;

/**
 * @author URK7KOR
 *
 */
@Service
public class SettledServiceImpl implements SettledService {
	
	@Autowired
	SettledRepository settledRepository;

	@Override
	public void addSettledBet(Settled settled) {
		// TODO Auto-generated method stub
		this.settledRepository.save(settled);
	}

	@Override
	public void updateSettledBet(Settled settled) {
		// TODO Auto-generated method stub
		this.settledRepository.save(settled);
		
	}

	@Override
	public void deleteSettledBet(Long settledId) {
		// TODO Auto-generated method stub
		this.settledRepository.delete(settledId);
		
	}

	@Override
	public Settled getSettledBet(Long settledId) {
		// TODO Auto-generated method stub
		return this.settledRepository.findOne(settledId);
	}

	@Override
	public List<Settled> getAllSettledBets() {
		// TODO Auto-generated method stub
		return this.settledRepository.findAll();
	}

}
