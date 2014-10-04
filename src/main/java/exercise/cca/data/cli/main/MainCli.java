package exercise.cca.data.cli.main;

//
//Copyright (c) 1979, the Gra projects.
//Please see the AUTHORS file for details.
//All rights reserved.
//Use of this source code is governed by a MIT-style license
//that can be found in the LICENSE file.
//
import java.io.IOException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 *  Core main file, runs all needed.
 *  Now just basic to began.
 *  // TODO add more, correct doc.
 *
 * @author Gra <Gołębiewski Radosław A.>
 *      https://github.com/golebier or https://golebier.github.io
 *      https://google.com/+RadoslawGolebiewski
 *      http://www.linkedin.com/pub/rados%C5%82aw-go%C5%82%C4%99biewski/70/832/35
*/
public class MainCli {
    private static final int OK_EXIT_STATUS = 0;
    private static final String CONTEXT_PATH = "main-context.xml";
    
    public static void main(String[] args) throws IOException {
        final ConfigurableApplicationContext applicationContext = loadContext(CONTEXT_PATH);
        
        if (null != applicationContext) {
            // TODO add more
        }
        
        new MainCli().run();
    }
    
    public void run() throws IOException {
        // TODO just adding final solutions, make this correct when all done.
        // DataInputReaderSimple dataInputReaderSimple = new DataInputReaderSimple(new DataInputReaderDimensions(), new DataInputReaderPieces());
        // dataInputReaderSimple.read(args)
        System.exit(OK_EXIT_STATUS);
    }
    
    protected static ConfigurableApplicationContext loadContext(final String contextPath) {
        final GenericApplicationContext ctx = new GenericApplicationContext();
        final XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
        xmlReader.loadBeanDefinitions(new ClassPathResource(contextPath));
        final PropertyPlaceholderConfigurer placeholderProcessor = new PropertyPlaceholderConfigurer();
        ctx.addBeanFactoryPostProcessor(placeholderProcessor);
        ctx.refresh();
        return ctx;
    }
}
