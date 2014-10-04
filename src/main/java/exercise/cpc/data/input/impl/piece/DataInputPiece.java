package exercise.cpc.data.input.impl.piece;
//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import exercise.cpc.data.input.DataInput;
/**
 *  Piece of the chess pieces. Implementation of  the {@code DataInput}.
 *  TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *      https://github.com/golebier or https://golebier.github.io
 *      https://google.com/+RadoslawGolebiewski
 *      http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
*/
public class DataInputPiece implements DataInput {
    private String name;
    private Integer amount;

    /**
     * Setup the piece of the chess pieces name and amount.
     * Correctness of the name and amount range is not checked.
     * 
     * @param name, {@code String} value of the name. TODO validate with existing chess pieces implementations.
     * @param amount, of piece of this kind in {@code Integer}.
     */
    public DataInputPiece(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }
    
    // TODO validate the dimensions, as public method, and use it in setters and constructor.


    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
