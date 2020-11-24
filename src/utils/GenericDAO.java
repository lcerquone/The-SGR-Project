package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public abstract class GenericDAO<T> {
    final Class<T> clase;
	protected File archivo;
	private java.lang.Object Object;

	public GenericDAO(Class<T> clase, String file) throws Exception {
        this.clase = clase;
		this.archivo = new File(file);
		this.archivo.createNewFile();
    }

	public Object getObject() throws Exception {

		List<T> list = new ArrayList<T>();
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		T sample =null;

		try {
			String cadena = b.readLine();

			if (cadena == null) {
				this.saveAll(list);
				cadena = "[]";
			}

			sample = new Gson().fromJson(cadena, clase);


			b.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sample;
	}

	public List<T> getAll() throws Exception {
		List<T> list = new ArrayList<T>();
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		
		try {
			String cadena = b.readLine();
			
			if (cadena == null) {
				this.saveAll(list);
				cadena = "[]";
			}
			
			JsonParser parser = new JsonParser();
			JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
			Gson g = new Gson();
			for (JsonElement js : gsonArr) {
				list.add(g.fromJson(js, clase));
			}
			b.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public void saveAll(List<T> list) throws Exception {
		Gson g = new Gson();
		String texto = g.toJson(list);
		FileWriter fileWriter = new FileWriter(archivo);
		fileWriter.write(texto);
		BufferedWriter bwEscritor = new BufferedWriter(fileWriter);
		bwEscritor.close();
	}

	public void saveObject(Object o) throws Exception {
		Gson g = new Gson();
		String texto = g.toJson(o);
		FileWriter fileWriter = new FileWriter(archivo);
		fileWriter.write(texto);
		BufferedWriter bwEscritor = new BufferedWriter(fileWriter);
		bwEscritor.close();
	}
	
}
