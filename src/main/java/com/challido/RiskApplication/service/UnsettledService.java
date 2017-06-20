/**
 * 
 */
package com.challido.RiskApplication.service;

import java.util.List;

import com.challido.RiskApplication.models.Unsettled;

/**
 * @author URK7KOR
 *
 */
public interface UnsettledService {
	
	public void addSettledBet(Unsettled unsettled);
	
	public void updateSettledBet(Unsettled unsettled);
	
	public void deleteSettledBet(Long unsettledId);
	
	public Unsettled getSettledBet(Long unsettledId);
	
	public List<Unsettled> getAllSettledBets();

}
