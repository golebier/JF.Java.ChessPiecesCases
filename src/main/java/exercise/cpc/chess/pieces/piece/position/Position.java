package exercise.cpc.chess.pieces.piece.position;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//

/**
 * x y of the piece.
 *  TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class Position {
    private int x;
    private int y;
    private String signe = "#";
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Position(String string) {
        signe = string;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object instanceof Position) {
            Position tested = (Position) object;
            if (tested.getX() != x) {
                return false;
            }
            if (tested.getY() != y) {
                return false;
            }
            if ("#".equals(getSigne())) {
                return true;
            }
            return getSigne().equals(tested.getSigne());
        }
        return false;
    }
    
    public int getX() {
        return x;
    }
    
    public String getSigne() {
        return signe;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setSigne(String signe) {
        this.signe = signe;
    }
}
