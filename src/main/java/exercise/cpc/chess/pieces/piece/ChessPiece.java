package exercise.cpc.chess.pieces.piece;

import java.util.List;

import exercise.cpc.chess.pieces.piece.position.Position;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
/**
 * Basic interface for all of the chess pieces. Now just basic to began.
 * // TODO add more, correct doc.
 *
 * @author Gra <Gołębiewski Radosław A.> https://github.com/golebier or
 *         https://golebier.github.io https://google.com/+RadoslawGolebiewski
 *         http
 *         ://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public interface ChessPiece {
    // TODO change method name, should be more clear
    /**
     * Checks if collisions accrue, to estimate if adding this piece brakes counting possibility.
     * @param freePositions {@code List} of {@code Position} that are free and can be used in counting. 
     * @param piecesPositions {@code List} of {@code Position} that represents allocated piece position.
     * @return false if free position for set this piece is not found, true if set piece in free position was possible.
     */
    boolean checkCollisions(List<Position> freePositions, List<Position> piecesPositions);
    
    /**
     * Allocated X position of the piece.
     *
     * @return {@code int} as X position allocation.
     */
    int getX();
    
    /**
     * Allocated Y position of the piece.
     *
     * @return {@code int} as Y position allocation.
     */
    int getY();
    
    /**
     * Short name of the piece.
     * @return {@code String} as short version of the piece name.
     */
    String getName();
}
