package io.bitzl.test.tostringwithyaml;

import io.bitzl.test.tostringwithyaml.yaml.JodaTimeImplicitConstructor;
import io.bitzl.test.tostringwithyaml.yaml.JodaTimeRepresenter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.nodes.Node;

import java.util.Date;

public class ToString {

    private class ConstructJodaTimestamp extends SafeConstructor.ConstructYamlTimestamp {
        public Object construct(Node node) {
            Date date = (Date) super.construct(node);
            return new DateTime(date, DateTimeZone.UTC);
        }
    }

    static {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.FLOW);
        YAML = new Yaml(new JodaTimeImplicitConstructor(), new JodaTimeRepresenter(), options);
    }

    private static Yaml YAML;

    public static String stringRepresentationOf(Object object) {
        return YAML.dump(object);
    }

    public static Object fromStringRepresetation(String string) {
        return YAML.load(string);
    }

}
