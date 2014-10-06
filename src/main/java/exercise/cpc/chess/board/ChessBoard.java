package exercise.cpc.chess.board;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.util.ArrayList;
import java.util.List;

import exercise.cpc.chess.pieces.piece.ChessPiece;
import exercise.cpc.chess.pieces.piece.position.Position;
import exercise.cpc.data.input.impl.dimensions.DataInputDimensions;

/**
 * Board place where magic is done.
 *  TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class ChessBoard {
    // TODO for tests add what pieces cross in what places
    private List<Position> freePositions = new ArrayList<Position>();
    private DataInputDimensions dimensions;
    
    public ChessBoard(DataInputDimensions dimensions) {
        this.dimensions = dimensions;
    }
    
    public void initialize() {
        for (int y = 0; y < dimensions.getM(); ++y) {
            for (int x = 0; x < dimensions.getN(); ++x) {
                freePositions.add(new Position(x, y));
            }
        }
    }
    
    /**
     * Only if could place piece on the board will return true.
     * Then if false this board is not useful.
     * 
     * @param piece
     * @return false if couldn't place given piece on the board
     *   true if could.
     */
    public boolean placePieceInPlaceWhereHasNotGotCollisions(ChessPiece piece) {
        // TODO test is this good path
        if (isValid(piece.getX(), piece.getY())) {
            return false;
        }
        List<Position> newFreePositions = piece.checkCollisions(freePositions);
        if (null == newFreePositions) {
            return false;
        }
        freePositions = newFreePositions;
        return true;
    }
    
    private boolean isValid(int x, int y) {
        if (x < 0 || x > dimensions.getN() || y < 0 || y > dimensions.getM()) {
            return false;
        }
        return true;
    }
}
