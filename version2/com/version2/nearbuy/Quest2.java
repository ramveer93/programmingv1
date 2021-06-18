/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.version2.nearbuy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author ramveersingh
 */
public class Quest2 {
	
	public static void main(String args[]){
		List<String> s = new ArrayList<>();
		
		s.add("jim likes mary");
		s.add("kate likes tom");
		s.add("tom does not like jim");
		
		List<String> q = new ArrayList<>();
		q.add("jim tom");
		q.add("likes");
		textQueries(s,q);
		
	}
	public static void textQueries(List<String> sentences, List<String> queries) {
		final List<List<Integer>> results = new ArrayList<>();
		String[] sent = sentences.toArray(new String[0]);
		for (final String querie : queries) {
			final List<Integer> queryResult = new ArrayList<>();
			results.add(queryResult);

			if (!querie.trim().isEmpty()) {
				final String[] queryWords = querie.trim().replaceAll(" +", " ").split(" ");
				for (int j = 0; j < sent.length; j++) {
					final String[] sentenceWords = sent[j].trim().replaceAll(" +", " ").split(" ");

					if (sentenceWords.length>0 && containsAll(sentenceWords, queryWords)) {
						queryResult.add(j);
					}
				}
			}
		}

    	for (final List<Integer> queryResult : results) {
    		if (!queryResult.isEmpty()) {
    			final StringBuffer print = new StringBuffer();
    			queryResult.forEach(value -> print.append(value + " "));
    			System.out.println(print.toString().trim());
    		} else {
    			System.out.println(-1);
    		}
    	}
	    }
	 static boolean containsAll(String[] sentenceWords, String[] queryWords) {
  	   return Arrays.asList(sentenceWords).containsAll(Arrays.asList(queryWords));
  }
}
