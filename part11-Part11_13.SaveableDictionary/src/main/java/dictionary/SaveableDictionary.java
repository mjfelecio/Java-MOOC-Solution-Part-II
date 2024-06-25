package dictionary;
	 
	import java.io.*;
	import java.util.*;
	 
	public class SaveableDictionary {
	    private String fileName;
	    private HashMap<String, String> dictionary;
	 
	    public SaveableDictionary() {
	        this.dictionary = new HashMap<>();
	    }
	 
	    public SaveableDictionary(String file) {
	        this.dictionary = new HashMap<>();
	        this.fileName = file;
	    }
	 
	    public void add(String words, String translation) {
	        if (!this.dictionary.containsKey(words)) {
	            this.dictionary.put(words, translation);
	        }
	    }
	 
	    public String translate(String word) {
	        String translation = null;
	 
	        for (String key: this.dictionary.keySet()) {
	            if (key.equals(word)) {
	                translation = this.dictionary.get(word);
	 
	            } else if (this.dictionary.get(key).equals(word)) {
	                translation = key;
	 
	            }
	        }
	        return translation;
	    }
	 
	    public void delete(String word) {
	        Iterator<Map.Entry<String, String>> iterator = dictionary.entrySet().iterator();
	 
	        while (iterator.hasNext()) {
	            Map.Entry<String, String> entry = iterator.next();
	 
	            String key = entry.getKey();
	            String value = entry.getValue();
	 
	            if (key.equals(word) || value.equals(word)) {
	                iterator.remove();
	            }
	 
	 
	        }
	 
	    }
	 
	    public boolean load() {
	        boolean fileLoaded = false;
	 
	        try {
	            Scanner fileReader = new Scanner(new File(fileName));
	 
	            while (fileReader.hasNextLine()) {
	                String line = fileReader.nextLine();
	 
	                String[] parts = line.split(":");
	 
	                String word = parts[0];
	                String translation = parts[1];
	 
	                this.dictionary.put(word, translation);
	            }
	 
	            fileLoaded = true;
	 
	            fileReader.close();
	 
	        } catch (IOException e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	 
	        return fileLoaded;
	    }
	 
	    public boolean save() {
	        boolean saved = false;
	        
	        try {
	        PrintWriter writer = new PrintWriter(fileName);
	 
	        for (String key: this.dictionary.keySet()) {
	            writer.println(key + ":" + dictionary.get(key));
	        }
	 
	        saved = true;
	        
	        writer.close();
	        
	        } catch (IOException e) {
	            System.err.println(e.getMessage());
	        }
	 
	        return saved;
	    }
	}
	 