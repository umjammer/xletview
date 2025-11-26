/*
 * Copyright (c) 2024 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

import java.util.concurrent.CountDownLatch;

import net.beiker.xletview.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;


/**
 * TestCase.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2024-11-19 nsano initial version <br>
 */
class TestCase {

    @Test
    @EnabledIfSystemProperty(named = "vavi.test", matches = "ide")
    void test0() throws Exception {
        Main.main(new String[0]);
        CountDownLatch cdl = new CountDownLatch(1);
        cdl.await();
    }
}
