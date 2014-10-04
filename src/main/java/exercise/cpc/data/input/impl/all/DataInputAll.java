package exercise.cpc.data.input.impl.all;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.util.ArrayList;
import java.util.List;

import exercise.cpc.data.input.DataInput;
import exercise.cpc.data.input.impl.dimensions.DataInputDimensions;
import exercise.cpc.data.input.impl.piece.DataInputPiece;

/**
 * All needed data is here. Implementation of the {@code DataInput}. Present
 * implementation uses {@code DataInputDimensions} and {@code List} of
 * {@code DataInputPiece}. TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class DataInputAll implements DataInput {
    private DataInputDimensions dataInputDimensions;
    private List<DataInputPiece> piecesList = new ArrayList<DataInputPiece>();
    
    /**
     * Setup all needed data for input data.
     * TODO there is no validation in this point, changed that
     * 
     * @param dataInputDimensions, {@code DataInputDimensions} for present board.
     * @param piecesList, {@code List} of {@code DataInputPiece}s.
     */
    public DataInputAll(DataInputDimensions dataInputDimensions, List<DataInputPiece> piecesList) {
        this.dataInputDimensions = dataInputDimensions;
        this.piecesList.addAll(piecesList);
    }

    public void addPiece(DataInputPiece piece) {
        piecesList.add(piece);
    }

    // TODO validate the dimensions, as public method, and use it in setters and
    // constructor.
    
    public DataInputDimensions getDataInputDimensions() {
        return dataInputDimensions;
    }
    
    public List<DataInputPiece> getPiecesList() {
        return piecesList;
    }
    
    public void setDataInputDimensions(DataInputDimensions dataInputDimensions) {
        this.dataInputDimensions = dataInputDimensions;
    }
    
    public void setPiecesList(List<DataInputPiece> piecesList) {
        this.piecesList.addAll(piecesList);
    }
}
