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
    
    public ChessPieceBase(int x, int y) {
        xy = new Position(x, y);
    }
    
    public ChessPieceBase(Position xy) {
        this.xy = xy;
    }
    
    @Override
    public List<Position> checkCollisions(List<Position> freePositions, List<Position> piecesPositions) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int getX() {
        return xy.getX();
    }
    
    @Override
    public int getY() {
        return xy.getY();
    }
}
