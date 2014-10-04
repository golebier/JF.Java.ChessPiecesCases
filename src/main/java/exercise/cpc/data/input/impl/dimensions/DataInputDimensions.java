package exercise.cpc.data.input.impl.dimensions;
//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import exercise.cpc.data.input.InputData;
/**
 *  Dimensions of the board. implementation of  the {@code DataInput}.
 *  TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *      https://github.com/golebier or https://golebier.github.io
 *      https://google.com/+RadoslawGolebiewski
 *      http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
*/
public class DataInputDimensions implements InputData {
    private Integer n;
    private Integer m;

    /**
     * Setup the {@code InputData} dimensions fields.
     * Correctness of n and m, as changed with m and n is not checked.
     *  
     * @param n, N dimension of the board.
     * @param m, M dimension of the board.
     */
    public DataInputDimensions(Integer n, Integer m) {
        this.n = n;
        this.m = m;
    }
    
    public Integer getN() {
        return n;
    }
    
    public Integer getM() {
        return m;
    }
    
    public void setN(Integer n) {
        this.n = n;
    }
    
    public void setM(Integer m) {
        this.m = m;
    }
}
