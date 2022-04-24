package com.intraway.fizzbuzz.services.business;

import java.util.List;

import com.intraway.fizzbuzz.dto.ERRORFizzbuzzDTO;
import com.intraway.fizzbuzz.dto.OKFizzbuzzDTO;

public interface FizzbuzzBusinessServices {

	public boolean validateMinMax(String min, String max);

	public OKFizzbuzzDTO getOkResult(String min, String max, String path);

	public ERRORFizzbuzzDTO getErrorResult(String path);

	public List<OKFizzbuzzDTO> getAllOkResult();

	public List<ERRORFizzbuzzDTO> getAllErrorResult();

}
