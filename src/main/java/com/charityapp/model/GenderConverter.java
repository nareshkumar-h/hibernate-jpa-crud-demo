package com.charityapp.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GenderConverter implements AttributeConverter<Gender, String>{

	public String convertToDatabaseColumn(Gender attribute) {
		System.out.println("Convert -" + attribute.toString());
		return attribute.toString();
	}

	public Gender convertToEntityAttribute(String dbData) {
		return Gender.toGender(dbData);
	}

	
}
