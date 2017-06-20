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
import com.challido.RiskApplication.models.Settled;
import com.challido.RiskApplication.service.SettledService;

import io.swagger.annotations.ApiOperation;

/**
 * @author URK7KOR
 *
 */
@RestController
public class SettledController {
	
	@Autowired
	SettledService settledService;
	
		//to get the list of all settled Bets
		@RequestMapping(value="/settledBets", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Get all the Settled Bet Details")
		public @ResponseBody ResponseDto<Object> getAllSettledBets(){
			
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				List<Settled> settledBetList = new ArrayList<Settled>();
				settledBetList = this.settledService.getAllSettledBets();
				
				if(settledBetList != null && !settledBetList.isEmpty()){
					responseDto.isSuccess(true);
					responseDto.setMessage("Settled Bet details are Fetched succesfully!");
					responseDto.setData(settledBetList);
				}
			}
			catch(DataException e){
				responseDto.setMessage(e.getMessage());
			}
			
			return responseDto;
		};
		
		//to get the particular settled bet details using id
		@RequestMapping(value="/settledBet/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Get a Settled Bet Details of a customer based on Id")
		public @ResponseBody ResponseDto<Object> getSettledBets(@PathVariable("id") Long id){
			
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				Settled settledBet = new Settled();
				settledBet = this.settledService.getSettledBet(id);
				
				if(settledBet!= null){
					responseDto.isSuccess(true);
					responseDto.setMessage("Settled Bet with id:" + id + " Successfully fetched!");
					responseDto.setData(settledBet);
				}
				
			}
			catch(DataException e){
				responseDto.isSuccess(false);
				responseDto.setMessage(e.getMessage());
			}
			
			
			return responseDto;
		}
		
		//to save a Settled Bet
		@RequestMapping(value="/settledBet",method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Save the Settled Bet Details of a customer")
		public @ResponseBody ResponseDto<Object> saveSettledBets(
				@RequestBody(required=true) Settled settled){
			
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				
				if(settled!=null){
					this.settledService.addSettledBet(settled);
					responseDto.setData(settled);
					responseDto.isSuccess(true);
					responseDto.setMessage("Settled Bet added Successfully!");
				}
				
			}catch(DataException e){
				responseDto.isSuccess(false);
				responseDto.setMessage(e.getMessage());
				
			}
			
			
			return responseDto;
			
		};
		
		//to update a Settled Bet
		@RequestMapping(value="/settledBet",method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Update the Settled Bet Details of a customer based on Id")
		public @ResponseBody ResponseDto<Object> updateSettledBets(@RequestBody(required=true) Settled settled){
			
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				
				if(settled!=null){
					this.settledService.addSettledBet(settled);
					responseDto.setData(settled);
					responseDto.isSuccess(true);
					responseDto.setMessage("Settled Bet Updated Successfully!");
				}
				
			}catch(DataException e){
				responseDto.isSuccess(false);
				responseDto.setMessage(e.getMessage());
				
			}		
			
			return responseDto;
			
		};
		
		//to delete a settled bet
		@RequestMapping(value="/settledBet",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Delete a Settled Bet based on its Id")
		public @ResponseBody ResponseDto<Object> deleteSettledBet(@RequestParam(name="id",required=true) Long id){
			ResponseDto<Object> responseDto = new ResponseDto<>();
			
			try{
				this.settledService.deleteSettledBet(id);
				responseDto.isSuccess(true);
				responseDto.setMessage("Settled Bet Deleted Successfully!");
			}
			catch(DataException e){
				responseDto.isSuccess(false);
				responseDto.setMessage(e.getMessage());				
			}
			
			return responseDto;
		}

}
