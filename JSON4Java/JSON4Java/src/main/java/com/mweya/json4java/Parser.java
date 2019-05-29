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
 * Based on the pj library written by Phil Eaton found at https://github.com/eatonphil/pj/blob/master/pj/lexer.py
 * Probably filled with bugs due to my translation of this from Python to Java
 */
import java.util.ArrayList;
public class Parser {
    private final char JSON_QUOTE = '\"';
    private final char[] JSON_WHITESPACE = {' ', '\t', '\b', '\n', '\r'};
    private final char[] JSON_SYNTAX = {',', ':', '[', ']', '{', '}'};
    private boolean is_root = false;
    
    public Parser() {}
    
    public JSONObject Parser(ArrayList tokens) throws ParseException {
        return parse(tokens);
    }
    
    public JSONObject parse(ArrayList tokens, boolean is_root) throws ParseException {
        this.is_root = is_root;
        return parse(tokens);
    }
    
    public JSONObject parse(ArrayList tokens) throws ParseException {
        JSONObject json = new JSONObject();
        JSONRule toadd = new JSONRule();
        while (tokens.size() > 0) {
            Object t = tokens.get(0);
            if (is_root && (!t.equals("{"))) {
                throw new ParseException("Root must be an object");
            }
            if (t.equals("[")) {
                tokens.remove(0);
                toadd.setValue(parse_array(tokens));
            } else if (t.equals("{")) {
                tokens.remove(0);
                toadd = parse_object(tokens);
            } else {
                tokens.remove(0);
            }
            
            json.addRule(toadd);
        }
        return json;
    }
    
    /** Parses a JSON array from a string and returns an ArrayList of array contents
     */
    private ArrayList parse_array(ArrayList tokens) throws ParseException {
        ArrayList toreturn  = new ArrayList();
        Object t = tokens.get(0);
        if (t.equals("]")) {
            return toreturn;
        } else {
            while (!t.equals("]")) {
                toreturn.add(t);
                tokens.remove(0);
                t = tokens.get(0);
                if (!t.equals(",")) {
                    throw new ParseException("Expected a comma after object in array");
                } else {
                    tokens.remove(0);
                    t = tokens.get(0);
                }
                
            }
            return toreturn;
        }
        // TODO
        //throw new ParseException("Expected an end of array bracket");
    }
    
    /** Parses a JSON object from a string and returns a JSONRule
     * @param tokens an ArrayList of tokens to be parsed
     * @hidden
     */
    // Needs rewrite, this doesn't make much sense right now
    private JSONRule parse_object(ArrayList tokens) throws ParseException {
        Object t = tokens.get(0);
        JSONRule rule = new JSONRule();
        if (t.equals("}")) {
            return rule;
        } else {
            while (!t.equals("}")) {
                if (t.getClass() == String.class) {
                    String name = (String) t;
                    rule.setName(name);
                    tokens.remove(0);
                    t = tokens.get(0);
                    if (!t.equals(":")) {
                        throw new ParseException("Expected colon after rule name");
                    } else {
                        // Interpret object here
                        rule.setValue(parse(tokens, false));
                    }
                    tokens.remove(0);
                    t = tokens.get(0);
                    if (!t.equals(",")) {
                        throw new ParseException("Expected comma in pair");
                    } else {
                        tokens.remove(0);
                        t = tokens.get(0);
                    }
                    
                } else {
                    throw new ParseException("Expected a string for the name");
                }
            }
        }
        return rule;
    }
}
