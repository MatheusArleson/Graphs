package br.com.xavier.graphs.impl.algorithms.color;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import br.com.xavier.graphs.util.Util;

public final class ColorFactory {
	
	private static final Random random = new Random();
	
	//XXX CONSTRUCTOR
	private ColorFactory(){	}
	
	//XXX METHODS
	public static Color generateRandomColor(){
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		Color color = new Color(r, g, b);
		
		return color;
	}
	
	public static List<Color> generateRandomColorList(int size, int colorOffset){
		if(size < 0){
			Util.handleIllegalParameter(size);
		}
		
		if(colorOffset < 0){
			Util.handleIllegalParameter(colorOffset);
		}
		
		List<Color> colorList = new LinkedList<>();
		if(size == 0){
			return colorList;
		}
		
		int tries = 0;
		for (int i = 0; i < size;) {
			tries++;
			Color randomColor = generateRandomColor();
			boolean isColorOK = isColorInOffset(colorList, randomColor, colorOffset);
			if(isColorOK){
				colorList.add(randomColor);
				i++;
				
				System.out.println("##>> COLOR ACCEPTED IN TRY > " + tries + " > " + randomColor);
				tries = 0;
			}
		}
		
		return colorList;
	}
	
	private static boolean isColorInOffset(List<Color> colorList, Color newColor, int colorOffset){
		for (Color color : colorList) {
			int redDiff = Math.abs(Math.subtractExact(color.getRed(), newColor.getRed()));
			int greenDiff = Math.abs(Math.subtractExact(color.getGreen(), newColor.getGreen()));
			int blueDiff = Math.abs(Math.subtractExact(color.getBlue(), newColor.getBlue()));
			System.out.println(" RD > " + redDiff + " GD > " + greenDiff + " BD > " + blueDiff);
			if(redDiff < colorOffset || greenDiff < colorOffset || blueDiff < colorOffset){
				return false;
			}
		}
		
		return true;
	}
	
	public static Set<Color> getPredefinedColorSet(int size){
		Set<Color> colorSet  = new LinkedHashSet<>();
		List<Color> predefinedColors = new ArrayList<>(getPredefinedColorsSet());
		
		for (int i = 0; i < size;) {
			int randomInt = Math.abs(random.nextInt());
			int index = randomInt % size;
			boolean added = colorSet.add(predefinedColors.get(index));
			if(added){
				i++;
			}
		}
		
		return colorSet;
	}
	
	private static Set<Color> getPredefinedColorsSet(){
		Set<Color> colorSet  = new LinkedHashSet<>();
		Field[] fields = Color.class.getDeclaredFields();
		for (Field field : fields) {
			if (field.getType().equals(Color.class) && Modifier.isStatic(field.getModifiers())) {
				try{
					colorSet.add((Color) field.get(null));
				} catch(IllegalAccessException e){					
				} 
			}
		}
		
		return colorSet;
	} 
	
}
