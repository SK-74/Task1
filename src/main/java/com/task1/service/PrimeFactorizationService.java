package com.task1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PrimeFactorizationService {

	public List<Integer> primeFactorization(int target){
		List<Integer> numbers = new ArrayList<>();

		int prime = 2;//素因数
		for(;;) {
			if(target % prime == 0) {
				//targetの数字がprimeの数字で割り切れた
				target /= prime; //割り切れたので商をtargetに入れ直す
				numbers.add(prime);//Listに追加
			}else {
				prime++;//次にチェックする素因数の候補
			}
			if(prime > target) {
				//これ以上分解できないのでforを抜ける
				break;
			}
		}
		return numbers;
	}
}
