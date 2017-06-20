/**
 * 
 */
package com.challido.RiskApplication.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author URK7KOR
 *
 */

@Entity
@Table(name="unsettled")
public class Unsettled implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6197611678147892147L;

	@Id
	@Column(name="id")
	//@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="customer")
	private String customer;
	
	@Column(name="event")
	private String event;
	
	@Column(name="participant")
	private int participant;
	
	@Column(name="stake")
	private int stake;
	
	@Column(name="win")
	private int toWin;
	
	@Column(name="date_added")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_added;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getParticipant() {
		return participant;
	}

	public void setParticipant(int participant) {
		this.participant = participant;
	}

	public int getStake() {
		return stake;
	}

	public void setStake(int stake) {
		this.stake = stake;
	}

	public int getToWin() {
		return toWin;
	}

	public void setToWin(int win) {
		this.toWin = win;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = new Date();
	}
	
	

}
