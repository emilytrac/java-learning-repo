package com.et.linkedhash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // whenever unique object being stored

public class Number {
	
	private int numberIn;
	private int indexIn;

}
