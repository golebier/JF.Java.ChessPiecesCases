package exercise.cpc.data.input.reader.impl.dimensions;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.util.List;

import exercise.cpc.data.input.impl.dimensions.DataInputDimensions;
import exercise.cpc.data.input.reader.DataInputReader;

/**
 * TODO write more.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *         https://github.com/golebier or https://golebier.github.io
 *         https://google.com/+RadoslawGolebiewski
 *         http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
 */
public class DataInputReaderDimensions implements DataInputReader<DataInputDimensions> {
    private static final String PARAMETER_PATTERN = "-D";
    
    // TODO use a lib
    @Override
    public DataInputDimensions read(String[] parameters) {
        for (int index = 0; index < parameters.length; ++index) {
            if (!PARAMETER_PATTERN.equals(parameters[index])) {
                continue;
            }
            Integer n = prepareParameter(parameters, index + 1);
            Integer m = prepareParameter(parameters, index + 2);
            if (null != n && null != m) {
                return new DataInputDimensions(n, m);
            }
        }
        return null;
    }
    
    // TODO extract as a util look at DataInputReaderPieces::prepareAmount
    private Integer prepareParameter(String[] parameters, int index) {
        if (index >= parameters.length) {
            return null;
        }
        try {
            return Integer.parseInt(parameters[index]);
        } catch (NumberFormatException e) {
            // TODO add logger
        }
        return null;
    }
    
    @Override
    public List<DataInputDimensions> readAll(String[] parameters) {
        return null;
    }
}
