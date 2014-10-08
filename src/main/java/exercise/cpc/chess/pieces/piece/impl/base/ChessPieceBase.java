package exercise.cpc.chess.pieces.piece.impl.base;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.util.List;

import exercise.cpc.chess.pieces.piece.ChessPiece;
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
public class ChessPieceBase implements ChessPiece {
    protected Position xy;
    protected DataInputDimensions did;
    
    @Deprecated
    public ChessPieceBase(int x, int y) {
        xy = new Position(x, y);
    }
    
    @Deprecated
    public ChessPieceBase(Position xy) {
        this.xy = xy;
    }
    
    // TODO extract protected methods
    
    public ChessPieceBase(DataInputDimensions did) {
        this.did = did;
    }
    
    @Override
    public boolean checkCollisions(List<Position> freePositions, List<Position> piecesPositions) {
        for (Position myFreeposition : freePositions) {
            if (hasGotCollision(myFreeposition, piecesPositions)) {
                continue;
            }
            placePieceOnBoard(myFreeposition, freePositions);
            xy = myFreeposition;
            piecesPositions.add(myFreeposition);
            return true;
        }
        // this mean we could not find free position to set this piece, then this variation is wrong
        return false;
    }
    
    protected void placePieceOnBoard(Position myFreeposition, List<Position> freePositions) {
    }
    
    protected boolean hasGotCollision(Position myFreeposition, List<Position> piecesPositions) {
        return false;
    }
    
    @Override
    public int getX() {
        return xy.getX();
    }
    
    @Override
    public int getY() {
        return xy.getY();
    }
    
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "p";
    }
}
