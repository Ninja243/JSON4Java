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
 * This file aims to represent a "rule" or "line" in a JSON document.
 * Multiple rules wrapped in curly brackets make a JSON object.
 * If possible, try to store your information as a string inside this object.
 * @author mweya
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class JSONRule<AnyType> {
    private String selector = null; // The leftmost part of a rule that tells you what the information to the right of the colon is for
    private String value = null; // The rightmost part of the rule which can be one value, a whole nested object or an array of vaules
    
    // Empty constructor, here for completeness' sake
    public JSONRule() {}
    
    // For a simple rule consisting of a single value for a single selector
    public JSONRule(String selector, String value) {
        this.selector = selector;
        this.value = "\""+value+"\"";
    }
    
    // For rules with an integer as a value
    public JSONRule(String selector, int value) {
        this.selector = selector;
        this.value = Integer.toString(value);
    }
    
    // For rules with a double as a value
    public JSONRule(String selector, double value) {
        this.selector = selector;
        this.value = Double.toString(value);
    }

    // For rules with an array of Doubles as the value
    public JSONRule(String selector, double[] value) {
        this.selector = selector;
        this.value = "[";
        int j = 0;
        while (j<value.length-1) {
            this.value = this.value+Double.toString(value[j])+",";
            j = j+1;
        }
        this.value = this.value+Double.toString(value[j]);
        this.value = this.value+"]";
    }
    
    // For rules with an array of integers as the value
    public JSONRule(String selector, int[] value) {
        this.selector = selector;
        this.value = "[";
        int j = 0;
        while (j<value.length-1) {
            this.value = this.value+Integer.toString(value[j])+",";
            j = j+1;
        }
        this.value = this.value+Integer.toString(value[j]);
        this.value = this.value+"]";
    }
    
    // For a rule consisting of an array of values for a single selector
    public JSONRule(String selector, String[] value) {
        this.selector = selector;
        this.value = "[";
        int j = 0;
        while (j<value.length-1) {
            this.value = this.value+"\""+value[j]+"\""+",";
            j = j+1;
        }
        this.value = this.value+"\""+value[j]+"\"";
        this.value = this.value+"]";
    }
    
    // For an array of nested objects because ofc that's a thing
    public JSONRule(String selector, JSONRule[] value) {
        this.selector = selector;
        this.value = "[";
        int j = 0;
        while (j<value.length-1) {
            this.value = this.value+value[j].toString()+",";
            j = j+1;
        }
        this.value = this.value+value[j];
        this.value = this.value+"]";
    }
    
    // For a rule consisting of a ArrayList of values for a single selector
    // Same idea as above really
    public JSONRule(String selector, ArrayList value) {
        this.selector = selector;
        this.value = "[";
        int j = 0;
        while (j<value.size()-1) {
            this.value = this.value+"\""+value.get(j)+"\""+",";
            j = j+1;
        }
        this.value = this.value+"\""+value.get(j)+"\"";
        this.value = this.value+"]";
    }
    
    // For a rule conisting of a Linked List of values and a single selector
    public JSONRule(String selector, LinkedList value) {
        this.selector = selector;
        this.value = "[";
        int j = 0;
        while (j<value.size()-1){
            this.value = this.value+"\""+value.get(j)+"\""+",";
            j = j+1;
        } 
        this.value = this.value+"\""+value.get(j)+"\"";
        this.value = this.value+"]";
    }
    
    // For a rule consisting of an embedded object
    public JSONRule(String selector, JSONObject value) {
        this.selector = selector;
        this.value = value.toString();
    }
    
    // Returns the selector part of this rule
    public String getSelector() {
        return this.selector;
    }
    
    @Override
    public String toString() {
        return selector+":"+value;
    }
}
