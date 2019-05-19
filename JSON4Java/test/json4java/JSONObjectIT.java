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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mweya
 */
public class JSONObjectIT {
    
    public JSONObjectIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of insertRule method, of class JSONObject.
     */
    @Test
    public void testInsertRule_String_double() {
        System.out.println("insertRule");
        String selector = "";
        double value = 0.0;
        JSONObject instance = new JSONObject();
        instance.insertRule(selector, value);
    }

    /**
     * Test of insertRule method, of class JSONObject.
     */
    @Test
    public void testInsertRule_String_doubleArr() {
        System.out.println("insertRule");
        String selector = "";
        double[] value = null;
        JSONObject instance = new JSONObject();
        instance.insertRule(selector, value);
    }

    /**
     * Test of insertRule method, of class JSONObject.
     */
    @Test
    public void testInsertRule_String_int() {
        System.out.println("insertRule");
        String selector = "";
        int value = 0;
        JSONObject instance = new JSONObject();
        instance.insertRule(selector, value);
    }

    /**
     * Test of insertRule method, of class JSONObject.
     */
    @Test
    public void testInsertRule_String_intArr() {
        System.out.println("insertRule");
        String selector = "";
        int[] value = null;
        JSONObject instance = new JSONObject();
        instance.insertRule(selector, value);
    }

    /**
     * Test of addRule method, of class JSONObject.
     */
    @Test
    public void testAddRule_String_double() {
        System.out.println("addRule");
        String selector = "";
        double value = 0.0;
        JSONObject instance = new JSONObject();
        instance.addRule(selector, value);
    }

    /**
     * Test of addRule method, of class JSONObject.
     */
    @Test
    public void testAddRule_String_doubleArr() {
        System.out.println("addRule");
        String selector = "";
        double[] value = null;
        JSONObject instance = new JSONObject();
        instance.addRule(selector, value);
    }

    /**
     * Test of addRule method, of class JSONObject.
     */
    @Test
    public void testAddRule_String_int() {
        System.out.println("addRule");
        String selector = "";
        int value = 0;
        JSONObject instance = new JSONObject();
        instance.addRule(selector, value);
    }

    /**
     * Test of addRule method, of class JSONObject.
     */
    @Test
    public void testAddRule_String_intArr() {
        System.out.println("addRule");
        String selector = "";
        int[] value = null;
        JSONObject instance = new JSONObject();
        instance.addRule(selector, value);
    }

    /**
     * Test of insertRule method, of class JSONObject.
     */
    @Test
    public void testInsertRule_String_String() {
        System.out.println("insertRule");
        String selector = "";
        String value = "";
        JSONObject instance = new JSONObject();
        instance.insertRule(selector, value);
    }

    /**
     * Test of addRule method, of class JSONObject.
     */
    @Test
    public void testAddRule_String_String() {
        System.out.println("addRule");
        String selector = "";
        String value = "";
        JSONObject instance = new JSONObject();
        instance.addRule(selector, value);
    }

    /**
     * Test of insertRule method, of class JSONObject.
     */
    @Test
    public void testInsertRule_String_JSONRuleArr() {
        System.out.println("insertRule");
        String selector = "";
        JSONRule[] value = null;
        JSONObject instance = new JSONObject();
        instance.insertRule(selector, value);
    }

    /**
     * Test of addRule method, of class JSONObject.
     */
    @Test
    public void testAddRule_String_JSONRuleArr() {
        System.out.println("addRule");
        String selector = "";
        JSONRule[] value = null;
        JSONObject instance = new JSONObject();
        instance.addRule(selector, value);
    }

    /**
     * Test of insertRule method, of class JSONObject.
     */
    @Test
    public void testInsertRule_JSONRule() {
        System.out.println("insertRule");
        JSONRule rule = null;
        JSONObject instance = new JSONObject();
        instance.insertRule(rule);
    }

    /**
     * Test of addRule method, of class JSONObject.
     */
    @Test
    public void testAddRule_JSONRule() {
        System.out.println("addRule");
        JSONRule rule = null;
        JSONObject instance = new JSONObject();
        instance.addRule(rule);
    }

    /**
     * Test of insertRule method, of class JSONObject.
     */
    @Test
    public void testInsertRule_String_JSONObject() {
        System.out.println("insertRule");
        String selector = "";
        JSONObject value = null;
        JSONObject instance = new JSONObject();
        instance.insertRule(selector, value);
    }

    /**
     * Test of addRule method, of class JSONObject.
     */
    @Test
    public void testAddRule_String_JSONObject() {
        System.out.println("addRule");
        String selector = "";
        JSONObject value = null;
        JSONObject instance = new JSONObject();
        instance.addRule(selector, value);
    }

    /**
     * Test of getRule method, of class JSONObject.
     */
    @Test
    public void testGetRule() {
        System.out.println("getRule");
        int position = 0;
        JSONObject instance = new JSONObject();
        JSONRule expResult = null;
        JSONRule result = instance.getRule(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchSelector method, of class JSONObject.
     */
    @Test
    public void testSearchSelector() {
        System.out.println("searchSelector");
        String selector = "";
        JSONObject instance = new JSONObject();
        JSONRule expResult = null;
        JSONRule result = instance.searchSelector(selector);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteRule method, of class JSONObject.
     */
    @Test
    public void testDeleteRule_int() {
        System.out.println("deleteRule");
        int position = 0;
        JSONObject instance = new JSONObject();
        instance.deleteRule(position);
    }

    /**
     * Test of deleteRule method, of class JSONObject.
     */
    @Test
    public void testDeleteRule_String() {
        System.out.println("deleteRule");
        String selector = "";
        JSONObject instance = new JSONObject();
        instance.deleteRule(selector);
    }

    /**
     * Test of removeRule method, of class JSONObject.
     */
    @Test
    public void testRemoveRule_int() {
        System.out.println("removeRule");
        int position = 0;
        JSONObject instance = new JSONObject();
        instance.removeRule(position);
    }

    /**
     * Test of removeRule method, of class JSONObject.
     */
    @Test
    public void testRemoveRule_String() {
        System.out.println("removeRule");
        String selector = "";
        JSONObject instance = new JSONObject();
        instance.removeRule(selector);
    }

    /**
     * Test of toFile method, of class JSONObject.
     */
    @Test
    public void testToFile() throws Exception {
        System.out.println("toFile");
        String path = "";
        JSONObject instance = new JSONObject();
        instance.toFile(path);
    }

    /**
     * Test of toString method, of class JSONObject.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        JSONObject instance = new JSONObject();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
