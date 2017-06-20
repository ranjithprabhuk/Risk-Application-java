/**
 * 
 */
package com.challido.RiskApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challido.RiskApplication.models.Unsettled;


/**
 * @author URK7KOR
 *
 */
public interface UnsettledRepository extends JpaRepository<Unsettled,Long> {

}
