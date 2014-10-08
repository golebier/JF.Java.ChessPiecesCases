package exercise.cpc.app;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.io.IOException;

import org.testng.annotations.Test;

/**
 *  Core test for main file, runs all needed in test env.
 *  Now just basic to began.
 *  // TODO add more, correct doc.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *      https://github.com/golebier or https://golebier.github.io
 *      https://google.com/+RadoslawGolebiewski
 *      http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
*/
public class MainCliTest {
    @Test
    public void shouldRunFullTest() throws IOException {
        // TODO test for given parameters
        MainCli.main(null);
    }
}
