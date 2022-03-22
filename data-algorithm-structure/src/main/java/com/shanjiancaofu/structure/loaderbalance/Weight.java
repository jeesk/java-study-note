package com.shanjiancaofu.structure.loaderbalance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weight {
	private String ip;
	private int currentWeight;
	private int weight;
}
