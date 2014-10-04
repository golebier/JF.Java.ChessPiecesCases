package exercise.cpc.data.input;
//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.io.IOException;

import org.testng.annotations.Test;

import exercise.cpc.data.input.reader.DataInputReader;
/**
 *  TOOD correct doc.
 *  Basic test for reading input data.  
 *  Should test:
 *   the board dimensions reading and saving for later
 *   each type pieces with amount
 *
 * @author Gra <Gołębiewski Radosław A.>
 *      https://github.com/golebier or https://golebier.github.io
 *      https://google.com/+RadoslawGolebiewski
 *      http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
*/
public class InputReadTest {
    // as far as simple: input data would be given via args[], then input data spec is:

    private static final String[] CORRECT_INPUT_DATA = {
        "-D", "7", "7"
        , "-P", "King", "1"
        , "-P", "Queen", "1"
        , "-P", "Bishop", "1"
        , "-P", "Rook", "1"
        , "-P", "Knight", "1"
    };

    private DataInput inputdata = null;
    private DataInputReader dataInputReader = null;

    @Test
    public void shouldAssertInputDataCorrectnesTest() throws IOException {
        
    }
}
