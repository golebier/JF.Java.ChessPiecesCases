package exercise.cpc.data.input.reader;

import exercise.cpc.data.input.DataInput;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
/**
 *  Basic interface for all of the input data reading process.
 *  TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *      https://github.com/golebier or https://golebier.github.io
 *      https://google.com/+RadoslawGolebiewski
 *      http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
*/
public interface DataInputReader {

    /**
     * Reads input parameters in {@code String} {@code Array} and produce {@code DataInput}.
     * If any validation is wrong then return null;
     * 
     * @param parameters, {@code String} {@code Array} with parameter
     *  to read and to transform them to {@code DataInput}.
     * @return, {@code DataInput} with all fields correctly set, or null
     * 
     * TODO should be changed. 
     */
    DataInput read(String[] parameters);
}
