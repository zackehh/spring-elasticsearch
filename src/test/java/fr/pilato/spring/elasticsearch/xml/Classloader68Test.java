package fr.pilato.spring.elasticsearch.xml;

import org.elasticsearch.node.Node;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for feature request #68 : https://github.com/dadoonet/spring-elasticsearch/issues/68
 * @author David
 *
 */
public class Classloader68Test extends AbstractXmlContextModel {
    private String[] xmlBeans = {"models/classloader-68/classloader-68-context.xml"};

    @Override
    String[] xmlBeans() {
        return xmlBeans;
    }

	@Test
	public void test_node_clustername() {
		Node node = checkNode();
        assertThat(node.settings().get("cluster.name"), is("junit.cluster.transport"));
	}
}
