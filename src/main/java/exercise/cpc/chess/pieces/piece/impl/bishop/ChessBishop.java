package exercise.cpc.chess.pieces.piece.impl.bishop;

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
public class ChessBishop extends ChessPieceBase implements ChessPiece {
    
    @Deprecated
    public ChessBishop(int x, int y) {
        super(x, y);
    }
    
    @Deprecated
    public ChessBishop(Position xy) {
        super(xy);
    }
    
    public ChessBishop(DataInputDimensions did) {
        super(did);
    }
    
    // TODO name is deprecated, change it
    public void placePieceOnBoard(Position myFreeposition, List<Position> freePositions) {
        freePositions.remove(myFreeposition);
        int x = myFreeposition.getX();
        int y = myFreeposition.getY();
        Position tmp = new Position(x, y);
        for (int xx = x, yy = y; xx < did.getN() && yy < did.getM();) {
            tmp.setX(xx++);
            tmp.setY(yy++);
            freePositions.remove(tmp);
            freePositions.remove(tmp);
        }
        for (int xx = x, yy = y; xx > 0 && yy > 0;) {
            tmp.setX(--xx);
            tmp.setY(--yy);
            freePositions.remove(tmp);
            freePositions.remove(tmp);
        }
        for (int xx = x, yy = y + 1; xx < did.getN() && yy > 0;) {
            tmp.setX(xx++);
            tmp.setY(--yy);
            freePositions.remove(tmp);
            freePositions.remove(tmp);
        }
        for (int xx = x + 1, yy = y; xx > 0 && yy < did.getM();) {
            tmp.setX(--xx);
            tmp.setY(yy++);
            freePositions.remove(tmp);
            freePositions.remove(tmp);
        }
    }
    
    public boolean hasGotCollision(Position myFreeposition, List<Position> piecesPositions) {
        int x = myFreeposition.getX();
        int y = myFreeposition.getY();
        Position tmp = new Position(x, y);
        
        // TODO add position to be removed
        for (int xx = x, yy = y; xx < did.getN() && yy < did.getM();) {
            tmp.setX(xx++);
            tmp.setY(yy++);
            if (piecesPositions.contains(tmp)) {
                return true;
            }
        }
        for (int xx = x, yy = y; xx > 0 && yy > 0;) {
            tmp.setX(--xx);
            tmp.setY(--yy);
            if (piecesPositions.contains(tmp)) {
                return true;
            }
        }
        for (int xx = x, yy = y + 1; xx < did.getN() && yy > 0;) {
            tmp.setX(xx++);
            tmp.setY(--yy);
            if (piecesPositions.contains(tmp)) {
                return true;
            }
        }
        for (int xx = x + 1, yy = y; xx > 0 && yy < did.getM();) {
            tmp.setX(--xx);
            tmp.setY(yy++);
            if (piecesPositions.contains(tmp)) {
                return true;
            }
        }
        // TODO positions to be removed can be used
        return false;
    }
    
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "B";
    }
}
