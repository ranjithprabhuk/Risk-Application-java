/**
 * 
 */
package com.challido.RiskApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challido.RiskApplication.dto.ResponseDto;
import com.challido.RiskApplication.models.Unsettled;
import com.challido.RiskApplication.service.UnsettledService;

import io.swagger.annotations.ApiOperation;

/**
 * @author URK7KOR
 *
 */

@RestController
public class UnsettledController {
	
	@Autowired
	UnsettledService unsettledService;
	
		//to get the list of all unsettled Bets
		@RequestMapping(value="/unsettledBets", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Get all the Un-Settled Bet Details")
		public @ResponseBody ResponseDto<Object> getAllUnSettledBets(){
			
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				List<Unsettled> unsettledBetList = new ArrayList<Unsettled>();
				unsettledBetList = this.unsettledService.getAllSettledBets();
				
				if(unsettledBetList != null && !unsettledBetList.isEmpty()){
					responseDto.isSuccess(true);
					responseDto.setMessage("Un-Settled Bet details are Fetched succesfully!");
					responseDto.setData(unsettledBetList);
				}
			}
			catch(DataException e){
				responseDto.setMessage(e.getMessage());
			}
			
			return responseDto;
		};
		
		//to get the particular un-settled bet details using id
		@RequestMapping(value="/unsettledBet/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Get a Un-Settled Bet Details of a customer based on Id")
		public @ResponseBody ResponseDto<Object> getUnSettledBets(@PathVariable("id") Long id){
			
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				Unsettled unsettledBet = new Unsettled();
				unsettledBet = this.unsettledService.getSettledBet(id);
				
				if(unsettledBet!= null){
					responseDto.isSuccess(true);
					responseDto.setMessage("Un-Settled Bet with id:" + id + " Successfully fetched!");
					responseDto.setData(unsettledBet);
				}
				
			}
			catch(DataException e){
				responseDto.isSuccess(false);
				responseDto.setMessage(e.getMessage());
			}
			
			
			return responseDto;
		}
		
		//to save a Un-Settled Bet
		@RequestMapping(value="/unsettledBet",method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Save the Settled Bet Details of a customer")
		public @ResponseBody ResponseDto<Object> saveunSettledBets(
				@RequestBody(required=true) Unsettled unsettled){
			
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				
				if(unsettled!=null){
					this.unsettledService.addSettledBet(unsettled);
					responseDto.setData(unsettled);
					responseDto.isSuccess(true);
					responseDto.setMessage("Un-Settled Bet added Successfully!");
				}
				
			}catch(DataException e){
				responseDto.isSuccess(false);
				responseDto.setMessage(e.getMessage());
				
			}
			
			
			return responseDto;
			
		};
		
		//to update a Settled Bet
		@RequestMapping(value="/unsettledBet",method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Update the Un-Settled Bet Details of a customer based on Id")
		public @ResponseBody ResponseDto<Object> updateUnSettledBets(@RequestBody(required=true) Unsettled unsettled){
			
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				
				if(unsettled!=null){
					this.unsettledService.addSettledBet(unsettled);
					responseDto.setData(unsettled);
					responseDto.isSuccess(true);
					responseDto.setMessage("Un-Settled Bet Updated Successfully!");
				}
				
			}catch(DataException e){
				responseDto.isSuccess(false);
				responseDto.setMessage(e.getMessage());
				
			}		
			
			return responseDto;
			
		};
		
		//to delete a un-settled bet
		@RequestMapping(value="/unsettledBet",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Delete a Un-Settled Bet based on its Id")
		public @ResponseBody ResponseDto<Object> deleteUnsettleBet(@RequestParam(name="id",required=true) Long id){
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				this.unsettledService.deleteSettledBet(id);
				responseDto.isSuccess(true);
				responseDto.setMessage("Un-Settled Bet Deleted Successfully!");
			}
			catch(DataException e){
				responseDto.isSuccess(false);
				responseDto.setMessage(e.getMessage());				
			}
			
			return responseDto;
		}

}
