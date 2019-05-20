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
 * Based on the pj library written by Eaton Phil found at https://github.com/eatonphil/pj/blob/master/pj/lexer.py
 * Probably filled with bugs due to my translation of this from Python to Java
 */
import java.util.ArrayList;
public class Lexer {
    private final char JSON_QUOTE = '\"';
    private final char[] JSON_WHITESPACE = {' ', '\t', '\b', '\n', '\r'};
    private final char[] JSON_SYNTAX = {',', ':', '[', ']', '{', '}'};
    
    
    public Lexer() {}
    
    public Lexer(String input) {

    }
    
    public Tuple lex_string(String in) {
        String json_string = "";
        Tuple toreturn = new Tuple();
        if (in.charAt(0) == JSON_QUOTE) {
            in = in.substring(1);
        } else {
            toreturn.setBoth(null, in);
            return toreturn;
        }
        
        int j = 0;
        char c;
        while (j<in.length()) {
            c = in.charAt(j);
            if (c == JSON_QUOTE) {
                toreturn.setBoth(json_string, in.substring(json_string.length()+1));
            } else {
                json_string = json_string+c;
            }
        }
        System.err.println("Expected an end of string quote");
        return toreturn;
    }
    
    public Tuple lex_number(String in) {
        String json_number = "";
        char[] number_chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', 'e', '.'};
        int j = 0;
        int i = 0;
        boolean isnumberchar = false;
        while (j<in.length()) {
            i = 0;
            isnumberchar = false;
            while (i<number_chars.length) {
                if (in.charAt(j) == number_chars[i]) {
                    isnumberchar = true;
                    json_number = json_number+in.charAt(j);
                }
                i = i+1;
            }
            if (!isnumberchar) {
                break;
            }
            j = j+1;
        }
        String therest = in.substring(json_number.length());
        Tuple toreturn = new Tuple();
        if (therest.length() == 0) {
            toreturn.setBoth(null, in);
        }
        
        if (json_number.contains(".")) {
            toreturn.setBoth(Double.parseDouble(json_number), therest);
        } else {
            toreturn.setBoth(Integer.parseInt(json_number), therest);
        }
        return toreturn;
    }
    
    public Tuple lex_bool(String in) {
        Tuple toreturn = new Tuple();
        if ((in.length()>="true".length()) && (in.substring((in.length()-(1+"true".length())), (in.length()-1))  ).toLowerCase().equals("true")) {
            toreturn.setBoth(true, in.substring("true".length()));
        } else if ((in.length()>="false".length()) && (in.substring((in.length()-(1+"false".length())), (in.length()-1))  ).toLowerCase().equals("false")) {
            toreturn.setBoth(false, in.substring("false".length()));
        } else {
            toreturn.setBoth(null, in);
        }
        return toreturn;
    }
    
    public Tuple lex_null(String in) {
        Tuple toreturn = new Tuple();
        if ((in.length()>="null".length()) && (in.substring(in.length()-(1+"null".length()), in.length()-1).toLowerCase().equals("null"))) {
            // can't return null as that's what these methods return when they fail
            toreturn.setBoth(true, in.substring("null".length()));
        } else {
            toreturn.setBoth(null, in);
        }
        return toreturn;
    }
    
    public ArrayList lex(String in) {
        ArrayList tokens = new ArrayList();
        
        
        while (in.length() > 0) {
            
            // Find string
            Tuple json = lex_string(in);
            if (json.getFirst() != null) {
                tokens.add(json.getFirst());
                in = (String) json.getSecond();
            }
            
            // Find numbers
            json = lex_number(in);
            if (json.getFirst() != null) {
                tokens.add(json.getFirst());
                in = (String) json.getSecond();
            }
            
            // Find bools
            json = lex_bool(in);
            if (json.getFirst() != null) {
                tokens.add(json.getFirst());
                in = (String) json.getSecond();
            }
            
            // Find nulls
            json = lex_bool(in);
            if (json.getFirst() != null) {
                tokens.add(null);
                in = (String) json.getSecond();
            }
            
            char c = in.charAt(0);
            int j = 0;
            boolean iswhitespace = false;
            while (j<JSON_WHITESPACE.length) {
                if (c == JSON_WHITESPACE[j]) {
                    iswhitespace = true;
                    break;
                }
                j = j+1;
            }
            
            // Drop whitespace
            if (iswhitespace) {
                in = in.substring(1);
            } else {
                boolean issyntax = false;
                j = 0;
                while (j<JSON_SYNTAX.length) {
                    if (c == JSON_SYNTAX[j]) {
                        issyntax = true;
                        break;
                    }
                    j = j+1;
                }
                if (issyntax) {
                    tokens.add(c);
                    in = in.substring(1);
                } else {
                    System.err.println("Unexpected char '"+c+"' found while analyzing");
                }
            }
        }
        
        return tokens;
    }
}
