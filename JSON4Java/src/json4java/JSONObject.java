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
import java.io.File;
public class JSONObject {
    private ArrayList<JSONRule> rules = new ArrayList();
    
    // Empty constructor here for completeness' sake
    public JSONObject() {}
    
    // In case you've already got a list of rules
    public JSONObject(ArrayList rules) {
        this.rules = rules;
    }
    
    // In case you've already got a linked list of rules
    public JSONObject(LinkedList rules) {
        int j = 0;
        while (j<rules.size()) {
            this.rules.add((JSONRule) rules.get(j));
            j = j+1;
        }
    }
    
    public void insertRule(String selector, double value) {
        addRule(selector, value);
    }

    public void insertRule(String selector, double[] value) {
        addRule(selector, value);
    }
    
    public void insertRule(String selector, int value) {
        addRule(selector, value);
    }
    
    public void insertRule(String selector, int[] value) {
        addRule(selector, value);
    }
    
    public void addRule(String selector, double value) {
        addRule(new JSONRule(selector, value));
    }

    public void addRule(String selector, double[] value) {
        addRule(new JSONRule(selector, value));
    }
    
    public void addRule(String selector, int value) {
        addRule(new JSONRule(selector, value));
    }
    
    public void addRule(String selector, int[] value) {
        addRule(new JSONRule(selector, value));
    }
    
    public void insertRule(String selector, String value) {
        addRule(selector, value);
    }
    
    public void addRule(String selector, String value) {
        JSONRule toinsert = new JSONRule(selector, value);
        addRule(toinsert);
    }
    
    public void insertRule(String selector, JSONRule[] value) {
        addRule(selector, value);
    }
    
    public void addRule(String selector, JSONRule[] value) {
        JSONRule toinsert = new JSONRule(selector, value);
        addRule(toinsert);
    }
    
    public void insertRule(JSONRule rule) {
        addRule(rule);
    }
    
    public void addRule(JSONRule rule) {
        this.rules.add(rule);
    }
    
    public void insertRule(String selector, JSONObject value) {
        addRule(selector, value);
    }
    
    public void addRule (String selector, JSONObject value) {
        this.rules.add(new JSONRule(selector, value));
    }
    
    // Return a rule at a specified position. If not found, return null.
    public JSONRule getRule(int position) {
        if (position <= this.rules.size()) {
            if (position > -1) {
                return this.rules.get(position);
            }
        }
        return null;
    }
    
    // Linear search as the list of rules isn't sorted, returns null if not found
    public JSONRule searchSelector(String selector) {
        int j = 0;
        while (j<this.rules.size()) {
            if (selector.equals(this.rules.get(j).getSelector())) {
                return this.rules.get(j);
            }
            j = j+1;
        }
        return null;
    }
    
    public void deleteRule(int position) {
        removeRule(position);
    }
    
    public void deleteRule(String selector) {
        removeRule(selector);
    }
    
    public void removeRule(int position) {
        if (position <= this.rules.size()) {
            if (position > -1) {
                this.rules.remove(position);
            }
        }
    }
    
    public void removeRule(String selector) {
        JSONRule toremove = searchSelector(selector);
        if (toremove != null) {
            this.rules.remove(toremove);
        }
    }
    
    // Make a JSONObject from a file
    // TODO
    
    // Print object to a file
    public void toFile(String path) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(path))) {
            pw.write(this.toString());
            pw.flush();
        }
    }
    
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
