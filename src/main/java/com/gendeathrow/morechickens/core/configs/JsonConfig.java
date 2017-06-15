package com.gendeathrow.morechickens.core.configs;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonConfig{

	
	boolean hasChanged = false;
	
	private File configFile;
	private JsonObject json;
	private Gson gson;
	
	public JsonConfig(File file){
		configFile = file;
		gson = new Gson();
		json = new JsonObject();
	}
	
	public void Save(){
		//save
		WriteFile();
		hasChanged = false;
	}
	
	public void Load(){
		try { SetupFile(); } 
		catch (IOException e) { e.printStackTrace(); }
		
		json = ReadFile();
		if(json == null)
			System.out.println("empty");
	}

	public JsonObject getFullJson(){
		return this.json;
	}
	
	public JsonObject getCategory(String categoryProperty)
	{
		JsonObject object = new JsonObject();
		
    	if(json.has(categoryProperty)){
    		object = json.getAsJsonObject(categoryProperty);
    	}
    	else{
    		json.add(categoryProperty, object);
    		setHasChanged(true);
    	}
    	
		return object;
	}
	
	
	/**
	 * Get or set a boolean
	 * 
	 * @param categoryProperty
	 * @param property
	 * @param value
	 * @return
	 */
	public boolean getBoolean(String categoryProperty, String property, boolean value)
	{
		JsonObject object = getCategory(categoryProperty);

		if(object.has(property)){
			value = object.get(property).getAsBoolean();
		}else{
			object.addProperty(property, value);
			setHasChanged(true);
		}
		
		return value;
	}
	
	public String getString(String categoryProperty, String property, String value) {
		
		JsonObject object = getCategory(categoryProperty);
		
		if(object.has(property)){
			value = object.get(property).getAsString();
		}else{
			object.addProperty(property, value);
			setHasChanged(true);
		}
		
		return value;
	}

		
	
	public float getFloat(String categoryProperty, String property, float value, float min, float max) {

		JsonObject object = getCategory(categoryProperty);

		if(object.has(property)){
			value = object.get(property).getAsFloat();
		}else{
			object.addProperty(property, value);
			setHasChanged(true);
		}
		
		if(value > max) value = max;
		if(value < min) value = min;
		
		return value;
	}
	
	
	public boolean hasChanged(){
		return this.hasChanged;
	}
	
	private void setHasChanged(boolean val){
		this.hasChanged = val;
	}
	/**
	 * Sets a file and Dir up if its missing
	 * 
	 * @throws IOException
	 */
	private void SetupFile() throws IOException{
    	
    	if (!configFile.exists()){
    		hasChanged = true;
    		configFile.getParentFile().mkdirs();
    		configFile.createNewFile();
    	}
	}
	
	/**
	 * Reads a file and converts it to json format
	 * @return
	 */
   private JsonObject ReadFile(){
	   
	   JsonObject obj = new JsonObject();
	   
		try{
			FileReader fr = new FileReader(configFile);
			JsonObject jsonobject = gson.fromJson(fr, JsonObject.class);
			fr.close();
			
			return jsonobject != null ? jsonobject : obj;

		} catch(Exception e){
			throw new RuntimeException("Error "+e.getCause()+" loading file: "+ configFile.getPath());
		}
   }
   
   
   /**
    * Takes the json and writes it to a file.
    */
   private void WriteFile(){
   	
	   try{
		   FileWriter fw = new FileWriter(configFile);
		   new GsonBuilder().setPrettyPrinting().create().toJson(json, fw);
		   fw.flush();
		   fw.close();
       }
       catch (IOException ioexception){
    	   ioexception.printStackTrace();
       }
   }



}
