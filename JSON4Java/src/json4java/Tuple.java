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
public class Tuple<AnyType> {
    private AnyType field1;
    private AnyType field2;
    
    public Tuple(){}
    
    public Tuple(AnyType field1, AnyType field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
    
    public void setBoth(AnyType field1, AnyType field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
    
    public ArrayList getBoth() {
        ArrayList toreturn = new ArrayList();
        toreturn.add(field1);
        toreturn.add(field2);
        return toreturn;
    }
    
    public void setFiest(AnyType field1) {
        this.field1 = field1;
    }
    
    public AnyType getFirst() {
        return this.field1;
    }
    
    public void setSecond(AnyType field2) {
        this.field2 = field2;
    }
    
    public AnyType getSecond() {
        return this.field2;
    }
    
}
