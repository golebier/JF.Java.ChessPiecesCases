package exercise.cpc.data.input.reader.impl.pieces;

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
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import exercise.cpc.data.input.impl.piece.DataInputPiece;

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
public class DataInputReaderPiecesTest {
    private static final int CORRECT_SIZE_OF_PIECES_LIST = 5;
    private static final String EXPECTED_PIECES_NAME = "King";
    
    private static final String[] CORRECT_INPUT_DATA_WITH_A_PIECE = {
            "-P", EXPECTED_PIECES_NAME, "1"
    };
    
    private static final String[] INCORRECT_INPUT_DATA_WITHOUT_A_PIECE = {
        "-P"
    };
    
    private static final String[] INCORRECT_INPUT_DATA_WITHOUT_A_ANOUNT = {
            "-P", EXPECTED_PIECES_NAME
    };
    
    private static final String[] INCORRECT_INPUT_DATA_WRONG_ORDER = {
            "-P", "1", EXPECTED_PIECES_NAME
    };
    
    private static final String[] CORRECT_INPUT_DATA = {
            "-P", EXPECTED_PIECES_NAME, "1", "-P", "Queen", "1", "-P", "Bishop", "1", "-P", "Rook", "1", "-P",
            "Knight", "1"
    };
    
    private DataInputReaderPieces dataInputReaderPieces = new DataInputReaderPieces();
    
    // TODO add -P not first parameter
    @Test
    public void shouldAssertCorrectnessOfPiecesListTest() {
        assertNotNull(dataInputReaderPieces.readAll(CORRECT_INPUT_DATA));
    }
    
    @Test
    public void shouldAssertIncorrectnessOfPiecesListTest() {
        assertNull(dataInputReaderPieces.readAll(INCORRECT_INPUT_DATA_WITHOUT_A_PIECE));
    }
    
    @Test
    public void shouldAssertIncorrectnessOfPiecesListWhenWithoutAmountTest() {
        assertNull(dataInputReaderPieces.readAll(INCORRECT_INPUT_DATA_WITHOUT_A_ANOUNT));
    }
    
    @Test
    public void shouldAssertIncorrectnessOfPiecesListWhenWrongOrderTest() {
        assertNull(dataInputReaderPieces.readAll(INCORRECT_INPUT_DATA_WRONG_ORDER));
    }
    
    @Test
    public void shouldAssertCorrectnessOfPiecesListSizeTest() {
        assertEquals(dataInputReaderPieces.readAll(CORRECT_INPUT_DATA).size(), CORRECT_SIZE_OF_PIECES_LIST);
    }
    
    @Test
    public void shouldAssertCorrectnessOfEachPieceTest() {
        List<DataInputPiece> piecesList = dataInputReaderPieces.readAll(CORRECT_INPUT_DATA_WITH_A_PIECE);
        assertTrue(piecesList.iterator().hasNext());
        DataInputPiece piece = piecesList.iterator().next();
        assertEquals(piece.getAmount(), new Integer(1));
        assertEquals(piece.getName(), EXPECTED_PIECES_NAME);
    }
    
    @Test
    public void shouldAssertIncorrectnessOfDataInputTest() {
        // this method is not used in this implementation
        assertNull(dataInputReaderPieces.read(CORRECT_INPUT_DATA));
    }
}
