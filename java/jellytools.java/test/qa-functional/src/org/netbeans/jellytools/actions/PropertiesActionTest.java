/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.jellytools.actions;

import java.io.IOException;
import junit.framework.Test;
import org.netbeans.jellytools.JellyTestCase;
import org.netbeans.jellytools.nodes.Node;
import org.netbeans.jellytools.nodes.SourcePackagesNode;
import org.netbeans.jellytools.properties.PropertySheetOperator;

/** Test of org.netbeans.jellytools.actions.PropertiesAction.
 *
 * @author Adam Sotona
 * @author Jiri Skrivanek
 */
public class PropertiesActionTest extends JellyTestCase {

    /** constructor required by JUnit
     * @param testName method name to be used as testcase
     */
    public PropertiesActionTest(String testName) {
        super(testName);
    }

    /** method used for explicit testsuite definition
     */
    public static Test suite() {
        return createModuleTest(PropertiesActionTest.class);
    }
    private static Node node;

    @Override
    public void setUp() throws IOException {
        System.out.println("### " + getName() + " ###");  // NOI18N
        openDataProjects("SampleProject");
        if (node == null) {
            node = new Node(new SourcePackagesNode("SampleProject"), "sample1|SampleClass1.java"); // NOI18N
        }
    }

    @Override
    public void tearDown() {
        new PropertySheetOperator("SampleClass1.java").close();  //NOI18N
    }

    /** Test performMenu */
    public void testPerformMenu() {
        new PropertiesAction().performMenu(node);
    }

    /** Test performPopup */
    public void testPerformPopup() {
        new PropertiesAction().performPopup(node);
    }

    /** Test performAPI */
    public void testPerformAPI() {
        new PropertiesAction().performAPI(node);
    }

    /** Test performShortcut */
    public void testPerformShortcut() {
        new PropertiesAction().performShortcut(node);
    }
}
