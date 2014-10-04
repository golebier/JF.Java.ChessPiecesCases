package exercise.cpc.data.input.reader.impl.simple;
import java.util.List;

import exercise.cpc.data.input.DataInput;
import exercise.cpc.data.input.impl.all.DataInputAll;
import exercise.cpc.data.input.impl.dimensions.DataInputDimensions;
import exercise.cpc.data.input.impl.piece.DataInputPiece;
//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import exercise.cpc.data.input.reader.DataInputReader;
/**
 *  TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *      https://github.com/golebier or https://golebier.github.io
 *      https://google.com/+RadoslawGolebiewski
 *      http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
*/
public class DataInputReaderSimple implements DataInputReader {
    private DataInputReaderDimensions dimensionsResder = null;
    private DataInputReaderPieces piecesReader = null;

    // TODO use a lib
    @Override
    public DataInput read(String[] parameters) {
        DataInputDimensions dimensions = dimensionsResder.read(parameters);
        List<DataInputPiece> pieces = piecesReader.read(parameters);

        // TODO is there more to do?
        return new DataInputAll(dimensions, pieces);
    }
}
