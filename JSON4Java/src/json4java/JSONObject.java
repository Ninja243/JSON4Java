/*
 * Copyright (c) 2019, mweya
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package json4java;

/**
 *
 * @author mweya
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
public class JSONObject {
    private ArrayList<JSONRule> rules = new ArrayList();
    
    /** Empty constructor here for completeness' sake */
    public JSONObject() {}
    
    /** In case you've already got a list of rules
     * @param rules an ArrayList of rules
     */
    public JSONObject(ArrayList rules) {
        this.rules = rules;
    }
    
    /** In case you've already got a linked list of rules
     * @param rules a list of JSONRules
     */
    public JSONObject(LinkedList rules) {
        int j = 0;
        while (j<rules.size()) {
            this.rules.add((JSONRule) rules.get(j));
            j = j+1;
        }
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void insertRule(String name, double value) {
        addRule(name, value);
    }

    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void insertRule(String name, double[] value) {
        addRule(name, value);
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void insertRule(String name, int value) {
        addRule(name, value);
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void insertRule(String name, int[] value) {
        addRule(name, value);
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void addRule(String name, double value) {
        addRule(new JSONRule(name, value));
    }

    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void addRule(String name, double[] value) {
        addRule(new JSONRule(name, value));
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void addRule(String name, int value) {
        addRule(new JSONRule(name, value));
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void addRule(String name, int[] value) {
        addRule(new JSONRule(name, value));
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void insertRule(String name, String value) {
        addRule(name, value);
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void addRule(String name, String value) {
        JSONRule toinsert = new JSONRule(name, value);
        addRule(toinsert);
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void insertRule(String name, JSONRule[] value) {
        addRule(name, value);
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void addRule(String name, JSONRule[] value) {
        JSONRule toinsert = new JSONRule(name, value);
        addRule(toinsert);
    }
    
    /** Add a new rule to the JSON object
     *  @param rule is a JSONRule object
     */
    public void insertRule(JSONRule rule) {
        addRule(rule);
    }
    
    /** Add a new rule to the JSON object
     *  @param rule is a JSONRule object
     */
    public void addRule(JSONRule rule) {
        this.rules.add(rule);
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void insertRule(String name, JSONObject value) {
        addRule(name, value);
    }
    
    /** Add a new rule to the JSON object
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them.
     * @param value is the value to be assigned to the name
     */
    public void addRule (String name, JSONObject value) {
        this.rules.add(new JSONRule(name, value));
    }
    
    /** Return a rule at a specified position. If not found, return null.
     * @param position the position of the rule to return
     * @return the JSONRule or null
     */
    public JSONRule getRule(int position) {
        if (position <= this.rules.size()) {
            if (position > -1) {
                return this.rules.get(position);
            }
        }
        return null;
    }
    
    /** Linear search as the list of rules isn't sorted, returns null if not found
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them
     * @return the JSONRule or null
     */
    public JSONRule searchName(String name) {
        int j = 0;
        while (j<this.rules.size()) {
            if (name.equals(this.rules.get(j).getName())) {
                return this.rules.get(j);
            }
            j = j+1;
        }
        return null;
    }
    
    /** Deletes a rule from the JSONObject 
     * @param position the position of the rule
     */
    public void deleteRule(int position) {
        removeRule(position);
    }
    
    /** Deletes a rule from the JSONObject 
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them
     */
    public void deleteRule(String name) {
        removeRule(name);
    }
    
    /** Deletes a rule from the JSONObject 
     * @param position the position of the rule
     */
    public void removeRule(int position) {
        if (position <= this.rules.size()) {
            if (position > -1) {
                this.rules.remove(position);
            }
        }
    }
    
    /** Deletes a rule from the JSONObject 
     * @param name is the leftmost part of the rule which gives context to the value supplied to the right of the colon that divides them
     */
    public void removeRule(String name) {
        JSONRule toremove = searchName(name);
        if (toremove != null) {
            this.rules.remove(toremove);
        }
    }
    
    /** Make a JSONObject from a file 
     *  @param path the path to the JSON file to make an object from
     *  @return a JSONObject
     *  @throws IOException
     *  @hidden
     *  This is _not_ finished
     */
    public JSONObject fromFile(String path) throws IOException {
    /*    JSONObject toreturn = null;
        try (FileReader f = new FileReader(path); BufferedReader r = new BufferedReader(f)) {
            String input = "";
            String line;
            while ((line = r.readLine()) != null) {
                input = input+line+"\n";
            }
        }
        */
        return null;
    }
    
    /** Print object to a file
     * @param path where to save the file
     * @throws IOException 
     */
    public void toFile(String path) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(path))) {
            pw.write(this.toString());
            pw.flush();
        }
    }
    
    /** Show representation of object as string
     * @return contents of this object as string
     */
    @Override
    public String toString() {
        int j = 0;
        String out = "{";
        if (this.rules.size() > 0){
            while (j<this.rules.size()-1) {
                out = out+rules.get(j).toString()+",\n";
                j = j+1;
            }
            out = out+rules.get(j).toString();
        }
        out = out+"}";
        return out;
    }
}
