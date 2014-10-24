package exercise.cpc.chess.pieces.piece.impl.queen;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.util.List;

import exercise.cpc.chess.pieces.piece.ChessPiece;
import exercise.cpc.chess.pieces.piece.impl.base.ChessPieceBase;
import exercise.cpc.chess.pieces.piece.impl.bishop.ChessBishop;
import exercise.cpc.chess.pieces.piece.impl.rook.ChessRook;
import exercise.cpc.chess.pieces.piece.position.Position;
import exercise.cpc.data.input.impl.dimensions.DataInputDimensions;

/**
 *  TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class ChessQueen extends ChessPieceBase implements ChessPiece {
    private ChessRook rook;
    private ChessBishop bishop;
    
    @Deprecated
    public ChessQueen(int x, int y) {
        super(x, y);
    }
    
    @Deprecated
    public ChessQueen(Position xy) {
        super(xy);
    }
    
    public ChessQueen(DataInputDimensions did) {
        super(did);
        rook = new ChessRook(did);
        bishop = new ChessBishop(did);
    }
    
    // TODO name is deprecated, change it
    protected void placePieceOnBoard(Position myFreeposition, List<Position> freePositions) {
        rook.placePieceOnBoard(myFreeposition, freePositions);
        bishop.placePieceOnBoard(myFreeposition, freePositions);
    }
    
    protected boolean hasGotCollision(Position myFreeposition, List<Position> piecesPositions) {
        if (rook.hasGotCollision(myFreeposition, piecesPositions)
                && rook.hasGotCollision(myFreeposition, piecesPositions)) {
            return true;
        }
        return false;
    }
    
    //    @Override
    //    public boolean checkCollisions(List<Position> freePositions, List<Position> piecesPositions) {
    //        if (rook.checkCollisions(freePositions, piecesPositions)
    //                && bishop.checkCollisions(freePositions, piecesPositions)) {
    //            xy = new Position(bishop.getX(), bishop.getY());
    //            return true;
    //        }
    //        return false;
    //    }
    
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Q";
    }
}
