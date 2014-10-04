package exercise.cpc.data.input.reader.impl.pieces;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.util.ArrayList;
import java.util.List;

import exercise.cpc.data.input.impl.piece.DataInputPiece;
import exercise.cpc.data.input.reader.DataInputReader;

/**
 * TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class DataInputReaderPieces implements DataInputReader<DataInputPiece> {
    private static final String PARAMETER_PATTERN = "-P";
    
    // TODO use a lib
    @Override
    public List<DataInputPiece> readAll(String[] parameters) {
        List<DataInputPiece> piecesList = new ArrayList<DataInputPiece>();
        for (int index = 0; index < parameters.length; ++index) {
            if (!PARAMETER_PATTERN.equals(parameters[index])) {
                continue;
            }
            String name = prepareName(parameters, index);
            Integer amount = prepareAmount(parameters, index);
            if (null != name && null != amount) {
                piecesList.add(new DataInputPiece(name, amount));
            }
        }
        // TODO change this
        if (piecesList.isEmpty()) {
            return null;
        }
        return piecesList;
    }
    
    private String prepareName(String[] parameters, int index) {
        if (index + 1 >= parameters.length) {
            return null;
        }
        return parameters[index + 1];
    }
    
    private Integer prepareAmount(String[] parameters, int index) {
        if (index + 2 >= parameters.length) {
            return null;
        }
        try {
            return Integer.parseInt(parameters[index + 2]);
        } catch (NumberFormatException e) {
            // TODO add logger
        }
        return null;
    }
    
    @Override
    public DataInputPiece read(String[] parameters) {
        return null;
    }
}
