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
	
	public static void main(String[] args) {
		Set<Color> colors = getPredefinedColorSet(4, true);
		for (Color color : colors) {
			System.out.println(color);
		}
	}
	
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
	
	public static Set<Color> getPredefinedColorSet(int size, boolean avoidBlackWhiteGray){
		Set<Color> colorSet  = new LinkedHashSet<>();
		List<Color> predefinedColors = new ArrayList<>(getPredefinedColorsSet(avoidBlackWhiteGray));
		
		for (int i = 0; i < size;) {
			int randomInt = Math.abs(random.nextInt());
			int index = randomInt % size;
			Color color = predefinedColors.get(index);
			boolean added = colorSet.add(color);
			if(added){
				i++;
			}
		}
		
		return colorSet;
	}
	
	private static Set<Color> getPredefinedColorsSet(boolean avoidBlackWhiteGray){
		Set<Color> colorSet  = new LinkedHashSet<>();
		Field[] fields = Color.class.getDeclaredFields();
		for (Field field : fields) {
			if (field.getType().equals(Color.class) && Modifier.isStatic(field.getModifiers())) {
				try{
					Color color = (Color) field.get(null);
					
					if(avoidBlackWhiteGray){
						boolean toAvoid = (
							color.equals(Color.BLACK) || color.equals(Color.black) || 
							color.equals(Color.WHITE) || color.equals(Color.white) || 
							color.equals(Color.GRAY)  || color.equals(Color.gray)  ||
							color.equals(Color.MAGENTA)  || color.equals(Color.magenta) ||
							color.equals(Color.PINK)  || color.equals(Color.pink)
						);
						
						if(toAvoid){
							continue;
						}
					}
					
					colorSet.add(color);
					
				} catch(IllegalAccessException e){					
				} 
			}
		}
		
		return colorSet;
	} 
	
}
