package com.intraway.fizzbuzz.services.business;

import com.intraway.fizzbuzz.domain.dto.ERRORFizzbuzzDTO;
import com.intraway.fizzbuzz.domain.dto.OKFizzbuzzDTO;

public interface FizzbuzzBusinessServices {

	public boolean validateMinMax(String min, String max);

	public OKFizzbuzzDTO getOkResult(String min, String max,  String path);

	public ERRORFizzbuzzDTO getErrorResult(String path);


}
