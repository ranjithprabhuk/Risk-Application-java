/**
 * 
 */
package com.challido.RiskApplication.service;

import java.util.List;

import com.challido.RiskApplication.models.Settled;
/**
 * @author URK7KOR
 *
 */
public interface SettledService {
	
	public void addSettledBet(Settled settled);
	
	public void updateSettledBet(Settled settled);
	
	public void deleteSettledBet(Long settledId);
	
	public Settled getSettledBet(Long settledId);
	
	public List<Settled> getAllSettledBets();

}
