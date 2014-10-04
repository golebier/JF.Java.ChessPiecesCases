package exercise.cpc.data.input.reader.impl.dimensions;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import exercise.cpc.data.input.impl.dimensions.DataInputDimensions;

/**
 *  TOOD correct doc.
 *  Basic test for reading input data for the {@code DataInputPiece}s
 *  via {@code DataInputReaderPieces}.  
 *  Should test:
 *   the board dimensions reading and saving for later
 *
 * @author Gra <Gołębiewski Radosław A.>
 *      https://github.com/golebier or https://golebier.github.io
 *      https://google.com/+RadoslawGolebiewski
 *      http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
*/
public class DataInputReaderDimensionsTest {
    private static final String[] DIMENSION_CORRECT_PARAMETERS = {
            "-D", "7", "5"
    };
    
    private static final String[] DIMENSION_EMPTY_PARAMETERS = {
        "-D"
    };
    
    private static final String[] DIMENSION_PARAMETERS_WRONG_N_DIMENTION = {
            "-D", "A", "5"
    };
    
    private static final String[] DIMENSION_PARAMETERS_WRONG_M_DIMENTION = {
            "-D", "7", "A"
    };
    
    private static final String[] DIMENSION_PARAMETERS_EMPTY_M_DIMENTION = {
            "-D", "7"
    };
    
    private DataInputReaderDimensions dataInputReaderDimensions = new DataInputReaderDimensions();
    
    // TODO add -D not first parameter
    @Test
    public void shouldAssertCorrectnessOfDimensionsTest() {
        assertNotNull(dataInputReaderDimensions.read(DIMENSION_CORRECT_PARAMETERS));
    }
    
    @Test
    public void shouldAssertIncorrectnessOfDimensionsNoNAndMTest() {
        assertNull(dataInputReaderDimensions.read(DIMENSION_EMPTY_PARAMETERS));
    }
    
    @Test
    public void shouldAssertIncorrectnessOfDimensionsMParameterTest() {
        assertNull(dataInputReaderDimensions.read(DIMENSION_PARAMETERS_WRONG_M_DIMENTION));
    }
    
    @Test
    public void shouldAssertIncorrectnessOfDimensionsMParameterEmptyTest() {
        assertNull(dataInputReaderDimensions.read(DIMENSION_PARAMETERS_EMPTY_M_DIMENTION));
    }
    
    @Test
    public void shouldAssertIncorrectnessOfDimensionsNParameterTest() {
        assertNull(dataInputReaderDimensions.read(DIMENSION_PARAMETERS_WRONG_N_DIMENTION));
    }
    
    @Test
    public void shouldAssertCorrectnessOfDimensionsByFieldTest() {
        DataInputDimensions dimentions = dataInputReaderDimensions.read(DIMENSION_CORRECT_PARAMETERS);
        assertEquals(dimentions.getN(), new Integer(7));
        assertEquals(dimentions.getM(), new Integer(5));
    }
    
    @Test
    public void shouldAssertIncorrectnessOfDataInputTest() {
        // this method is not used in this implementation
        assertNull(dataInputReaderDimensions.readAll(DIMENSION_CORRECT_PARAMETERS));
    }
}
