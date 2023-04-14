package com.tyss.warehouse.boot.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.dao.ProcessedGoodDao;
import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;
import com.tyss.warehouse.boot.warehouse.exception.IdNotFoundException;
import com.tyss.warehouse.boot.warehouse.exception.ProcessedGoodNotFoundByName;
import com.tyss.warehouse.boot.warehouse.exception.ProcessedGoodsNotFound;
@Service
public class ProcessedGoodService {
	@Autowired
	private ProcessedGoodDao dao;
	
	public ResponseEntity<ResponseStructure<ProcessedGood>> savePgood(ProcessedGood pgood ){
		ResponseStructure<ProcessedGood> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.addprocessedgood(pgood));
		responseStructure.setMessage("good saved success");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<ProcessedGood>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<ProcessedGood>> updatePgood(ProcessedGood pgood, int id){
		ProcessedGood pgood2 = dao.findprocessedgoodById(id);
		if(pgood2!=null) {
		ResponseStructure<ProcessedGood> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.updateprocessedgood(pgood, id));
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("processed good has been updated");
		return new ResponseEntity<ResponseStructure<ProcessedGood>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("processed good id not found");
		}
	}
	public ResponseEntity<ResponseStructure<ProcessedGood>> findPgood(int id){
		
		ProcessedGood pgood2 = dao.findprocessedgoodById(id);
		if(pgood2!=null) {
		ResponseStructure<ProcessedGood> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.findprocessedgoodById(id));
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("processed good found");
		return new ResponseEntity<ResponseStructure<ProcessedGood>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException("processed good id not found");
		}
	}
	public ResponseEntity<ResponseStructure<ProcessedGood>> deletePgood(int id){
		ProcessedGood pgood2 = dao.findprocessedgoodById(id);
		if(pgood2!=null) {
		ResponseStructure<ProcessedGood> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.deleteprocessedgoodById(id));
		responseStructure.setMessage("processed good deleted");
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<ProcessedGood>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException("processed good id not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<ProcessedGood>> findProcessedGoodByName(String name){
		ProcessedGood good = dao.findByName(name);
		if(good!=null) {
			ResponseStructure<ProcessedGood> structure = new ResponseStructure<>();
			structure.setData(good);
			structure.setMessage("ProcessedGood found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<ProcessedGood>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new ProcessedGoodNotFoundByName("ProcessedGood not found by name");
		}
	}
	public ResponseEntity<ResponseStructure<List<ProcessedGood>>> getAllGood(){
		List<ProcessedGood> goods = dao.getAllGoods();
		
		if(goods!=null) {
			ResponseStructure<List<ProcessedGood>> structure = new ResponseStructure<>();
			structure.setData(goods);
			structure.setMessage("goods found");
			structure.setStatus(HttpStatus.FOUND.value());
		
			return new ResponseEntity<ResponseStructure<List<ProcessedGood>>>(structure,HttpStatus.FOUND);
		}
		throw new ProcessedGoodsNotFound("no goods exists");		
	}
	public ResponseEntity<ResponseStructure<List<ProcessedGood>>> expiredGoods(){
		List<ProcessedGood> expiredItems= dao.expiredItems();
		if(expiredItems!=null) {
			ResponseStructure<List<ProcessedGood>> structure = new ResponseStructure<>();
			structure.setData(expiredItems);
			structure.setMessage("expired itemds found");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<List<ProcessedGood>>>(structure, HttpStatus.FOUND);			
		}
		throw new ProcessedGoodsNotFound("mo expired itemds found");
	}
	
}
