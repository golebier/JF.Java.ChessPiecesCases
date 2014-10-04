package exercise.cpc.data.input.reader.impl.simple;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import exercise.cpc.data.input.reader.impl.dimensions.DataInputReaderDimensions;
import exercise.cpc.data.input.reader.impl.pieces.DataInputReaderPieces;

/**
 * TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class DataInputReaderSimpleTest {
    private static final String[] CORRECT_PARAMETERS = {
            "-P", "King", "1"
            , "-P", "Queen", "1"
            , "-P", "Bishop", "1"
            , "-P", "Rook", "1"
            , "-P", "Knight", "1"
            , "-D", "7", "5"
    };

    private static final String[] INCORRECT_PARAMETERS_BY_PIECES = {
        "-P", "King"
        , "-D", "7", "5"
    };

    private static final String[] INCORRECT_PARAMETERS_BY_DIMENSIONS = {
        "-P", "King", "5"
        , "-D", "7"
    };

    private DataInputReaderSimple dataInputReaderSimple
        = new DataInputReaderSimple(new DataInputReaderDimensions(), new DataInputReaderPieces());
    
    // TODO add more, now only correct parameters are valid for me.
    @Test
    public void shouldAssertParametersReadingCorrectnessTest() {
        assertNotNull(dataInputReaderSimple.read(CORRECT_PARAMETERS));
    }

    @Test
    public void shouldAssertParametersReadingIncorrectnessIfDimentionsAreNotValidTest() {
        assertNull(dataInputReaderSimple.read(INCORRECT_PARAMETERS_BY_DIMENSIONS));
    }

    @Test
    public void shouldAssertParametersReadingIncorrectnessIfPiecesListIsNotValidTest() {
        assertNull(dataInputReaderSimple.read(INCORRECT_PARAMETERS_BY_PIECES));
    }
}
